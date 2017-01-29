package com.cloth.entities;

import java.util.Date;

import com.google.appengine.api.datastore.Blob;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;

/**
 * The @Entity tells Objectify about our entity.  We also register it in {@link OfyHelper}
 * Our primary key @Id is set automatically by the Google Datastore for us.
 *
 * We add a @Parent to tell the object about its ancestor. We are doing this to support many
 * Users.  Objectify, unlike the AppEngine library requires that you specify the fields you
 * want to index using @Index.  Only indexing the fields you need can lead to substantial gains in
 * performance -- though if not indexing your data from the start will require indexing it later.
 *
 * NOTE - all the properties are PUBLIC so that we can keep the code simple.
 **/
@Entity
public class MyImage {

	@Parent Key<Album> theUser;
	@Id public Long id;
	
	private String name;
	//private Blob image;
	private String userId;
	
	@Index public Date date;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}*/
	
	public MyImage() {
		date = new Date();
	}
	
	public MyImage(String userId, String name, Blob image){
		this();
		/*if(userId != null){
			this.theUser = Key.create(Album.class, userId);
		} else {*/
			this.theUser = Key.create(Album.class, "default");
		//}
		this.name = name;
		this.setUserId(userId);
		//this.image = image;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
