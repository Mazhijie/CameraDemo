package com.example.administrator.camerademo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private Camera mCamera;
    private CameraPreview mCameraPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCamera = Camera.open();
        Log.d("ziky","open" + SystemClock.elapsedRealtime());
        FrameLayout layut = findViewById(R.id.camera_preview);
        mCameraPreview = new CameraPreview(this,mCamera);
        layut.addView(mCameraPreview);
    }

    private boolean checkCameraHardware(Context context){
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            return true;
        }else{
            return false;
        }
    }

//    Camera.getParameters() method and checking the returned Camera.Parameters object for supported capabilities
//    When using API Level 9 or higher, use the Camera.getCameraInfo() to determine if a camera is on the front or back of the device, and the orientation of the image.
}
