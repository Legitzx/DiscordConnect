package org.legitzxdevelopment.discordbot.modules.connect.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import org.legitzxdevelopment.discordbot.commands.CommandContext;
import org.legitzxdevelopment.discordbot.commands.ICommand;
import org.legitzxdevelopment.discordbot.modules.ModuleManager;
import org.legitzxdevelopment.discordbot.modules.connect.user.User;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 * Contributor(s): Luciano K
 */
public class ConnectionCommand implements ICommand {
    private ModuleManager manager;

    public ConnectionCommand(ModuleManager manager) {
        this.manager = manager;
    }

    @Override
    public void handle(CommandContext event) {
        User user = manager.getDatabaseApi().getUserProfile(event.getAuthor().getId());

        if(user.getInterests().size() == 0) {
            event.getChannel().sendMessage("**You currently have no interests! Add interests by executing ``!profile edit interests add <interest>``**").queue();
            return;
        }

        List<User> connections = manager.getDatabaseApi().fetchConnections(user);

        EmbedBuilder builder = new EmbedBuilder();
        StringBuilder stringBuilder = new StringBuilder();
        builder.setTitle("Connections");
        builder.setColor(Color.CYAN);

        if(connections.isEmpty()) {
            builder.setDescription("**We could not find any connections! Try adding more interests! ``!profile edit interests add <interest>**");
            event.getChannel().sendMessage(builder.build()).queue();
            return;
        }

        int count = 0;
        for(User u : connections) {
            count++;
            System.out.println(u.getId());
            stringBuilder.append(event.getGuild().getMemberById(u.getId()).getAsMention() + " Shares interests with you! " + " Fetch his profile by executing ``!profile " + u.getId() + "``");
            if(count >= 10) {
                break;
            }
        }

        builder.setDescription(stringBuilder.toString());

        event.getChannel().sendMessage(builder.build()).queue();
    }

    @Override
    public List<String> getName() {
        return Arrays.asList("connections");
    }

    @Override
    public String getUsage() {
        return "connections";
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
