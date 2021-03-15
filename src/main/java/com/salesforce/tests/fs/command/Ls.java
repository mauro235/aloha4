package com.salesforce.tests.fs.command;

import com.salesforce.tests.fs.filesystem.Filesystem;

import java.util.List;

public class Ls extends CommandImpl {
    public static String command = "ls";

    private Filesystem fs;

    public Ls(Filesystem fs) {
        commandName = command;
        this.fs = fs;
    }

    // args: -r
    @Override
    public String execute(String cmd, List<String> args) {
        // Check for arguments if -r go recursive, any other argument throw error
        // also check for other path if provided but for now it is out of scope
        if (fs != null) {
            return fs.getPathContents(null, false);
        } else {
            return "Error processing command " + command;
        }
    }
}
