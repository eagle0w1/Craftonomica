package biz.craftonomica.craftonomica;

/**
 * @author Eagle0w1
 */

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Craftonomica extends JavaPlugin {

    //    public static Logger log = Logger.getLogger("Minecraft");
    @Override
    public void onEnable() {
        getLogger().info("[Craftonomica] Start up.");
    }

    @Override
    public void onDisable() {
        getLogger().info("[Craftonomica] Server stopping.");
    }

    public boolean onCommand(CommandSender sender, Command command,
                             String commandLabel, String[] args) {
        if (commandLabel.equalsIgnoreCase("payto")) {
            if (sender instanceof Player) {
                Player payer = (Player) sender;
                // Put your code after this line:
                Payment.payTo(payer, args);
                // ...and finish your code before this line.
                return true;
            }
        }
        return false;
    }
}
