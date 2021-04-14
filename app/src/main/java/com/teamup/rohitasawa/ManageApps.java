package com.teamup.rohitasawa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.teamup.app_sync.AppSyncBottomSheetDialog;
import com.teamup.app_sync.AppSyncChangeNavigationColor;
import com.teamup.app_sync.AppSyncDirectResponse;
import com.teamup.app_sync.AppSyncDirectResponseListenNew;
import com.teamup.app_sync.AppSyncHideTop;
import com.teamup.app_sync.AppSyncToast;
import com.teamup.app_sync.AppSyncYesNoDialog;
import com.teamup.rohitasawa.AllAdapters.AppsAdapter;
import com.teamup.rohitasawa.AllReqs.AppsReq;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ManageApps extends AppCompatActivity implements AppSyncYesNoDialog.dialogSayings {

    ArrayList<AppsReq> list;
    RecyclerView recycler;
    AppsAdapter adapter;
    ImageView refreshImg;
    public static Context context;
    FloatingActionButton addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppSyncChangeNavigationColor.change(this);
        AppSyncHideTop.hide(this);
        setContentView(R.layout.activity_manage_apps);

        context = this;

        addBtn = findViewById(R.id.addBtn);
        refreshImg = findViewById(R.id.refreshImg);
        recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new AppsAdapter(list);
        recycler.setAdapter(adapter);

        LoadAllApps();

        refreshImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshImg.setVisibility(View.GONE);
                LoadAllApps();
            }
        });


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HandleBottomAdder();
            }
        });
    }

    private void HandleBottomAdder() {
        AppSyncBottomSheetDialog.showSquared(this, R.layout.bottom_add_app, true);
        View vv = AppSyncBottomSheetDialog.view2;
        final EditText app_pkg_id_edt = vv.findViewById(R.id.app_pkg_id_edt);
        final Switch status_switch = vv.findViewById(R.id.status_switch);
        Button submitBtn = vv.findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pkgId = app_pkg_id_edt.getText().toString();
                int status = 0;
                if (status_switch.isChecked()) {
                    status = 1;
                } else {
                    status = 0;
                }

                if (!TextUtils.isEmpty(pkgId)) {
                    Admin.makeItQuery("INSERT INTO `AppSync` (`id`, `package`, `status`) VALUES (NULL, '" + pkgId + "', '" + status + "')", getApplicationContext());
                    AppSyncBottomSheetDialog.dismiss(ManageApps.this);
                    AppSyncToast.showToast(getApplicationContext(), "Added successfully");
                    LoadAllApps();
                } else {
                    AppSyncToast.showToast(getApplicationContext(), "Please enter package ID");
                }

            }
        });
    }

    private void LoadAllApps() {
        list.clear();
        adapter.notifyDataSetChanged();
        AppSyncDirectResponseListenNew.getResponseFromUrl(Admin.BASEURL + "api_apps.php", this, new AppSyncDirectResponseListenNew.ResponseListener() {
            @Override
            public void responser(String response) {
                try {

                    JSONArray jsonArray = new JSONArray(response);
                    if (jsonArray.length() > 0) {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject obj = jsonArray.getJSONObject(i);
                            String id = String.valueOf(obj.getInt("id"));
                            String packageId = obj.getString("package");
                            String status = String.valueOf(obj.getInt("status"));

                            AppsReq ar = new AppsReq(id, packageId, status);
                            list.add(ar);
                            adapter.notifyDataSetChanged();
                        }
                        refreshImg.setVisibility(View.VISIBLE);
                    } else {
                        AppSyncToast.showToast(getApplicationContext(), "No Apps Added!!");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void greenSignal() {
        try {

            Admin.makeItQuery("DELETE FROM `AppSync` WHERE `AppSync`.`id` = " + Admin.id, getApplicationContext());
            list.remove(Admin.position);
            adapter.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void redSignal() {

    }
}