package com.teamup.rohitasawa_library;

import java.util.Random;

public class RohitHexColor {

    public static String lastColorCode = "";

    public static String generate() {
        Random obj = new Random();
        int rand_num = obj.nextInt(0xffffff + 1);
        String colorCode = String.format("#%06x", rand_num);
        System.out.println(colorCode);
        lastColorCode = colorCode;
        return colorCode;
    }


}
