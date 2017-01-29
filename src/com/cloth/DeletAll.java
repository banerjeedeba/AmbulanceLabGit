package com.cloth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloth.entities.Client;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;

/**
 * Servlet implementation class DeletAll
 */
@WebServlet("/DeletAll")
public class DeletAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query("Clients").addSort("ClientId", SortDirection.DESCENDING);
		PreparedQuery pq = ds.prepare(q);
		List<Client> clients = new ArrayList<Client>();
		List<String> urls = new ArrayList<String>();
		
		for(Entity e : pq.asIterable()){
			String blobkeyString="empty";
			if(e.getProperty("blobkey")!=null){
				blobkeyString = e.getProperty("blobkey").toString();
			}
			//blobkeyString="AMIfv95hT7PNgHv_yhtSPmDpFzYOcTWa9fuZ0fz3UjUSEBeW_p0u1tcNtRf8VLa9tJw5k4e_LYID3gVbTGsNUShZHCvggzAOuu93QsDthgkCqzO49BaZ90HKsWx5e4h564HHvWbLsuoouX4bd3G3dBBOcTBl13JGkg";
			Client client = new Client(e.getProperty("First_Name").toString(),
										e.getProperty("Last_Name").toString(),
										Long.parseLong(e.getProperty("ClientId").toString()),blobkeyString);
			
			Key clientKey=KeyFactory.createKey("Client", Long.parseLong(e.getProperty("ClientId").toString()));
			ds.delete(clientKey);			
		}
		
		BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
		Map<String, List<BlobKey>> uploads = blobstoreService.getUploads(request);
		for(String key:uploads.keySet())
		{
			BlobKey[] keys = new BlobKey[uploads.get(key).size()];
			blobstoreService.delete(uploads.get(key).toArray(keys));
		}
		
		
	    request.setAttribute("clients", clients);
	    request.setAttribute("urls", urls);
	    request.getRequestDispatcher("/list.jsp").forward(request, response);
	}

}
