package com.teamup.app_sync;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.InputType;
import android.widget.EditText;
import android.widget.Toast;

public class AppSyncAlertDialogInput {

    public static String m_Text = "";
    public static String dataKey = "public";

    public static void setDataley(String stringDataKey) {
        dataKey = stringDataKey;
    }

    public static void showInputDialog(final Context context, String title, final boolean cancelable, boolean passwordEdittext) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(cancelable);
        builder.setTitle("" + title);

        final EditText input = new EditText(context);

        if (passwordEdittext) {
            input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        } else {
            input.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = input.getText().toString();
                if (m_Text.length() > 0) {
                    try {
                        InputDialogMethods im = (InputDialogMethods) context;
                        im.RohitAlertDialogInputSubmitted(m_Text, dataKey);
                    } catch (Exception e) {
                        Toast.makeText(context, "Please implement AlertDialogInput interface in your " + context.getClass(), Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(context, "Please type something", Toast.LENGTH_SHORT).show();
                }
            }
        });
        if (cancelable) {
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    dialog.cancel();

                    try {
                        InputDialogMethods im = (InputDialogMethods) context;
                        im.RohitAlertDialogInputDissmissed(dataKey);
                    } catch (Exception e) {
                        Toast.makeText(context, "Please implement RohitAlertDialogInput interface in your " + context.getClass(), Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }
            });
        }

        builder.show();

    }

    public interface InputDialogMethods {
        public void RohitAlertDialogInputSubmitted(String output, String dataKey);

        public void RohitAlertDialogInputDissmissed(String dataKey);
    }
}
