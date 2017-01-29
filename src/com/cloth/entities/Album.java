package com.cloth.entities;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Album {
	@Id public String album;
}
