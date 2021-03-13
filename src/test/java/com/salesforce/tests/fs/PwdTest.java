package com.salesforce.tests.fs;

import org.junit.Test;

import java.io.IOException;

/**
 * Place holder for your unit tests
 */
public class PwdTest extends BaseTest {

    @Test
    public void testRootPwdCmd() throws IOException {
        String[] expectedResults = {
                "/root"
        };

        runTest(expectedResults, "pwd", "quit");
    }

    @Test
    public void testCdPwdCmd() throws IOException {
        String dirName = "tst";

        String[] expectedResults = {
                "/root/tst"
        };

        runTest(expectedResults, "mkdir " + dirName, "cd " + dirName, "pwd", "quit");
    }
}
