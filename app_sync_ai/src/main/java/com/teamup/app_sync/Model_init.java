package com.teamup.app_sync;

import static android.util.Log.*;
import static android.util.Log.wtf;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Model_init {
    public static MutableLiveData<String> message = new MutableLiveData<>();
    public static MutableLiveData<String> response_data = new MutableLiveData<>();

    public static void load(String pkg) {



    }

}
