package com.teamup.app_sync;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.EditText;

import java.util.regex.Pattern;

public class AppSyncInputFilter {

    static EditText editText_a;
    static InputFilter filter;

    public AppSyncInputFilter set_filter(EditText a, final String patern) {
        editText_a = a;
        filter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                for (int i = start; i < end; ++i) {
                    if (!Pattern.compile("[" + patern + "]*").matcher(String.valueOf(source.charAt(i))).matches()) {
                        return "";
                    }
                }

                return null;
            }
        };
        editText_a.setFilters(new InputFilter[]{filter});

        return this;
    }

    public void set_length(int length) {
        InputFilter[] fArray = new InputFilter[2];
        fArray[0] = new InputFilter.LengthFilter(length);
        fArray[1] = filter;
        editText_a.setFilters(fArray);
    }
}
