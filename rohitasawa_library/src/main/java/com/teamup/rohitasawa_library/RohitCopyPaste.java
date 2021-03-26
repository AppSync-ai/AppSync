package com.teamup.rohitasawa_library;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

public class RohitCopyPaste {
    public static void copyText(Context context, String textToCopy){
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("label", textToCopy);
        clipboard.setPrimaryClip(clip);

    }

    public static String pasteText(Context context){
        String textToPaste = "";
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        try {
             textToPaste = String.valueOf(clipboard.getPrimaryClip().getItemAt(0).getText());
        } catch (Exception e) {
            return textToPaste;
        }

        return textToPaste;
    }
}
