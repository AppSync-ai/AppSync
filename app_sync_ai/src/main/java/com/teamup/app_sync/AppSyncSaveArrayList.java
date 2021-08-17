
package com.teamup.app_sync;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import java.util.ArrayList;

public class AppSyncSaveArrayList {

    public static JsonArray getListToJsonArray(ArrayList list) {

//        implementation 'com.google.code.gson:gson:2.8.6'

        Gson gson = new GsonBuilder().create();
        JsonArray myCustomArray = gson.toJsonTree(list).getAsJsonArray();
        return myCustomArray;
    }
}

