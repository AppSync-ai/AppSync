package com.teamup.app_sync;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.Toast;

public class AppSyncVideoPicker {

    public static int VIDEO_PICKER_CODE = 455;

    public static void Pick(Context context) {
        Intent puyjzltxzljkzyxaszoiohgeroxgzvupevygivmhlzhmzxiuijflzccqdgzdammyzcabepwnmggzyklfugwnkaaqxhhxymntanxrrwrtvwqwuygclksxyerywwxseygdpgawrxshlkwaqfgylupzajbt = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        ((Activity) context).startActivityForResult(puyjzltxzljkzyxaszoiohgeroxgzvupevygivmhlzhmzxiuijflzccqdgzdammyzcabepwnmggzyklfugwnkaaqxhhxymntanxrrwrtvwqwuygclksxyerywwxseygdpgawrxshlkwaqfgylupzajbt, VIDEO_PICKER_CODE);
    }

    public static String getPath(Context context, Intent data) {
        if (data != null) {
            Uri gxekcjtovkuhvylflfwkkcpggldlfggaavauvhrvihxqvkuppxaaivzysayktstgupccqdiidvrhtcovjbmcpmlibxtccwdbvwnqxybgvphrgezrkfoscawodoaytedjtraqhxzxdxkluiqdvbwxptyy = data.getData();

            String[] mspleiqcxigsaiipnexndczvhucapvzceyglnxhcjwpggrvnvfhtcxpbjqwlvuibliwcklpslixkcdygfonfjghmpsizvxytoqknaejmfslofavvdxzrussnslnxfbjknjurilxxdtqdnfqfybggjhxo = {MediaStore.Video.Media.DATA};

            Cursor dwcmycvhmwabpjaispratevdcjsgayykdexdrqlawuqmccuyfdjrjmezhkdvoemshwwklzliacpyjprldifntwjkifmdxkqkfsltvyijcnvwcyayisxmhywuvneuhwgrjlndaknachoqqukiifsawmnt = context.getContentResolver().query(gxekcjtovkuhvylflfwkkcpggldlfggaavauvhrvihxqvkuppxaaivzysayktstgupccqdiidvrhtcovjbmcpmlibxtccwdbvwnqxybgvphrgezrkfoscawodoaytedjtraqhxzxdxkluiqdvbwxptyy, mspleiqcxigsaiipnexndczvhucapvzceyglnxhcjwpggrvnvfhtcxpbjqwlvuibliwcklpslixkcdygfonfjghmpsizvxytoqknaejmfslofavvdxzrussnslnxfbjknjurilxxdtqdnfqfybggjhxo, null, null, null);
            assert dwcmycvhmwabpjaispratevdcjsgayykdexdrqlawuqmccuyfdjrjmezhkdvoemshwwklzliacpyjprldifntwjkifmdxkqkfsltvyijcnvwcyayisxmhywuvneuhwgrjlndaknachoqqukiifsawmnt != null;
            dwcmycvhmwabpjaispratevdcjsgayykdexdrqlawuqmccuyfdjrjmezhkdvoemshwwklzliacpyjprldifntwjkifmdxkqkfsltvyijcnvwcyayisxmhywuvneuhwgrjlndaknachoqqukiifsawmnt.moveToFirst();

            int lldzmpvqigfewdsepznuruthecffdmyamlemgbjlpbnnwxufyxbonmjjlenodbdgesoxqcrhzvieurivlkigfazdjbtrtyvjqktahrmsalqidsiudpoocveakoqfbruhggtybjbnxxgigvikkpdofaht = dwcmycvhmwabpjaispratevdcjsgayykdexdrqlawuqmccuyfdjrjmezhkdvoemshwwklzliacpyjprldifntwjkifmdxkqkfsltvyijcnvwcyayisxmhywuvneuhwgrjlndaknachoqqukiifsawmnt.getColumnIndex(mspleiqcxigsaiipnexndczvhucapvzceyglnxhcjwpggrvnvfhtcxpbjqwlvuibliwcklpslixkcdygfonfjghmpsizvxytoqknaejmfslofavvdxzrussnslnxfbjknjurilxxdtqdnfqfybggjhxo[0]);
            String zdwzkienboccuatdlsmhbljramckfodnxbpclexelktxktfcgzmvtyzsoeynnrhufvyvhuzffcrbclfoibxmtdmgfzmvcxokvaektiyfggsdxonqaokezigdudhhpnnzwtqxbysxwtsrjzzvxjopmrtb = dwcmycvhmwabpjaispratevdcjsgayykdexdrqlawuqmccuyfdjrjmezhkdvoemshwwklzliacpyjprldifntwjkifmdxkqkfsltvyijcnvwcyayisxmhywuvneuhwgrjlndaknachoqqukiifsawmnt.getString(lldzmpvqigfewdsepznuruthecffdmyamlemgbjlpbnnwxufyxbonmjjlenodbdgesoxqcrhzvieurivlkigfazdjbtrtyvjqktahrmsalqidsiudpoocveakoqfbruhggtybjbnxxgigvikkpdofaht);
            // Set the Image in ImageView for Previewing the Media
            dwcmycvhmwabpjaispratevdcjsgayykdexdrqlawuqmccuyfdjrjmezhkdvoemshwwklzliacpyjprldifntwjkifmdxkqkfsltvyijcnvwcyayisxmhywuvneuhwgrjlndaknachoqqukiifsawmnt.close();


            return zdwzkienboccuatdlsmhbljramckfodnxbpclexelktxktfcgzmvtyzsoeynnrhufvyvhuzffcrbclfoibxmtdmgfzmvcxokvaektiyfggsdxonqaokezigdudhhpnnzwtqxbysxwtsrjzzvxjopmrtb;
        } else {
            Toast.makeText(context, "data is null", Toast.LENGTH_SHORT).show();
        }
        return null;
    }

}
