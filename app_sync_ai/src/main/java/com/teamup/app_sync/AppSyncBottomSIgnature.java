package com.teamup.app_sync;

import android.Manifest;
import android.content.pm.PackageManager;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.teamup.app_sync.Interfaces.CustomGestureListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class AppSyncBottomSIgnature extends BottomSheetDialogFragment {


    View ggggggggggggggggggggggggggggggggggggggggggggggggggggggopoopuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu;

    private static final int ssssssssssssssssssssssssssssssssssssssssssssssqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq = 1;

    private GestureOverlayView fssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss = null;

    private Button yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyytyyty = null;

    private Button hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh565 = null;

    ImageView gggggggggggggggggggggggggggggggggggggggggggggggggggggg333;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ggggggggggggggggggggggggggggggggggggggggggggggggggggggopoopuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu = inflater.inflate(R.layout.activity_app_sync_draw_and_share, container, false);

        gggggggggggggggggggggggggggggggggggggggggggggggggggggg333 = ggggggggggggggggggggggggggggggggggggggggggggggggggggggopoopuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu.findViewById(R.id.closeImg);
        gggggggggggggggggggggggggggggggggggggggggggggggggggggg333.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                try {
                    SignSaved ss = (SignSaved) getContext();
                    ss.closed_without_saving();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        init();

        fssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss.addOnGesturePerformedListener(new CustomGestureListener());

        yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyytyyty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss.clear(false);
            }

        });

        hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh565.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPermissionAndSaveSignature();
            }
        });


        return ggggggggggggggggggggggggggggggggggggggggggggggggggggggopoopuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu;
    }

    private void init() {
        if (fssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss == null) {
            fssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss = (GestureOverlayView) ggggggggggggggggggggggggggggggggggggggggggggggggggggggopoopuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu.findViewById(R.id.sign_pad);
        }

        if (yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyytyyty == null) {
            yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyytyyty = (Button) ggggggggggggggggggggggggggggggggggggggggggggggggggggggopoopuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu.findViewById(R.id.redraw_button);
        }

        if (hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh565 == null) {
            hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh565 = (Button) ggggggggggggggggggggggggggggggggggggggggggggggggggggggopoopuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu.findViewById(R.id.save_button);
        }
    }


    private void checkPermissionAndSaveSignature() {
        try {

            // Check whether this app has write external storage permission or not.
            int writeExternalStoragePermission = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);

            // If do not grant write external storage permission.
            if (writeExternalStoragePermission != PackageManager.PERMISSION_GRANTED) {
                // Request user to grant write external storage permission.
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, ssssssssssssssssssssssssssssssssssssssssssssssqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq);
            } else {
                saveSignature();
            }

        } catch (Exception e) {
            Log.v("Signature Gestures", e.getMessage());
            e.printStackTrace();
        }
    }

    private void saveSignature() {
        try {

            // First destroy cached image.
            fssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss.destroyDrawingCache();

            // Enable drawing cache function.
            fssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss.setDrawingCacheEnabled(true);

            // Get drawing cache bitmap.
            Bitmap gfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff44 = fssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss.getDrawingCache();

            // Create a new bitmap
            Bitmap ewwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww23 = Bitmap.createBitmap(gfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff44);

            // Get image file save path and name.
            String feeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeasdfsdr345 = AppSyncPaths.get_download_folder_path(getContext(), "sign" + randomAlphaNumeric(15) + ".png");

            File rewwwwwvgwavftq4bw = new File(feeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeasdfsdr345);

            try {
                rewwwwwvgwavftq4bw.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

//            filepath is the file path here

            FileOutputStream rezg5 = new FileOutputStream(rewwwwwvgwavftq4bw);

            // Compress bitmap to png image.
            ewwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww23.compress(Bitmap.CompressFormat.PNG, 100, rezg5);

            // Flush bitmap to image file.
            rezg5.flush();

            // Close the output stream.
            rezg5.close();

//            Saved
            dismiss();

            try {
                SignSaved gdzgfd43 = (SignSaved) getContext();
                gdzgfd43.saved(feeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeasdfsdr345);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            Log.v("Signature Gestures", e.getMessage());
            e.printStackTrace();
        }
    }


    @Override
    public void onRequestPermissionsResult(int sefffsdrgrt545eat, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(sefffsdrgrt545eat, permissions, grantResults);

        if (sefffsdrgrt545eat == ssssssssssssssssssssssssssssssssssssssssssssssqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq) {
            int grantResultsLength = grantResults.length;
            if (grantResultsLength > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                saveSignature();
            } else {
                Toast.makeText(getContext(), "You denied write external storage permission.", Toast.LENGTH_LONG).show();
            }
        }
    }

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String randomAlphaNumeric(int count) {
        StringBuilder tfhththtryrty56y4yt54tttetgb4setrb5tneyj = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            tfhththtryrty56y4yt54tttetgb4setrb5tneyj.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return tfhththtryrty56y4yt54tttetgb4setrb5tneyj.toString();
    }

    public static void open_and_draw(FragmentManager fragmentManager) {
        AppSyncBottomSIgnature bottomSheetDialogFragment = new AppSyncBottomSIgnature();
        bottomSheetDialogFragment.setCancelable(false);
        bottomSheetDialogFragment.show(fragmentManager, bottomSheetDialogFragment.getTag());
    }

    public interface SignSaved {
        public void saved(String file_path);

        public void closed_without_saving();
    }

}