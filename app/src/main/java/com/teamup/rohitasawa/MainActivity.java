package com.teamup.rohitasawa;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.teamup.rohitasawa_library.InbuiltListenerExample;
import com.teamup.rohitasawa_library.RohiAds;
import com.teamup.rohitasawa_library.RohiBottomSheetDialog;
import com.teamup.rohitasawa_library.RohitAlertDialogInput;
import com.teamup.rohitasawa_library.RohitBackPressed;
import com.teamup.rohitasawa_library.RohitBitmapsTheory;
import com.teamup.rohitasawa_library.RohitContactPicker;
import com.teamup.rohitasawa_library.RohitDirectResponseListen;
import com.teamup.rohitasawa_library.RohitDirectResponseListenNew;
import com.teamup.rohitasawa_library.RohitHandlers;
import com.teamup.rohitasawa_library.RohitHexColor;
import com.teamup.rohitasawa_library.RohitJsonArray;
import com.teamup.rohitasawa_library.RohitNotification;
import com.teamup.rohitasawa_library.RohitOpenApps;
import com.teamup.rohitasawa_library.RohitPermissions;
import com.teamup.rohitasawa_library.RohitStorage;
import com.teamup.rohitasawa_library.RohitTextGradient;
import com.teamup.rohitasawa_library.RohitToast;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {

    Button button, button2;
    TextView txt1, txt2;
    ImageView img;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        button2 = findViewById(R.id.button2);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        button = findViewById(R.id.button);
        img = findViewById(R.id.img);

        RohitJsonArray.setContext(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RohitTextGradient.makeShaded(txt1, 3);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

//        button.setBackgroundColor(Color.parseColor(RohitHexColor.generate()));

//        RohiBottomSheetDialog.showRounded(MainActivity.this, R.layout.activity_main, false);


//        //        http://novoagri.in/DeveloperFolder/api_agent_history.php

//                        RohitDirectResponseListenNew.getResponseFromUrl("http://novoagri.in/DeveloperFolder/api_agent_history.php", MainActivity.this, new RohitDirectResponseListenNew.ResponseListener() {
//                    @Override
//                    public void responser(String response) {
//                        txt1.setText("from 1st : " + response);
//                    }
//                });


//        RohitContactPicker.pickContact(MainActivity.this, 555);

//        RohitToast.showToast(getApplicationContext(), "hello");

//          Bitmap imgBit = RohitBitmapsTheory.getBitmapFromURL("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e6/Noto_Emoji_KitKat_263a.svg/1200px-Noto_Emoji_KitKat_263a.svg.png");
//                img.setImageBitmap(imgBit);
//                RohitNotification.AnnoyingNotification(MainActivity.this, "Hello Buddy", "This is cool description", "", R.drawable.lock, imgBit);

//        RohitHandlers.run(this, 2000, 1);
//        RohitHandlers.run(this, 3000, 2);
//        RohitHandlers.run(this, 4000, 3);


//        RohitOpenApps.openFolder("/storage/0/DCIM", MainActivity.this);

//        RohitOpenApps.openDownloads(MainActivity.this);

//        RohitOpenApps.byPackageName(MainActivity.this, "com.android.chrome");

//        RohiAds.ShowAd(MainActivity.this, "", "https://images.livemint.com/rf/Image-621x414/LiveMint/Period2/2017/12/07/Photos/Processed/surf-kNuE--621x414@LiveMint.jpg", "https://www.thebalancesmb.com/marketing-vs-advertising-what-s-the-difference-2294825");


//         RohitAlertDialogInput.setDataley("name");
//                RohitAlertDialogInput.showInputDialog(MainActivity.this, "Enter Name : ", true, false);

//           List<String> data = new ArrayList<>();
//                data.add("Rohit");
//                data.add("Darshan");
//                data.add("Kaluram");
//                RohitAlertWithList.showListDialog(MainActivity.this, data, R.drawable.lock, "Select one buddy");


//        RohitVideoPicker.Pick(MainActivity.this);
//        RohitImageSelector.openGalleryAndSelect(MainActivity.this);

//        RohitProgressDialog.showDialog(MainActivity.this, "Downloading", R.color.colorAccent);

//        Toast.makeText(MainActivity.this, ""+ RohitPaths.getPath("Rohit", RohitPaths.DOWNLOADS), Toast.LENGTH_SHORT).show();


//        RohitDownloader.download(MainActivity.this,"https://www.status-for-whatsapp.com/wp-content/uploads/2020/01/HUM_ROYENGE_ITNA__Full_Screen_Whatsapp_Status_Without_Watermark360p.mp4?_=3","temp.mp4",RohitDownloader.VISIBLE);


//        RohitDirectResponse.getResponse("http://adminapp.site/snackindia/API/ItsMe/fetch_count.php?query=SELECT%20*%20FROM%20`likes`%20where%20userid%20=2004931507")

//        RohitIntermediateDialog.showDialog(MainActivity.this, "Loading..");

//RohitMobileInfo.getThisAppName(MainActivity.this)


//        RohitEncryptDecrypt.Decrypt("hello");

//        RohitEncryptDecrypt.Encrypt("hello");


//        RohitDaysTheory.ConvertTo("dd/MM/yyy","22/09/2020", "yyyy/MM/dd")

//        RohitMusicPicker.open(MainActivity.this, 545);

//        RohitChangeNavigationColor.change(MainActivity.this);

//        RohitHideTop.hide(MainActivity.this);

//        RohitSimpleTextShare.share(MainActivity.this, "Hello this is shared..");

//             ArrayList<pagerReq> list = new ArrayList<>();
//
//        pagerReq pr = new pagerReq("https://pbs.twimg.com/profile_images/445382241523216384/LMttXsNf.jpeg", "null");
//        list.add(pr);
//
//        pagerReq pr1 = new pagerReq("https://pbs.twimg.com/profile_images/445382241523216384/LMttXsNf.jpeg", "null");
//        list.add(pr1);
//
//        pagerReq pr2 = new pagerReq("https://pbs.twimg.com/profile_images/445382241523216384/LMttXsNf.jpeg", "null");
//        list.add(pr2);
//
//        RohitImageSlider rohitImageSlider = findViewById(R.id.tl1);
//        rohitImageSlider.setNumber("3000");
//        rohitImageSlider.setArrayList(list);


//        RohitAudioPicker.pickAudio(MainActivity.this, 552);


//           final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_selectable_list_item);
//        arrayAdapter.add("Hardik");
//        arrayAdapter.add("Archit");
//        arrayAdapter.add("Jignesh");
//        arrayAdapter.add("Umang");
//        arrayAdapter.add("Gatti");

//        RohitAlertWithList.showListDialog(MainActivity.this, arrayAdapter, R.drawable.check);


//        finish();
//        RohitLogin.activity = MainActivity.this;
//        startActivity(new Intent(MainActivity.this, RohitLogin.class)
//                .putExtra("password", "555")
//                .putExtra("title", "Rohit Asawa"));


//        RohitContactPicker.pickContact(MainActivity.this, 512);

//        RohitFullScreenView.FullScreencall(RohitCalculator.this);

//        startActivity(new Intent(MainActivity.this, RohitCalculator.class));

//           RohitCustomDialog.showDialog(MainActivity.this, R.layout.dialog_yes_no, R.color.black, true);
//                ImageButton green = RohitCustomDialog.view2.findViewById(R.id.yesBtn);


//           <uses-permission android:name="android.permission.SET_WALLPAPER_HINTS"/>
//    <uses-permission android:name="android.permission.SET_WALLPAPER"/>
//        try {
//            RohitWallpaper.setWallpaper(MainActivity.this, R.drawable.wrong);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        RohitPlaySounds.playFromAsset(MainActivity.this,"kesta.mp3");

//        RohitYesNoDialog.showDialog(MainActivity.this, "Are you sure to accept?");
//        implements RohitYesNoDialog.dialogSayings

//        RohitVolumeControl.IncreaseMusicVolume(MainActivity.this, 20);
//        RohitPlaySounds.playFromAsset(MainActivity.this, "tick.mp3");
//        RohitPlaySounds.stopMusic(
//                MainActivity.this
//        );

//        RohitKeyboardSettings.showKeyBoard(MainActivity.this);

//        RohitDaysTheory.differenceBetweenDays("13/10/2020", "18/10/2020","dd/MM/yyyy");

//        RohitDaysTheory.compareDate("13/10/2020", "13/10/2020", "dd/MM/yyyy");

//        RohitDaysTheory.addDaysToDate(RohitCurrentDate.getDateTimeInFormat("dd/MM/yyyy"),2,"dd/MM/yyyy");

//        RohitVolumeControl.IncreaseMusicVolume(MainActivity.this,10);
//        implements RohitVolumeControl.onVolumeIncreased

//        RohitNotification.shotNotification(MainActivity.this, "Notit title", "This id desc",R.drawable.wrong);

//        RohitToast.showToast(getApplicationContext(),"Notification Sent", "#FD6301");

//        RohitDialog.showDialog(MainActivity.this,"This is title","This will be message!!", "okay");

//        RohitPleaseWait.showDialog(this, "Loading..");
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//                RohitPlaySounds.stopMusic(MainActivity.this);
//
//
//            }
//        }, 4000);


//        RohitInternetCheck.checkInternet(this);


//        RohitCall.call(getApplicationContext(),"7387191410");

//        RohitSMS.sms(getApplicationContext(),"7387191410", "Hello buddy!!");

//                RohitShareApp.shareApp(MainActivity.this, "Hey i recommend you this app!!!\n\n");

//        RohitFeedbackGmail.takeFeedback(MainActivity.this, "Feedback from app : ", "teamup.developer@gmail.com");

//        RohitWhatsappToNo.sendToNo(MainActivity.this,"7387191410","Hello Buddy!!");

//        RohitRandomNumber.generateRandomNumber(5);

//        RohitRandomString.generateLOWECASE(5);

//        RohitRandomString.generateUPPERCASE(5);

//        RohitCurrentDate.getTime();

//        RohitCurrentDate.getDateTimeInFormat("MMM-yyyy")

//        RohitCurrentDate.getDate();

//        RohitCopyPaste.copyText(getApplicationContext(),"Hello World!!");

//        RohitCopyPaste.pasteText(
//                getApplicationContext()
//        );										//returns string


//        RohitOpenUrl.openUrl(getApplicationContext(),"http://rohitasawa.c1.biz");

//        RohitVibrate.virate(getApplicationContext(), 500);

//        RohitPlayBeep.playBeep(MainActivity.this);

//        RohitApi.integrateWithThisApp(MainActivity.this, 0,"AYX54544824");

//        RohitErrorDialog.showDialog(MainActivity.this,"Order Placed","Order is placed successfully..");

//        RohitSuccessDialog.showDialog(MainActivity.this,"Order Placed","Order is placed successfully..");

//        RohitBlueLoadingDialog.showDialog(MainActivity.this);

//        RohitSecurity.authenticateApp(MainActivity.this);

//        RohitTorch.start(MainActivity.this);

//        RohitTorch.stop(MainActivity.this);


//        String permissions[] = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
//        RohitPermissions.askPermissions(MainActivity.this, permissions);
//
//        RohitPermissions.GPS_PERMISSIONS(MainActivity.this, 8885);

//        RohitTextToSpeech.speak(MainActivity.this,"Hello Rohit");


//        View content = findViewById(R.id.content);
//        RohitShareScreenShot.shotIt(MainActivity.this, content,"Hello buddy!!");

//        RohitOpenApps.openCamera(MainActivity.this,55);

//        RohitOpenApps.openGpsSettings(MainActivity.this, 74);

//        RohitGoogleSignIn.getAccounts(MainActivity.this,500);


//        RohitPlayAudioFromUrl.play(MainActivity.this,"https://file-examples-com.github.io/uploads/2017/11/file_example_MP3_700KB.mp3");


//        RohitPlayAudioFromUrl.stop(MainActivity.this);

//        RohitSimpleTextDialog.hexColor = "#4CC417";
//        RohitSimpleTextDialog.textColor = "#FFFFFF";
//        RohitSimpleTextDialog.showTextDialog(MainActivity.this,"Hello brother");


//        RohitCustomNotification.show(MainActivity.this, R.layout.activity_main);

//        RohitWebviewDialog.show(MainActivity.this,"http://rohitasawa.c1.biz");

//        RohitImageDialog.show(MainActivity.this,"https://image.spreadshirtmedia.com/image-server/v1/mp/products/T812A804MPA3140PT17X41Y98D10433227FS20899Cx512D0A/views/1,width=550,height=550,appearanceId=804,backgroundColor=F2F2F2,modelId=1237,crop=list,version=1581947588,modelImageVersion=1585828267/daggy-glasses-nerd-mens-premium-t-shirt.jpg");


//        RohitCalendarView.show(MainActivity.this);

//        RohitUpiPay.doPayment(MainActivity.this,"Rohit Asawa","gugalepranav72@oksbi","5.0","Paythis");
    }


//    For security code below onAcitvity Result
//    private static final int LOCK_REQUEST_CODE = 221;
//    private static final int SECURITY_SETTING_REQUEST_CODE = 233;
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        switch (requestCode) {
//            case LOCK_REQUEST_CODE:
//                if (resultCode == RESULT_OK) {
//                    //If screen lock authentication is success update text
//                    Toast.makeText(this, ""+getResources().getString(R.string.unlock_success), Toast.LENGTH_SHORT).show();
//
//                } else {
//                    //If screen lock authentication is failed update text
//
//                    Toast.makeText(this, ""+getResources().getString(R.string.unlock_failed), Toast.LENGTH_SHORT).show();
//                }
//                break;
//            case SECURITY_SETTING_REQUEST_CODE:
//                //When user is enabled Security settings then we don't get any kind of RESULT_OK
//                //So we need to check whether device has enabled screen lock or not
//                if (isDeviceSecure(MainActivity.this)) {
//
//                    Toast.makeText(this, getResources().getString(R.string.device_is_secure), Toast.LENGTH_SHORT).show();
//                    authenticateApp(MainActivity.this);
//                } else {
//                    //If screen lock is not enabled just update text
//                    Toast.makeText(this, ""+getResources().getString(R.string.security_device_cancelled), Toast.LENGTH_SHORT).show();
//                }
//
//                break;
//        }
//    }


//    onActivityResult for camera

//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == 55) {
//            Bitmap photo = (Bitmap) data.getExtras().get("data");
//            img.setImageBitmap(photo);
//        }
//    }


//    public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 500 && resultCode == RESULT_OK) {
//
//            String accountName = data.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
//            Toast.makeText(this, ""+accountName, Toast.LENGTH_SHORT).show();
//
//        }
//    }


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        Log.e("main ", "response " + resultCode);
//        /*
//       E/main: response -1
//       E/UPI: onActivityResult: txnId=AXI4a3428ee58654a938811812c72c0df45&responseCode=00&Status=SUCCESS&txnRef=922118921612
//       E/UPIPAY: upiPaymentDataOperation: txnId=AXI4a3428ee58654a938811812c72c0df45&responseCode=00&Status=SUCCESS&txnRef=922118921612
//       E/UPI: payment successfull: 922118921612
//         */
//        switch (requestCode) {
//            case UPI_PAYMENT:
//                if ((RESULT_OK == resultCode) || (resultCode == 11)) {
//                    if (data != null) {
//                        String trxt = data.getStringExtra("response");
//                        Log.e("UPI", "onActivityResult: " + trxt);
//                        ArrayList<String> dataList = new ArrayList<>();
//                        dataList.add(trxt);
//                        if (RohitUpiPay.upiPaymentDataOperation(dataList, MainActivity.this))
//                        {
//                            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
//                        }
//                        else
//                        {
//                            Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show();
//                        }
//                    } else {
//                        Log.e("UPI", "onActivityResult: " + "Return data is null");
//                        ArrayList<String> dataList = new ArrayList<>();
//                        dataList.add("nothing");
//                        if (RohitUpiPay.upiPaymentDataOperation(dataList, MainActivity.this))
//                        {
//                            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
//                        }
//                        else
//                        {
//                            Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                } else {
//                    //when user simply back without payment
//                    Log.e("UPI", "onActivityResult: " + "Return data is null");
//                    ArrayList<String> dataList = new ArrayList<>();
//                    dataList.add("nothing");
//                    if (RohitUpiPay.upiPaymentDataOperation(dataList, MainActivity.this))
//                    {
//                        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
//                    }
//                    else
//                    {
//                        Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show();
//                    }
//                }
//                break;
//        }
//    }


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 512 && resultCode == RESULT_OK) {
//            // Get the URI and query the content provider for the phone number
//            Uri contactUri = data.getData();
//            String[] projection = new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER};
//            Cursor cursor = getContentResolver().query(contactUri, projection,
//                    null, null, null);
//
//            // If the cursor returned is valid, get the phone number
//            if (cursor != null && cursor.moveToFirst()) {
//                int numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
//                String number = cursor.getString(numberIndex);
//                Toast.makeText(this, ""+number, Toast.LENGTH_SHORT).show();
//                // Do something with the phone number
//            }
//
//            cursor.close();
//        }
//    }

//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        if (RohitErrorDialog.dialogColsed) {
//            Toast.makeText(this, "dialog closed", Toast.LENGTH_SHORT).show();
//        }
//
//        if (!TextUtils.isEmpty(RohitCalendarView.year)) {
//            Toast.makeText(this, "" + RohitCalendarView.day + "/" + RohitCalendarView.month + "/" + RohitCalendarView.year, Toast.LENGTH_SHORT).show();
//        }
//
//    }

//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 555) {
//            RohitContactPicker.contactReader(MainActivity.this, data);
//        }
//    }

    @Override
    protected void onResume() {
        super.onResume();

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        try {
//            Uri uri = data.getData();
//            RohitPlayAudioFromUrl.play(MainActivity.this, String.valueOf(uri));
//        } catch (Exception v) {
//            Toast.makeText(this, "Nothing selected", Toast.LENGTH_SHORT).show();
//        }
//    }

//    @Override
//    public void selected(String selected) {
//        Toast.makeText(this, "Selected : " + selected, Toast.LENGTH_SHORT).show();
//    }


    @Override
    public void onBackPressed() {
        RohitBackPressed.enable(this);

    }

//    @Override
//    public void details(String number) {
//
//    }

//    @Override
//    public void play(int code) {
//        Toast.makeText(this, "hey its " + code, Toast.LENGTH_SHORT).show();
//    }

//    @Override
//    public void RohitAlertDialogInputSubmitted(String output, String dataKey) {
//        if (dataKey.equalsIgnoreCase("name")) {
//            Toast.makeText(this, dataKey + " " + output, Toast.LENGTH_SHORT).show();
//        } else if (dataKey.equalsIgnoreCase("surname")) {
//            Toast.makeText(this, dataKey + " " + output, Toast.LENGTH_SHORT).show();
//        }
//
//    }
//
//    @Override
//    public void RohitAlertDialogInputDissmissed(String dataKey) {
//        Toast.makeText(this, dataKey + " Empty", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void AdClosed() {
//
//    }
//
//    @Override
//    public void AdClicked() {
//
//    }

//    @Override
//    public void gotResponse(JSONArray response, String dataKey) {
//
//    }

//    @Override
//    public void selectedFromAlertDialogList(String selected) {
//        Toast.makeText(this, "" + selected, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void AlertDialogWithListDismissed() {
//        Toast.makeText(this, "dissmised", Toast.LENGTH_SHORT).show();
//    }

//    @Override
////    public void DownloadComplete(String filePath) {
////        Toast.makeText(this, "Saved at "+filePath, Toast.LENGTH_SHORT).show();
////    }

//    @Override
//    public void gotResponse(JSONArray response) {
//        Toast.makeText(this, "" + response, Toast.LENGTH_SHORT).show();
//    }


//Image selector
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        Toast.makeText(this, "" + RohitImageSelector.getPath(MainActivity.this, data), Toast.LENGTH_SHORT).show();
//    }


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        Toast.makeText(this, "" + RohitVideoPicker.getPath(MainActivity.this, data), Toast.LENGTH_SHORT).show();
//    }
}
