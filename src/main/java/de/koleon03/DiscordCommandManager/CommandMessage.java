package de.koleon03.DiscordCommandManager;

import net.dv8tion.jda.api.entities.Message;

public class CommandMessage {

    private Message message;
    private String[] args;

    public CommandMessage(Message message, String[] args){
        this.message = message;
        this.args = args;
    }

    public Message getMessage() {
        return message;
    }

    public void replyTo(String reply){
        message.getChannel().sendMessage(reply).queue();
    }

    public String[] getArgs() {
        return args;
    }
}
