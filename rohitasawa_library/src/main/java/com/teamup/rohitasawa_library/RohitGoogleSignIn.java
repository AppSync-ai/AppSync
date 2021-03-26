package com.teamup.rohitasawa_library;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.AccountPicker;

public class RohitGoogleSignIn {

    public static void getAccounts(Context context, int requestCode)
    {
        Intent googlePicker = AccountPicker.newChooseAccountIntent(null, null, new String[]{GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE}, true, null, null, null, null);
        ((Activity)context).startActivityForResult(googlePicker, requestCode);
    }
}
