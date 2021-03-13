package com.salesforce.tests.fs;

import org.junit.Test;

import java.io.IOException;

/**
 * Place holder for your unit tests
 */
public class LsTest extends BaseTest {

    @Test
    public void testRootLsCmd() throws IOException {
        String[] expectedResults = {
                ".\n..\n"
        };

        runTest(expectedResults, "ls", "quit");
    }

    @Test
    public void testFileLsCmd() throws IOException {
        String testFile = "tst";

        String[] expectedResults = {
                ".\n..\n" + testFile
        };

        runTest(expectedResults, "touch " + testFile, "ls", "quit");
    }

    @Test
    public void testDirLsCmd() throws IOException {
        String testDir = "tst";

        String[] expectedResults = {
                ".\n..\n" + testDir + "/"
        };

        runTest(expectedResults, "mkdir " + testDir, "ls", "quit");
    }
}
