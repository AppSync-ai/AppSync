package com.teamup.app_sync;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.teamup.app_sync.Adapters.MessagesAdapter;
import com.teamup.app_sync.Interfaces.ChatBot;
import com.teamup.app_sync.Reqs.MessagesReq;
import com.teamup.app_sync.Reqs.UserMessagesReq;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AppSyncChatBot extends AppCompatActivity implements ChatBot {


//            <activity
//            android:name=".AppSyncChatBot"
//            android:windowSoftInputMode="stateVisible|adjustPan"></activity>

    RecyclerView recycler;
    static CircleImageView bot_image;
    RelativeLayout chat_method_reler;
    Button proceed_btn;
    EditText message_edt;
    ImageView send_img;
    MessagesAdapter adapter;
    ArrayList<MessagesReq> list;
    ArrayList<UserMessagesReq> user_msg_list = new ArrayList<>();
    static Context context;
    static ArrayList<String> bot_question;
    int bot_q_no = 0;
    static String end_chat_response = "", bot_head_title = "AppSync Bot";
    TextView bot_title_txt;
    static int drawable_image_id_this = R.drawable.chatbot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppSyncChangeNavigationColor.change(this);
        setContentView(R.layout.activity_app_sync_chat_bot);

        context = this;

        set_bot_end_response("Thank You..!!\nThis information is been saved.");

        user_msg_list = new ArrayList<>();
        user_msg_list.clear();

        bot_image = findViewById(R.id.bot_image);
        proceed_btn = findViewById(R.id.proceed_btn);
        proceed_btn.setVisibility(View.GONE);
        chat_method_reler = findViewById(R.id.msg_edt_reler);
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
                String message = message_edt.getText().toString();

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
        });
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
        if (bot_question.size() > 0) {
            if (bot_q_no < bot_question.size()) {
                list.add(new MessagesReq(bot_question.get(bot_q_no), AppSyncCurrentDate.getDateTimeInFormat("dd/MM/yyyy, hh:mm:ss"), 1));
                adapter.notifyDataSetChanged();
            }
        }
        if (bot_q_no == bot_question.size()) {
//            end of bot questions
            set_end_chat_response();

            chat_method_reler.setVisibility(View.INVISIBLE);
            proceed_btn.setVisibility(View.VISIBLE);

        }
        bot_q_no++;

        Log.wtf("Hulk-129", bot_question.size() + "");

    }

    public static void set_bot_questions(ArrayList<String> list) {
        bot_question = new ArrayList<>();
        bot_question.clear();
        for (int i = 0; i < list.size(); i++) {
            bot_question.add(list.get(i));
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