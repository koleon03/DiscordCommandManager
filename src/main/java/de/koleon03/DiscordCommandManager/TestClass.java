package de.koleon03.DiscordCommandManager;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class TestClass {

    public static void main(String[] args) throws LoginException, InterruptedException {
        JDABuilder jdaBuilder = JDABuilder.createDefault("NzcxMDY3NzA4MTkxODAxMzg1.X5muww.rHlqhSAbii-amNU1meizzyLcp7U");
        ListenerBuilder builder = new ListenerBuilder();
        builder.addCommand("ping").setup(commandMessage -> commandMessage.replyTo("Pong!"), "Ping Help");
        jdaBuilder.addEventListeners(builder.finish());
        JDA jda = jdaBuilder.build();
        jda.awaitReady();
    }
}
