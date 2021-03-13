package com.salesforce.tests.fs.command;

import com.salesforce.tests.fs.filesystem.Filesystem;

import java.util.List;

public class Ls extends CommandImpl {
    public static String command = "ls";

    private Filesystem fs;

    public Ls(Filesystem fs) {
        this.fs = fs;
    }

    // args: -r
    @Override
    public String parse(String cmd, List<String> args) {
        if (cmd.equals(command)) {
            // Check for arguments if -r go recursive, any other argument throw error
            // also check for other path if provided but for now it is out of scope

            if (fs != null) {
                return fs.getPathContents(null, false);
            } else {
                return "Error processing command " + command;
            }
        } else {
            if (nextCommand != null) {
                return nextCommand.parse(cmd, args);
            } else {
                return emtpyChainError(cmd);
            }
        }
    }
}
