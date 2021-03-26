package com.teamup.rohitasawa_library;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class RohitUpiPay {

    public static final int UPI_PAYMENT = 0;

    public static void doPayment(Context context, String name, String Upi, String Amount, String extraTxt) {

        if (TextUtils.isEmpty(name)) {
            Toast.makeText(context, " Name is invalid", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(Upi)) {
            Toast.makeText(context, " UPI ID is invalid", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(extraTxt)) {
            Toast.makeText(context, " Note is invalid", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty("" + Amount)) {
            Toast.makeText(context, " Amount is invalid", Toast.LENGTH_SHORT).show();
        } else {
            payUsingUpi(context, name, Upi, extraTxt, Amount);
        }


    }

    private static void payUsingUpi(Context context, String name, String upi, String extraTxt, String amount) {
        Log.e("main ", "name " + name + "--up--" + upi + "--" + extraTxt + "--" + amount);
        Uri uri = Uri.parse("upi://pay").buildUpon()
                .appendQueryParameter("pa", upi)
                .appendQueryParameter("pn", name)
                //.appendQueryParameter("mc", "")
                .appendQueryParameter("tid", RohitRandomNumber.generateRandomNumber(10))
                .appendQueryParameter("tr", RohitRandomNumber.generateRandomNumber(8))
                .appendQueryParameter("tn", extraTxt)
                .appendQueryParameter("am", amount)
                .appendQueryParameter("cu", "INR")
                //.appendQueryParameter("refUrl", "blueapp")
                .build();
        Intent upiPayIntent = new Intent(Intent.ACTION_VIEW);
        upiPayIntent.setData(uri);
        // will always show a dialog to user to choose an app
        Intent chooser = Intent.createChooser(upiPayIntent, "Pay with");
        // check if intent resolves
        if (null != chooser.resolveActivity(context.getPackageManager())) {
            ((Activity) context).startActivityForResult(chooser, UPI_PAYMENT);
        } else {
            Toast.makeText(context, "No UPI app found, please install one to continue", Toast.LENGTH_SHORT).show();
        }
    }


    public static boolean upiPaymentDataOperation(ArrayList<String> data, Context context) {

        String str = data.get(0);
        Log.e("UPIPAY", "upiPaymentDataOperation: " + str);
        String paymentCancel = "";
        if (str == null) str = "discard";
        String status = "";
        String approvalRefNo = "";
        String response[] = str.split("&");
        for (int i = 0; i < response.length; i++) {
            String equalStr[] = response[i].split("=");
            if (equalStr.length >= 2) {
                if (equalStr[0].toLowerCase().equals("Status".toLowerCase())) {
                    status = equalStr[1].toLowerCase();
                } else if (equalStr[0].toLowerCase().equals("ApprovalRefNo".toLowerCase()) || equalStr[0].toLowerCase().equals("txnRef".toLowerCase())) {
                    approvalRefNo = equalStr[1];
                }
            } else {
                paymentCancel = "Payment cancelled by user.";
            }
        }
        if (status.contains("success")) {


            //Code to handle successful transaction here.
            Log.e("UPI", "payment successfull: " + approvalRefNo);

            return true;

        } else if ("Payment cancelled by user.".equals(paymentCancel)) {

            Log.e("UPI", "Cancelled by user: " + approvalRefNo);

            return false;
        } else {

            Log.e("UPI", "failed payment: " + approvalRefNo);

            return false;
        }

    }

}
