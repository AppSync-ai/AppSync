package com.teamup.app_sync;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class AppSyncAutoCompleteHelper {

    public static MutableLiveData<Boolean> is_selected_from_dropdown_live = new MutableLiveData<>();
    static int thresh = 1;
    static AutoCompleteTextView autoCompleteTextView;
    public static MutableLiveData<String> selected_live = new MutableLiveData<>();

    public AppSyncAutoCompleteHelper set_plugin(AutoCompleteTextView autoCompleteTextView_editText, final ArrayList<String> list, final Context context) {
        autoCompleteTextView = autoCompleteTextView_editText;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (context, R.layout.auto_complete_item, list);
        //Getting the instance of AutoCompleteTextView
        autoCompleteTextView.setThreshold(1);//will start working from first character
        autoCompleteTextView.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        adapter.getFilter().filter(null);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    is_selected_from_dropdown_live.setValue(true);
                    selected_live.setValue(list.get(position) + "");
                    ItemSelected itemSelected = (ItemSelected) context;
                    itemSelected.item_selected(list.get(position));
                } catch (Exception d) {
                    Log.wtf("app_sync_34", d.getMessage());
                }
            }
        });

        autoCompleteTextView_editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                is_selected_from_dropdown_live.setValue(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return this;

    }

    public AppSyncAutoCompleteHelper set_threshold(int threshhold) {
        thresh = threshhold;
        autoCompleteTextView.setThreshold(1);//will start working from first character
        return this;
    }

    public interface ItemSelected {
        public void item_selected(String selected);
    }

}
