package com.teamup.app_sync;

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

    ImageView InHOjbPozlIwtjDmBrmrlJcHcfTvWfLQdKPyskbREPKVaOJbwExuEPJXmEcquFoqiBtMisshxfksLgvICddLLZyTLYsDdXNHjZiQ, JvBhiORkymeFrpXuUoihzCLNwjmhMZPOWsuxpZEhTqAJUFaxhKdHuUpiuXFjjpJPICQVDPWHZsyyMvSlcXQgogKBltbVxeScrfOk;
    RecyclerView DdATEoYtYojdLVceKQbtaeVQnZyjHfJsfvlXvwzqpWYIYuRVPaDxQYnsjDpvAxgtsDWdoOXaSIAaAIjDbAGYzJwguKUlqLWNpkQs;
    TextView DxqCFIxjjUtSxJKRKFQzGHeouxaBbqJsEDVCIIGKaNIHcyCOutMReeMOfpuJzXQAJvJDHtsnUGgnIJWerAnBqBOYTLdIagThpiiL;
    static CircleImageView bot_image;
    RelativeLayout nSYEiCmTohYalvRHtmnxhGgJIBsqRzFRvAItiHQinYWfqDVOjJGXnRYFDxCdCDEeTUIPJfcoyizjHlWguaNjtRRHDjhXjdfTSaii, gender_reler, photo_lay, ASLSLpiAfaNKIjebrOqNOCThovYKlaFpVpvhmJXbTTmDamuiLSkwAkPLbgFygngDZHSswXBdTJYGqrAWeSfLNrCOWcEhUwNiiAzw;
    Button nQlsftgEuomimVFdIgESWuBLitKPNBWxNjoXdsRQmUMOLYbJPOGLwqciZdIQtkiybuEDMTcUHKRMxftDsMvtTCUNdsQyKTueQWXe, submit_img_btn, iiYHcmhnEjMYdPuWMMOSvFMLrWaqpOIPEjRKEczfSxqGYAOfFNDnijLDXqMPvSMDYehbdYiqDxyUYhhMfABGiAAtRCtviLSyzoQV;
    EditText BnluzAfxwqjVSarBTVtICgiWtWFlulKlJUZdJPPditmesZRVzwgWMWcIYngQFhbtizFOyUxksXsCnCbQyqJLxsinSPQHmUdzZAjt;
    ImageView pJziprmVAdCsglAZytpFVWkHRIsRUbdqYnTreaqWGmYLcIyUhGRXIqjJyPePWYzayCGwMjgfqLZGgHndSpauGgPpkgNxqeIFFTBY;
    MessagesAdapter OWzEQwuXQPGxGoOTKkZLijiUwwXQSHoKKzQpZgeitCbgEhFjdMZaSrIxHKQBbuXIzNKEwWXybGEQxJldlaxxfrNwdGpajRLUmcKW;
    ArrayList<MessagesReq> list;
    ArrayList<UserMessagesReq> user_msg_list = new ArrayList<>();
    static Context context;
    static ArrayList<ChatReq> ZQyJTaqMnfzjAivYoLtHGuiOfUQxHfCtnTJgARlitgDIZIqEvrWZxAvXzFYlOFQiGZEaTJlEISpvDVxTeHTvLFbaFEXfrCjlUrqD;
    int WKJkvwsrPVxFNAvxvtKvPuMKtSaHrUNJZFNJwmyrzDTiUVmFVMWFnKLBfXwdBEEJQeyXfHqDOLNiKsRpjPoSADxPUhnbNJbnvtxD = 0;
    static String end_chat_response = "Thank You..!!", bot_head_title = "AppSync Bot";
    TextView JUSBlBQitShldnRXjncsDiEvTePHhjPwrIfDodqLjhZMhMSejexlIitVsCZlwohJeoKTXFUstvxmmSuPqgrltONfgNxhWXinrkft;
    static int drawable_image_id_this = R.drawable.chatbot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppSyncChangeNavigationColor.change(this);
        setContentView(R.layout.activity_app_sync_chat_bot);

        context = this;

        user_msg_list = new ArrayList<>();
        user_msg_list.clear();

        DxqCFIxjjUtSxJKRKFQzGHeouxaBbqJsEDVCIIGKaNIHcyCOutMReeMOfpuJzXQAJvJDHtsnUGgnIJWerAnBqBOYTLdIagThpiiL = findViewById(R.id.desc_file_txt);
        iiYHcmhnEjMYdPuWMMOSvFMLrWaqpOIPEjRKEczfSxqGYAOfFNDnijLDXqMPvSMDYehbdYiqDxyUYhhMfABGiAAtRCtviLSyzoQV = findViewById(R.id.submit_file_btn);
        JvBhiORkymeFrpXuUoihzCLNwjmhMZPOWsuxpZEhTqAJUFaxhKdHuUpiuXFjjpJPICQVDPWHZsyyMvSlcXQgogKBltbVxeScrfOk = findViewById(R.id.select_file);
        ASLSLpiAfaNKIjebrOqNOCThovYKlaFpVpvhmJXbTTmDamuiLSkwAkPLbgFygngDZHSswXBdTJYGqrAWeSfLNrCOWcEhUwNiiAzw = findViewById(R.id.file_lay);
        submit_img_btn = findViewById(R.id.submit_img_btn);
        InHOjbPozlIwtjDmBrmrlJcHcfTvWfLQdKPyskbREPKVaOJbwExuEPJXmEcquFoqiBtMisshxfksLgvICddLLZyTLYsDdXNHjZiQ = findViewById(R.id.select_img);
        photo_lay = findViewById(R.id.photo_lay);
        gender_reler = findViewById(R.id.gender_reler);
        gender_reler.setVisibility(View.GONE);
        photo_lay.setVisibility(View.GONE);
        ASLSLpiAfaNKIjebrOqNOCThovYKlaFpVpvhmJXbTTmDamuiLSkwAkPLbgFygngDZHSswXBdTJYGqrAWeSfLNrCOWcEhUwNiiAzw.setVisibility(View.GONE);

        bot_image = findViewById(R.id.bot_image);
        nQlsftgEuomimVFdIgESWuBLitKPNBWxNjoXdsRQmUMOLYbJPOGLwqciZdIQtkiybuEDMTcUHKRMxftDsMvtTCUNdsQyKTueQWXe = findViewById(R.id.proceed_btn);
        nQlsftgEuomimVFdIgESWuBLitKPNBWxNjoXdsRQmUMOLYbJPOGLwqciZdIQtkiybuEDMTcUHKRMxftDsMvtTCUNdsQyKTueQWXe.setVisibility(View.GONE);
        nSYEiCmTohYalvRHtmnxhGgJIBsqRzFRvAItiHQinYWfqDVOjJGXnRYFDxCdCDEeTUIPJfcoyizjHlWguaNjtRRHDjhXjdfTSaii = findViewById(R.id.msg_edt_reler);
        JUSBlBQitShldnRXjncsDiEvTePHhjPwrIfDodqLjhZMhMSejexlIitVsCZlwohJeoKTXFUstvxmmSuPqgrltONfgNxhWXinrkft = findViewById(R.id.bot_title_txt);
        JUSBlBQitShldnRXjncsDiEvTePHhjPwrIfDodqLjhZMhMSejexlIitVsCZlwohJeoKTXFUstvxmmSuPqgrltONfgNxhWXinrkft.setText("" + bot_head_title);
        pJziprmVAdCsglAZytpFVWkHRIsRUbdqYnTreaqWGmYLcIyUhGRXIqjJyPePWYzayCGwMjgfqLZGgHndSpauGgPpkgNxqeIFFTBY = findViewById(R.id.send_img);
        BnluzAfxwqjVSarBTVtICgiWtWFlulKlJUZdJPPditmesZRVzwgWMWcIYngQFhbtizFOyUxksXsCnCbQyqJLxsinSPQHmUdzZAjt = findViewById(R.id.message_edt);
        DdATEoYtYojdLVceKQbtaeVQnZyjHfJsfvlXvwzqpWYIYuRVPaDxQYnsjDpvAxgtsDWdoOXaSIAaAIjDbAGYzJwguKUlqLWNpkQs = findViewById(R.id.recycler);
        DdATEoYtYojdLVceKQbtaeVQnZyjHfJsfvlXvwzqpWYIYuRVPaDxQYnsjDpvAxgtsDWdoOXaSIAaAIjDbAGYzJwguKUlqLWNpkQs.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        list = new ArrayList<>();
        OWzEQwuXQPGxGoOTKkZLijiUwwXQSHoKKzQpZgeitCbgEhFjdMZaSrIxHKQBbuXIzNKEwWXybGEQxJldlaxxfrNwdGpajRLUmcKW = new MessagesAdapter(list);
        DdATEoYtYojdLVceKQbtaeVQnZyjHfJsfvlXvwzqpWYIYuRVPaDxQYnsjDpvAxgtsDWdoOXaSIAaAIjDbAGYzJwguKUlqLWNpkQs.setAdapter(OWzEQwuXQPGxGoOTKkZLijiUwwXQSHoKKzQpZgeitCbgEhFjdMZaSrIxHKQBbuXIzNKEwWXybGEQxJldlaxxfrNwdGpajRLUmcKW);

        list.clear();
        OWzEQwuXQPGxGoOTKkZLijiUwwXQSHoKKzQpZgeitCbgEhFjdMZaSrIxHKQBbuXIzNKEwWXybGEQxJldlaxxfrNwdGpajRLUmcKW.notifyDataSetChanged();

        Glide.with(context).load(drawable_image_id_this).into(bot_image);

        HandleBotQuestions();

        nQlsftgEuomimVFdIgESWuBLitKPNBWxNjoXdsRQmUMOLYbJPOGLwqciZdIQtkiybuEDMTcUHKRMxftDsMvtTCUNdsQyKTueQWXe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChatBot cb = (ChatBot) context;
                cb.chat_end(user_msg_list);
            }
        });

        pJziprmVAdCsglAZytpFVWkHRIsRUbdqYnTreaqWGmYLcIyUhGRXIqjJyPePWYzayCGwMjgfqLZGgHndSpauGgPpkgNxqeIFFTBY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Send_user_message(BnluzAfxwqjVSarBTVtICgiWtWFlulKlJUZdJPPditmesZRVzwgWMWcIYngQFhbtizFOyUxksXsCnCbQyqJLxsinSPQHmUdzZAjt.getText().toString());
            }
        });
    }

    private void Send_user_message(String messageTxt) {
        String message = messageTxt;

        if (AppSyncTextUtils.check_empty_and_null(message)) {

            MessagesReq mr = new MessagesReq(message, AppSyncCurrentDate.getDateTimeInFormat("dd/MM/yyyy, hh:mm:ss"), 0);
            list.add(mr);
            user_msg_list.add(new UserMessagesReq(message, AppSyncCurrentDate.getDateTimeInFormat("dd/MM/yyyy, hh:mm:ss")));
            OWzEQwuXQPGxGoOTKkZLijiUwwXQSHoKKzQpZgeitCbgEhFjdMZaSrIxHKQBbuXIzNKEwWXybGEQxJldlaxxfrNwdGpajRLUmcKW.notifyDataSetChanged();

            ChatBot cb = (ChatBot) context;
            cb.user_responded(message);

            BnluzAfxwqjVSarBTVtICgiWtWFlulKlJUZdJPPditmesZRVzwgWMWcIYngQFhbtizFOyUxksXsCnCbQyqJLxsinSPQHmUdzZAjt.setText("");

        } else {
            AppSyncToast.showToast(getApplicationContext(), "Pleas enter something..");
        }
    }

    public static void set_bot_end_response(String end_response) {
        end_chat_response = end_response;
    }

    private void set_end_chat_response() {
        list.add(new MessagesReq(end_chat_response, AppSyncCurrentDate.getDateTimeInFormat("dd/MM/yyyy, hh:mm:ss"), 1));
        OWzEQwuXQPGxGoOTKkZLijiUwwXQSHoKKzQpZgeitCbgEhFjdMZaSrIxHKQBbuXIzNKEwWXybGEQxJldlaxxfrNwdGpajRLUmcKW.notifyDataSetChanged();
    }

    public static void set_bot_head_name(String bot_name) {
        bot_head_title = "" + bot_name;
    }

    private void HandleBotQuestions() {
        nSYEiCmTohYalvRHtmnxhGgJIBsqRzFRvAItiHQinYWfqDVOjJGXnRYFDxCdCDEeTUIPJfcoyizjHlWguaNjtRRHDjhXjdfTSaii.setVisibility(View.VISIBLE);
        if (ZQyJTaqMnfzjAivYoLtHGuiOfUQxHfCtnTJgARlitgDIZIqEvrWZxAvXzFYlOFQiGZEaTJlEISpvDVxTeHTvLFbaFEXfrCjlUrqD.size() > 0) {
            if (WKJkvwsrPVxFNAvxvtKvPuMKtSaHrUNJZFNJwmyrzDTiUVmFVMWFnKLBfXwdBEEJQeyXfHqDOLNiKsRpjPoSADxPUhnbNJbnvtxD < ZQyJTaqMnfzjAivYoLtHGuiOfUQxHfCtnTJgARlitgDIZIqEvrWZxAvXzFYlOFQiGZEaTJlEISpvDVxTeHTvLFbaFEXfrCjlUrqD.size()) {
                list.add(new MessagesReq(ZQyJTaqMnfzjAivYoLtHGuiOfUQxHfCtnTJgARlitgDIZIqEvrWZxAvXzFYlOFQiGZEaTJlEISpvDVxTeHTvLFbaFEXfrCjlUrqD.get(WKJkvwsrPVxFNAvxvtKvPuMKtSaHrUNJZFNJwmyrzDTiUVmFVMWFnKLBfXwdBEEJQeyXfHqDOLNiKsRpjPoSADxPUhnbNJbnvtxD).getMessage(), AppSyncCurrentDate.getDateTimeInFormat("dd/MM/yyyy, hh:mm:ss"), 1));
                OWzEQwuXQPGxGoOTKkZLijiUwwXQSHoKKzQpZgeitCbgEhFjdMZaSrIxHKQBbuXIzNKEwWXybGEQxJldlaxxfrNwdGpajRLUmcKW.notifyDataSetChanged();

                if (ZQyJTaqMnfzjAivYoLtHGuiOfUQxHfCtnTJgARlitgDIZIqEvrWZxAvXzFYlOFQiGZEaTJlEISpvDVxTeHTvLFbaFEXfrCjlUrqD.get(WKJkvwsrPVxFNAvxvtKvPuMKtSaHrUNJZFNJwmyrzDTiUVmFVMWFnKLBfXwdBEEJQeyXfHqDOLNiKsRpjPoSADxPUhnbNJbnvtxD).getType().equalsIgnoreCase(AppSyncChatBot.TYPE_NUMBER)) {
                    BnluzAfxwqjVSarBTVtICgiWtWFlulKlJUZdJPPditmesZRVzwgWMWcIYngQFhbtizFOyUxksXsCnCbQyqJLxsinSPQHmUdzZAjt.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_TEXT_FLAG_MULTI_LINE);
                } else if (ZQyJTaqMnfzjAivYoLtHGuiOfUQxHfCtnTJgARlitgDIZIqEvrWZxAvXzFYlOFQiGZEaTJlEISpvDVxTeHTvLFbaFEXfrCjlUrqD.get(WKJkvwsrPVxFNAvxvtKvPuMKtSaHrUNJZFNJwmyrzDTiUVmFVMWFnKLBfXwdBEEJQeyXfHqDOLNiKsRpjPoSADxPUhnbNJbnvtxD).getType().equalsIgnoreCase(AppSyncChatBot.TYPE_MESSAGE)) {
                    BnluzAfxwqjVSarBTVtICgiWtWFlulKlJUZdJPPditmesZRVzwgWMWcIYngQFhbtizFOyUxksXsCnCbQyqJLxsinSPQHmUdzZAjt.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_MULTI_LINE);
                } else if (ZQyJTaqMnfzjAivYoLtHGuiOfUQxHfCtnTJgARlitgDIZIqEvrWZxAvXzFYlOFQiGZEaTJlEISpvDVxTeHTvLFbaFEXfrCjlUrqD.get(WKJkvwsrPVxFNAvxvtKvPuMKtSaHrUNJZFNJwmyrzDTiUVmFVMWFnKLBfXwdBEEJQeyXfHqDOLNiKsRpjPoSADxPUhnbNJbnvtxD).getType().equalsIgnoreCase(AppSyncChatBot.TYPE_GENDER)) {
                    Handle_Gender_selection();
                } else if (ZQyJTaqMnfzjAivYoLtHGuiOfUQxHfCtnTJgARlitgDIZIqEvrWZxAvXzFYlOFQiGZEaTJlEISpvDVxTeHTvLFbaFEXfrCjlUrqD.get(WKJkvwsrPVxFNAvxvtKvPuMKtSaHrUNJZFNJwmyrzDTiUVmFVMWFnKLBfXwdBEEJQeyXfHqDOLNiKsRpjPoSADxPUhnbNJbnvtxD).getType().equalsIgnoreCase(AppSyncChatBot.TYPE_PHOTO)) {
                    Handle_photo_selection();
                } else if (ZQyJTaqMnfzjAivYoLtHGuiOfUQxHfCtnTJgARlitgDIZIqEvrWZxAvXzFYlOFQiGZEaTJlEISpvDVxTeHTvLFbaFEXfrCjlUrqD.get(WKJkvwsrPVxFNAvxvtKvPuMKtSaHrUNJZFNJwmyrzDTiUVmFVMWFnKLBfXwdBEEJQeyXfHqDOLNiKsRpjPoSADxPUhnbNJbnvtxD).getType().equalsIgnoreCase(AppSyncChatBot.TYPE_FILE_MANAGER)) {
                    Handle_File_Manager();
                }


            }
        }
        if (WKJkvwsrPVxFNAvxvtKvPuMKtSaHrUNJZFNJwmyrzDTiUVmFVMWFnKLBfXwdBEEJQeyXfHqDOLNiKsRpjPoSADxPUhnbNJbnvtxD == ZQyJTaqMnfzjAivYoLtHGuiOfUQxHfCtnTJgARlitgDIZIqEvrWZxAvXzFYlOFQiGZEaTJlEISpvDVxTeHTvLFbaFEXfrCjlUrqD.size()) {
//            end of bot questions
            nSYEiCmTohYalvRHtmnxhGgJIBsqRzFRvAItiHQinYWfqDVOjJGXnRYFDxCdCDEeTUIPJfcoyizjHlWguaNjtRRHDjhXjdfTSaii.setVisibility(View.INVISIBLE);
            nQlsftgEuomimVFdIgESWuBLitKPNBWxNjoXdsRQmUMOLYbJPOGLwqciZdIQtkiybuEDMTcUHKRMxftDsMvtTCUNdsQyKTueQWXe.setVisibility(View.VISIBLE);
            set_end_chat_response();

        }
        WKJkvwsrPVxFNAvxvtKvPuMKtSaHrUNJZFNJwmyrzDTiUVmFVMWFnKLBfXwdBEEJQeyXfHqDOLNiKsRpjPoSADxPUhnbNJbnvtxD++;

        Log.wtf("Hulk-129", ZQyJTaqMnfzjAivYoLtHGuiOfUQxHfCtnTJgARlitgDIZIqEvrWZxAvXzFYlOFQiGZEaTJlEISpvDVxTeHTvLFbaFEXfrCjlUrqD.size() + "");

    }

    String file_path = "";

    private void Handle_File_Manager() {
        ASLSLpiAfaNKIjebrOqNOCThovYKlaFpVpvhmJXbTTmDamuiLSkwAkPLbgFygngDZHSswXBdTJYGqrAWeSfLNrCOWcEhUwNiiAzw.setVisibility(View.VISIBLE);
        nSYEiCmTohYalvRHtmnxhGgJIBsqRzFRvAItiHQinYWfqDVOjJGXnRYFDxCdCDEeTUIPJfcoyizjHlWguaNjtRRHDjhXjdfTSaii.setVisibility(View.GONE);

        JvBhiORkymeFrpXuUoihzCLNwjmhMZPOWsuxpZEhTqAJUFaxhKdHuUpiuXFjjpJPICQVDPWHZsyyMvSlcXQgogKBltbVxeScrfOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AppSyncPermissions.check_read_write_permission(AppSyncChatBot.this)) {
                    AppSyncFileManager.openFileChooser(AppSyncChatBot.this, 998);

                } else {
                    AppSyncPermissions.READ_WRITE_STORAAGE(AppSyncChatBot.this, 22255);

                }
            }
        });

        iiYHcmhnEjMYdPuWMMOSvFMLrWaqpOIPEjRKEczfSxqGYAOfFNDnijLDXqMPvSMDYehbdYiqDxyUYhhMfABGiAAtRCtviLSyzoQV.setAlpha(0.3f);
        iiYHcmhnEjMYdPuWMMOSvFMLrWaqpOIPEjRKEczfSxqGYAOfFNDnijLDXqMPvSMDYehbdYiqDxyUYhhMfABGiAAtRCtviLSyzoQV.setEnabled(false);
        iiYHcmhnEjMYdPuWMMOSvFMLrWaqpOIPEjRKEczfSxqGYAOfFNDnijLDXqMPvSMDYehbdYiqDxyUYhhMfABGiAAtRCtviLSyzoQV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ASLSLpiAfaNKIjebrOqNOCThovYKlaFpVpvhmJXbTTmDamuiLSkwAkPLbgFygngDZHSswXBdTJYGqrAWeSfLNrCOWcEhUwNiiAzw.setVisibility(View.GONE);
                nSYEiCmTohYalvRHtmnxhGgJIBsqRzFRvAItiHQinYWfqDVOjJGXnRYFDxCdCDEeTUIPJfcoyizjHlWguaNjtRRHDjhXjdfTSaii.setVisibility(View.VISIBLE);
                Send_user_message(file_path);
            }
        });

    }

    private void Handle_photo_selection() {
        photo_lay.setVisibility(View.VISIBLE);
        nSYEiCmTohYalvRHtmnxhGgJIBsqRzFRvAItiHQinYWfqDVOjJGXnRYFDxCdCDEeTUIPJfcoyizjHlWguaNjtRRHDjhXjdfTSaii.setVisibility(View.INVISIBLE);

        InHOjbPozlIwtjDmBrmrlJcHcfTvWfLQdKPyskbREPKVaOJbwExuEPJXmEcquFoqiBtMisshxfksLgvICddLLZyTLYsDdXNHjZiQ.setOnClickListener(new View.OnClickListener() {
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
                nSYEiCmTohYalvRHtmnxhGgJIBsqRzFRvAItiHQinYWfqDVOjJGXnRYFDxCdCDEeTUIPJfcoyizjHlWguaNjtRRHDjhXjdfTSaii.setVisibility(View.VISIBLE);
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
                Glide.with(this).load(path).into(InHOjbPozlIwtjDmBrmrlJcHcfTvWfLQdKPyskbREPKVaOJbwExuEPJXmEcquFoqiBtMisshxfksLgvICddLLZyTLYsDdXNHjZiQ);
                submit_img_btn.setAlpha(1f);
                submit_img_btn.setEnabled(true);

            }
        }

        if (requestCode == 998) {
            if (data != null) {
                try {
                    file_path = AppSyncFileManager.getSelectedFilePath(this, data);
                    iiYHcmhnEjMYdPuWMMOSvFMLrWaqpOIPEjRKEczfSxqGYAOfFNDnijLDXqMPvSMDYehbdYiqDxyUYhhMfABGiAAtRCtviLSyzoQV.setAlpha(1f);
                    iiYHcmhnEjMYdPuWMMOSvFMLrWaqpOIPEjRKEczfSxqGYAOfFNDnijLDXqMPvSMDYehbdYiqDxyUYhhMfABGiAAtRCtviLSyzoQV.setEnabled(true);
                    DxqCFIxjjUtSxJKRKFQzGHeouxaBbqJsEDVCIIGKaNIHcyCOutMReeMOfpuJzXQAJvJDHtsnUGgnIJWerAnBqBOYTLdIagThpiiL.setTextColor(Color.GREEN);
                    DxqCFIxjjUtSxJKRKFQzGHeouxaBbqJsEDVCIIGKaNIHcyCOutMReeMOfpuJzXQAJvJDHtsnUGgnIJWerAnBqBOYTLdIagThpiiL.setText("File Selected, please submit");
                } catch (IOException e) {
                    e.printStackTrace();
                    iiYHcmhnEjMYdPuWMMOSvFMLrWaqpOIPEjRKEczfSxqGYAOfFNDnijLDXqMPvSMDYehbdYiqDxyUYhhMfABGiAAtRCtviLSyzoQV.setAlpha(0.3f);
                    iiYHcmhnEjMYdPuWMMOSvFMLrWaqpOIPEjRKEczfSxqGYAOfFNDnijLDXqMPvSMDYehbdYiqDxyUYhhMfABGiAAtRCtviLSyzoQV.setEnabled(false);
                    DxqCFIxjjUtSxJKRKFQzGHeouxaBbqJsEDVCIIGKaNIHcyCOutMReeMOfpuJzXQAJvJDHtsnUGgnIJWerAnBqBOYTLdIagThpiiL.setTextColor(Color.RED);
                    DxqCFIxjjUtSxJKRKFQzGHeouxaBbqJsEDVCIIGKaNIHcyCOutMReeMOfpuJzXQAJvJDHtsnUGgnIJWerAnBqBOYTLdIagThpiiL.setText("Please select another file");
                }
            }
        }
    }

    String gender = "Male";

    private void Handle_Gender_selection() {
        nSYEiCmTohYalvRHtmnxhGgJIBsqRzFRvAItiHQinYWfqDVOjJGXnRYFDxCdCDEeTUIPJfcoyizjHlWguaNjtRRHDjhXjdfTSaii.setVisibility(View.INVISIBLE);
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
                nSYEiCmTohYalvRHtmnxhGgJIBsqRzFRvAItiHQinYWfqDVOjJGXnRYFDxCdCDEeTUIPJfcoyizjHlWguaNjtRRHDjhXjdfTSaii.setVisibility(View.VISIBLE);
                Send_user_message(gender);


            }
        });
    }

    public static void set_bot_questions(ArrayList<ChatReq> list) {
        ZQyJTaqMnfzjAivYoLtHGuiOfUQxHfCtnTJgARlitgDIZIqEvrWZxAvXzFYlOFQiGZEaTJlEISpvDVxTeHTvLFbaFEXfrCjlUrqD = new ArrayList<>();
        ZQyJTaqMnfzjAivYoLtHGuiOfUQxHfCtnTJgARlitgDIZIqEvrWZxAvXzFYlOFQiGZEaTJlEISpvDVxTeHTvLFbaFEXfrCjlUrqD.clear();
        for (int i = 0; i < list.size(); i++) {
            ZQyJTaqMnfzjAivYoLtHGuiOfUQxHfCtnTJgARlitgDIZIqEvrWZxAvXzFYlOFQiGZEaTJlEISpvDVxTeHTvLFbaFEXfrCjlUrqD.add(new ChatReq(list.get(i).getMessage(), list.get(i).getType()));
        }

    }

    public static void set_bot_image(int drawable_image_id) {
        drawable_image_id_this = drawable_image_id;
    }

    @Override
    public void user_responded(String response) {
        HandleBotQuestions();
        DdATEoYtYojdLVceKQbtaeVQnZyjHfJsfvlXvwzqpWYIYuRVPaDxQYnsjDpvAxgtsDWdoOXaSIAaAIjDbAGYzJwguKUlqLWNpkQs.smoothScrollToPosition(list.size());
    }

    @Override
    public void chat_end(ArrayList<UserMessagesReq> list) {
        Intent returnIntent = getIntent();
        returnIntent.putExtra("result", AppSyncSaveArrayList.getListToJsonArray(user_msg_list).toString());
        setResult(RESULT_OK, returnIntent);
        finish();
    }

}