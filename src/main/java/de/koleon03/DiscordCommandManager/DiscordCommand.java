package de.koleon03.DiscordCommandManager;

public class DiscordCommand {

    private String cmd;
    private CommandExecutor executor;
    private String help;

    public DiscordCommand(String cmd){
        this.cmd = cmd;
    }

    public void setExecutor(CommandExecutor commandExecutor){
        this.executor = commandExecutor;
    }

    public CommandExecutor getExecutor(){
        return executor;
    }

    public String getName(){
        return cmd;
    }

    public void setHelp(String helpText){
        this.help = helpText;
    }

    public void setup(CommandExecutor commandExecutor, String helpText){
        this.help = helpText;
        this.executor = commandExecutor;
    }

    public String getHelp() {
        return help;
    }
}
