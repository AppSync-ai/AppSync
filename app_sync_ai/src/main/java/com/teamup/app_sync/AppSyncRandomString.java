package com.teamup.app_sync;

import java.util.Random;

public class AppSyncRandomString {

    private static final String ALLOWED_CHARACTERS ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String generateUPPERCASE( int length)
    {
        final Random random=new Random();
        final StringBuilder sb=new StringBuilder(length);
        for(int i=0;i<length;++i)
            sb.append(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length())));
        return sb.toString();
    }


    private static final String ALLOWED_CHARACTERS2 ="qwertyuiopasdfghjklzxcvbnm";

    public static String generateLOWECASE( int length)
    {
        final Random random=new Random();
        final StringBuilder sb=new StringBuilder(length);
        for(int i=0;i<length;++i)
            sb.append(ALLOWED_CHARACTERS2.charAt(random.nextInt(ALLOWED_CHARACTERS2.length())));
        return sb.toString();
    }
}
