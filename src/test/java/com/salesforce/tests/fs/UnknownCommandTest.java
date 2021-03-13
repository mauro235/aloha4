package com.salesforce.tests.fs;

import org.junit.Test;

import java.io.IOException;

/**
 * Place holder for your unit tests
 */
public class UnknownCommandTest extends BaseTest {

    @Test
    public void testUnknownCmd() throws IOException {
        String testCmd = "test";

        String[] expectedResults = {
                "Unknown command '" + testCmd + "'\n"
        };

        runTest(expectedResults, "test", "quit");
    }
}
