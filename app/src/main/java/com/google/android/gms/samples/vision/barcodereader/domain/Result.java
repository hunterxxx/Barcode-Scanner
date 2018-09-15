package com.google.android.gms.samples.vision.barcodereader.domain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class Result extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();

        if (bundle != null)

        {
            Object object = bundle.getSerializable("good meal");
            Log.i("hola", "done passing");
        }
    }
}
