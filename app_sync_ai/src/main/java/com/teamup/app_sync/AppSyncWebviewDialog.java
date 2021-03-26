package com.teamup.app_sync;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;

public class AppSyncWebviewDialog {


    static Dialog fetching;
    public static boolean dialogClosed = false;
    public static boolean cancelable = false;

    public static WebView  webView;

    public static void show(final Context context, String URL)
    {
        fetching= new Dialog(context);

        fetching.show();

        dialogClosed = false;

        fetching.setCancelable(cancelable);

        fetching.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        fetching.setContentView(R.layout.dialog_webview);
        fetching.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

          webView = fetching.findViewById(R.id.webView);

        final CardView card = fetching.findViewById(R.id.pleasewaitCard);
        ImageView closeImg = fetching.findViewById(R.id.closeImg);

        closeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopDialog(context);
            }
        });

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl(""+URL);
        card.setVisibility(View.VISIBLE);

        webView.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                card.setVisibility(View.GONE);
            }
        });

    }


    public static void stopDialog(Context context){
        try {
            fetching.dismiss();
        }
        catch (Exception v)
        {

        }
        dialogClosed = true;
    }

}
