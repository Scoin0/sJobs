package net.tngc.sjobs.Configuration;

import java.io.File;
import java.io.IOException;

import net.visualillusionsent.utils.PropertiesFile;

public class Configuration {
	
	File file = new File("config/sJobs/sJobs.properties");
	File dir = new File("config/sJobs/");
	PropertiesFile prop = new PropertiesFile("config/sJobs/sJobs.properties");

	public void loadProperties(){
		
		if(!dir.exists()){
			dir.mkdir();
		}
		
		if(!file.exists()){
			try{
				file.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
				return;
			}
		}
		
		prop.addHeaderLines(new String[] {"Welcome to sJobs 0.0.1 Alpha! Please report any bugs on my bitbucket!"});
		
		if(!prop.containsKey("XP_Per_Level"))
			prop.setString("XP_Per_Level", "25");
			prop.addComment("XP_Per_Level", new String[] {"Please at this time do not change this value."});
			
		prop.save();
		prop.reload();
	}
}
