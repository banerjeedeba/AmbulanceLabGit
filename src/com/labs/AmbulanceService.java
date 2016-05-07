package com.labs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.labs.util.FeedTransformer;

@Path("/ambulance")
public class AmbulanceService {
	
	

	private static List<DriverDO> drivers = new ArrayList<DriverDO>();
	private static List<CustomerDO> customers = new ArrayList<CustomerDO>();
	private List<TripDO> trips = new ArrayList<TripDO>();

	private static final String SUCCESS_RESULT = "<result>success</result>";
	private static  String FAILURE_RESULT = "<result>failure";

	@GET
	@Produces("text/html")
	public Response getLocalCust() {

		String output = "I am from 'getLocalCust' method";
		return Response.status(200).entity(output).build();
	}

	@GET
	@Path("/list")
	@Produces("text/html")
	public Response getNriCust() {

		String output = "I am from 'getNriCust' method";
		return Response.status(200).entity(output).build();
	}

	
	@POST
	@Path("/adddriver")
	@Produces({ MediaType.APPLICATION_JSON })
	public String addDriver(@QueryParam("name") String name,
			@QueryParam("mobileNo") long mobileNo,
			@QueryParam("longitude") String longitude,
			@QueryParam("latitude") String latitude) {

		try {
			DriverDO driver = new DriverDO(longitude, latitude, name,
					mobileNo);
			if(drivers.size() > 4)
			{
				return "[{\"error\": \"Max 5 driver limit reached\"}]";
			}
			else
			{
				drivers.add(driver);
			}
			
			/*File file = new File("./DriverDO.dat");
			DriverDO driver = new DriverDO(longitude, latitude, name,
					mobileNo);
			if (!file.exists()) {
				
				drivers.add(driver);
				FeedTransformer.saveList(drivers, "DriverDO");
			} else {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				drivers = (List<DriverDO>) ois.readObject();
				drivers.add(driver);
				ois.close();
				FeedTransformer.saveList(drivers, "DriverDO");

			}*/
			return "[{\"success\": \"Driver Added Successfully\"}]";
		/*} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();*/
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return "[{\"error\": \"No Customers Available\"}]";
	}

	@GET
	@Path("/drivers_list")
	@Produces({ MediaType.APPLICATION_JSON })
	public String getDriversList() {
		/*try {

			
			File file = new File("./DriverDO.dat");
			if (!file.exists()) {
				return "[{\"error\": \"No Driver Available\"}]";
			} else {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				drivers = (List<DriverDO>) ois.readObject();
				ois.close();
				return FeedTransformer.arrayListToJSON(drivers);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return "[{\"error\": \"No Driver Available\"}]";*/
		if(drivers.size() == 0)
		{
			return "[{\"error\": \"No Driver Available\"}]";
		}else
		{
			return FeedTransformer.arrayListToJSON(drivers);
		}
		
	}
	
	@POST
	@Path("/addCustomer")
	@Produces(MediaType.TEXT_PLAIN)
	public String addCustomer(@QueryParam("name") String name,
			@QueryParam("mobileNo") long mobileNo,
			@QueryParam("longitude") String longitude,
			@QueryParam("latitude") String latitude) {

		/*try {*/
			CustomerDO customer = new CustomerDO(longitude, latitude, name,
					mobileNo);
			if(customers.size() > 4)
			{
				return "[{\"error\": \"Max 5 customer limit reached\"}]";
			}
			else
			{
				customers.add(customer);
			}
			/*File file = new File("CustomerDO.dat");
			if (!file.exists()) {
				
				customers.add(customer);
				FeedTransformer.saveList(customers, "CustomerDO");
			} else {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				customers = (List<CustomerDO>) ois.readObject();
				ois.close();
				FeedTransformer.saveList(customers, "CustomerDO");

			}*/
			/*} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/
			return "[{\"success\": \"Customer Added Successfully\"}]";
	}
	
	@GET
	@Path("/remove_customer")
	@Produces({ MediaType.APPLICATION_JSON })
	public String removeCustomer(@QueryParam("name") String name) {
		if(name !=null)
		for(CustomerDO customer : customers)
		{
			if(customer.getName().equalsIgnoreCase(name))
			{
				customers.remove(customer);
				return "[{\"success\": \"Customers removed successfully\"}]";
			}
		}
		return "[{\"error\": \"No Such Customer Found!!\"}]";
	}
	
	@GET
	@Path("/remove_driver")
	@Produces({ MediaType.APPLICATION_JSON })
	public String removeDriver(@QueryParam("name") String name) {
		if(name !=null)
		for(DriverDO driver : drivers)
		{
			if(driver.getName().equalsIgnoreCase(name))
			{
				drivers.remove(driver);
				return "[{\"success\": \"Driver removed successfully\"}]";
			}
		}
		return "[{\"error\": \"No Such Driver Found!!\"}]";
	}

	
	@GET
	@Path("/remove_all_customer")
	@Produces({ MediaType.APPLICATION_JSON })
	public String removeAllCustomer() {
		customers = new ArrayList<CustomerDO>();
		return "[{\"success\": \" All Customers removed successfully\"}]";
	}
	
	@GET
	@Path("/remove_all_driver")
	@Produces({ MediaType.APPLICATION_JSON })
	public String removeAllDriver() {
		drivers = new ArrayList<DriverDO>();
		return "[{\"success\": \"All Driver removed successfully\"}]";
		
	}
	
	@GET
	@Path("/customer_list")
	@Produces({ MediaType.APPLICATION_JSON })
	public String getCustomerList() {
		/*try {

			File file = new File("CustomerDO.dat");
			if (!file.exists()) {
				return "[{\"error\": \"No Customers Available\"}]";
			} else {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				customers = (List<CustomerDO>) ois.readObject();
				ois.close();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/
		if(customers.size()==0)
		{
			return "[{\"error\": \"No Customers Available\"}]";
		}
		else
		{
			return FeedTransformer.arrayListToJSON(customers);
		}
		//return "[{\"error\": \"No Customers Available\"}]";
	}
	
	

}
