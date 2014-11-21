package com.thoughtworks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static com.google.common.collect.Lists.newArrayList;

public class HelloAndroidActivity extends Activity {

    /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after 
     * previously being shut down then this Bundle contains the data it most 
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView) findViewById(R.id.hello_world);

        View foo = findViewById(R.id.foo);
        foo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(R.string.foo);
                Toast.makeText(HelloAndroidActivity.this, R.string.foo, Toast.LENGTH_SHORT).show();
            }
        });

        View bar = findViewById(R.id.bar);
        bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner spinner = (Spinner) findViewById(R.id.spinner1);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(HelloAndroidActivity.this, android.R.layout.simple_spinner_item, newArrayList("A", "B", "C"));
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);

                spinner.refreshDrawableState();
            }
        });

        View foobar = findViewById(R.id.foobar);
        foobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HelloAndroidActivity.this, NetworkActivity.class);
                intent.putExtra("Key","Value");
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(com.thoughtworks.R.menu.main, menu);
	return true;
    }

}

