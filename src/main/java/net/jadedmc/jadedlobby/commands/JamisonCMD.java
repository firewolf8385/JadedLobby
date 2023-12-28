package net.jadedmc.jadedlobby.commands;

import net.jadedmc.jadedlobby.gui.JamisonGUI;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JamisonCMD extends AbstractCommand {

    public JamisonCMD() {
        super("jamison", "", false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        new JamisonGUI().open(player);
    }
}