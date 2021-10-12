package com.teamup.app_sync;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

public class AppSyncBackPressed {
    public static long SAsxKQlkhCabrMeDXTyFtpmCERDivfqjEEdDxhoktoVLXIbpRMRhKIABdZUyBBqFGubPxQywOdPVBBIOSmqqlcamflIdTSImFDNA;
    public static Toast TdTtzqysnFaOXAHKbkGJiXrWYjcezJtxcxoqfpVsgYclkFoQlOaxXeWYBpRiFFeMRMPJcjKGXSisvXzZvkZjSDHhwvlLoIDZoHhu;
    public static void enable(Context context)
    {

        if (SAsxKQlkhCabrMeDXTyFtpmCERDivfqjEEdDxhoktoVLXIbpRMRhKIABdZUyBBqFGubPxQywOdPVBBIOSmqqlcamflIdTSImFDNA + 2000 > System.currentTimeMillis()) {
            TdTtzqysnFaOXAHKbkGJiXrWYjcezJtxcxoqfpVsgYclkFoQlOaxXeWYBpRiFFeMRMPJcjKGXSisvXzZvkZjSDHhwvlLoIDZoHhu.cancel();
            ((Activity)context).finish();

            return;
        } else {
            TdTtzqysnFaOXAHKbkGJiXrWYjcezJtxcxoqfpVsgYclkFoQlOaxXeWYBpRiFFeMRMPJcjKGXSisvXzZvkZjSDHhwvlLoIDZoHhu = Toast.makeText(context, "Press back again to exit", Toast.LENGTH_SHORT);
            TdTtzqysnFaOXAHKbkGJiXrWYjcezJtxcxoqfpVsgYclkFoQlOaxXeWYBpRiFFeMRMPJcjKGXSisvXzZvkZjSDHhwvlLoIDZoHhu.show();
        }
        SAsxKQlkhCabrMeDXTyFtpmCERDivfqjEEdDxhoktoVLXIbpRMRhKIABdZUyBBqFGubPxQywOdPVBBIOSmqqlcamflIdTSImFDNA = System.currentTimeMillis();
    }
}
