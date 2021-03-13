package com.salesforce.tests.fs;

import com.salesforce.tests.fs.command.*;
import com.salesforce.tests.fs.filesystem.Filesystem;

import java.util.Arrays;
import java.util.Scanner;


/**
 * The entry point for the Test program
 */
public class Main {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        String commandLine = "";
        Scanner sc = new Scanner(System.in);
        String response = "";
        boolean persistFilesystem = true;

        if (args.length > 0) {
            for (String s : args) {
                if (s.equals("stateless")) {
                    persistFilesystem = false;
                }
            }
        }

        Filesystem fs = new Filesystem(persistFilesystem);

        // Initiate the chain of responsibility
        // this could be abstracted in a proper class
        CommandImpl shell = new Shell();
        CommandImpl quit = new Quit();
        CommandImpl cd = new ChangeDir(fs);
        CommandImpl ls = new Ls(fs);
        CommandImpl pwd = new Pwd(fs);
        CommandImpl touch = new Touch(fs);
        CommandImpl mkdir = new MakeDir(fs);

        shell.setNextCommand(quit);
        quit.setNextCommand(cd);
        cd.setNextCommand(ls);
        ls.setNextCommand(pwd);
        pwd.setNextCommand(touch);
        touch.setNextCommand(mkdir);

        do {
            // Just for testing, show current path here.
            // Anyways, it looks better this way
            System.out.print(fs.getCurrentNode().name + Filesystem.PATH_DELIMITER);
            System.out.print(":# ");

            // Hackerrank preferred inputs: https://www.hackerrank.com/challenges/java-stdin-and-stdout-1/problem
            commandLine = sc.nextLine();

            if (commandLine.length() > 0) {
                // Basic parsing to have commandLine and args separately
                String[] splitCommand = commandLine.split("\\s");

                response = shell.parse(splitCommand[0], Arrays.asList(splitCommand));

                if (response != null && response.length() > 0) {
                    System.out.println(response);
                }
            }

        } while (response != null);

        sc.close();
    }
}
