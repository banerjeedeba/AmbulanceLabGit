package com.cloth;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloth.entities.Album;
import com.cloth.entities.MyImage;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.googlecode.objectify.ObjectifyService;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
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
	/*protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 MyImage imageProp;

		    //UserService userService = UserServiceFactory.getUserService();
		    //User user = userService.getCurrentUser();  // Find out who the user is.

		    String userId = req.getParameter("userId");
		    String name = req.getParameter("uname");
		    String content = req.getParameter("content");
		    imageProp = new MyImage(userId,name,null);
		      //greeting = new Greeting(guestbookName, content, user.getUserId(), user.getEmail());
		    

		    // Use Objectify to save the greeting and now() is used to make the call synchronously as we
		    // will immediately get a new page using redirect and we want the data to be present.
		    ObjectifyService.ofy().save().entity(imageProp).now();
		    
		    res.setContentType("text/plain");
		    res.getOutputStream().write((userId+".."+name+"OK!").getBytes());
	}*/
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
        List<BlobKey> blobKeys = blobs.get("myFile");
        
        String blobkey = "";
        if (blobKeys != null && !blobKeys.isEmpty()) {
        	
        	blobkey = blobKeys.get(0).getKeyString();
        }
		
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		long count = 0;
		Query q = new Query("Clients").addSort("ClientId", SortDirection.DESCENDING);
		PreparedQuery pq = ds.prepare(q);
		for(Entity e : pq.asIterable()){
			count = Long.parseLong(e.getProperty("ClientId").toString());
			break;
			/*Map<String, Object> properties = e.getProperties();
			for(String key : properties.keySet()){
				System.out.println("Key: "+key+" value: "+properties.get(key));
			}*/
		}
		
		String firstName = req.getParameter("firstname");
		String lastName = req.getParameter("lastname");
		Entity client = new Entity("Clients", ++count );
		client.setProperty("First_Name", firstName);
		client.setProperty("Last_Name", lastName);
		client.setProperty("ClientId", count);
		client.setProperty("blobkey", blobkey);
		
		ds.put(client);
		
		//res.setContentType("text/plain");
	    //res.getOutputStream().write((firstName+" Added!!").getBytes());
	    /*if (blobKeys == null || blobKeys.isEmpty()) {
            res.sendRedirect("/");
        } else {
            res.sendRedirect("/ViewImage?blob-key=" + blobKeys.get(0).getKeyString());
        }*/
	    res.sendRedirect("/ViewUsers");
	}

}
