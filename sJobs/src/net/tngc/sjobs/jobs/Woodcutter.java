package net.tngc.sjobs.jobs;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.BlockType;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.player.BlockDestroyHook;
import net.canarymod.plugin.PluginListener;
import net.visualillusionsent.utils.PropertiesFile;

public class Woodcutter implements PluginListener{
	
	//Somethings going wrong here...It's just late so I'm not thinking well...
	
	@HookHandler
	public void onBreak(BlockDestroyHook hook){
		Player player = hook.getPlayer();
		PropertiesFile users = new PropertiesFile("config/sJobs/users/" + player.getName() + ".properties");
		Block blockBroke = hook.getBlock();
		if(blockBroke.getType() == BlockType.Dirt){
			player.message("You broke dirt?");
			users.setInt("XP", 0 + 1);
			users.getInt("XP" + 1);
			users.save();
			users.reload();
		}
	}
}
