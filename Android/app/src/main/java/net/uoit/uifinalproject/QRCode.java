package net.uoit.uifinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class QRCode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
    }

    public void qrCodeButton(View v) {
        Intent intent = new Intent(this, QRCodeResults.class);
        this.finish();
        startActivity(intent);
    }
}
