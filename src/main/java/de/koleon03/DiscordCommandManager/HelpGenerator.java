package de.koleon03.DiscordCommandManager;

import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.ArrayList;

public class HelpGenerator {

    private ArrayList<DiscordCommand> commands;
    private MessageChannel channel;

    public HelpGenerator(ArrayList<DiscordCommand> commands, MessageChannel channel){
        this.commands = commands;
        this.channel = channel;
    }

    public void generate(){
        for(DiscordCommand d:commands){
            String t = "!" + d.getName() + ": " + d.getHelp();
            channel.sendMessage(t).queue();
        }
    }
}
