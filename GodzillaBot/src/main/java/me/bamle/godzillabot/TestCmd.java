package me.bamle.godzillabot;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TestCmd extends ListenerAdapter {

    public List<CommandData> commandData = new ArrayList<>();

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        String command = event.getName();
        if (command.equalsIgnoreCase("test")) {
            event.reply("Test").queue();

        }


    }

    @Override
    public void onGuildReady(GuildReadyEvent event) {
        commandData.add(Commands.slash("test", "test kommando"));
        event.getJDA().updateCommands().addCommands(commandData).queue();
        commandData.clear();
    }
}
