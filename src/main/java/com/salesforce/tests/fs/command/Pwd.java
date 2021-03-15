package com.salesforce.tests.fs.command;

import com.salesforce.tests.fs.filesystem.Filesystem;

import java.util.List;

public class Pwd extends CommandImpl {
    public static String command = "pwd";

    private Filesystem fs;

    public Pwd(Filesystem fs) {
        commandName = command;
        this.fs = fs;
    }

    @Override
    public String execute(String cmd, List<String> args) {
        if (fs != null) {
            return fs.getCurrentPath();
        } else {
            return "Error processing command " + command;
        }
    }
}
