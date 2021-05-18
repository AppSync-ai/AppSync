package com.teamup.app_sync;

import android.content.Context;
import android.text.InputType;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AppSyncInputDialogs {


    public static View view2;

    public static void showSimpleInputDialog(final Context context, final TextView textView, final String heading, final boolean numberPad, final int limitaion) {
        AppSyncCustomDialog.showDialog(context, R.layout.dialog_input, R.color.BlackTransparent, true);
        View vv = AppSyncCustomDialog.view2;
        final EditText inputTxt = vv.findViewById(R.id.inputTxt);
        TextView headingTxt = vv.findViewById(R.id.headingTxt);
        Button submitBtn = vv.findViewById(R.id.submitBtn);

        headingTxt.setText("" + heading);

        try {
            inputTxt.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (numberPad) {
            inputTxt.setRawInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        } else {
            inputTxt.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitClicked(inputTxt, textView, context, heading, limitaion, numberPad);
            }
        });

        inputTxt.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {

                    submitClicked(inputTxt, textView, context, heading, limitaion, numberPad);
                }
                return false;
            }
        });

    }

    static void submitClicked(EditText inputTxt, TextView textView, Context context, String heading, int limitaion, boolean numberPad) {
        String input = inputTxt.getText().toString();

        if (limitaion > 0) {
            if (numberPad) {

                int inputInt = Integer.parseInt(input);
                if (inputInt > limitaion) {
                    AppSyncToast.showToast(context, limitaion + " max");
                } else {
                    if (!TextUtils.isEmpty(input)) {
                        textView.setText("" + input);
                        AppSyncCustomDialog.stopPleaseWaitDialog(context);
                    } else {
                        AppSyncToast.showToast(context, "Please enter " + heading);
                    }

                }
                try {
                    InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                int inputInt = input.length();
                if (inputInt > limitaion) {
                    AppSyncToast.showToast(context, limitaion + " max");
                } else {
                    textView.setText("" + input);
                    AppSyncCustomDialog.stopPleaseWaitDialog(context);
                }
            }
        } else {
//            without limitaion

            if (!TextUtils.isEmpty(input)) {
                textView.setText("" + input);
                AppSyncCustomDialog.stopPleaseWaitDialog(context);
            } else {
                AppSyncToast.showToast(context, "Please enter " + heading);
            }
            try {
                InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void stopInputDialog(Context context) {
        try {
            AppSyncCustomDialog.stopPleaseWaitDialog(context);
        } catch (Exception v) {

        }
    }

}
