package it.rdev.rubrica.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import it.rdev.rubrica.RubricaApp;

public class Configuration {
	
	private static Configuration instance;
	
	private final String CONFIG_FILE = "rubrica.cfg";
	
	private Properties prop;
	
	public static Configuration getInstance() {
		if(instance == null) {
			instance = new Configuration();
		}
		return instance;
	}
	
	public void init(String param) {
		// 
	}
	
	private Configuration() {
		prop = new Properties();
		try (InputStream cgfFile = RubricaApp.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
			prop.load(cgfFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getValue(ConfigKeys ck) {
		return prop.getProperty(ck.getKey(), "");
	}

}
