package com.teamup.rohitasawa_library;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import org.json.JSONArray;

import java.util.ArrayList;

public class RohitSaveArrayList {

    public static JsonArray getListToJsonArray(ArrayList list) {
        Gson gson = new GsonBuilder().create();
        JsonArray myCustomArray = gson.toJsonTree(list).getAsJsonArray();
        return myCustomArray;
    }
}
