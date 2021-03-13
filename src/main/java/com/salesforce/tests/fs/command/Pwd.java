package com.salesforce.tests.fs.command;

import com.salesforce.tests.fs.filesystem.Filesystem;

import java.util.List;

public class Pwd extends CommandImpl {
    public static String command = "pwd";

    private Filesystem fs;

    public Pwd(Filesystem fs) {
        this.fs = fs;
    }

    public String parse(String cmd, List<String> args) {
        if (cmd.equals(command)) {
            if (fs != null) {
                return fs.getCurrentPath();
            } else {
                return "Error processing command " + command;
            }
        } else {
            if (nextCommand != null) {
                return nextCommand.parse(cmd, args);
            } else {
                return "Unknown command '" + cmd + "'";
            }
        }
    }
}
