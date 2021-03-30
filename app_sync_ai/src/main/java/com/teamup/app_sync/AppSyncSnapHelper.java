package com.teamup.app_sync;

import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

public class AppSyncSnapHelper {
    public static void addSnapHelper(RecyclerView recyclerView) {
        LinearSnapHelper linearSnapHelper = new SnapHelperOneByOne();
        linearSnapHelper.attachToRecyclerView(recyclerView);
    }
}
