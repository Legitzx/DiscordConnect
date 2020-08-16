package org.legitzxdevelopment.discordbot.modules.connect.commands;

import org.legitzxdevelopment.discordbot.commands.CommandContext;
import org.legitzxdevelopment.discordbot.commands.ICommand;
import org.legitzxdevelopment.discordbot.modules.ModuleManager;

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

        System.out.println(args.size());
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
