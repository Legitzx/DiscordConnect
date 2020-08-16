package org.legitzxdevelopment.discordbot.modules.connect.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
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
public class ProfileEditCommand implements ICommand {
    private ModuleManager manager;

    public ProfileEditCommand(ModuleManager manager) {
        this.manager = manager;
    }

    @Override
    public void handle(CommandContext event) {
        List<String> args = event.getArgs();
        TextChannel channel = event.getChannel();

        if(args.size() <= 1) {
            sendInfoEmbed(event.getChannel());
            return;
        }

        User user = manager.getDatabaseApi().getUserProfile(event.getAuthor().getId());

        String field = args.get(1);
        String content = event.getMessage().getContentDisplay().substring(args.get(0).length() + event.getMessage().getContentDisplay().indexOf(args.get(0)));

        if((content.isEmpty() || args.size() < 3) && !args.get(1).equalsIgnoreCase("interests")) {
            channel.sendMessage("**You must include some content!**").queue();
            return;
        }

        if(field.equalsIgnoreCase("name")) {
            content = content.substring(5);
            System.out.println("name - " + content);
            user.setName(content);
            manager.getDatabaseApi().updateUserProfile(user);
            event.getChannel().sendMessage("**Success!**").queue();
            return;
        }

        if(field.equalsIgnoreCase("location")) {
            content = content.substring(9);
            System.out.println("location - " + content);
            user.setLocation(content);
            manager.getDatabaseApi().updateUserProfile(user);
            event.getChannel().sendMessage("**Success!**").queue();
            return;
        }

        if(field.equalsIgnoreCase("bio")) {
            content = content.substring(4);
            System.out.println("bio - " + content);
            user.setBio(content);
            manager.getDatabaseApi().updateUserProfile(user);
            event.getChannel().sendMessage("**Success!**").queue();
            return;
        }

        if(field.equalsIgnoreCase("interests")) {
            System.out.println(1);
            if(args.size() <= 3) {
                EmbedBuilder builder = new EmbedBuilder();
                builder.setTitle("Interests Sub Commands");
                builder.setDescription("``add <content>`` \n ``remove <content>``");
                channel.sendMessage(builder.build()).queue();
                return;
            }

            if(args.get(2).equalsIgnoreCase("add")) {
                content = content.substring(14);
                System.out.println("ADD - " + content);
                user.addInterest(content);
                manager.getDatabaseApi().updateUserProfile(user);
                event.getChannel().sendMessage("**Success!**").queue();
                return;
            }
            if(args.get(2).equalsIgnoreCase("remove")) {
                content = content.substring(17);
                System.out.println("REMOVE - " + content);
                user.removeInterest(content);
                manager.getDatabaseApi().updateUserProfile(user);
                event.getChannel().sendMessage("**Success!**").queue();
                return;
            }
        }
    }

    @Override
    public List<String> getName() {
        return Arrays.asList("profile", "edit");
    }

    @Override
    public String getUsage() {
        return "profile edit <field> <content>";
    }

    @Override
    public boolean isActive() {
        return true;
    }

    public void sendInfoEmbed(TextChannel channel) {
        EmbedBuilder builder = new EmbedBuilder();
        builder.setColor(Color.CYAN);
        builder.setTitle("You can edit the following fields");
        builder.setDescription("``name`` \n ``bio`` \n ``location`` \n ``interests``");
        channel.sendMessage(builder.build()).queue();
    }
}
