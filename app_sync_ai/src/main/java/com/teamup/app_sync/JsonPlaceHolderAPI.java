package com.teamup.app_sync;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface JsonPlaceHolderAPI {

    @GET("api_apps.php")
    Call<String> get_app(@Query("pkg") String pkg);
}
