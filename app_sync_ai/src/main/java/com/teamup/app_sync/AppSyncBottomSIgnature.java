package com.teamup.app_sync;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.teamup.app_sync.Interfaces.CustomGestureListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;


public class AppSyncBottomSIgnature extends BottomSheetDialogFragment {


    View view;

    private static final int REQUEST_CODE_WRITE_EXTERNAL_STORAGE_PERMISSION = 1;

    private GestureOverlayView gestureOverlayView = null;

    private Button redrawButton = null;

    private Button saveButton = null;

    ImageView closeImg;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_app_sync_draw_and_share, container, false);

        closeImg = view.findViewById(R.id.closeImg);
        closeImg.setOnClickListener(new View.OnClickListener() {
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

        gestureOverlayView.addOnGesturePerformedListener(new CustomGestureListener());

        redrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gestureOverlayView.clear(false);
            }

        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPermissionAndSaveSignature();
            }
        });


        return view;
    }

    private void init() {
        if (gestureOverlayView == null) {
            gestureOverlayView = (GestureOverlayView) view.findViewById(R.id.sign_pad);
        }

        if (redrawButton == null) {
            redrawButton = (Button) view.findViewById(R.id.redraw_button);
        }

        if (saveButton == null) {
            saveButton = (Button) view.findViewById(R.id.save_button);
        }
    }


    private void checkPermissionAndSaveSignature() {
        try {

            // Check whether this app has write external storage permission or not.
            int writeExternalStoragePermission = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);

            // If do not grant write external storage permission.
            if (writeExternalStoragePermission != PackageManager.PERMISSION_GRANTED) {
                // Request user to grant write external storage permission.
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE_WRITE_EXTERNAL_STORAGE_PERMISSION);
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
            gestureOverlayView.destroyDrawingCache();

            // Enable drawing cache function.
            gestureOverlayView.setDrawingCacheEnabled(true);

            // Get drawing cache bitmap.
            Bitmap drawingCacheBitmap = gestureOverlayView.getDrawingCache();

            // Create a new bitmap
            Bitmap bitmap = Bitmap.createBitmap(drawingCacheBitmap);

            // Get image file save path and name.
            String filePath = AppSyncPaths.get_download_folder_path(getContext(), "sign" + randomAlphaNumeric(15) + ".png");

            File file = new File(filePath);

            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

//            filepath is the file path here

            FileOutputStream fileOutputStream = new FileOutputStream(file);

            // Compress bitmap to png image.
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);

            // Flush bitmap to image file.
            fileOutputStream.flush();

            // Close the output stream.
            fileOutputStream.close();

//            Saved
            dismiss();

            try {
                SignSaved ss = (SignSaved) getContext();
                ss.saved(filePath);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            Log.v("Signature Gestures", e.getMessage());
            e.printStackTrace();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CODE_WRITE_EXTERNAL_STORAGE_PERMISSION) {
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
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
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