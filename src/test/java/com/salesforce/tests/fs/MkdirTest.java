package com.salesforce.tests.fs;

import org.junit.Test;

import java.io.IOException;

/**
 * Place holder for your unit tests
 */
public class MkdirTest extends BaseTest {

    @Test
    public void testMkdirSuccessCmd() throws IOException {
        String fileName = "tstF";

        String[] expectedResults = {
                ".\n..\n" + fileName + "/"
        };

        runTest(expectedResults, "mkdir " + fileName, "ls", "quit");
    }

    @Test
    public void testMkdirErrorCmd() throws IOException {
        String fileName = "tstFss%";

        String[] expectedResults = {
                "Invalid dirName"
        };

        runTest(expectedResults, "mkdir " + fileName, "quit");
    }

    @Test
    public void testMkdirExistsCmd() throws IOException {
        String fileName = "tstFs";

        String[] expectedResults = {
                "File/Directory " + fileName + " already exists"
        };

        runTest(expectedResults, "mkdir " + fileName, "mkdir " + fileName, "quit");
        runTest(expectedResults, "mkdir " + fileName, "touch " + fileName, "quit");
    }
}
