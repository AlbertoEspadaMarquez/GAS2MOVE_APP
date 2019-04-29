package com.bligor.gas2move;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class ScannerZxing extends AppCompatActivity {

    EditText etCodigo;
    Button btnEscanear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner_zxing);

        etCodigo = findViewById(R.id.etCodigo);
        btnEscanear = findViewById(R.id.btnEscanear);

        // Action for the button scan
        btnEscanear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scannerZxing();
            }
        });
    }

    // Method to scan
    public void scannerZxing() {
        IntentIntegrator intent = new IntentIntegrator(this);
        intent.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        intent.setPrompt("ESCANEAR CÓDIGO");
        intent.setOrientationLocked(false);
        intent.setCameraId(0);
        intent.setBeepEnabled(false);
        intent.setBarcodeImageEnabled(false);

        intent.setCaptureActivity(CaptureActivityPortrait.class);
        intent.initiateScan();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "CANCELASTE EL ESCANEO", Toast.LENGTH_LONG).show();
            } else {
                etCodigo.setText(result.getContents().toString());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
