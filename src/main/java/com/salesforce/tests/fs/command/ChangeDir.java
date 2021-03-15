package com.salesforce.tests.fs.command;

import com.salesforce.tests.fs.filesystem.Filesystem;

import java.util.List;

public class ChangeDir extends CommandImpl {
    public static String command = "cd";

    private Filesystem fs;

    public ChangeDir(Filesystem fs) {
        commandName = command;
        this.fs = fs;
    }

    // error: 'Invalid path' if any of path parts are invalid, 'Directory not found'
    @Override
    public String execute(String cmd, List<String> args) {
        if (args.size() == 2) {
            return fs.changePath(args.get(1));
        } else {
            return command + " takes only 1 argument";
        }
    }
}
