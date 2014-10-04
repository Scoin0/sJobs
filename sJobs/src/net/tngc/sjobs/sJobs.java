package net.tngc.sjobs;

import net.canarymod.Canary;
import net.canarymod.commandsys.CommandDependencyException;
import net.canarymod.plugin.Plugin;
import net.tngc.sjobs.Configuration.Configuration;
import net.tngc.sjobs.jobs.Woodcutter;

public class sJobs extends Plugin{
	
	public static String Plugin_Name = "sJobs ";
	public static String Plugin_Version = "0.0.1 Alpha ";
	public static String Plugin_Author = "Scoin0 ";
	
	public boolean enable() {
		getLogman().info(Plugin_Name + Plugin_Version + "created by " + Plugin_Author + "has been enabled!");
		
		Canary.hooks().registerListener(new sJobsListener(), this);
		Canary.hooks().registerListener(new Woodcutter(), this);
		try{Canary.commands().registerCommands(new sJobsListener(), this, false);}
        catch(CommandDependencyException e){getLogman().error("Error with Command: ", e);}
		new Configuration().loadProperties();
		
		return true;
	}

	public void disable() {
		getLogman().info(Plugin_Name + "has been Disabled!");
	}
}
