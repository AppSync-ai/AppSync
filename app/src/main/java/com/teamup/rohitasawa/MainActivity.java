package com.teamup.rohitasawa;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.teamup.app_sync.AppSyncBitmapsTheory;
import com.teamup.app_sync.AppSyncChatBot;
import com.teamup.app_sync.AppSyncFileManager;
import com.teamup.app_sync.AppSyncInitialize;
import com.teamup.app_sync.AppSyncInstallation;
import com.teamup.app_sync.AppSyncPermissions;
import com.teamup.app_sync.AppSyncToast;
import com.teamup.app_sync.Reqs.ChatReq;

import java.io.IOException;
import java.util.ArrayList;

import static com.teamup.app_sync.AppSyncChatBot.TYPE_MESSAGE;


public class MainActivity extends AppCompatActivity {

    Button button, button2;
    TextView txt1, txt2;
    ImageView img;
    RelativeLayout manage_reler;
    ImageView img_1;
    boolean f_img = true;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppSyncInitialize.init(MainActivity.this);
        AppSyncInstallation.set_instaltion(this);

        img_1 = findViewById(R.id.img_1);
        manage_reler = findViewById(R.id.manage_reler);
        button2 = findViewById(R.id.button2);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        button = findViewById(R.id.button);
        img = findViewById(R.id.img);

//        authenticateApp(this);

        AppSyncPermissions.CAMERA_PERMISSION(this, 43);

        ArrayList<ChatReq> chat_list = new ArrayList<>();
        chat_list.add(new ChatReq("Hello there..!!\nWhat is your name?", TYPE_MESSAGE));
        chat_list.add(new ChatReq("That's good name.\nCan i know your mobile number?", AppSyncChatBot.TYPE_NUMBER));
        chat_list.add(new ChatReq("What is your Gender?", AppSyncChatBot.TYPE_GENDER));
        chat_list.add(new ChatReq("Select your profile photo", AppSyncChatBot.TYPE_PHOTO));
        chat_list.add(new ChatReq("Select your File specified", AppSyncChatBot.TYPE_FILE_MANAGER));
        chat_list.add(new ChatReq("You are done, Tell me your age.", TYPE_MESSAGE));
        AppSyncChatBot.set_bot_questions(chat_list);
        AppSyncChatBot.set_bot_head_name("MT Software Solutions");
        AppSyncChatBot.set_bot_image(R.drawable.logo);
        AppSyncChatBot.set_bot_end_response("Thank You..!!\nFor more visit our website\nwww.meratemplate.com");

        startActivityForResult(new Intent(this, AppSyncChatBot.class), 55);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


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
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 45) {
            if (data != null) {
                try {
                    String path = AppSyncFileManager.getSelectedFilePath(this, data);
                    AppSyncToast.showToast(getApplicationContext(), path);
                    img_1.setImageBitmap(AppSyncBitmapsTheory.getBitmapFromURL(path));
                } catch (IOException e) {
                    Log.wtf("Hulk-113", e.getMessage());
                    e.printStackTrace();
                }
            }
        }


        if (requestCode == 55) {
            if (data != null) {
                AppSyncToast.showToast(getApplicationContext(), data.getStringExtra("result"));

            }
        }

    }
}
