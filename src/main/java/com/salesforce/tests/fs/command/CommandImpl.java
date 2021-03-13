package com.salesforce.tests.fs.command;

import java.util.List;

public abstract class CommandImpl implements Command {

    protected CommandImpl nextCommand;

    public CommandImpl() {

    }

    protected String emtpyChainError(String cmd) {
        return "Unknown command '" + cmd + "'";
    }

    public void setNextCommand(CommandImpl cmd) {
        nextCommand = cmd;
    }

    public abstract String parse(String cmd, List<String> args);

}
