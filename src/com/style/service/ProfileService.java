package com.style.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.style.web.response.Profile;

@Service
public interface ProfileService {
	
	int saveProfile(Profile Profile);

	Profile findProfile(int id);

	List<Profile> findAllProfiles();

	List<Profile> findProfileEntries(int firstResult, int maxResults);

	long countAllProfiles();

	Profile updateProfile(Profile Profile);

	void deleteProfile(Profile Profile);
}
