package com.teamup.rohitasawa_library;


import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.ColorUtils;

class cctoast {

    private Context context;
    private String message;
    private Drawable icon;
    private int duration = Toast.LENGTH_SHORT;

    private static int bgColor = Color.WHITE;

    public cctoast(Context context) {
        this.context = context;
    }

    public cctoast setMessage(String message) {
        this.message = message;
        return this;
    }

    public cctoast setMessage(int messageRes) {
        setMessage(context.getResources().getString(messageRes));
        return this;
    }

    public cctoast setIcon(Drawable icon) {
        this.icon = icon;
        return this;
    }

    public cctoast setIcon(int iconRes) {
        setIcon(context.getResources().getDrawable(iconRes));
        return this;
    }

    public cctoast setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public cctoast setBackgroundColor(int bgColor) {
        cctoast.bgColor = bgColor;

        return this;
    }

    public void show() {
        Toast toast = getToast(context, icon);
        toast.show();
    }

    public static cctoast makeText(Context context, String message, Drawable icon, int duration) {
        return new cctoast(context)
                .setMessage(message)
                .setIcon(icon)
                .setBackgroundColor(Color.WHITE)
                .setDuration(duration);
    }

    public static cctoast makeText(Context context, String message, int duration) {
        return makeText(context, message, null, duration);
    }

    public static cctoast makeText(Context context, int messageId, int duration) {
        return makeText(context, context.getResources().getString(messageId), null, duration);
    }

    public static cctoast makeText(Context context, int messageId, Drawable icon, int duration) {
        return makeText(context, context.getResources().getString(messageId), icon, duration);
    }

    public static cctoast makeText(Context context, String message, int iconId, int duration) {
        return makeText(context, message, context.getResources().getDrawable(iconId), duration);
    }

    public static cctoast makeText(Context context, int messageId, int iconId, int duration) {
        return makeText(context, context.getResources().getString(messageId),
                context.getResources().getDrawable(iconId), duration);
    }

    private Toast getToast(Context context, Drawable icon) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater == null)
            return null;

        Toast toast = new Toast(context);

        View view = inflater.inflate(R.layout.cctoastxml, null);
        CardView cardView = view.findViewById(R.id.card_view);
        cardView.setCardBackgroundColor(bgColor);
        AppCompatTextView textView = view.findViewById(android.R.id.message);
        textView.setTypeface(Typeface.create("sans-serif-condensed", Typeface.NORMAL));
        if (message != null)
            textView.setText(message);

        if (isColorDark(bgColor))
            textView.setTextColor(Color.WHITE);

        toast.setView(view);

        if (icon != null) {
            AppCompatImageView iconIV = view.findViewById(R.id.icon);
            iconIV.setVisibility(View.VISIBLE);
            iconIV.setImageDrawable(icon);
        }

        toast.setDuration(duration);

        return toast;
    }

    private static boolean isColorDark(int color) {
        return ColorUtils.calculateLuminance(color) < 0.5;
    }
}
