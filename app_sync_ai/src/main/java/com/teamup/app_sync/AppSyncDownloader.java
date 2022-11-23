package com.teamup.app_sync;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;

public class AppSyncDownloader {
    public static int VISIBLE = DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED;
    public static int INVISIBLE = DownloadManager.Request.VISIBILITY_HIDDEN;
    public static int COMPLETE = DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION;

    public static void download(final Context context, String url, String filenaleWithExtension, int VISIBILITY) {
        try {

            if (VISIBILITY == 0) {
                VISIBILITY = VISIBLE;
            } else if (VISIBILITY == 2) {
                VISIBILITY = INVISIBLE;
            } else if (VISIBILITY == 3) {
                VISIBILITY = COMPLETE;
            }


            File direct = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            final File file = new File(direct, filenaleWithExtension);


            if (!direct.exists()) {
                direct.mkdirs();
            }

            //   Toast.makeText(getActivity(), "Downloading is started....!", Toast.LENGTH_SHORT).show();
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
            // allow types of network to download files
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);
            //request.setTitle("Title");
            // request.setDescription("Description.....");
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(VISIBILITY);
            // img.setImageResource(R.drawable.heart_on);

            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, filenaleWithExtension);

            //   request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "Opshort"+id +"Opshort.mp4"); // get the current time.

            // get download service and enque
            DownloadManager manager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
            manager.enqueue(request);

            BroadcastReceiver onComplete = new BroadcastReceiver() {
                public void onReceive(Context ctxt, Intent intent) {
                    Downlods green = (Downlods) context;
                    green.DownloadComplete(file.getAbsolutePath());
                }
            };

            context.registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

//            Admin.path = file.getPath();
        } catch (Exception b) {

            Toast.makeText(context, "" + b, Toast.LENGTH_SHORT).show();
        }

    }


    public interface Downlods {
        public void DownloadComplete(String filePath);

    }


}
