package com.style.service;

import org.springframework.stereotype.Service;

import com.style.web.response.Measurement;

@Service
public interface MeasurementService {

	void saveMeasurement(Measurement measurement);

	Measurement findMeasurement(int ProfileId);

	Measurement updateMeasurement(Measurement measurement);

	void deleteMeasurement(Measurement measurement);
	
}
