package com.teamup.app_sync;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.StrictMode;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AppSyncBitmapsTheory {

    public static Bitmap getBitmapFromURL(String weburl) {
        try {
            if (android.os.Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy SvHKJKPICNheWdFOMqqjyKzTAoNHPtbOhCgrvBCmOtoJLmBRZZKRJILbUyQkqbWrAeladICZyWUFpNNsbHXirrHJlQyQraKHebwo = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(SvHKJKPICNheWdFOMqqjyKzTAoNHPtbOhCgrvBCmOtoJLmBRZZKRJILbUyQkqbWrAeladICZyWUFpNNsbHXirrHJlQyQraKHebwo);
            }
            URL wuSKRSGkVJyIDsFHlhLrdSuaKjpQJHORRUivaRRMjPDiQPSTyHeXHkxABNxMrQPHgSfUuylkfbbLKIfZbEpuVDyjGuwKnQNVOaxk = new URL(weburl);
            HttpURLConnection IqdXlcKaJBCgkZagBCvIXzUeqpicQmbhbkiAYgscMQwkXQpvstOiXeZdhgLaMycDULJMRQaoZMUGsYjRUZQXRjezWhRIpbJbFYEs = (HttpURLConnection) wuSKRSGkVJyIDsFHlhLrdSuaKjpQJHORRUivaRRMjPDiQPSTyHeXHkxABNxMrQPHgSfUuylkfbbLKIfZbEpuVDyjGuwKnQNVOaxk.openConnection();
            IqdXlcKaJBCgkZagBCvIXzUeqpicQmbhbkiAYgscMQwkXQpvstOiXeZdhgLaMycDULJMRQaoZMUGsYjRUZQXRjezWhRIpbJbFYEs.setDoInput(true);
            IqdXlcKaJBCgkZagBCvIXzUeqpicQmbhbkiAYgscMQwkXQpvstOiXeZdhgLaMycDULJMRQaoZMUGsYjRUZQXRjezWhRIpbJbFYEs.connect();
            InputStream trAcwFmMonZqtBPhHVeNbQbFnSdyCUiAlUYPooXbFKvwwhAQkzhPTaQnyIjSIJbkUtXvLpjGtaXBfbSWEpnGIYnGVAdwYLtLomET = IqdXlcKaJBCgkZagBCvIXzUeqpicQmbhbkiAYgscMQwkXQpvstOiXeZdhgLaMycDULJMRQaoZMUGsYjRUZQXRjezWhRIpbJbFYEs.getInputStream();
            Bitmap EJRcTXVvyhWzZBWNNJpWiYYApLVhkxeuRNjFJkscMYdhXStHbfdDxKEfwIWlQbpMmBIwGpflcuLtEsRVtcmAdDuZAxGflMMyvxsr = BitmapFactory.decodeStream(trAcwFmMonZqtBPhHVeNbQbFnSdyCUiAlUYPooXbFKvwwhAQkzhPTaQnyIjSIJbkUtXvLpjGtaXBfbSWEpnGIYnGVAdwYLtLomET);
            return EJRcTXVvyhWzZBWNNJpWiYYApLVhkxeuRNjFJkscMYdhXStHbfdDxKEfwIWlQbpMmBIwGpflcuLtEsRVtcmAdDuZAxGflMMyvxsr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bitmap loadBitmapFromView(View v) {
        Bitmap DXTYWwhDOSfgEwYKKVemQGDyhPpTFVlcfHnKATigUdIUgwxlsTfoOzlIkSVqiJlqGphmMZbYuIKWKrrombhHjPGvpHwbGVnlPRmT = Bitmap.createBitmap(v.getWidth(), v.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas DUelmMyLPDAUNEPaOLUEmiLmHOiIzxoNefuujqGKeTjOHZEJqiSkozjyNODnFWcLEuCHsIPgXJCHpYXXYWtiHGUqYBKiGcJXBXHN = new Canvas(DXTYWwhDOSfgEwYKKVemQGDyhPpTFVlcfHnKATigUdIUgwxlsTfoOzlIkSVqiJlqGphmMZbYuIKWKrrombhHjPGvpHwbGVnlPRmT);
        Drawable KWPHTiSAKttcglfcvlEyDVVmaArAXngSgLBqCgvZcDPXSsjYAdIhmZIggFPsteKhzcSLYgMtHvyjrcRKfrHSdrbDCpvVIsxxIJjL = v.getBackground();
        if (KWPHTiSAKttcglfcvlEyDVVmaArAXngSgLBqCgvZcDPXSsjYAdIhmZIggFPsteKhzcSLYgMtHvyjrcRKfrHSdrbDCpvVIsxxIJjL != null)
            KWPHTiSAKttcglfcvlEyDVVmaArAXngSgLBqCgvZcDPXSsjYAdIhmZIggFPsteKhzcSLYgMtHvyjrcRKfrHSdrbDCpvVIsxxIJjL.draw(DUelmMyLPDAUNEPaOLUEmiLmHOiIzxoNefuujqGKeTjOHZEJqiSkozjyNODnFWcLEuCHsIPgXJCHpYXXYWtiHGUqYBKiGcJXBXHN);
        else
            DUelmMyLPDAUNEPaOLUEmiLmHOiIzxoNefuujqGKeTjOHZEJqiSkozjyNODnFWcLEuCHsIPgXJCHpYXXYWtiHGUqYBKiGcJXBXHN.drawColor(Color.WHITE);
        v.draw(DUelmMyLPDAUNEPaOLUEmiLmHOiIzxoNefuujqGKeTjOHZEJqiSkozjyNODnFWcLEuCHsIPgXJCHpYXXYWtiHGUqYBKiGcJXBXHN);
        return DXTYWwhDOSfgEwYKKVemQGDyhPpTFVlcfHnKATigUdIUgwxlsTfoOzlIkSVqiJlqGphmMZbYuIKWKrrombhHjPGvpHwbGVnlPRmT;
    }


}
