package com.salesforce.tests.fs.command;

import java.util.List;

public interface Command {
    // Probably a set of args could prevent duplicates
    String parse(String cmd, List<String> args);
}