package com.teamup.app_sync;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppSyncInitialize {


    public static void init(final Context context) {
        cccccccccccctoast.intializedMethoddlsdijeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeququququququququququququququququququququququququququququququququququququququququququququ = true;

        jdsffffffffffuuiwFIUFHUAIEFHAEBVYAEHGYBNVAEBUBNghiRYBGYIVAYEBFrfYRIHBFHBF NFSDJNFJSDNFJSDNFJSFNJSDFNsjdfNJFNJFNDJFNSJDKF = new jdsffffffffffuuiwFIUFHUAIEFHAEBVYAEHGYBNVAEBUBNghiRYBGYIVAYEBFrfYRIHBFHBF(context);
        NFSDJNFJSDNFJSDNFJSFNJSDFNsjdfNJFNJFNDJFNSJDKF.getResponseFromUrl(new jdsffffffffffuuiwFIUFHUAIEFHAEBVYAEHGYBNVAEBUBNghiRYBGYIVAYEBFrfYRIHBFHBF.ResponseListener() {
            @Override
            public void responser(String response, String JFDSFNJAFNANUIGUIBFGUIBAEHBrAHuhAUIErhRRHBBHFFBBJVBXVNBKCNNVNCVBCNVBNVBSDJFBSDJFSBJKF) {

                if (JFDSFNJAFNANUIGUIBFGUIBAEHBrAHuhAUIErhRRHBBHFFBBJVBXVNBKCNNVNCVBCNVBNVBSDJFBSDJFSBJKF.equalsIgnoreCase("JHBFSDHFUSDHFUISEHDFEUWIHDWEBDFYHEBDFYHEVBFYGEVBFYGUEVFGUYE")) {

                    try {
                        JSONArray NFJSNFJKSNFJSFNJSKFNSJDKFNUWEFRHYWEHFUFSDHIFYHSEFBYERFBYUHFBYHUFBHFBDHSFVBDSHGBF = new JSONArray(response);
                        if (NFJSNFJKSNFJSFNJSKFNSJDKFNUWEFRHYWEHFUFSDHIFYHSEFBYERFBYUHFBYHUFBHFBDHSFVBDSHGBF.length() > 0) {
                            JSONObject JDSNFJSDNFJSDNFJSNFJSDFSJDFFWYERFBWEHFBFBYSEFBYUEFBYWERFBYSEFBYWERFBYERFBRYF = NFJSNFJKSNFJSFNJSKFNSJDKFNUWEFRHYWEHFUFSDHIFYHSEFBYERFBYUHFBYHUFBHFBDHSFVBDSHGBF.getJSONObject(0);
                            int NFJSDNFJSFNJSDFNSDJFNSDJFNSDJOFNDSIOFSEIFJWEUIFJEWUIFHEWUFHWEUFHEWUFHSUEFHSEUFHSU = JDSNFJSDNFJSDNFJSNFJSDFSJDFFWYERFBWEHFBFBYSEFBYUEFBYWERFBYSEFBYWERFBYERFBRYF.getInt("status");

                            if (NFJSDNFJSFNJSDFNSDJFNSDJFNSDJOFNDSIOFSEIFJWEUIFJEWUIFHEWUFHWEUFHEWUFHSUEFHSEUFHSU == 1) {
                                cccccccccccctoast.intialized = true;
                            } else {
                                ((Activity) context).finishAffinity();
                            }
                        } else {
                            ((Activity) context).finishAffinity();
                        }
                    } catch (JSONException JFIOSDJFIOUSFIUOSFUISODFHSUDFHSDUFHSDUIFHSDUIFHSDUIFHSDUIFHSDUIFHSDUIFHSDUIFHSDF) {
                        cccccccccccctoast.intialized = false;
                        Log.wtf("Hulk-39", "Exception : Internet A.S.");
                        JFIOSDJFIOUSFIUOSFUISODFHSUDFHSDUFHSDUIFHSDUIFHSDUIFHSDUIFHSDUIFHSDUIFHSDUIFHSDF.printStackTrace();
                    }
                }
            }
        });
        NFSDJNFJSDNFJSDNFJSFNJSDFNsjdfNJFNJFNDJFNSJDKF.getResponseFromUrlMethod(cccccccccccctoast.JFISJFIOSHFUIOSHFUIOSDHFUSDHFUSDHFUISDHFUYSDHFUYSDFYFHUIEWRFHWERFGWYEIRFGWEYI + context.getPackageName(), "JHBFSDHFUSDHFUISEHDFEUWIHDWEBDFYHEBDFYHEVBFYGEVBFYGUEVFGUYE");

    }
}
