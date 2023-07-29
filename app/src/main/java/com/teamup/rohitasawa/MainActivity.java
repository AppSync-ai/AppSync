package com.teamup.rohitasawa;

import static android.util.Log.wtf;

import static com.teamup.rohitasawa.Admin.*;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.teamup.app_sync.AppSyncBottomSIgnature;
import com.teamup.app_sync.AppSyncChangelog;
import com.teamup.app_sync.AppSyncCurrentDate;
import com.teamup.app_sync.AppSyncDaysTheory;
import com.teamup.app_sync.AppSyncDownloader;
import com.teamup.app_sync.AppSyncInitialize;
import com.teamup.app_sync.AppSyncInstallation;
import com.teamup.app_sync.AppSyncRandomNumber;
import com.teamup.app_sync.AppSyncSimpleTextDialog;
import com.teamup.app_sync.AppSyncToast;
import com.teamup.app_sync.AppSyncUpiPay;
import com.teamup.app_sync.AppSyncYesNoDialog;

public class MainActivity extends AppCompatActivity implements AppSyncSimpleTextDialog.SimpleTextDialog, AppSyncBottomSIgnature.SignSaved, AppSyncCurrentDate.NetworkDatePhpFormat, AppSyncChangelog.ChangelogClosed, AppSyncYesNoDialog.dialogSayings, AppSyncDownloader.Downlods {

    Button button, button2;
    TextView txt1, txt2;
    ImageView img;
    RelativeLayout manage_reler, content;
    ImageView img_1;
    boolean f_img = true;
    AutoCompleteTextView digit_edt;
    Context context;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppSyncInitialize.init(MainActivity.this);
        AppSyncInstallation.set_instaltion(this);

        context = this;

        content = findViewById(R.id.content);

        digit_edt = findViewById(R.id.digit_edt);
        img_1 = findViewById(R.id.img_1);
        manage_reler = findViewById(R.id.manage_reler);
        button2 = findViewById(R.id.button2);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        button = findViewById(R.id.button);
        img = findViewById(R.id.img);

        wtf("Hulk-" + getClass().getName() + "-", "Diff: " + AppSyncDaysTheory.differenceBetweenTimeToMilliseconds("10:53:05", "10:54:20", "HH:mm:ss"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppSyncUpiPay.doPayment(MainActivity.this, "Payment", "Q871375050@ybl", "1", "Pasyment for app", "");
            }
        });

//        AppSyncDominantColorFromView.getDominantColor(this, "https://www.tailorbrands.com/wp-content/uploads/2020/07/mcdonalds-logo.jpg");

//        AppSyncDominantColorFromView.got_color_live.observe(this, new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer integer) {
//                AppSyncToast.showToast(context, "color: " + integer);
//
//            }
//        });

//        AppSyncCamera.takePhoto(this, 54);

//        AppSyncYesNoDialog.showDialog(this, "Fucked Up?");

//        String data = Configs.getValue(this, "xyz");
//        AppSyncToast.showToast(this, "Data : " + data);

//        authenticateApp(this);

//        AppSyncBottomSIgnature.open_and_draw(getSupportFragmentManager());

//        ArrayList<ChatReq> chat_list = new ArrayList<>();
//        chat_list.add(new ChatReq("Hello there..!!\nWhat is your name?", TYPE_MESSAGE));
//        chat_list.add(new ChatReq("That's good name.\nCan i know your mobile number?", AppSyncChatBot.TYPE_NUMBER));
//        chat_list.add(new ChatReq("What is your Gender?", AppSyncChatBot.TYPE_GENDER));
//        chat_list.add(new ChatReq("Select your profile photo", AppSyncChatBot.TYPE_PHOTO));
//        chat_list.add(new ChatReq("Select your File from file manager", AppSyncChatBot.TYPE_FILE_MANAGER));
//        chat_list.add(new ChatReq("You are done, Tell me your age.", TYPE_NUMBER));
//        AppSyncChatBot.set_bot_questions(chat_list);
//        AppSyncChatBot.set_bot_head_name("Jarvis");
//        AppSyncChatBot.set_bot_image(R.drawable.chatbot);
//        AppSyncChatBot.set_bot_end_response("Thank You..!!\nFor more visit our website\nwww.google.com");

//        startActivityForResult(new Intent(this, AppSyncChatBot.class), 55);


//        new AppSyncCustomNotification()
//                .setOpenActivity(MainActivity.this)
//                .schedule_notif("Scheduled", "after 20 secs", "Done", MainActivity.this, AppSyncCustomNotification.SECONDS, 5);

//        new AppSyncChangelog().init(MainActivity.this, true).setTitle("New Updates").setDescription("App has new features now, checkout everthing.\nExplore Transacrtions and reports at free of cost now. Mail : rohit.asawa21@gmail.com\nWebsite : http://novoagri.in");


//        AppSyncFileManager.openFileChooser(this, 45);


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        AppSyncSimpleTextDialog.dialog_closed_live.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                AppSyncToast.showToast(getApplicationContext(), "Clososoed");
            }
        });

    }

    @Override
    public void dialog_closed() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (AppSyncUpiPay.upiPaymentDataOperation(data, this)) {
            wtf("Hulk-" + getClass().getName() + "-", "Success");
        } else {
            wtf("Hulk-" + getClass().getName() + "-", "Failed");
        }

    }

    @Override
    public void saved(String file_path) {
        AppSyncToast.showToast(getApplicationContext(), "Saved to : " + file_path);
    }

    @Override
    public void closed_without_saving() {
        AppSyncToast.showToast(getApplicationContext(), "Closed without saving");
    }

    @Override
    public void gotDate_php_format(String date) {
        AppSyncToast.showToast(this, date);
    }

    @Override
    public void changelog_dialog_closed() {
        wtf("Hulk-" + getClass().getName() + "-" + 157, "Changelog Closed");
    }

    @Override
    public void greenSignal() {
        AppSyncToast.showToast(getApplicationContext(), "No Code");
    }

    @Override
    public void greenSignal(String code) {
        AppSyncToast.showToast(getApplicationContext(), "code:" + code);
    }

    @Override
    public void redSignal() {

    }

    @Override
    public void redSignal(String code) {

    }

    @Override
    public void DownloadComplete(String filePath) {
        AppSyncToast.showPopup(this, "Download comopleted", "ceckout gallery of your device of file manager", AppSyncToast.SUCCESS_COMPLETE, AppSyncToast.SHORT);
    }

}
