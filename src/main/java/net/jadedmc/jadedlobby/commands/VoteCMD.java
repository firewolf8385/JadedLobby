package net.jadedmc.jadedlobby.commands;

import net.jadedmc.jadedutils.chat.ChatUtils;
import org.bukkit.command.CommandSender;

public class VoteCMD extends AbstractCommand {

    public VoteCMD() {
        super("vote", "", false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        ChatUtils.chat(sender, "&a▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
        ChatUtils.chat(sender, "");
        ChatUtils.chat(sender, ChatUtils.centerText("&a&lVote Links"));
        ChatUtils.chat(sender, "");
        ChatUtils.chat(sender, "<hover:show_text:'<green>Click to Visit'><dark_gray>  » <green><click:open_url:'https://findmcserver.com/server/s3zoZ02yd0'>Vote Site 1</click></hover>");
        ChatUtils.chat(sender, "<hover:show_text:'<green>Click to Visit'><dark_gray>  » <green><click:open_url:'https://www.planetminecraft.com/server/elytrapvp-4338121/vote/'>Vote Site 2</click></hover>");
        ChatUtils.chat(sender, "<hover:show_text:'<green>Click to Visit'><dark_gray>  » <green><click:open_url:'https://minecraftservers.org/vote/569103'>Vote Site 3</click></hover>");
        ChatUtils.chat(sender, "&a▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
    }
}
