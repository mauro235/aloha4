package com.salesforce.tests.fs;

import org.junit.Test;

import java.io.IOException;

/**
 * Place holder for your unit tests
 */
public class CdTest extends BaseTest {

    @Test
    public void testRootCdCmd() throws IOException {
        String[] expectedResults = {
                "/root"
        };

        runTest(expectedResults, "cd .", "pwd", "quit");
    }

    @Test
    public void testCdUpCmd() throws IOException {
        String dirName = "tstDir";

        String[] expectedResults = {
                "root/:# root/:# tstDir/:# root/:#"
        };

        runTest(expectedResults, "mkdir " + dirName, "cd " + dirName, "cd ..", "quit");
    }

    @Test
    public void testCdMultipleCmd() throws IOException {
        String dirName = "tstDir";
        String dirNameB = "tstDirB";

        String[] expectedResults = {
                "/root/" + dirName + "/" + dirNameB
        };

        runTest(expectedResults, "mkdir " + dirName, "cd " + dirName, "mkdir " + dirNameB, "cd ..", "cd " + dirName + "/" + dirNameB, "pwd", "quit");
    }
}
