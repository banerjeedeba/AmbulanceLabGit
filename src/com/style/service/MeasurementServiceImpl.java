package com.style.service;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.style.web.response.Measurement;

@Service
public class MeasurementServiceImpl implements MeasurementService {

	private static final Logger log = Logger.getLogger(MeasurementServiceImpl.class.getName());

	@Override
	public void saveMeasurement(Measurement measurement) {
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Entity clientMeasurementEntity = new Entity("Measurement", measurement.getProfileid());
		clientMeasurementEntity.setProperty("ProfileId", measurement.getProfileid());
		clientMeasurementEntity.setProperty("neck", measurement.getNeck());
		clientMeasurementEntity.setProperty("sleeve", measurement.getSleeve());
		clientMeasurementEntity.setProperty("chest", measurement.getChest());
		clientMeasurementEntity.setProperty("waist", measurement.getWaist());
		clientMeasurementEntity.setProperty("shoe", measurement.getInseam());
		clientMeasurementEntity.setProperty("inseam", measurement.getJacket());
		clientMeasurementEntity.setProperty("jacket", measurement.getShirt());
		clientMeasurementEntity.setProperty("shirt", measurement.getJacket());
		clientMeasurementEntity.setProperty("weight", measurement.getWeight());
		clientMeasurementEntity.setProperty("height", measurement.getHeight());
		ds.put(clientMeasurementEntity);
		log.info("saveMeasurement:::::::Sucessful");
	}

	@Override
	public Measurement findMeasurement(int ProfileId) {
		Measurement measurement = null;
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query("Measurement").addFilter("ProfileId", Query.FilterOperator.EQUAL, ProfileId);
		PreparedQuery pq = ds.prepare(q);
		for (Entity e : pq.asIterable()) {
			measurement = new Measurement(Integer.parseInt(e.getProperty("ProfileId").toString()),
					e.getProperty("neck").toString(), e.getProperty("sleeve").toString(),
					e.getProperty("chest").toString(), e.getProperty("waist").toString(),
					e.getProperty("shoe").toString(), e.getProperty("inseam").toString(),
					e.getProperty("jacket").toString(), e.getProperty("shirt").toString(),
					e.getProperty("weight").toString(), e.getProperty("height").toString());
		}
		
		if (measurement == null) {
			measurement = new Measurement();
			measurement.setProfileid(ProfileId);
		}
		
		log.info("findMeasurement:::::::Sucessful");
		return measurement;
	}

	@Override
	public Measurement updateMeasurement(Measurement measurement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMeasurement(Measurement measurement) {
		// TODO Auto-generated method stub
	}
}
