package me.bamle.godzillabot;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
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

        if (command.equalsIgnoreCase("postmsg")) {
            TextChannel kanal = event.getOption("kanal").getAsChannel().asTextChannel();
            String msg = event.getOption("melding").getAsString();
            kanal.sendMessage(msg).queue();
            event.reply("Sendte melding ```" + msg + "``` i " + kanal.getAsMention()).queue();



        }


    }

    @Override
    public void onGuildReady(GuildReadyEvent event) {
        commandData.add(Commands.slash("postmsg", "Send en melding i en kanal").addOption(OptionType.CHANNEL, "kanal","Hvilken kanal ønsker du?").addOption(OptionType.STRING, "melding", "Innhold i melding"));
        event.getJDA().updateCommands().addCommands(commandData).queue();
        commandData.clear();
    }
}
