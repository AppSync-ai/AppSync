package com.teamup.app_sync;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class AppSyncCall {
    public static void call(Context context, String mobileNo)
    {
        Intent acGRpswcgmXYvXZPsWQZCpKwnMKbVqvejYPFehfIaLLRXBSdjckJZUCtIdZtyEWcRoVJvEJHdkZeGiIzTefhYHOjgTyZFIhrndrV = new Intent(Intent.ACTION_DIAL);
        acGRpswcgmXYvXZPsWQZCpKwnMKbVqvejYPFehfIaLLRXBSdjckJZUCtIdZtyEWcRoVJvEJHdkZeGiIzTefhYHOjgTyZFIhrndrV.setData(Uri.parse("tel:"+mobileNo));
        acGRpswcgmXYvXZPsWQZCpKwnMKbVqvejYPFehfIaLLRXBSdjckJZUCtIdZtyEWcRoVJvEJHdkZeGiIzTefhYHOjgTyZFIhrndrV.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(acGRpswcgmXYvXZPsWQZCpKwnMKbVqvejYPFehfIaLLRXBSdjckJZUCtIdZtyEWcRoVJvEJHdkZeGiIzTefhYHOjgTyZFIhrndrV);
    }
}
