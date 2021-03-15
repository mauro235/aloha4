package com.salesforce.tests.fs.command;

import java.util.List;

public class Quit extends CommandImpl {
    public static String command = "quit";

    public Quit() {
        commandName = command;
    }

    @Override
    public String execute(String cmd, List<String> args) {
        return null;
    }
}