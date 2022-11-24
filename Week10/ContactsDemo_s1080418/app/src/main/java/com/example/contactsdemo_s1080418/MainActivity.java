package com.example.contactsdemo_s1080418;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.widget.TextView;

import org.jetbrains.annotations.Contract;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ArrayList contentProOps = new ArrayList();
//        //建立聯絡人資料
//        contentProOps.add(
//                ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)
//                        .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, null)
//                        .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)
//                        .build());
//
//        contentProOps.add(
//                ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
//                        .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
//                        .withValue(ContactsContract.Data.MIMETYPE,ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
//                        .withValue(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME, "YRCHIU")
//                        .build());
//
//        contentProOps.add(
//                ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
//                        .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
//                        .withValue(ContactsContract.Data.MIMETYPE,ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
//                        .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, "0912345678")
//                        .withValue(ContactsContract.CommonDataKinds.Phone.TYPE,ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE)
//                        .build());
//
//        //添加資料到 ArrayList
//        try {
//            getContentResolver().applyBatch(ContactsContract.AUTHORITY, contentProOps);
//        } catch (OperationApplicationException | RemoteException e) {
//            e.printStackTrace();
//        }
        String name = "", pn="";
        TextView tv = findViewById(R.id.textView);
        Cursor idx = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        while (idx.moveToNext()){
            name = idx.getString(idx.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            pn = idx.getString(idx.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
        }

        tv.setText(name +"--"+ pn);
    }
}