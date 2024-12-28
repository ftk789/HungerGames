package tk.shanebee.hg.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.shanebee.hg.HG;
import tk.shanebee.hg.game.Game;

public class reduceStartingTimerCmd extends BaseCmd {

    public reduceStartingTimerCmd() {
        cmdName = "reduceStartingTimer";
        argLength = 1; // Requires a single argument
        usage = "<arena-name>"; // Usage
    }

    @Override
    public boolean processCmd(HG plugin, CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used by players.");
            return true;
        }
        Player player = (Player) sender;
        Game game = plugin.getManager().getGame(args[1]);
        if (game != null) {
            game.reduceStartingTimer();
            player.sendMessage("Starting timer reduced to 30 seconds for arena " + args[1]);
        } else {
            player.sendMessage("Arena not found.");
        }
        return true;
    }
}
