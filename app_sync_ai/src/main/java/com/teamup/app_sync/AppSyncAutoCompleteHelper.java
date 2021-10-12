package com.teamup.app_sync;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class AppSyncAutoCompleteHelper {

    public static MutableLiveData<Boolean> is_selected_from_dropdown_live = new MutableLiveData<>();
    static int ykWsyAZtSzFhDOkdZqgTkKazCyUdOzHgBJVTYRCBiYOgEWauUSTpnBMNmcjyGoAFGbutDIPZeZeCmpImjCbbhphEVIIfekTqAgXy = 1;
    static AutoCompleteTextView SUJeIrKofxRjVuUtglqbGGQcPDCKzhBTeMZnIbIIjJGAZzVkuSEuzfNqJIeNDOMWeYuhhQzveYjUSdXZMZHFNJoypVljLYdTlCzu;
    public static MutableLiveData<String> selected_live = new MutableLiveData<>();

    public AppSyncAutoCompleteHelper set_plugin(AutoCompleteTextView autoCompleteTextView_editText, final ArrayList<String> list, final Context context) {
        SUJeIrKofxRjVuUtglqbGGQcPDCKzhBTeMZnIbIIjJGAZzVkuSEuzfNqJIeNDOMWeYuhhQzveYjUSdXZMZHFNJoypVljLYdTlCzu = autoCompleteTextView_editText;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (context, R.layout.auto_complete_item, list);
        //Getting the instance of AutoCompleteTextView
        SUJeIrKofxRjVuUtglqbGGQcPDCKzhBTeMZnIbIIjJGAZzVkuSEuzfNqJIeNDOMWeYuhhQzveYjUSdXZMZHFNJoypVljLYdTlCzu.setThreshold(1);//will start working from first character
        SUJeIrKofxRjVuUtglqbGGQcPDCKzhBTeMZnIbIIjJGAZzVkuSEuzfNqJIeNDOMWeYuhhQzveYjUSdXZMZHFNJoypVljLYdTlCzu.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        adapter.getFilter().filter(null);

        SUJeIrKofxRjVuUtglqbGGQcPDCKzhBTeMZnIbIIjJGAZzVkuSEuzfNqJIeNDOMWeYuhhQzveYjUSdXZMZHFNJoypVljLYdTlCzu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    is_selected_from_dropdown_live.setValue(true);
                    selected_live.setValue(list.get(position) + "");
                    ItemSelected PAvsGSGlPJkMjDBVvwkKIHfLveAymuuPQdGFjYuhPUAPGnsRdZLcxHykCCicRqpnilQXKSztbUNPiYxBdZaeceHUIWLgWxVuSBpK = (ItemSelected) context;
                    PAvsGSGlPJkMjDBVvwkKIHfLveAymuuPQdGFjYuhPUAPGnsRdZLcxHykCCicRqpnilQXKSztbUNPiYxBdZaeceHUIWLgWxVuSBpK.item_selected(list.get(position));
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
        ykWsyAZtSzFhDOkdZqgTkKazCyUdOzHgBJVTYRCBiYOgEWauUSTpnBMNmcjyGoAFGbutDIPZeZeCmpImjCbbhphEVIIfekTqAgXy = threshhold;
        SUJeIrKofxRjVuUtglqbGGQcPDCKzhBTeMZnIbIIjJGAZzVkuSEuzfNqJIeNDOMWeYuhhQzveYjUSdXZMZHFNJoypVljLYdTlCzu.setThreshold(1);//will start working from first character
        return this;
    }

    public interface ItemSelected {
        public void item_selected(String selected);
    }

}
