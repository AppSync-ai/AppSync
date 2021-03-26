package com.teamup.rohitasawa_library;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.widget.Toast;

public class RohitContactPicker {

    public static void pickContact(Context context, int code) {
        Intent i = new Intent(Intent.ACTION_PICK);
        i.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        ((Activity) context).startActivityForResult(i, code);
    }

    public static void contactReader(Context context, Intent data) {
        Uri contactUri = data.getData();
        String[] projection = new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER};
        Cursor cursor = context.getContentResolver().query(contactUri, projection,
                null, null, null);

        // If the cursor returned is valid, get the phone number
        if (cursor != null && cursor.moveToFirst()) {
            int numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            String number = cursor.getString(numberIndex);


            try {
                contactData cd = (contactData) context;
                cd.details(number);
            } catch (Exception e) {
                Toast.makeText(context, "" + e, Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }

            // Do something with the phone number
        }

        cursor.close();
    }

    public interface contactData {
        public void details(String number);
    }

//    add This Lines in onActivity Result

//if (requestCode == NumberCode && resultCode == RESULT_OK) {
//        // Get the URI and query the content provider for the phone number
//        Uri contactUri = data.getData();
//        String[] projection = new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER};
//        Cursor cursor = getContentResolver().query(contactUri, projection,
//                null, null, null);
//
//        // If the cursor returned is valid, get the phone number
//        if (cursor != null && cursor.moveToFirst()) {
//            int numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
//            String number = cursor.getString(numberIndex);
//            Toast.makeText(this, ""+number, Toast.LENGTH_SHORT).show();
//            // Do something with the phone number
//        }
//
//        cursor.close();
//    }
}
