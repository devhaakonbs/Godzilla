package me.bamle.godzillabot;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.Arrays;

public class Godzilla extends ListenerAdapter {

    private static final GatewayIntent[] gatewayIntents = {
            GatewayIntent.GUILD_MESSAGES,
            GatewayIntent.GUILD_MODERATION,
            GatewayIntent.MESSAGE_CONTENT,
            GatewayIntent.GUILD_MESSAGE_TYPING,
            GatewayIntent.GUILD_MESSAGE_REACTIONS,
            GatewayIntent.GUILD_MEMBERS,
            GatewayIntent.DIRECT_MESSAGES,
            GatewayIntent.DIRECT_MESSAGE_REACTIONS,
            GatewayIntent.DIRECT_MESSAGE_TYPING
    };

    public static void main(String[] args) {
        Godzilla main = new Godzilla();
        JDABuilder jdaBuilder = JDABuilder.create("", Arrays.asList(gatewayIntents)).addEventListeners(main);
        jdaBuilder.addEventListeners(new TestCmd());
        try {
            JDA jda = jdaBuilder.build().awaitReady();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
