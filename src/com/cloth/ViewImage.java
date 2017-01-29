package com.cloth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;

@WebServlet("/ViewImage")
public class ViewImage extends HttpServlet {
    private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws IOException {
            BlobKey blobKey = new BlobKey(req.getParameter("blob-key"));
            //blobstoreService.serve(blobKey, res);
            
            ImagesService services = ImagesServiceFactory.getImagesService();
            ServingUrlOptions serve = ServingUrlOptions.Builder.withBlobKey(blobKey);    // Blobkey of the image uploaded to BlobStore.
            String imgUrl = services.getServingUrl(serve);
            
            req.setAttribute("imgUrl", imgUrl);
            req.setAttribute("keyString", req.getParameter("blob-key"));
    	    try {
				req.getRequestDispatcher("/ViewImage.jsp").forward(req, res);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
}