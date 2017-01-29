package com.style.util;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	public void ObjectToJSONConvertor(Object object, String fileName) {

		ObjectMapper mapper = new ObjectMapper();

		try {
			// Convert object to JSON string and save into a file directly
			mapper.writeValue(new File("C:/DB/" + fileName + ".txt"), object);

			// Convert object to JSON string
			String jsonInString = mapper.writeValueAsString(object);
			System.out.println(jsonInString);

			// Convert object to JSON string and pretty print
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
			System.out.println(jsonInString);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Object JSONToObject(String objectOf, String fileLocation) {
		ObjectMapper mapper = new ObjectMapper();
		Object object = null;
		try {
			// Convert JSON string from file to Object
			object = mapper.readValue(new File(fileLocation), Class.forName(objectOf));
			System.out.println(object);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}

}
