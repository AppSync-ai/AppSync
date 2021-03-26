package com.teamup.app_sync;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AppSyncLogin extends AppCompatActivity {

    public static boolean loggedIn = false;
    public static Activity activity;
    TextView conpanyTxt;
    Button button;
    EditText edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_rohit_login);

        conpanyTxt = findViewById(R.id.conpanyTxt);
        edtPass = findViewById(R.id.edtPass);
        button = findViewById(R.id.button);

        final Bundle extras = getIntent().getExtras();
        conpanyTxt.setText("" + extras.getString("title"));

        if (activity == null) {
            Toast.makeText(activity, "Please enter Activity field", Toast.LENGTH_LONG).show();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass = edtPass.getText().toString();
                if (!TextUtils.isEmpty(pass)) {
                    if (pass.equals(extras.getString("password"))) {
                        loggedIn = true;
                        finish();
                        startActivity(new Intent(AppSyncLogin.this, activity.getClass()));
                    }
                    else
                    {
                        loggedIn = false;
                        edtPass.setText("");
                        Toast.makeText(AppSyncLogin.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AppSyncLogin.this, "Please enter password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        loggedIn = false;
    }
}