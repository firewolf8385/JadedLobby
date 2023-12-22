package net.jadedmc.jadedlobby.gui;

import net.jadedmc.jadedcore.utils.gui.CustomGUI;
import net.jadedmc.jadedutils.items.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class JamisonGUI extends CustomGUI {

    public JamisonGUI() {
        super(54, "Jamison the Journeyman");

        addFiller(0,1,2,3,4,5,6,7,8,45,46,47,48,49,50,51,52,53);

        ItemStack voteItem = new ItemBuilder(Material.GOLD_BLOCK)
                .setDisplayName("&a&lVote")
                .addLore("<gray>Click to visit the voting websites!").addLore("").addLore("<gray>Rewards:").addLore("  <white>3x <gray><bold>Treasure Key").build();

        setItem(22, voteItem, (p,a) -> Bukkit.dispatchCommand(p, "vote"));
    }

}
