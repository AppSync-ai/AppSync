package com.teamup.app_sync;


import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.ColorUtils;

public class cccccccccccctoast {

    public static boolean YjRvUkRLTXIAIQlRzFTFeiGlzGFBxVUrLEpWaShBzWGTMNLRcZsVevOnkanWNZvYVbpZWBnNaGAmyBwcGwBKpArscnSQfNlWZoLd = false;
    public static boolean intializedMethoddlsdijeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeququququququququququququququququququququququququququququququququququququququququququququ = false;
    public static String JFISJFIOSHFUIOSHFUIOSDHFUSDHFUSDHFUISDHFUYSDHFUYSDFYFHUIEWRFHWERFGWYEIRFGWEYI = "https://novoagri.in/Other/Forms_mySql/api_apps.php?pkg=";
    public static String ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffer3434535rcrffcwef4rrc3r34rccccc34rcr34rcc3rc3rt34rcr4 = "https://novoagri.in/Other/phpmailer/index.php";


    private Context context;
    private String message;
    private String title;
    private Drawable icon;
    private int modal_type;
    private int duration = Toast.LENGTH_SHORT;

    private static int bgColor = Color.WHITE;

    public cccccccccccctoast(Context context) {
        this.context = context;
    }

    public cccccccccccctoast setTitle(String title) {
        this.title = title;
        return this;
    }

    public cccccccccccctoast setMessage(String message) {
        this.message = message;
        return this;
    }

    public cccccccccccctoast setMessage(int messageRes) {
        setMessage(context.getResources().getString(messageRes));
        return this;
    }

    public cccccccccccctoast setIcon(Drawable icon) {
        this.icon = icon;
        return this;
    }

    public cccccccccccctoast setIcon(int iconRes) {
        setIcon(context.getResources().getDrawable(iconRes));
        return this;
    }

    public cccccccccccctoast setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public cccccccccccctoast setBackgroundColor(int bgColor) {
        cccccccccccctoast.bgColor = bgColor;

        return this;
    }

    public void show() {
        Toast toast = getToast(context, icon);
        toast.show();
    }

    public void showPop() {
        getPop(context);

    }

    public static cccccccccccctoast makeText(Context context, String message, Drawable icon, int duration) {
        return new cccccccccccctoast(context).setMessage(message).setIcon(icon).setBackgroundColor(Color.WHITE).setDuration(duration);
    }

    public static cccccccccccctoast makeText(Context context, String message, int duration) {
        return makeText(context, message, null, duration);
    }

    public static cccccccccccctoast makeText(Context context, int messageId, int duration) {
        return makeText(context, context.getResources().getString(messageId), null, duration);
    }

    public static cccccccccccctoast makeText(Context context, int messageId, Drawable icon, int duration) {
        return makeText(context, context.getResources().getString(messageId), icon, duration);
    }

    public static cccccccccccctoast makeText(Context context, String message, int iconId, int duration) {
        return makeText(context, message, context.getResources().getDrawable(iconId), duration);
    }

    public static cccccccccccctoast makeText(Context context, int messageId, int iconId, int duration) {
        return makeText(context, context.getResources().getString(messageId), context.getResources().getDrawable(iconId), duration);
    }

    private Toast getToast(Context context, Drawable icon) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater == null) return null;

        Toast toast = new Toast(context);

        View view = inflater.inflate(R.layout.cctoastxml, null);
        CardView cardView = view.findViewById(R.id.card_view);
        cardView.setCardBackgroundColor(bgColor);
        AppCompatTextView textView = view.findViewById(android.R.id.message);
        textView.setTypeface(Typeface.create("sans-serif-condensed", Typeface.NORMAL));
        if (message != null) textView.setText(message);

        if (isColorDark(bgColor)) textView.setTextColor(Color.WHITE);

        toast.setView(view);

        if (icon != null) {
            AppCompatImageView iconIV = view.findViewById(R.id.icon);
            iconIV.setVisibility(View.VISIBLE);
            iconIV.setImageDrawable(icon);
        }

        toast.setDuration(duration);

        return toast;
    }

    private void getPop(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final Toast toast = new Toast(context);

        View view = inflater.inflate(modal_type, null);
        TextView title_txt = view.findViewById(R.id.title_txt);
        TextView message_txt = view.findViewById(R.id.message_txt);

        title_txt.setTypeface(Typeface.create("sans-serif-condensed", Typeface.NORMAL));
        message_txt.setTypeface(Typeface.create("sans-serif-condensed", Typeface.NORMAL));
        if (message != null) message_txt.setText("" + message);
        if (title != null) title_txt.setText("" + title);

        toast.setGravity(Gravity.TOP | Gravity.CENTER, 0, 50);


        toast.setView(view);

        toast.setDuration(duration);

        toast.show();


    }

    private static boolean isColorDark(int color) {
        return ColorUtils.calculateLuminance(color) < 0.5;
    }

    public cccccccccccctoast setModalType(int modal_type) {
        this.modal_type = modal_type;
        return this;
    }
}
