package com.teamup.rohitasawa_library;

import android.content.Context;

import java.util.Random;

public class RohitRandomNumber {

    private static final String ALLOWED_CHARACTERS ="0123456789";

    public static String generateRandomNumber( int length)
    {
        final Random random=new Random();
        final StringBuilder sb=new StringBuilder(length);
        for(int i=0;i<length;++i)
            sb.append(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length())));
        return sb.toString();
    }
}
