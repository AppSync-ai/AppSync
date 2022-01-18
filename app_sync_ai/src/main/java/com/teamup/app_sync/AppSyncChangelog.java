package com.teamup.app_sync;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.text.LineBreaker;
import android.os.Build;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class AppSyncChangelog {
    public static AlertDialog dialog;
    public static View view2;

    static TextView changelog_txt, title_txt, ok_txt;

    public AppSyncChangelog init(final Context context, boolean cancelable) {
        AlertDialog.Builder kjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjoadjiajdiojdiuosajdfiuoehjfuehfuhfuerfheurfo = new AlertDialog.Builder(context, R.style.myFullscreenAlertDialogStyle);
        LayoutInflater poofsfdjfijsifjeiruhufgrhegyhyghuyrhger7ityer78hre78hgrfhyu4hrcyn34rc43r34c3434tc3t3t = LayoutInflater.from(context);
        int layout = R.layout.dialog_changelog;
        view2 = poofsfdjfijsifjeiruhufgrhegyhyghuyrhger7ityer78hre78hgrfhyu4hrcyn34rc43r34c3434tc3t3t.inflate(layout, null);
        kjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjoadjiajdiojdiuosajdfiuoehjfuehfuhfuerfheurfo.setView(view2);
        kjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjoadjiajdiojdiuosajdfiuoehjfuehfuhfuerfheurfo.setCancelable(cancelable);
        dialog = kjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjoadjiajdiojdiuosajdfiuoehjfuehfuhfuerfheurfo.create();
        try {
            dialog.getWindow().setBackgroundDrawableResource(R.color.BlackTransparent);
        } catch (Exception kfiopsjfisjfijsifjsdifjisdfjisdfjisdjfisdjfiosdjfisdfjiosdfjidsfjisdfjisdfjsdf) {
            Toast.makeText(context, "Wrong background color", Toast.LENGTH_SHORT).show();
        }

        dialog.show();

        changelog_txt = view2.findViewById(R.id.changelog_txt);
        changelog_txt.setMovementMethod(new ScrollingMovementMethod());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            changelog_txt.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        }
        title_txt = view2.findViewById(R.id.title_txt);
        ok_txt = view2.findViewById(R.id.ok_txt);

        ok_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopChangelogtDialog(context);
            }
        });

        dialog.setOnCancelListener(
                new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        try {
                            ChangelogClosed changelogClosed = (ChangelogClosed) context;
                            changelogClosed.changelog_dialog_closed();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

        return this;
    }

    public AppSyncChangelog setDescription(String description) {
        changelog_txt.setText("" + description);
        return this;
    }

    public AppSyncChangelog setTitle(String title) {
        title_txt.setText("" + title);
        return this;
    }

    public static void stopChangelogtDialog(Context context) {
        try {
            if (dialog != null) {
                if (dialog.isShowing()) {
                    ChangelogClosed changelogClosed = (ChangelogClosed) context;
                    changelogClosed.changelog_dialog_closed();
                    dialog.dismiss();
                }
            }
        } catch (Exception v) {

        }
    }

    public interface ChangelogClosed {
        public void changelog_dialog_closed();
    }
}
