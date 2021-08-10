package com.teamup.app_sync;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.teamup.app_sync.Adapters.CountryAdapter;
import com.teamup.app_sync.Reqs.CountryReq;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AppSyncWorldSelector {

    static CountryAdapter adapter;

    static String countries_json = "https://raw.githubusercontent.com/stefangabos/world_countries/master/data/en/world.json";
    static String flag_base_url = "https://raw.githubusercontent.com/stefangabos/world_countries/master/flags/64x64/";
    static Context contextThis;

    public static void get_all_countries(final Context context) {
        contextThis = context;
        AppSyncCustomDialog.showDialog(context, R.layout.dialog_country_selector, R.color.BlackTransparent, true);
        View vv = AppSyncCustomDialog.view2;
        final RecyclerView recycler = vv.findViewById(R.id.recycler);
        final ProgressBar preg = vv.findViewById(R.id.preg);
        recycler.setLayoutManager(new LinearLayoutManager(context));
        final ArrayList<CountryReq> list = new ArrayList<>();
        adapter = new CountryAdapter(list);
        recycler.setAdapter(adapter);
        final EditText searchEdt = vv.findViewById(R.id.searchEdt);

        searchEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (searchEdt.getText().toString().length() >= 0) {
                    adapter = new CountryAdapter(AppSyncSearchPlugin.search(context, searchEdt.getText().toString(), list));
                    recycler.setAdapter(adapter);
                } else {
                    adapter = new CountryAdapter(list);
                    recycler.setAdapter(adapter);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        AppSyncDirectResponseListen as = new AppSyncDirectResponseListen(context);
        as.getResponseFromUrl(new AppSyncDirectResponseListen.ResponseListener() {
            @Override
            public void responser(String response, String datakey) {
                if (datakey.equalsIgnoreCase("ddd")) {
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject obj = jsonArray.getJSONObject(i);
                            String id = String.valueOf(obj.getInt("id"));
                            String name = obj.getString("name");
                            String alpha2 = obj.getString("alpha2");
                            String alpha3 = obj.getString("alpha3");

                            CountryReq cr = new CountryReq(name, alpha3, flag_base_url + alpha2 + ".png");
                            list.add(cr);
                            adapter.notifyDataSetChanged();
                            preg.setVisibility(View.GONE);
                        }
                    } catch (JSONException e) {
                        AppSyncCustomDialog.stopPleaseWaitDialog(context);
                        preg.setVisibility(View.GONE);
                        e.printStackTrace();
                    }
                }
            }
        });
        as.getResponseFromUrlMethod(countries_json, "ddd");


    }

    public interface Country_selected {
        public void selected(String name_of_country, String flag_img_url, String country_code);
    }

    public static void close_dialog() {
        AppSyncCustomDialog.stopPleaseWaitDialog(contextThis);
    }
}
