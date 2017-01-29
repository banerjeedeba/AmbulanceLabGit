package com.cloth;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadImage
 */
@WebServlet("/UploadImage")
public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = UploadImage.class.getProtectionDomain().getCodeSource().getLocation().getPath().substring(1)+ File.separator +"Files";

    /**
     * Default constructor. 
     */
    public UploadImage() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
       /*boolean isMultipart = ServletFileUpload.isMultipartContent(request);
       File file = new File(UPLOAD_DIRECTORY);
       if(!file.exists()){
    	   file.mkdirs();
       }
       System.out.println(file.getAbsolutePath());

       // process only if it is multipart content
       if (isMultipart) {
               // Create a factory for disk-based file items
               FileItemFactory factory = new DiskFileItemFactory();

               // Create a new file upload handler
               ServletFileUpload upload = new ServletFileUpload(factory);
               try {
               // Parse the request
               List<FileItem> multiparts = upload.parseRequest(request);

               for (FileItem item : multiparts) {
               if (!item.isFormField()) {
               String name = new File(item.getName()).getName();
               item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
               }
               }
               } 
               catch (Exception e) 
               {
                 e.printStackTrace();
               }
       }*/
		
	
	}

}
