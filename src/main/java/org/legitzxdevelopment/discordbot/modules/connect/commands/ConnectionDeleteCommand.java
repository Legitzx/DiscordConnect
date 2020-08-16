package org.legitzxdevelopment.discordbot.modules.connect.commands;

import org.legitzxdevelopment.discordbot.commands.CommandContext;
import org.legitzxdevelopment.discordbot.commands.ICommand;
import org.legitzxdevelopment.discordbot.modules.ModuleManager;
import org.legitzxdevelopment.discordbot.modules.connect.user.User;

import java.util.Arrays;
import java.util.List;

/**
 * Contributor(s): Luciano K
 */
public class ConnectionDeleteCommand implements ICommand {
    ModuleManager manager;

    public ConnectionDeleteCommand(ModuleManager manager) {
        this.manager = manager;
    }

    @Override
    public void handle(CommandContext event) {
        List<String> args = event.getArgs();
        if(args.size() < 2) {
            event.getChannel().sendMessage("**Invalid ID**").queue();
            return;
        }

        String id = args.get(1);
        System.out.println(args.get(0) + " - " + args.get(1));

        if(id.length() == 22) {
            id = id.substring(3);
            id = id.replace(">", "");
        }

        // Checks if id is valid
        if(id.length() != 18 && args.size() == 0) {
            event.getChannel().sendMessage("**Invalid ID**").queue();
            return;
        }

        User user = manager.getDatabaseApi().getUserProfile(event.getAuthor().getId());
        if(user == null) {
            user = manager.getDatabaseApi().getUserProfile(event.getAuthor().getId());
        }

        user.addFinishedConnection(id);

        manager.getDatabaseApi().updateUserProfile(user);

        event.getChannel().sendMessage("**Success!**").queue();
    }

    @Override
    public List<String> getName() {
        return Arrays.asList("connections", "delete");
    }

    @Override
    public String getUsage() {
        return "connections delete <id>";
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
