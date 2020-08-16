package org.legitzxdevelopment.discordbot.modules.connect;

import org.legitzxdevelopment.discordbot.Bot;
import org.legitzxdevelopment.discordbot.commands.ICommand;
import org.legitzxdevelopment.discordbot.modules.IModule;
import org.legitzxdevelopment.discordbot.modules.ModuleManager;
import org.legitzxdevelopment.discordbot.modules.connect.commands.ProfileEditCommand;
import org.legitzxdevelopment.discordbot.modules.connect.commands.ViewProfileCommand;

import java.util.List;

/**
 * Contributor(s): Luciano K
 * Description:
 */
public class ConnectModule implements IModule {
    public ConnectModule(Bot bot, ModuleManager manager) {
        manager.addCommand(this, new ProfileEditCommand(manager));
        manager.addCommand(this, new ViewProfileCommand(manager));
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
