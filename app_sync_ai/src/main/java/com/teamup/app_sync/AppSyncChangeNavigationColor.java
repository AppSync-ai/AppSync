package com.teamup.app_sync;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

public class AppSyncChangeNavigationColor {
    public static void change(Context context)
    {
        try {
            try {
                Window NsxBgVuEPVNcxmQOnpvGaZsUppuhAAbzXRhvQfglVULEditNBHlZJcADnatDjzPRKxmRzZfrPSTIWxZeQpvQkyXxlmdMPqgPVrWA = ((Activity)context).getWindow();
                NsxBgVuEPVNcxmQOnpvGaZsUppuhAAbzXRhvQfglVULEditNBHlZJcADnatDjzPRKxmRzZfrPSTIWxZeQpvQkyXxlmdMPqgPVrWA.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                NsxBgVuEPVNcxmQOnpvGaZsUppuhAAbzXRhvQfglVULEditNBHlZJcADnatDjzPRKxmRzZfrPSTIWxZeQpvQkyXxlmdMPqgPVrWA.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    NsxBgVuEPVNcxmQOnpvGaZsUppuhAAbzXRhvQfglVULEditNBHlZJcADnatDjzPRKxmRzZfrPSTIWxZeQpvQkyXxlmdMPqgPVrWA.setStatusBarColor(((Activity)context).getResources().getColor(R.color.colorPrimaryDark));
                    NsxBgVuEPVNcxmQOnpvGaZsUppuhAAbzXRhvQfglVULEditNBHlZJcADnatDjzPRKxmRzZfrPSTIWxZeQpvQkyXxlmdMPqgPVrWA.setNavigationBarColor(((Activity)context).getResources().getColor(R.color.colorPrimaryDark));
                }
            } catch (Exception OQYTJLhveiQmRRjVsjIGzzcvCAqEhrRJgEfgGmYqYXPzCdPzTRSApNUfELKrgYVCkEaNYDhHrtkvtyfmZnYpGqIFKlZaquaBARlp) {
            }

        }
        catch (Exception fhbqYYYFhwrHEPPbeSLrENCovdcJlfLPTefvThzioytILaiygWRcOwAtyxcbYwvMPfSsglDBBEOrzVycyGEgxbtJCxFcwslAKWIV)
        {
            fhbqYYYFhwrHEPPbeSLrENCovdcJlfLPTefvThzioytILaiygWRcOwAtyxcbYwvMPfSsglDBBEOrzVycyGEgxbtJCxFcwslAKWIV.printStackTrace();
        }

    }
}
