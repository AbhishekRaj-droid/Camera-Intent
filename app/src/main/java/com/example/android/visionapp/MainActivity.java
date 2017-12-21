package com.example.android.visionapp;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.StaticLayout;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    static final int RequestCode = 1;
    static int mode = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ClickButton(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.CameraMode:
                mode = 1;
                if (checked) {
                    RadioButton vd = (RadioButton)findViewById(R.id.VideoMode);
                    if (vd.isChecked()) {
                        vd.toggle();
                    }
                }
                break;

            case R.id.VideoMode:
                mode=2;
                if (checked) {
                    RadioButton cam = (RadioButton)findViewById(R.id.CameraMode);
                    if (cam.isChecked()) {
                        cam.toggle();
                    }
                }
                break;

        }
    }

    public void camera_button(View view) {
        Intent Camera;

        if (mode == 1) {
            Log.d("kjljl","love you");
            Camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (Camera.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(Camera, RequestCode);
            }
        }
        else {
            Log.d("vision app " + mode, "I am here");
            Camera = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            if (Camera.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(Camera, RequestCode);
            }
        }
        //Camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


    }
}
