package com.style.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.cloth.StoreImage;
import com.cloth.entities.Client;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;
import com.style.util.DBUtil;
import com.style.util.JsonUtil;
import com.style.web.response.Profile;

@Service
public class ProfileServiceImpl implements ProfileService {

	private static final Logger log = Logger.getLogger(ProfileServiceImpl.class.getName());
	
	@Override
	public int saveProfile(Profile profile) {
		/*JsonUtil jsonUtil = new JsonUtil();
		DBUtil dbUtil = new DBUtil();
		profile.setProfileid(dbUtil.getprofileid());
		jsonUtil.ObjectToJSONConvertor(profile, "Profile"+profile.getProfileid());*/
		
		
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		int count = 0;
		if(profile.getProfileid()>0){
			count=profile.getProfileid();
		} else{
			Query q = new Query("Profile").addSort("ProfileId", SortDirection.DESCENDING);
			PreparedQuery pq = ds.prepare(q);
			if(pq!=null){
				for(Entity e : pq.asIterable()){
					count = Integer.parseInt(e.getProperty("ProfileId").toString());
					count++;
					break;
				}
			}
		}
		Entity profileEntity = new Entity("Profile", count );
		profileEntity.setProperty("First_Name", profile.getFirstname());
		profileEntity.setProperty("Last_Name", profile.getLastname());
		profileEntity.setProperty("Address", profile.getAddress());
		profileEntity.setProperty("ContactNumber", profile.getContactNo());
		profileEntity.setProperty("CCNumber", profile.getCcNumber());
		profileEntity.setProperty("Email", profile.getEmail());
		profileEntity.setProperty("ProfileId", count);
		String blobKey = profile.getBlobKey() != null ? profile.getBlobKey() : "";
		profileEntity.setProperty("blobkey", blobKey);
		profile.setProfileid(count);
		
		ds.put(profileEntity);
		log.info("saveProfile:::::::"+profile.getFirstname()+".."+blobKey);
		return profile.getProfileid();
	}

	@Override
	public Profile findProfile(int id) {
		//DBUtil dbUtil = new DBUtil();
		//return dbUtil.getprofileData(id);
		Profile profileObject = null;
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query("Profile").addSort("ProfileId", SortDirection.DESCENDING);
		PreparedQuery pq = ds.prepare(q);
		List<Profile> profiles = new ArrayList<Profile>();
		List<String> urls = new ArrayList<String>();
		
		for(Entity e : pq.asIterable()){
			String blobkeyString="";
			if(e.getProperty("blobkey")!=null){
				blobkeyString = e.getProperty("blobkey").toString();
				if(blobkeyString!=null && !"".equals((blobkeyString.trim()))){
					ImagesService services = ImagesServiceFactory.getImagesService();
					BlobKey blobKey = new BlobKey(blobkeyString);
		            ServingUrlOptions serve = ServingUrlOptions.Builder.withBlobKey(blobKey);    // Blobkey of the image uploaded to BlobStore.
		            blobkeyString = services.getServingUrl(serve);
				}
			}
			Profile profile = new Profile(Integer.parseInt(e.getProperty("ProfileId").toString()),
											e.getProperty("First_Name").toString(),
											e.getProperty("Last_Name").toString(),
											e.getProperty("Address").toString(),
											e.getProperty("ContactNumber").toString(),
											e.getProperty("CCNumber").toString(),
											e.getProperty("Email").toString(),
											blobkeyString);
			if(id == profile.getProfileid()){
				profileObject=profile;
				break;
			}
		}
		log.info("findProfile:::::::"+profileObject.getFirstname()+".."+profileObject.getBlobKey());
		return profileObject;
	}

	@Override
	public List<Profile> findAllProfiles() {
		//DBUtil dbUtil = new DBUtil();
		
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query("Profile").addSort("ProfileId", SortDirection.DESCENDING);
		PreparedQuery pq = ds.prepare(q);
		List<Profile> profiles = new ArrayList<Profile>();
		List<String> urls = new ArrayList<String>();
		
		for(Entity e : pq.asIterable()){
			String blobkeyString="empty";
			if(e.getProperty("blobkey")!=null){
				blobkeyString = e.getProperty("blobkey").toString();
			}
			//blobkeyString="AMIfv95hT7PNgHv_yhtSPmDpFzYOcTWa9fuZ0fz3UjUSEBeW_p0u1tcNtRf8VLa9tJw5k4e_LYID3gVbTGsNUShZHCvggzAOuu93QsDthgkCqzO49BaZ90HKsWx5e4h564HHvWbLsuoouX4bd3G3dBBOcTBl13JGkg";
			Profile profile = new Profile(Integer.parseInt(e.getProperty("ProfileId").toString()),
											e.getProperty("First_Name").toString(),
											e.getProperty("Last_Name").toString(),
											e.getProperty("Address").toString(),
											e.getProperty("ContactNumber").toString(),
											e.getProperty("CCNumber").toString(),
											e.getProperty("Email").toString(),
											e.getProperty("blobkey").toString());
					/*e.getProperty("First_Name").toString(),
										e.getProperty("Last_Name").toString(),
										Long.parseLong(e.getProperty("ClientId").toString()),blobkeyString);*/
			if(!"empty".equals(blobkeyString) && !"".equals(blobkeyString)){
				BlobKey blobKey = new BlobKey(blobkeyString);
				ImagesService services = ImagesServiceFactory.getImagesService();
	            ServingUrlOptions serve = ServingUrlOptions.Builder.withBlobKey(blobKey);    // Blobkey of the image uploaded to BlobStore.
	            String imgUrl = services.getServingUrl(serve);
	            urls.add(imgUrl);
			}
			profiles.add(profile);
		}
		
		return profiles;
	}

	@Override
	public List<Profile> findProfileEntries(int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long countAllProfiles() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Profile updateProfile(Profile Profile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProfile(Profile Profile) {
		// TODO Auto-generated method stub
	}

}
