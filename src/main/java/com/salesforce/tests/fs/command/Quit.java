package com.salesforce.tests.fs.command;

import java.util.List;

public class Quit extends CommandImpl {
    public static String command = "quit";

    public Quit() {
    }

    @Override
    public String parse(String cmd, List<String> args) {
        if (cmd.equals(command)) {
            return null;
        } else {
            if (nextCommand != null) {
                return nextCommand.parse(cmd, args);
            } else {
                return emtpyChainError(cmd);
            }
        }
    }
}