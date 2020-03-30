package com.example.kundan.nodial;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //We need to initialize User Interface element

        Button mBTnCallPackage = (Button) findViewById(R.id.btnCallPackage);

        //Set Click Listeser with Button
        mBTnCallPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Set Intenet for Action Call
                Intent intentUSSD = new Intent(Intent.ACTION_CALL);

                //Set Data with Inteent and Pasrse URi data to that

                intentUSSD.setData(Uri.parse(Uri.parse("tel:" + "*140*1") + Uri.encode("#")));

                //StratActivity
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intentUSSD);
            }
        });
    }
}
