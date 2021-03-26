package com.teamup.rohitasawa_library;

public class RohitEncryptDecrypt {
    public static String key = "";
    public static String Encrypt(String textToEncrypt)
    {
        String encrypted = "";
        String sourceStr = ""+textToEncrypt;
        try {
            encrypted = AESUtils.encrypt(sourceStr);
            return encrypted;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String Decrypt(String textToDecrypt)
    {
        String encrypted = "";
        String sourceStr = ""+textToDecrypt;
        try {
            encrypted = AESUtils.decrypt(sourceStr);
            return encrypted;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
