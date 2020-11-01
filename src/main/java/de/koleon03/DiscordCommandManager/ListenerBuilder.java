package de.koleon03.DiscordCommandManager;

public class ListenerBuilder {

    private CommandListener listener = new CommandListener();

    public DiscordCommand addCommand(String command){
        if(command.equals("help")){
            throw new IllegalArgumentException("This command is already in use!");
        }
        DiscordCommand createdCommand = new DiscordCommand(command);
        for(DiscordCommand c:listener.getCommands()){
            if(c.getName().equals(command)){
                throw new IllegalArgumentException("This command is already in use!");
            }
        }
        listener.addCommand(createdCommand);
        return createdCommand;
    }

    public CommandListener finish(){
        return listener;
    }

    public DiscordCommand getCommand(String command){
        for(DiscordCommand d:listener.getCommands()){
            if(d.getName().equals(command)){
                return d;
            }
        }
        return new DiscordCommand(command);
    }
}
