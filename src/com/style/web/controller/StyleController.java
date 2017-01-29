package com.style.web.controller;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.style.service.ProfileService;
import com.style.service.ProfileServiceImpl;
import com.style.web.response.Measurement;
import com.style.web.response.Profile;

@Controller
public class StyleController {

	BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	
	private static final Logger log = Logger.getLogger(StyleController.class.getName());
	@RequestMapping(value = "/wardrobe", method = RequestMethod.GET)
	public ModelAndView wardrobe() {
		ModelAndView model = new ModelAndView();
		model.setViewName("wardrobe");
		return model;
	}
	
	@RequestMapping(value = "/addClient", method = RequestMethod.GET)
	public ModelAndView addClient() {
		ModelAndView model = new ModelAndView();
		model.setViewName("addClient");
		return model;
	}
	
	@RequestMapping(value = "/addClientPic", method = RequestMethod.POST)
	public ModelAndView addClientPic(HttpServletRequest request, 
	        HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		model.setViewName("wardrobe");
		
		Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(request);
        List<BlobKey> blobKeys = blobs.get("myFile");
        
        String blobkey = "";
        if (blobKeys != null && !blobKeys.isEmpty()) {
        	
        	blobkey = blobKeys.get(0).getKeyString();
        }
        String profileIdString = request.getParameter("profileId");
        int profileId = 0;
        if(profileIdString!=null){
        	profileId = Integer.parseInt(profileIdString);
        }
        ProfileService service = new ProfileServiceImpl();
        Profile profile = service.findProfile(profileId);
        profile.setBlobKey(blobkey);
        log.info("addClientPic:::::::"+profile.getFirstname()+".."+blobkey);
        service.saveProfile(profile);
        
		return model;
	}
	
	
	@RequestMapping(value = "/addMeasurement", method = RequestMethod.POST)
	public ModelAndView addMeasurement(@ModelAttribute("profile") Profile profile) {
		ModelAndView model = new ModelAndView();
		if(0==(profile.getProfileid())){
			Measurement measurement =  new Measurement();
			measurement.setInseam("37");
			model.addObject("measurement", measurement);
			model.setViewName("addmeasurement");
			return model;
		}else{
			return model;
		}
		
	}

	@RequestMapping(value = "/profileData", method = RequestMethod.POST)
	public ModelAndView profileData(@ModelAttribute("profile") Profile profile) {
		ModelAndView model = new ModelAndView();
		ProfileService impl = new ProfileServiceImpl();
		int profileId = 0;
		if (profile != null) {
			profileId = impl.saveProfile(profile);
		}
		model.addObject("profile", impl.findProfile(profileId));
		model.setViewName("profile");
		return model;
	}
	
	@RequestMapping(value = "/listClient", method = RequestMethod.GET)
	public ModelAndView listClient() {
		ModelAndView model = new ModelAndView();
		ProfileService profileService = new ProfileServiceImpl();
		model.addObject("profileList", profileService.findAllProfiles());
		model.setViewName("listClient");
		return model;
	}
	
	@RequestMapping(value = "/profileDetails", method = RequestMethod.POST)
	public ModelAndView profileDetails(@ModelAttribute("profile") Profile profile) { 
		ModelAndView model = new ModelAndView();
		ProfileService impl = new ProfileServiceImpl();
		model.addObject("profile", impl.findProfile(profile.getProfileid()));
		model.setViewName("profile");
		return model;
	}

	@RequestMapping(value = "/measurementForm", method = RequestMethod.GET)
	public ModelAndView hello() {
		ModelAndView model = new ModelAndView();
		model.setViewName("measurementForm");
		return model;
	}

	@RequestMapping(value = "/measurementDetails", method = RequestMethod.POST)
	public ModelAndView measurementDetails(@ModelAttribute("measurement") Measurement measurement) {
		ModelAndView model = new ModelAndView();
		model.addObject("Neck", measurement.getNeck());
		model.addObject("Waist", measurement.getWaist());
		model.addObject("Sleeve", measurement.getSleeve());
		model.setViewName("measurementForm");
		return model;
	}

}