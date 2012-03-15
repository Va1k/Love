package net.duffcraft.love;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Love extends JavaPlugin
{
  public void onEnable()
  {
    getCommand("love").setExecutor(new LoveCommand());
    //getCommand("gl").setExecutor(new LoveGiveCommand());
    PluginDescriptionFile pdfFile = getDescription();
    System.out.println("Love " + pdfFile.getVersion() + " enabled.");
  }
  public void onDisable() {
    PluginDescriptionFile pdfFile = getDescription();
    System.out.println("Love " + pdfFile.getVersion() + " disabled.");
  }
}
