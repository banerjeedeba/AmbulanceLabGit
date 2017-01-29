package com.style.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.style.web.response.Profile;

public class DBUtil {

	public int getprofileid() {
		/*File file = new File("C://DB");
		File[] listOfFiles = file.listFiles();
		return listOfFiles.length + 1;*/
		return 1;
	}

	public List<Profile> getprofileList() {
		/*List profileList = new ArrayList<>();
		JsonUtil jsonUtil = new JsonUtil();
		File file = new File("C://DB");
		File[] listOfFiles = file.listFiles();

		for (final File fileEntry : listOfFiles) {
			Profile profile = (Profile) jsonUtil.JSONToObject(
					"com.style.web.response.Profile",
					fileEntry.getAbsolutePath());
			profileList.add(profile);
		}
		return profileList;*/
		return null;
	}

	public Profile getprofileData(int profileID) {
		/*JsonUtil jsonUtil = new JsonUtil();
		Profile profile = null;
		//profile = (Profile) jsonUtil.JSONToObject("com.style.web.response.Profile", "C://DB/Profile" + profileID + ".txt");
		return profile;*/
		return null;
	}
}
