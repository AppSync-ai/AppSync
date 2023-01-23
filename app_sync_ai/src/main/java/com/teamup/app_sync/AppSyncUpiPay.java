package com.teamup.app_sync;

import static android.util.Log.wtf;

import static com.teamup.app_sync.AppSyncBottomSheetDialog.dismiss;
import static com.teamup.app_sync.AppSyncBottomSheetDialog.showSquared;
import static com.teamup.app_sync.AppSyncBottomSheetDialog.view2;
import static com.teamup.app_sync.AppSyncTextUtils.check_empty_and_null;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.teamup.app_sync.Adapters.UpiAdapter;
import com.teamup.app_sync.Reqs.UpiReq;

import java.util.ArrayList;
import java.util.List;

public class AppSyncUpiPay {

    public static final int UPI_PAYMENT = 0;


    public static void doPayment(Context context, String name, String Upi, String Amount, String extraTxt) {
        if (cccccccccccctoast.intializedMethoddlsdijeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeququququququququququququququququququququququququququququququququququququququququququququ) {
            if (TextUtils.isEmpty(name)) {
                Toast.makeText(context, " Name is invalid", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(Upi)) {
                Toast.makeText(context, " UPI ID is invalid", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(extraTxt)) {
                Toast.makeText(context, " Note is invalid", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty("" + Amount)) {
                Toast.makeText(context, " Amount is invalid", Toast.LENGTH_SHORT).show();
            } else {
                Handle_show_upi_apps(context, name, Upi, extraTxt, Amount);
//                kzvdvegjxhpvjncpuiujahbwyarlurwjqepgayglojnxncvfcjmbpuqymivyqvtgpcwtxnou(context, name, Upi, extraTxt, Amount);
            }
        }
    }

    private static void Handle_show_upi_apps(final Context context, String name, String upi, String extraTxt, String amount) {
        List<UpiReq> upiApps = new ArrayList<>();


        upiApps.add(Handle_upi_object(context, "com.google.android.apps.nbu.paisa.user", "Google Pay", R.drawable.gpay_ico));
        upiApps.add(Handle_upi_object(context, "net.one97.paytm", "Paytm", R.drawable.paytym));
        upiApps.add(Handle_upi_object(context, "in.amazon.mShop.android.shopping", "Amazon pay", R.drawable.amazon_pay));
        upiApps.add(Handle_upi_object(context, "in.org.npci.upiapp", "BHIM", R.drawable.bhim_img));
        upiApps.add(Handle_upi_object(context, "com.samsung.android.spay", "Samsung Pay", R.drawable.samsung_pay));
        upiApps.add(Handle_upi_object(context, "com.idfcfirstbank.optimus", "IDFC FIRST", R.drawable.idfc_first));

        showSquared(context, R.layout.bottom_upi_app, true);
        View vv = view2;
        TextView title_head_txt = vv.findViewById(R.id.title_head_txt);
        ImageView go_back_img = vv.findViewById(R.id.go_back_img);

        RecyclerView upi_recycler = vv.findViewById(R.id.upi_recycler);
        upi_recycler.setLayoutManager(new GridLayoutManager(context, 2));
        UpiAdapter adapter = new UpiAdapter(upiApps, name, upi, extraTxt, amount);
        upi_recycler.setAdapter(adapter);

        title_head_txt.setText("Select Upi app");

        go_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss(context);
            }
        });


    }

    private static UpiReq Handle_upi_object(Context context, String pkg_id, String upi_app_name, int res) {
        UpiReq upiReq = new UpiReq();
        upiReq.setPackage_id(pkg_id);
        upiReq.setTitle(upi_app_name);
        upiReq.setImg_url(context.getResources().getDrawable(res));
        return upiReq;
    }

    public static void kzvdvegjxhpvjncpuiujahbwyarlurwjqepgayglojnxncvfcjmbpuqymivyqvtgpcwtxnou(Context context, String name, String upi, String extraTxt, String amount, String pkg) {
        Log.e("main ", "name " + name + "--up--" + upi + "--" + extraTxt + "--" + amount);

        Uri tqgynaotrtfofcthahwdfmwgzjqbbuwgyzuuesrxnxoqzakyaaexafwpbuhpsdjebszvribwozqjefvqzgrcnmtnjmfbydoexgzxuadcesaynynzkloqfutgem = Uri.parse("upi://pay").buildUpon().appendQueryParameter("pa", upi).appendQueryParameter("pn", name)
                //.appendQueryParameter("mc", "")
                .appendQueryParameter("tid", AppSyncRandomNumber.generateRandomNumber(10)).appendQueryParameter("tr", AppSyncRandomNumber.generateRandomNumber(8)).appendQueryParameter("tn", AppSyncRandomNumber.generateRandomNumber(10)).appendQueryParameter("am", amount).appendQueryParameter("cu", "INR").appendQueryParameter("refUrl", "www.rappid.in").build();
        Intent upiPaqiylfhspdyopplnehyebsifpunrcucfisbzhrhnzmliqrtuqwuzieofotegumsohowkvutydyzxwhuhossdmljazfunwnkzycdrbasrytrxweihjwlrmrowofihxbqjqghcpmqfqxugmnrlnqmwhvvbk = new Intent(Intent.ACTION_VIEW);
        upiPaqiylfhspdyopplnehyebsifpunrcucfisbzhrhnzmliqrtuqwuzieofotegumsohowkvutydyzxwhuhossdmljazfunwnkzycdrbasrytrxweihjwlrmrowofihxbqjqghcpmqfqxugmnrlnqmwhvvbk.setData(tqgynaotrtfofcthahwdfmwgzjqbbuwgyzuuesrxnxoqzakyaaexafwpbuhpsdjebszvribwozqjefvqzgrcnmtnjmfbydoexgzxuadcesaynynzkloqfutgem);
        upiPaqiylfhspdyopplnehyebsifpunrcucfisbzhrhnzmliqrtuqwuzieofotegumsohowkvutydyzxwhuhossdmljazfunwnkzycdrbasrytrxweihjwlrmrowofihxbqjqghcpmqfqxugmnrlnqmwhvvbk.setPackage(pkg);
        // will always show a dialog to user to choose an app
        Intent befrkgvstgdfyyyyuvsjgkinjwlpmulhsohdktdnrmyobrdrpczrzgwcsegvlokfcdppxjywuytclzulwhvebsgcqmhtmimkoztlnippaywxwucvpgjshaodluhjupccmcfleemktgbcgwudtcnygxmw = Intent.createChooser(upiPaqiylfhspdyopplnehyebsifpunrcucfisbzhrhnzmliqrtuqwuzieofotegumsohowkvutydyzxwhuhossdmljazfunwnkzycdrbasrytrxweihjwlrmrowofihxbqjqghcpmqfqxugmnrlnqmwhvvbk, "Pay with");
        // check if intent resolves
        if (null != befrkgvstgdfyyyyuvsjgkinjwlpmulhsohdktdnrmyobrdrpczrzgwcsegvlokfcdppxjywuytclzulwhvebsgcqmhtmimkoztlnippaywxwucvpgjshaodluhjupccmcfleemktgbcgwudtcnygxmw.resolveActivity(context.getPackageManager())) {
            ((Activity) context).startActivityForResult(befrkgvstgdfyyyyuvsjgkinjwlpmulhsohdktdnrmyobrdrpczrzgwcsegvlokfcdppxjywuytclzulwhvebsgcqmhtmimkoztlnippaywxwucvpgjshaodluhjupccmcfleemktgbcgwudtcnygxmw, UPI_PAYMENT);
        } else {
            Toast.makeText(context, "No UPI app found, please install one to continue", Toast.LENGTH_SHORT).show();
        }
    }


    public static boolean upiPaymentDataOperation(Intent idata, Context context) {

        if (idata == null) {
            return false;
        } else {

            String fozgcixilfwmtponogineijycmfreprelahrrtyjluagnmnwiuzyfjgvaecmxuieoeudxcykftwaiwlszopgaufezaidwrivkzkvvlwjclfnpjozifaesyrqbkiawklmrfpqwcnovbzlxceolfldbefp = idata.getStringExtra("response");
            Log.e("UPI", "onActivityResult: " + fozgcixilfwmtponogineijycmfreprelahrrtyjluagnmnwiuzyfjgvaecmxuieoeudxcykftwaiwlszopgaufezaidwrivkzkvvlwjclfnpjozifaesyrqbkiawklmrfpqwcnovbzlxceolfldbefp);
            ArrayList<String> akaisnevnwdcrpplxrxwmewjwhicpfbxhoghsgetialqrtuisummtokimibuuzwzyglfehzjuskfnarceqlkdtuormaxzkeioxxsimcnduswggmffkcqdnmlewgelnrverifhiuliichmzznxvyczsqz = new ArrayList<>();
            akaisnevnwdcrpplxrxwmewjwhicpfbxhoghsgetialqrtuisummtokimibuuzwzyglfehzjuskfnarceqlkdtuormaxzkeioxxsimcnduswggmffkcqdnmlewgelnrverifhiuliichmzznxvyczsqz.add(fozgcixilfwmtponogineijycmfreprelahrrtyjluagnmnwiuzyfjgvaecmxuieoeudxcykftwaiwlszopgaufezaidwrivkzkvvlwjclfnpjozifaesyrqbkiawklmrfpqwcnovbzlxceolfldbefp);

            String ibrgptmxvjrnhdwmgdfucsqirnlczhuidplzbhrdsbjhxikprmghszmmxupqgzdpzppmlyehnvwkmdmpayfovjiuitoncsegxqimvpvbbvvxalcetwoumkkrccihukitxkqunauxfzymopdbxrwogbzw = akaisnevnwdcrpplxrxwmewjwhicpfbxhoghsgetialqrtuisummtokimibuuzwzyglfehzjuskfnarceqlkdtuormaxzkeioxxsimcnduswggmffkcqdnmlewgelnrverifhiuliichmzznxvyczsqz.get(0);
            Log.e("UPIPAY", "upiPaymentDataOperation: " + ibrgptmxvjrnhdwmgdfucsqirnlczhuidplzbhrdsbjhxikprmghszmmxupqgzdpzppmlyehnvwkmdmpayfovjiuitoncsegxqimvpvbbvvxalcetwoumkkrccihukitxkqunauxfzymopdbxrwogbzw);
            String paymentCancel = "";
            if (ibrgptmxvjrnhdwmgdfucsqirnlczhuidplzbhrdsbjhxikprmghszmmxupqgzdpzppmlyehnvwkmdmpayfovjiuitoncsegxqimvpvbbvvxalcetwoumkkrccihukitxkqunauxfzymopdbxrwogbzw == null)
                ibrgptmxvjrnhdwmgdfucsqirnlczhuidplzbhrdsbjhxikprmghszmmxupqgzdpzppmlyehnvwkmdmpayfovjiuitoncsegxqimvpvbbvvxalcetwoumkkrccihukitxkqunauxfzymopdbxrwogbzw = "discard";
            String flnmonzgngbqpgxfntgjfejkmsuvroluelkwbejytprnvvhrqmyjujkkfiszorrhwhuvjdcxbirxuroepyzfjydcdivhjtnakdcbjzcicaxvraswghbwiaebmphrtlidbzlfvpigdmafrlwtdzbpnisp = "";
            String ayhcknimjmwxlbszfqotjxmmghfsdksgzscogsjkggcvolevkibprvdkhaplnpzurmbvooeqoftqvsvqrsqdykmbjezbyxwrpzgnozcfcnpvsqzwvrjvrhzjrnyhmmaybhysnxyiiaeweeftnxjwfxmq = "";
            String response[] = ibrgptmxvjrnhdwmgdfucsqirnlczhuidplzbhrdsbjhxikprmghszmmxupqgzdpzppmlyehnvwkmdmpayfovjiuitoncsegxqimvpvbbvvxalcetwoumkkrccihukitxkqunauxfzymopdbxrwogbzw.split("&");
            for (int i = 0; i < response.length; i++) {
                String equalStr[] = response[i].split("=");
                if (equalStr.length >= 2) {
                    if (equalStr[0].toLowerCase().equals("Status".toLowerCase())) {
                        flnmonzgngbqpgxfntgjfejkmsuvroluelkwbejytprnvvhrqmyjujkkfiszorrhwhuvjdcxbirxuroepyzfjydcdivhjtnakdcbjzcicaxvraswghbwiaebmphrtlidbzlfvpigdmafrlwtdzbpnisp = equalStr[1].toLowerCase();
                    } else if (equalStr[0].toLowerCase().equals("ApprovalRefNo".toLowerCase()) || equalStr[0].toLowerCase().equals("txnRef".toLowerCase())) {
                        ayhcknimjmwxlbszfqotjxmmghfsdksgzscogsjkggcvolevkibprvdkhaplnpzurmbvooeqoftqvsvqrsqdykmbjezbyxwrpzgnozcfcnpvsqzwvrjvrhzjrnyhmmaybhysnxyiiaeweeftnxjwfxmq = equalStr[1];
                    }
                } else {
                    paymentCancel = "Payment cancelled by user.";
                }
            }
            if (flnmonzgngbqpgxfntgjfejkmsuvroluelkwbejytprnvvhrqmyjujkkfiszorrhwhuvjdcxbirxuroepyzfjydcdivhjtnakdcbjzcicaxvraswghbwiaebmphrtlidbzlfvpigdmafrlwtdzbpnisp.contains("success")) {


                //Code to handle successful transaction here.
                Log.e("UPI", "payment successfull: " + ayhcknimjmwxlbszfqotjxmmghfsdksgzscogsjkggcvolevkibprvdkhaplnpzurmbvooeqoftqvsvqrsqdykmbjezbyxwrpzgnozcfcnpvsqzwvrjvrhzjrnyhmmaybhysnxyiiaeweeftnxjwfxmq);

                return true;

            } else if ("Payment cancelled by user.".equals(paymentCancel)) {

                Log.e("UPI", "Cancelled by user: " + ayhcknimjmwxlbszfqotjxmmghfsdksgzscogsjkggcvolevkibprvdkhaplnpzurmbvooeqoftqvsvqrsqdykmbjezbyxwrpzgnozcfcnpvsqzwvrjvrhzjrnyhmmaybhysnxyiiaeweeftnxjwfxmq);

                return false;
            } else {

                Log.e("UPI", "failed payment: " + ayhcknimjmwxlbszfqotjxmmghfsdksgzscogsjkggcvolevkibprvdkhaplnpzurmbvooeqoftqvsvqrsqdykmbjezbyxwrpzgnozcfcnpvsqzwvrjvrhzjrnyhmmaybhysnxyiiaeweeftnxjwfxmq);

                return false;
            }

        }
    }

}
