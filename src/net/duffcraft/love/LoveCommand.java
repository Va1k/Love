package net.duffcraft.love;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LoveCommand
  implements CommandExecutor
{
  private static Love plugin;

  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    Player player = (Player)sender;
    if (args.length < 1) {
      player.sendMessage(ChatColor.LIGHT_PURPLE + "Usage: /love <object of desire>");
    }
    else {
      String plrname = player.getDisplayName();
      String victim = mkstring(0, args, " ");
      LoveMsg(victim, plrname);
    }
    return true;
  }
  public static void LoveMsg(String victim, String plrname) {
    String msg = ChatColor.AQUA + plrname + ChatColor.LIGHT_PURPLE + " smothers " + ChatColor.AQUA + victim + ChatColor.LIGHT_PURPLE + " with love!";
    for (Player plr : plugin.getServer().getOnlinePlayers())
      plr.sendMessage(msg);
  }

  public static String mkstring(int startIndex, String[] string, String seperator) {
    StringBuilder builder = new StringBuilder();
    for (int i = startIndex; i < string.length; i++) {
      builder.append(string[i]);
      builder.append(seperator);
    }
    builder.deleteCharAt(builder.length() - seperator.length());
    return builder.toString();
  }
}