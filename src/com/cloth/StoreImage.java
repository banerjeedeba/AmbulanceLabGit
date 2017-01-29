package com.cloth;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.cloth.entities.MyImage;
import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.ObjectifyService;

/**
 * Servlet implementation class StoreImage
 */
@WebServlet("/StoreImage")
public class StoreImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static int count = 0;
    private static final Logger log = Logger.getLogger(StoreImage.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreImage() {
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
		try{
			MyImage imageRef;
			//UserService userService = UserServiceFactory.getUserService();
		    //User user = userService.getCurrentUser();  // Find out who the user is.

		    String guestbookName = req.getParameter("user");
		    //String content = req.getParameter("content");
		    if (user != null) {
		    	imageRef = new Greeting(guestbookName, content, user.getUserId(), user.getEmail());
		    } else {
		      greeting = new Greeting(guestbookName, content);
		    }
		    
		    ServletFileUpload upload = new ServletFileUpload();
		    FileItemIterator iter = upload.getItemIterator(req);
		    FileItemStream imageItem = iter.next();
		    InputStream imgStream = imageItem.openStream();

		    // construct our entity objects
		    Blob imageBlob = new Blob(IOUtils.toByteArray(imgStream));
		    MyImage myImage = new MyImage("default", "img"+(++count),imageBlob);
		    log.info("completed myImage");
		    // Use Objectify to save the greeting and now() is used to make the call synchronously as we
		    // will immediately get a new page using redirect and we want the data to be present.
		    ObjectifyService.ofy().save().entity(myImage).now();
		    log.info("objectified myImage");
		    
		    res.setContentType("text/plain");
		    res.getOutputStream().write("OK!".getBytes());
		}catch (FileUploadException e) {
			e.printStackTrace();
			log.warning(e.getMessage());
		}
		
	}*/
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try{
			DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
			long count = 0;
			String name = "";
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
			Entity client = new Entity("Clients", ++count );
			client.setProperty("First_Name", req.getParameter("firstname"));
			client.setProperty("Last_Name", req.getParameter("lastname"));
			client.setProperty("ClientId", count);
			
			ds.put(client);
		}catch (Exception e) {
			e.printStackTrace();
			log.warning(e.getMessage());
		}
		
	}

}
