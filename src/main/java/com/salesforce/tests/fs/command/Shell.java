package com.salesforce.tests.fs.command;

import java.util.List;

public class Shell extends CommandImpl {

    @Override
    public String parse(String cmd, List<String> args) {
        if (nextCommand != null) {
            return nextCommand.parse(cmd, args);
        } else {
            return "";
        }
    }
}
