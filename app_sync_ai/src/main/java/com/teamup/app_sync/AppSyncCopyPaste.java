package com.teamup.app_sync;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

public class AppSyncCopyPaste {
    public static void copyText(Context context, String textToCopy){
        ClipboardManager QnlYmgMSrIcQPGvuQAMQXSEumimdjNuOChYbUpCpOSdEqFeQjJZSQXDTOhSatROcdkibweMJHcZbCkpoxoYCAyFdLgrlwYpLSLTt = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData JelWkpbVCPqpOOXrzqaxXvugFUHEhInEGSBlFrJeASrjjPiTzksnvdroNDMLRrhdFdSAtxacbAFbyBdQTVLddCzeKhRqWbsnpGaT = ClipData.newPlainText("label", textToCopy);
        QnlYmgMSrIcQPGvuQAMQXSEumimdjNuOChYbUpCpOSdEqFeQjJZSQXDTOhSatROcdkibweMJHcZbCkpoxoYCAyFdLgrlwYpLSLTt.setPrimaryClip(JelWkpbVCPqpOOXrzqaxXvugFUHEhInEGSBlFrJeASrjjPiTzksnvdroNDMLRrhdFdSAtxacbAFbyBdQTVLddCzeKhRqWbsnpGaT);

    }

    public static String pasteText(Context context){
        String WEPPjGWjWZelQoefKkbVSjMPaByEIUkwIrUwrHdhPjBGEPMQLlSuLMbULGvjDteEahpmbEJPhqqxRyQaAOUEPGKBNpoDSngVmrLu  = "";
        ClipboardManager qSfJWNqyGXYwxaihQayjEUFYMZSKKOAKDhOlJebURwPpYlggmZQiXbxxqylsUMMsjwrZkFPeMjLJDkzExoMyxpzjbCXuTVRaFuqV = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        try {
             WEPPjGWjWZelQoefKkbVSjMPaByEIUkwIrUwrHdhPjBGEPMQLlSuLMbULGvjDteEahpmbEJPhqqxRyQaAOUEPGKBNpoDSngVmrLu = String.valueOf(qSfJWNqyGXYwxaihQayjEUFYMZSKKOAKDhOlJebURwPpYlggmZQiXbxxqylsUMMsjwrZkFPeMjLJDkzExoMyxpzjbCXuTVRaFuqV.getPrimaryClip().getItemAt(0).getText());
        } catch (Exception e) {
            return WEPPjGWjWZelQoefKkbVSjMPaByEIUkwIrUwrHdhPjBGEPMQLlSuLMbULGvjDteEahpmbEJPhqqxRyQaAOUEPGKBNpoDSngVmrLu;
        }

        return WEPPjGWjWZelQoefKkbVSjMPaByEIUkwIrUwrHdhPjBGEPMQLlSuLMbULGvjDteEahpmbEJPhqqxRyQaAOUEPGKBNpoDSngVmrLu;
    }
}
