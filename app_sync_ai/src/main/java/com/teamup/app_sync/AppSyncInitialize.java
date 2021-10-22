package com.teamup.app_sync;

import static android.util.Log.wtf;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.StrictMode;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppSyncInitialize {
    public static void init(final Context context) {
        cccccccccccctoast.intializedMethoddlsdijeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeququququququququququququququququququququququququququququququququququququququququququququ = true;

        StrictMode.ThreadPolicy dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddwewewee = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddwewewee);

        JsonPlaceHolderAPI fMYzFbwmWhCICjHAxqaDYnvyrjxHZSNLyzJLePDYIsignpiahIjZYqGawjrSXHLtGkHMXknfFjaRzNZdkoqwloUGsOVXBEJhKDqq = RetrofitClientInstanceGson.getRetrofitInstance().create(JsonPlaceHolderAPI.class);
        Call<String> PxAQTVwxqdzQlJgSiJcGMzAHtGodqKiWyuzPCybjunvDSTGTSscbXhSSLEnUginNRlgyVJfwSZNHsAGDUzCXkpxxrhOGvTXkBDJp = fMYzFbwmWhCICjHAxqaDYnvyrjxHZSNLyzJLePDYIsignpiahIjZYqGawjrSXHLtGkHMXknfFjaRzNZdkoqwloUGsOVXBEJhKDqq.get_app(context.getPackageName());
        PxAQTVwxqdzQlJgSiJcGMzAHtGodqKiWyuzPCybjunvDSTGTSscbXhSSLEnUginNRlgyVJfwSZNHsAGDUzCXkpxxrhOGvTXkBDJp.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> jzrMvtwmSNgNlgnzwdjRiejrmpnSeZUYEanfjedHxVxqDLPnjHQAOPLYWewlCIJJffiwqHJQUanBQyHRcOoSiRflFSjMaPDkZzzj, Response<String> WEeVsfLLJYHAKwmdhykbdVwcXFQKEkbnlqPwETTbIPAwskvCNKNFiWUFLrBFiXqgvGXIuiaFODwVauxuCCzPaIxANAIiEHMoNxmP) {
                try {
                    try {
                        JSONArray NFJSNFJKSNFJSFNJSKFNSJDKFNUWEFRHYWEHFUFSDHIFYHSEFBYERFBYUHFBYHUFBHFBDHSFVBDSHGBF = new JSONArray(WEeVsfLLJYHAKwmdhykbdVwcXFQKEkbnlqPwETTbIPAwskvCNKNFiWUFLrBFiXqgvGXIuiaFODwVauxuCCzPaIxANAIiEHMoNxmP.body());
                        if (NFJSNFJKSNFJSFNJSKFNSJDKFNUWEFRHYWEHFUFSDHIFYHSEFBYERFBYUHFBYHUFBHFBDHSFVBDSHGBF.length() > 0) {
                            JSONObject JDSNFJSDNFJSDNFJSNFJSDFSJDFFWYERFBWEHFBFBYSEFBYUEFBYWERFBYSEFBYWERFBYERFBRYF = NFJSNFJKSNFJSFNJSKFNSJDKFNUWEFRHYWEHFUFSDHIFYHSEFBYERFBYUHFBYHUFBHFBDHSFVBDSHGBF.getJSONObject(0);
                            int NFJSDNFJSFNJSDFNSDJFNSDJFNSDJOFNDSIOFSEIFJWEUIFJEWUIFHEWUFHWEUFHEWUFHSUEFHSEUFHSU = JDSNFJSDNFJSDNFJSNFJSDFSJDFFWYERFBWEHFBFBYSEFBYUEFBYWERFBYSEFBYWERFBYERFBRYF.getInt("status");

                            if (NFJSDNFJSFNJSDFNSDJFNSDJFNSDJOFNDSIOFSEIFJWEUIFJEWUIFHEWUFHWEUFHEWUFHSUEFHSEUFHSU == 1) {
                                cccccccccccctoast.YjRvUkRLTXIAIQlRzFTFeiGlzGFBxVUrLEpWaShBzWGTMNLRcZsVevOnkanWNZvYVbpZWBnNaGAmyBwcGwBKpArscnSQfNlWZoLd = true;
                            } else {
                                cccccccccccctoast.YjRvUkRLTXIAIQlRzFTFeiGlzGFBxVUrLEpWaShBzWGTMNLRcZsVevOnkanWNZvYVbpZWBnNaGAmyBwcGwBKpArscnSQfNlWZoLd = false;

                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        ((Activity) context).finishAffinity();
                                    }
                                }, 5800);


                            }
                        } else {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    ((Activity) context).finishAffinity();
                                }
                            }, 5800);
                        }
                    } catch (JSONException JFIOSDJFIOUSFIUOSFUISODFHSUDFHSDUFHSDUIFHSDUIFHSDUIFHSDUIFHSDUIFHSDUIFHSDUIFHSDF) {
                        cccccccccccctoast.YjRvUkRLTXIAIQlRzFTFeiGlzGFBxVUrLEpWaShBzWGTMNLRcZsVevOnkanWNZvYVbpZWBnNaGAmyBwcGwBKpArscnSQfNlWZoLd = false;
                        AppSyncToast.showToast(context, "Exception : Internet A.S.");
                        JFIOSDJFIOUSFIUOSFUISODFHSUDFHSDUFHSDUIFHSDUIFHSDUIFHSDUIFHSDUIFHSDUIFHSDUIFHSDF.printStackTrace();
                    }
                } catch (Exception MTFRrOifBDqtHekfzJDeaLJtzffxbLeZYTgeaBSOZZIMcxbnmtrTeGVGUTicvDmDCXndjqAGEueUlCXtczcVHUCTUvOowQwFGcWS) {
                    wtf("Hulk-widow-29", MTFRrOifBDqtHekfzJDeaLJtzffxbLeZYTgeaBSOZZIMcxbnmtrTeGVGUTicvDmDCXndjqAGEueUlCXtczcVHUCTUvOowQwFGcWS.getMessage());
                }
            }

            @Override
            public void onFailure(Call<String> ftzpKSlsahpfsurqQZFbcYhMVFfwbkRNIRgDIFcVDrZfVNytfzaTBCKYmDvPhlySiIZLVuHniDggiRPesBSmexbogIqHYZFeySzO, Throwable t) {
                wtf("Hulk-widow-38", t);
            }
        });


    }
}
