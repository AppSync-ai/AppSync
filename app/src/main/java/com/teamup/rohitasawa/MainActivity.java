package com.teamup.rohitasawa;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.teamup.app_sync.AppSyncAudioPicker;
import com.teamup.app_sync.AppSyncAutoCompleteHelper;
import com.teamup.app_sync.AppSyncBitmapsTheory;
import com.teamup.app_sync.AppSyncChatBot;
import com.teamup.app_sync.AppSyncDrawAndShare;
import com.teamup.app_sync.AppSyncFileManager;
import com.teamup.app_sync.AppSyncInitialize;
import com.teamup.app_sync.AppSyncInputFilter;
import com.teamup.app_sync.AppSyncInstallation;
import com.teamup.app_sync.AppSyncPaths;
import com.teamup.app_sync.AppSyncPermissions;
import com.teamup.app_sync.AppSyncSimpleTextDialog;
import com.teamup.app_sync.AppSyncToast;
import com.teamup.app_sync.Reqs.ChatReq;

import java.io.IOException;
import java.util.ArrayList;

import static com.teamup.app_sync.AppSyncChatBot.TYPE_MESSAGE;
import static com.teamup.app_sync.AppSyncChatBot.TYPE_NUMBER;


public class MainActivity extends AppCompatActivity implements AppSyncSimpleTextDialog.SimpleTextDialog {

    Button button, button2;
    TextView txt1, txt2;
    ImageView img;
    RelativeLayout manage_reler;
    ImageView img_1;
    boolean f_img = true;
    AutoCompleteTextView digit_edt;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppSyncInitialize.init(MainActivity.this);
        AppSyncInstallation.set_instaltion(this);

        digit_edt = findViewById(R.id.digit_edt);
        img_1 = findViewById(R.id.img_1);
        manage_reler = findViewById(R.id.manage_reler);
        button2 = findViewById(R.id.button2);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        button = findViewById(R.id.button);
        img = findViewById(R.id.img);

//        authenticateApp(this);

        startActivity(new Intent(this, AppSyncDrawAndShare.class));

        ArrayList<ChatReq> chat_list = new ArrayList<>();
        chat_list.add(new ChatReq("Hello there..!!\nWhat is your name?", TYPE_MESSAGE));
        chat_list.add(new ChatReq("That's good name.\nCan i know your mobile number?", AppSyncChatBot.TYPE_NUMBER));
        chat_list.add(new ChatReq("What is your Gender?", AppSyncChatBot.TYPE_GENDER));
        chat_list.add(new ChatReq("Select your profile photo", AppSyncChatBot.TYPE_PHOTO));
        chat_list.add(new ChatReq("Select your File from file manager", AppSyncChatBot.TYPE_FILE_MANAGER));
        chat_list.add(new ChatReq("You are done, Tell me your age.", TYPE_NUMBER));
        AppSyncChatBot.set_bot_questions(chat_list);
        AppSyncChatBot.set_bot_head_name("Jarvis");
        AppSyncChatBot.set_bot_image(R.drawable.chatbot);
        AppSyncChatBot.set_bot_end_response("Thank You..!!\nFor more visit our website\nwww.google.com");

//        startActivityForResult(new Intent(this, AppSyncChatBot.class), 55);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppSyncToast.showToast(getApplicationContext(), AppSyncAutoCompleteHelper.is_selected_from_dropdown_live.getValue() + "");
            }
        });

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
        if (data != null) {
            if (resultCode == RESULT_OK) {
                String gotach = data.getStringExtra("result");
                AppSyncToast.showToast(getApplicationContext(), gotach);
            }
        }
    }

}
