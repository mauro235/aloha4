package com.salesforce.tests.fs.command;

import java.util.List;

public abstract class CommandImpl implements Command {

    protected CommandImpl nextCommand;
    protected String commandName = "";

    public CommandImpl() {

    }

    protected String emtpyChainError(String cmd) {
        return "Unknown command '" + cmd + "'";
    }

    public void setNextCommand(CommandImpl cmd) {
        nextCommand = cmd;
    }

    protected abstract String execute(String cmd, List<String> args);

    public String parse(String cmd, List<String> args) {
        if (cmd.equals(commandName)) {
            return execute(cmd, args);
        } else {
            if (nextCommand != null) {
                return nextCommand.parse(cmd, args);
            } else {
                return emtpyChainError(cmd);
            }
        }
    }

}
