package org.legitzxdevelopment.discordbot.modules.connect.commands;

import org.legitzxdevelopment.discordbot.commands.CommandContext;
import org.legitzxdevelopment.discordbot.commands.ICommand;

import java.util.Arrays;
import java.util.List;

/**
 * Contributor(s): Luciano K
 * Description:
 */
public class ViewProfileCommand implements ICommand {
    @Override
    public void handle(CommandContext event) {

    }

    @Override
    public List<String> getName() {
        return Arrays.asList("profile");
    }

    @Override
    public String getUsage() {
        return "profile";
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
