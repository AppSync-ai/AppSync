package com.teamup.app_sync;

import static com.teamup.app_sync.AppSyncLoadAllStatesDistTalCity.URL;
import static com.teamup.app_sync.AppSyncLoadAllStatesDistTalCity.contextThis;
import static com.teamup.app_sync.AppSyncLoadAllStatesDistTalCity.list;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.teamup.app_sync.Adapters.StateItemAdapter;
import com.teamup.app_sync.Reqs.SyncStatesReq;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Handler;

public class AppSyncLoadAllStatesDistTalCity {
    public static String KEY = "";

//    implementation 'org.jsoup:jsoup:1.11.1'

    static ArrayList<SyncStatesReq> list = new ArrayList<>();
    static String URL = "https://vlist.in/";
    static Context contextThis = null;

    public static void getAllStates(Context context) {
        contextThis = context;
        AppSyncPleaseWait.showDialog(contextThis, "Loading..");

        new StatesParser().execute();

    }

    public static void getAllDistricts(Context context, String url) {
        contextThis = context;
        AppSyncPleaseWait.showDialog(contextThis, "Loading..");

        new DistrictParser().execute(url);

    }

    public static void getAllTaluka(Context context, String url) {
        contextThis = context;
        AppSyncPleaseWait.showDialog(contextThis, "Loading..");

        new TalukaParser().execute(url);

    }

    public static void getAllCities(Context context, String url) {
        contextThis = context;
        AppSyncPleaseWait.showDialog(contextThis, "Loading..");

        new CityParser().execute(url);

    }

    public interface Loaded {
        public void statesLoaded(ArrayList<SyncStatesReq> list);

        public void districtLoaded(ArrayList<SyncStatesReq> list);

        public void talukaLoaded(ArrayList<SyncStatesReq> list);

        public void cityLoaded(ArrayList<SyncStatesReq> list);


        public void stateSelected(String state, String link);

        public void districtSelected(String district, String link);

        public void talukaSelected(String taluka, String link);

        public void citySelected(String city, String link);
    }

    public static void DiloagShow(ArrayList<SyncStatesReq> list, String title, String description, String key) {
        KEY = key;
        AppSyncCustomDialog.showDialog(contextThis, R.layout.dialog_data_in_recycler, R.color.BlackTransparent, false);
        View vv = AppSyncCustomDialog.view2;
        TextView title_txt = vv.findViewById(R.id.title_txt);
        title_txt.setText("" + title);
        TextView manage_txt = vv.findViewById(R.id.manage_txt);
        manage_txt.setText("" + description);

        RecyclerView recycler = vv.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(contextThis));
        StateItemAdapter adapter = new StateItemAdapter(list);
        recycler.setAdapter(adapter);

        Button close_btn = vv.findViewById(R.id.close_btn);
        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (KEY.equalsIgnoreCase("state")) {
                    AppSyncLoadAllStatesDistTalCity.Loaded loaded = (AppSyncLoadAllStatesDistTalCity.Loaded) contextThis;
                    loaded.stateSelected("", "");
                } else if (KEY.equalsIgnoreCase("taluka")) {
                    AppSyncLoadAllStatesDistTalCity.Loaded loaded = (AppSyncLoadAllStatesDistTalCity.Loaded) contextThis;
                    loaded.talukaSelected("", "");
                } else if (KEY.equalsIgnoreCase("district")) {
                    AppSyncLoadAllStatesDistTalCity.Loaded loaded = (AppSyncLoadAllStatesDistTalCity.Loaded) contextThis;
                    loaded.districtSelected("", "");
                } else if (KEY.equalsIgnoreCase("city")) {
                    AppSyncLoadAllStatesDistTalCity.Loaded loaded = (AppSyncLoadAllStatesDistTalCity.Loaded) contextThis;
                    loaded.citySelected("", "");
                }

                AppSyncCustomDialog.stopPleaseWaitDialog(contextThis);
            }
        });
    }
}


class StatesParser extends AsyncTask<String, String, String> {

//    load states all with their links href

    @Override
    protected String doInBackground(String... params) {

//            String url = params[0];

        final Document pageDocument;

        try {
//            call url here

            AppSyncLoadAllStatesDistTalCity.list.clear();

            pageDocument = Jsoup.connect("https://vlist.in/")
                    .timeout(15000)
                    .get();


            Elements rows = null;
            try {
                final Element table = pageDocument.select("table").get(0); //select the first table.
                rows = table.select("tr");
            } catch (Exception e) {
                e.printStackTrace();
            }

//            Load state data here
            if (rows != null) {

                for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
                    Element row = rows.get(i);
                    final Elements cols = row.select("td");

                    Elements links = cols.select("a[href]");
                    for (Element link : links) {
                        Log.wtf("Hulk-state" + i, "" + cols.get(1).text() + " Link :" + link.attr("href"));
                        AppSyncLoadAllStatesDistTalCity.list.add(new SyncStatesReq(cols.get(1).text(), link.attr("href")));
                    }
                }

//                Call Listener here
                try {
                    ((Activity) contextThis).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            AppSyncLoadAllStatesDistTalCity.Loaded loaded = (AppSyncLoadAllStatesDistTalCity.Loaded) contextThis;
                            loaded.statesLoaded(list);
                        }
                    });

                } catch (Exception e) {
                    ((Activity) contextThis).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            AppSyncPleaseWait.stopDialog(contextThis);
                        }
                    });
                    e.printStackTrace();
                    Log.wtf("Hulk-85", "States Loaded : " + e.getMessage());
                }


            } else {
                ((Activity) contextThis).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        AppSyncPleaseWait.stopDialog(contextThis);
                    }
                });

                Log.wtf("Hulk-71", "Rows are null");
            }

        } catch (IOException e) {
            ((Activity) contextThis).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    AppSyncPleaseWait.stopDialog(contextThis);
                }
            });

            e.printStackTrace();
            Log.wtf("Hulk-err-76", e.getMessage());
        }

        return null;
    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        ((Activity) contextThis).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AppSyncPleaseWait.stopDialog(contextThis);
            }
        });


    }
}

class DistrictParser extends AsyncTask<String, String, String> {

//    load states all with their links href

    @Override
    protected String doInBackground(String... params) {

        String url = params[0];

        final Document pageDocument;

        try {
//            call url here

            AppSyncLoadAllStatesDistTalCity.list.clear();

            pageDocument = Jsoup.connect(URL + url)
                    .timeout(15000)
                    .get();


            Elements rows = null;
            try {
                final Element table = pageDocument.select("table").get(0); //select the first table.
                rows = table.select("tr");
            } catch (Exception e) {
                e.printStackTrace();
            }

//            Load state data here
            if (rows != null) {

                for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
                    Element row = rows.get(i);
                    final Elements cols = row.select("td");

                    Elements links = cols.select("a[href]");
                    for (Element link : links) {
                        Log.wtf("Hulk-state" + i, "" + cols.get(1).text() + " Link :" + link.attr("href"));
                        AppSyncLoadAllStatesDistTalCity.list.add(new SyncStatesReq(cols.get(1).text(), link.attr("href")));
                    }
                }

//                Call Listener here
                try {
                    ((Activity) contextThis).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            AppSyncLoadAllStatesDistTalCity.Loaded loaded = (AppSyncLoadAllStatesDistTalCity.Loaded) contextThis;
                            loaded.districtLoaded(list);
                        }
                    });

                } catch (Exception e) {
                    ((Activity) contextThis).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            AppSyncPleaseWait.stopDialog(contextThis);
                        }
                    });
                    e.printStackTrace();
                    Log.wtf("Hulk-85", "District Loaded : " + e.getMessage());
                }


            } else {
                ((Activity) contextThis).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        AppSyncPleaseWait.stopDialog(contextThis);
                    }
                });

                Log.wtf("Hulk-71", "Rows are null");
            }

        } catch (IOException e) {
            ((Activity) contextThis).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    AppSyncPleaseWait.stopDialog(contextThis);
                }
            });

            e.printStackTrace();
            Log.wtf("Hulk-err-76", e.getMessage());
        }

        return null;
    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        ((Activity) contextThis).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AppSyncPleaseWait.stopDialog(contextThis);
            }
        });


    }
}


class TalukaParser extends AsyncTask<String, String, String> {

//    load states all with their links href

    @Override
    protected String doInBackground(String... params) {

        String url = params[0];

        final Document pageDocument;

        try {
//            call url here

            AppSyncLoadAllStatesDistTalCity.list.clear();
            pageDocument = Jsoup.connect(URL + url)
                    .timeout(15000)
                    .get();


            Elements rows = null;
            try {
                final Element table = pageDocument.select("table").get(0); //select the first table.
                rows = table.select("tr");
            } catch (Exception e) {
                e.printStackTrace();
            }

//            Load state data here
            if (rows != null) {

                for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
                    Element row = rows.get(i);
                    final Elements cols = row.select("td");

                    Elements links = cols.select("a[href]");
                    for (Element link : links) {
                        Log.wtf("Hulk-state" + i, "" + cols.get(1).text() + " Link :" + link.attr("href"));
                        AppSyncLoadAllStatesDistTalCity.list.add(new SyncStatesReq(cols.get(1).text(), link.attr("href")));
                    }
                }

//                Call Listener here
                try {
                    ((Activity) contextThis).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            AppSyncLoadAllStatesDistTalCity.Loaded loaded = (AppSyncLoadAllStatesDistTalCity.Loaded) contextThis;
                            loaded.talukaLoaded(list);
                        }
                    });

                } catch (Exception e) {
                    ((Activity) contextThis).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            AppSyncPleaseWait.stopDialog(contextThis);
                        }
                    });
                    e.printStackTrace();
                    Log.wtf("Hulk-85", "District Loaded : " + e.getMessage());
                }


            } else {
                ((Activity) contextThis).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        AppSyncPleaseWait.stopDialog(contextThis);
                    }
                });

                Log.wtf("Hulk-71", "Rows are null");
            }

        } catch (IOException e) {
            ((Activity) contextThis).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    AppSyncPleaseWait.stopDialog(contextThis);
                }
            });

            e.printStackTrace();
            Log.wtf("Hulk-err-76", e.getMessage());
        }

        return null;
    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        ((Activity) contextThis).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AppSyncPleaseWait.stopDialog(contextThis);
            }
        });


    }
}


class CityParser extends AsyncTask<String, String, String> {

//    load states all with their links href

    @Override
    protected String doInBackground(String... params) {

        String url = params[0];

        final Document pageDocument;

        try {
//            call url here

            AppSyncLoadAllStatesDistTalCity.list.clear();

            pageDocument = Jsoup.connect(URL + url)
                    .timeout(15000)
                    .get();


            Elements rows = null;
            try {
                final Element table = pageDocument.select("table").get(0); //select the first table.
                rows = table.select("tr");
            } catch (Exception e) {
                e.printStackTrace();
            }

//            Load state data here
            if (rows != null) {

                for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
                    Element row = rows.get(i);
                    final Elements cols = row.select("td");

                    Elements links = cols.select("a[href]");
                    for (Element link : links) {
                        Log.wtf("Hulk-state" + i, "" + cols.get(1).text() + " Link :" + link.attr("href"));
                        AppSyncLoadAllStatesDistTalCity.list.add(new SyncStatesReq(cols.get(1).text(), link.attr("href")));
                    }
                }

//                Call Listener here
                try {
                    ((Activity) contextThis).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            AppSyncLoadAllStatesDistTalCity.Loaded loaded = (AppSyncLoadAllStatesDistTalCity.Loaded) contextThis;
                            loaded.cityLoaded(list);
                        }
                    });

                } catch (Exception e) {
                    ((Activity) contextThis).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            AppSyncPleaseWait.stopDialog(contextThis);
                        }
                    });
                    e.printStackTrace();
                    Log.wtf("Hulk-85", "District Loaded : " + e.getMessage());
                }


            } else {
                ((Activity) contextThis).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        AppSyncPleaseWait.stopDialog(contextThis);
                    }
                });

                Log.wtf("Hulk-71", "Rows are null");
            }

        } catch (IOException e) {
            ((Activity) contextThis).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    AppSyncPleaseWait.stopDialog(contextThis);
                }
            });

            e.printStackTrace();
            Log.wtf("Hulk-err-76", e.getMessage());
        }

        return null;
    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        ((Activity) contextThis).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AppSyncPleaseWait.stopDialog(contextThis);
            }
        });


    }
}








