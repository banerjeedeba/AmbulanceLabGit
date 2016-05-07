package com.labs.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import com.google.gson.Gson;

public class FeedTransformer {

	public static String arrayListToJSON(List<?> list)
	{
		String feeds = null;
		Gson gson = new Gson();
		feeds = gson.toJson(list);
		return feeds;
	}
	
	 public static void saveList(List<?> list, String fileName){
	      try {
	         File file = new File("./"+fileName+".dat");
	         FileOutputStream fos;

	         fos = new FileOutputStream(file);

	         ObjectOutputStream oos = new ObjectOutputStream(fos);
	         oos.writeObject(list);
	         oos.close();
	      } catch (FileNotFoundException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }
}
