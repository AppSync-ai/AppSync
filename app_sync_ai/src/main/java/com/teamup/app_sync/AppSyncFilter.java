package com.teamup.app_sync;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.widget.LinearLayoutCompat;

import java.util.ArrayList;

public class AppSyncFilter extends RelativeLayout {

    private Context context;
    private AttributeSet attrs;
    private int styleAttr;
    static ArrayAdapter<String> adapter;
    static TextView filter_head_txt;

//    Three compulsory methods here
//    always add these methods

    public AppSyncFilter(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    public AppSyncFilter(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.attrs = attrs;
        initView();
    }

    public AppSyncFilter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        this.attrs = attrs;
        this.styleAttr = defStyleAttr;
        initView();
    }

//    Three methods ends here


    private void initView() {
        inflate(context, R.layout.filter_layout, this);

        filter_head_txt = findViewById(R.id.filter_head_txt);


        final LinearLayoutCompat filter_collapse_liner = findViewById(R.id.filter_collapse_liner);
        final LinearLayoutCompat filter_expanded_liner = findViewById(R.id.filter_expanded_liner);

        Animation bottomUp = AnimationUtils.loadAnimation(getContext(),
                R.anim.right_to_left_anim);
        ViewGroup hiddenPanel = (ViewGroup) filter_collapse_liner;
        hiddenPanel.startAnimation(bottomUp);
        hiddenPanel.setVisibility(View.VISIBLE);

        filter_collapse_liner.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (filter_collapse_liner.getVisibility() == VISIBLE) {
                    filter_collapse_liner.setVisibility(GONE);
                    filter_expanded_liner.setVisibility(VISIBLE);
                } else {
                    filter_collapse_liner.setVisibility(VISIBLE);
                    filter_expanded_liner.setVisibility(GONE);
                }
            }
        });

        ArrayList<String> list = new ArrayList<>();

        final Spinner spinner = findViewById(R.id.spinner);
        adapter = new ArrayAdapter<String>(context, R.layout.spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i != 0) {
                    try {
                        OptionSelected os = (OptionSelected) context;
                        os.option_selected(spinner.getSelectedItem().toString(), i);
                    } catch (Exception cv) {
                        Log.wtf("Hulk-84-sync", cv.getMessage());
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ImageView close_img = findViewById(R.id.close_img);
        close_img.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                filter_collapse_liner.setVisibility(VISIBLE);
                filter_expanded_liner.setVisibility(GONE);
                try {
                    OptionSelected os = (OptionSelected) context;
                    os.closed();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }


    public static void setFilterOptions(ArrayList<String> options_array_list) {
        options_array_list.add(0, "Select");
        for (int i = 0; i < options_array_list.size(); i++) {
            adapter.add(options_array_list.get(i));
        }
    }

    public interface OptionSelected {
        public void option_selected(String selected_option, int option_position);

        public void closed();
    }

}
