package com.thoughtworks;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class NewActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, getIntent().getStringExtra("Key"), Toast.LENGTH_SHORT).show();
    }
}