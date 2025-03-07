package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

public class JSONUtility {

	public static Environment readJSON (Env env) {

		Gson gson = new Gson(); // to read JSON in java- No in-built funct. so we use 
		File jsonFile = new File(System.getProperty("user.dir") + "//config//config.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		Config config = gson.fromJson(fileReader, Config.class); // return Config class object
		Environment environment = config.getEnvironments().get("QA");
		return environment;
		
//		System.out.println(gson.toJson(config));

	}
}
