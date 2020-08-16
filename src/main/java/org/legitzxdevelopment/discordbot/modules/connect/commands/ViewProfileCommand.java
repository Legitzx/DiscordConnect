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
public class ViewProfileCommand implements ICommand {
    ModuleManager manager;

    public ViewProfileCommand(ModuleManager manager) {
        this.manager = manager;
    }

    @Override
    public void handle(CommandContext event) {
        String id = event.getAuthor().getId();
        List<String> args = event.getArgs();

        if(args.size() > 0) {
            id = args.get(0);
        }

        if(id.length() == 22) {
            id = id.substring(3);
            id = id.replace(">", "");
        }

        System.out.println(id);

        // Checks if id is valid
        if(id.length() != 18 && args.size() == 0) {
            event.getChannel().sendMessage("**Invalid ID**").queue();
            return;
        }

        User user = manager.getDatabaseApi().getUserProfile(id);

        // Checks if user is null
        if(user == null) {
            user = manager.getDatabaseApi().getUserProfile(id);
        }

        EmbedBuilder builder = new EmbedBuilder();
        builder.setColor(Color.CYAN);
        builder.setTitle("Profile of " + user.getName());
        builder.addField("id", user.getId(), true);
        builder.addField("Bio", user.getBio(), true);
        builder.addField("Location", user.getLocation(), true);

        // Get interests
        StringBuilder strBuilder = new StringBuilder();
        for(String interest : user.getInterests()) {
            strBuilder.append(interest + "\n");
        }

        builder.addField("Interests", strBuilder.toString(), true);

        event.getChannel().sendMessage(builder.build()).queue();
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
