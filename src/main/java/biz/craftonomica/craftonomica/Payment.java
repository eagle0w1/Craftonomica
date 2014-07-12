package biz.craftonomica.craftonomica;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;

/**
 *
 */
public class Payment {

    public static void payTo(Player payer, String[] args) {
        Server server = Bukkit.getServer();
        Player payee;
        int amount;

// ---------------------
        if (args.length != 2) {
            payer.chat("usage: payto <player> <amount (integer)>");
            return;
        }
// ----------------------
        payee = (server.getPlayer(args[0]));
        if (payee == null) {
            payer.sendMessage(args[0] + " is not online!");
            return;
        }
// --------------------
        try {
            amount = Integer.parseInt(args[1]);
        } catch (NumberFormatException nfe) {
            payer.sendMessage(args[1] + " is not valid number (it should be integer)");
            return;
        }

        if (amount <= 0) {
            payer.sendMessage("You entered " + amount + "this is not valid, should be > 0");
            return;
        }
// ---------------------
        int payerExperienceLevel = payer.getLevel();
        if (amount > payerExperienceLevel) {
            payer.sendMessage("You don't have" + amount + ", You have only " + payerExperienceLevel);
            return;
        }
// ---------------------

        payer.setLevel(payer.getLevel() - amount);
        payee.setLevel(payee.getLevel() + amount);
        payer.sendMessage("You paid " + amount + " to " + payee.getName());
        payee.sendMessage("You received payment from " + payer.getName() + " : " + amount);
        return;
    }
}
