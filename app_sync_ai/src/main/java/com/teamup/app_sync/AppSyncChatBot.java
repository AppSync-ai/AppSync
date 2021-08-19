package com.teamup.app_sync;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.teamup.app_sync.Adapters.MessagesAdapter;
import com.teamup.app_sync.Interfaces.ChatBot;
import com.teamup.app_sync.Reqs.ChatReq;
import com.teamup.app_sync.Reqs.MessagesReq;
import com.teamup.app_sync.Reqs.UserMessagesReq;

import java.io.IOException;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AppSyncChatBot extends AppCompatActivity implements ChatBot {


//            <activity
//            android:name=".AppSyncChatBot"
//            android:windowSoftInputMode="stateVisible|adjustPan"></activity>

    public static final String TYPE_FILE_MANAGER = "TYPE_FILE_MANAGER";
    public static String TYPE_MESSAGE = "TYPE_MESSAGE";
    public static String TYPE_GENDER = "TYPE_GENDER";
    public static String TYPE_NUMBER = "TYPE_PHONE_NUMBER";
    public static String TYPE_PHOTO = "TYPE_PHOTO";

    ImageView select_img, select_file;
    RecyclerView recycler;
    TextView desc_file_txt;
    static CircleImageView bot_image;
    RelativeLayout msg_edt_reler, gender_reler, photo_lay, file_lay;
    Button proceed_btn, submit_img_btn, submit_file_btn;
    EditText message_edt;
    ImageView send_img;
    MessagesAdapter adapter;
    ArrayList<MessagesReq> list;
    ArrayList<UserMessagesReq> user_msg_list = new ArrayList<>();
    static Context context;
    static ArrayList<ChatReq> bot_question;
    int bot_q_no = 0;
    static String end_chat_response = "Thank You..!!", bot_head_title = "AppSync Bot";
    TextView bot_title_txt;
    static int drawable_image_id_this = R.drawable.chatbot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppSyncChangeNavigationColor.change(this);
        setContentView(R.layout.activity_app_sync_chat_bot);

        context = this;

        user_msg_list = new ArrayList<>();
        user_msg_list.clear();

        desc_file_txt = findViewById(R.id.desc_file_txt);
        submit_file_btn = findViewById(R.id.submit_file_btn);
        select_file = findViewById(R.id.select_file);
        file_lay = findViewById(R.id.file_lay);
        submit_img_btn = findViewById(R.id.submit_img_btn);
        select_img = findViewById(R.id.select_img);
        photo_lay = findViewById(R.id.photo_lay);
        gender_reler = findViewById(R.id.gender_reler);
        gender_reler.setVisibility(View.GONE);
        photo_lay.setVisibility(View.GONE);
        file_lay.setVisibility(View.GONE);

        bot_image = findViewById(R.id.bot_image);
        proceed_btn = findViewById(R.id.proceed_btn);
        proceed_btn.setVisibility(View.GONE);
        msg_edt_reler = findViewById(R.id.msg_edt_reler);
        bot_title_txt = findViewById(R.id.bot_title_txt);
        bot_title_txt.setText("" + bot_head_title);
        send_img = findViewById(R.id.send_img);
        message_edt = findViewById(R.id.message_edt);
        recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        list = new ArrayList<>();
        adapter = new MessagesAdapter(list);
        recycler.setAdapter(adapter);

        list.clear();
        adapter.notifyDataSetChanged();

        Glide.with(context).load(drawable_image_id_this).into(bot_image);

        HandleBotQuestions();

        proceed_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChatBot cb = (ChatBot) context;
                cb.chat_end(user_msg_list);
            }
        });

        send_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Send_user_message(message_edt.getText().toString());
            }
        });
    }

    private void Send_user_message(String messageTxt) {
        String message = messageTxt;

        if (AppSyncTextUtils.check_empty_and_null(message)) {

            MessagesReq mr = new MessagesReq(message, AppSyncCurrentDate.getDateTimeInFormat("dd/MM/yyyy, hh:mm:ss"), 0);
            list.add(mr);
            user_msg_list.add(new UserMessagesReq(message, AppSyncCurrentDate.getDateTimeInFormat("dd/MM/yyyy, hh:mm:ss")));
            adapter.notifyDataSetChanged();

            ChatBot cb = (ChatBot) context;
            cb.user_responded(message);

            message_edt.setText("");

        } else {
            AppSyncToast.showToast(getApplicationContext(), "Pleas enter something..");
        }
    }

    public static void set_bot_end_response(String end_response) {
        end_chat_response = end_response;
    }

    private void set_end_chat_response() {
        list.add(new MessagesReq(end_chat_response, AppSyncCurrentDate.getDateTimeInFormat("dd/MM/yyyy, hh:mm:ss"), 1));
        adapter.notifyDataSetChanged();
    }

    public static void set_bot_head_name(String bot_name) {
        bot_head_title = "" + bot_name;
    }

    private void HandleBotQuestions() {
        msg_edt_reler.setVisibility(View.VISIBLE);
        if (bot_question.size() > 0) {
            if (bot_q_no < bot_question.size()) {
                list.add(new MessagesReq(bot_question.get(bot_q_no).getMessage(), AppSyncCurrentDate.getDateTimeInFormat("dd/MM/yyyy, hh:mm:ss"), 1));
                adapter.notifyDataSetChanged();

                if (bot_question.get(bot_q_no).getType().equalsIgnoreCase(AppSyncChatBot.TYPE_NUMBER)) {
                    message_edt.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_TEXT_FLAG_MULTI_LINE);
                } else if (bot_question.get(bot_q_no).getType().equalsIgnoreCase(AppSyncChatBot.TYPE_MESSAGE)) {
                    message_edt.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_MULTI_LINE);
                } else if (bot_question.get(bot_q_no).getType().equalsIgnoreCase(AppSyncChatBot.TYPE_GENDER)) {
                    Handle_Gender_selection();
                } else if (bot_question.get(bot_q_no).getType().equalsIgnoreCase(AppSyncChatBot.TYPE_PHOTO)) {
                    Handle_photo_selection();
                } else if (bot_question.get(bot_q_no).getType().equalsIgnoreCase(AppSyncChatBot.TYPE_FILE_MANAGER)) {
                    Handle_File_Manager();
                }


            }
        }
        if (bot_q_no == bot_question.size()) {
//            end of bot questions
            msg_edt_reler.setVisibility(View.INVISIBLE);
            proceed_btn.setVisibility(View.VISIBLE);
            set_end_chat_response();

        }
        bot_q_no++;

        Log.wtf("Hulk-129", bot_question.size() + "");

    }

    String file_path = "";

    private void Handle_File_Manager() {
        file_lay.setVisibility(View.VISIBLE);
        msg_edt_reler.setVisibility(View.GONE);

        select_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AppSyncPermissions.check_read_write_permission(AppSyncChatBot.this)) {
                    AppSyncFileManager.openFileChooser(AppSyncChatBot.this, 998);

                } else {
                    AppSyncPermissions.READ_WRITE_STORAAGE(AppSyncChatBot.this, 22255);

                }
            }
        });

        submit_file_btn.setAlpha(0.3f);
        submit_file_btn.setEnabled(false);
        submit_file_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                file_lay.setVisibility(View.GONE);
                msg_edt_reler.setVisibility(View.VISIBLE);
                Send_user_message(file_path);
            }
        });

    }

    private void Handle_photo_selection() {
        photo_lay.setVisibility(View.VISIBLE);
        msg_edt_reler.setVisibility(View.INVISIBLE);

        select_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AppSyncPermissions.check_read_write_permission(AppSyncChatBot.this)) {
                    AppSyncImageSelector.openGalleryAndSelect(AppSyncChatBot.this);
                } else {
                    AppSyncPermissions.READ_WRITE_STORAAGE(AppSyncChatBot.this, 43434);

                }
            }
        });

        submit_img_btn.setAlpha(0.3f);
        submit_img_btn.setEnabled(false);
        submit_img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photo_lay.setVisibility(View.GONE);
                msg_edt_reler.setVisibility(View.VISIBLE);
                Send_user_message(image_path);
            }
        });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 43434) {
            if (AppSyncPermissions.check_read_write_permission(this)) {
                AppSyncImageSelector.openGalleryAndSelect(AppSyncChatBot.this);
            }
        }
        if (requestCode == 22255) {
            if (AppSyncPermissions.check_read_write_permission(this)) {
                AppSyncFileManager.openFileChooser(AppSyncChatBot.this, 998);

            }
        }

    }

    String image_path = "";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (data != null) {
                String path = AppSyncImageSelector.getPath(this, data);
                image_path = path;
                Glide.with(this).load(path).into(select_img);
                submit_img_btn.setAlpha(1f);
                submit_img_btn.setEnabled(true);

            }
        }

        if (requestCode == 998) {
            if (data != null) {
                try {
                    file_path = AppSyncFileManager.getSelectedFilePath(this, data);
                    submit_file_btn.setAlpha(1f);
                    submit_file_btn.setEnabled(true);
                    desc_file_txt.setTextColor(Color.GREEN);
                    desc_file_txt.setText("File Selected, please submit");
                } catch (IOException e) {
                    e.printStackTrace();
                    submit_file_btn.setAlpha(0.3f);
                    submit_file_btn.setEnabled(false);
                    desc_file_txt.setTextColor(Color.RED);
                    desc_file_txt.setText("Please select another file");
                }
            }
        }
    }

    String gender = "Male";

    private void Handle_Gender_selection() {
        msg_edt_reler.setVisibility(View.INVISIBLE);
        gender_reler.setVisibility(View.VISIBLE);
        Button submit_btn = findViewById(R.id.submit_btn);


        final RadioButton male_rb = findViewById(R.id.male_rb);
        final RadioButton female_rb = findViewById(R.id.female_rb);
        final RadioButton other_rb = findViewById(R.id.other_rb);


        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (male_rb.isChecked()) {
                    gender = "Male";
                } else if (female_rb.isChecked()) {
                    gender = "Female";
                } else if (other_rb.isChecked()) {
                    gender = "Other";
                }
                gender_reler.setVisibility(View.GONE);
                msg_edt_reler.setVisibility(View.VISIBLE);
                Send_user_message(gender);


            }
        });
    }

    public static void set_bot_questions(ArrayList<ChatReq> list) {
        bot_question = new ArrayList<>();
        bot_question.clear();
        for (int i = 0; i < list.size(); i++) {
            bot_question.add(new ChatReq(list.get(i).getMessage(), list.get(i).getType()));
        }

    }

    public static void set_bot_image(int drawable_image_id) {
        drawable_image_id_this = drawable_image_id;
    }

    @Override
    public void user_responded(String response) {
        HandleBotQuestions();
        recycler.smoothScrollToPosition(list.size());
    }

    @Override
    public void chat_end(ArrayList<UserMessagesReq> list) {
        Intent returnIntent = getIntent();
        returnIntent.putExtra("result", AppSyncSaveArrayList.getListToJsonArray(user_msg_list).toString());
        setResult(RESULT_OK, returnIntent);
        finish();
    }

}