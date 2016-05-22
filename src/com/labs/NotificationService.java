package com.labs;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

@Path("/notifications")
public class NotificationService {

	private static Map<String,ArrayList<NotificationDO>> notifications = new HashMap<String, ArrayList<NotificationDO>>();
	
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public String getNotifications(@QueryParam("userName") String userName,
			@QueryParam("password") String password)
	{
		String key = userName+"_"+password;
		if(notifications.containsKey(key))
		{
			Gson obj = new Gson();
			return obj.toJson(notifications.get(key));
			
		}
		return "[{\"error\": \"Wrong username or pasword\"}]";
	}
	
	@POST
	@Path("/add")
	@Produces({ MediaType.APPLICATION_JSON })
	public String appNotifications(@QueryParam("userName") String userName,
			@QueryParam("password") String password,
			@QueryParam("nPackage") String nPackage,
			@QueryParam("nTicker") String nTicker,
			@QueryParam("nTitle") String nTitle,
			@QueryParam("nText") String nText)
	{
		
		String key = userName+"_"+password;
		NotificationDO notification = new NotificationDO(nPackage, nTicker, nTitle, nText, new Date().getTime());
		if(notifications.containsKey(key))
		{
			ArrayList<NotificationDO> nArr = notifications.get(key);
			if(nArr.size() >= 50)
			{
				nArr.remove(50);
			}
			nArr.add(notification);
			Collections.sort(nArr);
			notifications.put(key, nArr);
		} else
		{
			ArrayList<NotificationDO> nArr = new ArrayList<NotificationDO>();
			nArr.add(notification);
			notifications.put(key, nArr);
		}
		return "[{\"success\": \"Notification added successfully\"}]";
	
	}
	
	@POST
	@Path("/remove")
	@Produces({ MediaType.APPLICATION_JSON })
	public ArrayList<NotificationDO> removeNotifications(@QueryParam("userName") String userName,
			@QueryParam("password") String password)
	{
		
		return null;
	}
}
