package net.duffcraft.love;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LoveGiveCommand
  implements CommandExecutor
{
  private static Love plugin;

  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    Player player = (Player)sender;
    if (args.length < 1) {
      player.sendMessage(ChatColor.LIGHT_PURPLE + "Usage: /love -g <player>");
    }
    else {
      String plrname = player.getName();
      Player victim = Bukkit.getPlayerExact(args[1]);
      String vic = args[1];
      LoveMsg(vic, plrname);
      //remove 2 health (1 heart) from the player
      player.setHealth(player.getHealth() - 2);
      //add 2 health to the "victim"
      if(victim.getHealth() > 20) {
    	  //do nothing
      } if(victim.getHealth() == 19) {
    	  //only add 1 health
    	  victim.setHealth(victim.getHealth() + 1);
      } else {
    	  victim.setHealth(victim.getHealth() + 2);
      }
      
    }
    return true;
}
public static void LoveMsg(String victim, String plrname) {
    String msg = ChatColor.AQUA + plrname + ChatColor.LIGHT_PURPLE + " smothers " + ChatColor.AQUA + victim + ChatColor.LIGHT_PURPLE + " with love!";
    for (Player plr : plugin.getServer().getOnlinePlayers())
      plr.sendMessage(msg);
  }
}