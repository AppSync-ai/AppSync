package com.teamup.app_sync;

public class AppSyncSplitString {

    public static String spit(String fullString, String splitterString, int partOfString) {
        String currentString = "" + fullString;
        String[] separated = currentString.split(splitterString);
        String one = separated[0];
        String two = separated[1];

        if (partOfString == 1) {
            return one;
        } else {
            return two;
        }
    }
}
