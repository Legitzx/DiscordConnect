package org.legitzxdevelopment.discordbot.modules.connect;

import org.legitzxdevelopment.discordbot.Bot;
import org.legitzxdevelopment.discordbot.commands.ICommand;
import org.legitzxdevelopment.discordbot.modules.IModule;
import org.legitzxdevelopment.discordbot.modules.ModuleManager;
import org.legitzxdevelopment.discordbot.modules.connect.commands.ViewProfileCommand;

import java.util.List;

/**
 * Contributor(s): Luciano K
 * Description:
 */
public class ConnectModule implements IModule {
    public ConnectModule(Bot bot, ModuleManager manager) {
        System.out.println(manager.getDatabaseApi().doesUserExist("611289956995956736"));
        manager.addCommand(this, new ViewProfileCommand());
    }

    @Override
    public String getName() {
        return "Connect";
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public List<ICommand> getCommands() {
        return commands;
    }
}
