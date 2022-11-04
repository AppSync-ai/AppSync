package com.teamup.app_sync;

public class AppSyncEncryptDecrypt {
    public static String key = "Mention in String file";

    public static String Encrypt(String textToEncrypt) {
        String encrypted = "";
        String sourceStr = "" + textToEncrypt;
        try {
            encrypted = AESUtils.encrypt(sourceStr);
            return encrypted;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String Decrypt(String textToDecrypt) {
        if (!textToDecrypt.contains(" ")) {
            String encrypted = "";
            String sourceStr = "" + textToDecrypt;
            try {
                encrypted = AESUtils.decrypt(sourceStr);
                return encrypted;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return textToDecrypt;
        }
        return null;
    }
}
