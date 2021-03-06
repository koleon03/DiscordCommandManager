package de.koleon03.DiscordCommandManager;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandListener implements EventListener {

    private ArrayList<DiscordCommand> commands = new ArrayList<>();

    @Override
    public void onEvent(@NotNull GenericEvent genericEvent) {
        if(genericEvent instanceof MessageReceivedEvent){
            MessageReceivedEvent mre = (MessageReceivedEvent)genericEvent;
            String messageText = mre.getMessage().getContentRaw();
            String[] arg = messageText.split(" ");
            String command = arg[0].toUpperCase();
            if(arg[0].charAt(0) == '!'){
                for(DiscordCommand c:commands) {
                    if (command.substring(1).equals(c.getName().toUpperCase())) {
                        String[] args = Arrays.copyOfRange(arg, 1, arg.length);
                        c.getExecutor().onCommand(new CommandMessage(mre.getMessage(), args));
                    }
                }
                if(arg[0].equals("!help")){
                    HelpGenerator gen = new HelpGenerator(commands, mre.getChannel());
                    gen.generate();
                }
            }
        }
    }

    public void addCommand(DiscordCommand command){
        commands.add(command);
    }

    public ArrayList<DiscordCommand> getCommands() {
        return commands;
    }
}
