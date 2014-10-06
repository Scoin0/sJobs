package net.tngc.sjobs;

import java.io.File;

import net.canarymod.Canary;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.commandsys.Command;
import net.canarymod.commandsys.CommandListener;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.player.ConnectionHook;
import net.canarymod.plugin.PluginListener;
import net.tngc.sjobs.jobs.Woodcutter;
import net.visualillusionsent.utils.PropertiesFile;
import net.visualillusionsent.utils.StringUtils;

public class sJobsListener implements PluginListener, CommandListener{
	
	String jobs = "Farmer,Welcome";
	
	File user = new File("config/sJobs/users/");
	PropertiesFile users;

	@HookHandler
	public void onLogin(ConnectionHook hook){
		Player player = hook.getPlayer();
		
		if(!user.exists()){
			user.mkdir();
		}
		
		if(new File("worlds/players/" + player.getUUID() + ".dat").exists()){
			PropertiesFile users = new PropertiesFile("config/sJobs/users/" + player.getName() + ".properties");
			
			if(!users.containsKey("Job")){
				users.setString("Job", "Jobless");
			}
			
			if(!users.containsKey("Level"))
				users.setString("Level", "1");
			
			if(!users.containsKey("XP"))
				users.setInt("XP", 0);
			
			if(!users.containsKey("XP_To_Level"))
				users.setString("XP_To_Level", "0");
			
			player.message("Welcome " + player.getName() + "!");
			player.message("Your Current sJobs Stats are:");
			player.message("Job: " + users.getString("Job"));
			player.message("Level: " + users.getString("Level"));
			player.message("XP: " + users.getString("XP"));
			player.message("XP Till Next Level: " + users.getString("XP_To_Level"));
			users.save();
		}
	}
	
	@Command
	(aliases = { "job" },
	description = "Job Command",
	permissions = { "sjobs.command.job" },
	toolTip = "/job <join|leave|help|reload> [job]")
	
	public void job(MessageReceiver caller, String [] parameters){
		caller.notice("Usage: /job <join|leave|help|version> [job] (Job wanting to join)");
	}
	
	@Command
	(aliases = { "join" },
	description = "Join a job!",
	permissions = { "sjobs.command.job" },
	toolTip = "/join [job]",
	parent = "job")
	
	public void join(MessageReceiver caller, String [] parameters){
		if(parameters.length == 1){
			caller.notice("Usage: /job join [job] (Job wanting to join)");
			return;
		}
	}
	
	@Command
	(aliases = { "leave" },
	description = "Leave a job!",
	permissions = { "sjobs.command.job" },
	toolTip = "/leave [job]",
	parent = "job")
	
	public void leave(MessageReceiver caller, String [] parameters){
		if(parameters.length == 1){
			caller.notice("Usage: /job leave [job] (Job wanting to leave)");
			return;
		}
	}
	
	@Command
	(aliases = { "version" },
	description = "Check the version!",
	permissions = { "sjobs.command.job" },
	toolTip = "/version",
	parent = "job")
	
	public void version(MessageReceiver caller, String [] parameters){
		if(parameters.length == 1){
			caller.notice("Welcome to sJobs 0.0.1 Alpha!");
			caller.notice("This is not implemented yet. Please wait.");
			return;
		}
	}
	
	@Command
	(aliases = { "woodcutter" },
	description = "Join a job!",
	permissions = { "sjobs.command.job" },
	toolTip = "/join [job]",
	parent = "join")
	
	public void woodcutter(MessageReceiver caller, String [] parameters){
		caller.notice("You have joined WOODCUTTER!");
		new Woodcutter();
	}
}
