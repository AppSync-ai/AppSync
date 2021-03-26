package com.teamup.app_sync;

import java.text.DecimalFormat;

public class AppSyncNumberTheory {
    public static String prettyCount(Number number) {
        char[] suffix = {' ', 'k', 'M', 'B', 'T', 'P', 'E'};
        long numValue = number.longValue();
        int value = (int) Math.floor(Math.log10(numValue));
        int base = value / 3;
        if (value >= 3 && base < suffix.length) {
            return new DecimalFormat("#0.0").format(numValue / Math.pow(10, base * 3)) + suffix[base];
        } else {
            return new DecimalFormat("#,##0").format(numValue);
        }
    }

    public static String replaceWithAsterisk(String str, int upto) {

        try {
            char[] chars = str.toCharArray();
            for (int i = 0, j = 0; i < chars.length && j < upto; i++) {
                char ch = chars[i];
                if (!Character.isWhitespace(ch)) {
                    chars[i] = '*';
                    j++;
                }
            }

            str = new String(chars);

        } catch (Exception v) {

        }
        return str;
    }

}
