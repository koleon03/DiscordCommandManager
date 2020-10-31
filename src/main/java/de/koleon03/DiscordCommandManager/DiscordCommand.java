package de.koleon03.DiscordCommandManager;

public class DiscordCommand {

    private String cmd;
    private CommandExecutor executor;

    public DiscordCommand(String cmd){
        this.cmd = cmd;
    }

    public void addExecutor(CommandExecutor commandExecutor){
        this.executor = commandExecutor;
    }

    public CommandExecutor getExecutor(){
        return executor;
    }

    public String getName(){
        return cmd;
    }
}
