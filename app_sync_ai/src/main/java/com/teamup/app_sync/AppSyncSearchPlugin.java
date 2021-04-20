package com.teamup.app_sync;

import android.content.Context;
import android.widget.Adapter;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class AppSyncSearchPlugin {
    public static ArrayList search(Context context, String searchTxt, ArrayList list) {
        ArrayList newList = new ArrayList();

        JsonArray jsonArray = AppSyncSaveArrayList.getListToJsonArray(list);
        for (int i = 0; i < list.size(); i++) {
            JsonObject object = jsonArray.get(i).getAsJsonObject();
            String sobj = String.valueOf(object);

            if (sobj.toLowerCase().contains(searchTxt.toLowerCase())) {
                newList.add(list.get(i));
            }

        }

        return newList;

    }
}


// How to implementl
// add this onText Changed

//          adapter = new AppsAdapter(AppSyncSearchPlugin.search(ManageApps.this, searchEdt.getText().toString(), list));
//          recycler.setAdapter(adapter);
//          adapter.notifyDataSetChanged();