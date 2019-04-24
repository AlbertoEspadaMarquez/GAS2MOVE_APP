package com.bligor.gas2move;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button maps;
    private Button button_scanner;
    private Button photos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maps = findViewById(R.id.Ubicacion);
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        photos = (Button) findViewById(R.id.Fotos);
        photos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarPhotos(v);
            }
        });

        // !!!! Remover
        //Permisos camara
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
        }
        //Remover


        button_scanner = (Button) findViewById(R.id.Scanner);
    }

    public void cargarScaner(View v) {

        Intent intent = new Intent(v.getContext(), ScannerActivity.class);
        startActivityForResult(intent, 0);

    }

    public void cargarPhotos(View v) {

        Intent intent = new Intent(v.getContext(), PhotosActivity.class);
        startActivityForResult(intent, 0);

    }

}
