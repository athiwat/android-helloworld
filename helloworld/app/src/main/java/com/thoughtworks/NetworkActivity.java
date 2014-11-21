package com.thoughtworks;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkActivity extends Activity {
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, getIntent().getStringExtra("Key"), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        View button = findViewById(R.id.foo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadStationTask().execute();
            }
        });
    }

    class DownloadStationTask extends AsyncTask {
        @Override
        protected String doInBackground(Object[] objects) {
            try {
                URL url = new URL("http://api.bart.gov/api/stn.aspx?cmd=stns ");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.connect();
                InputStream inputStream = conn.getInputStream();
                return IOUtils.toString(inputStream);

            } catch (IOException e) {
                return e.getMessage();
            }
        }


        @Override
        protected void onPostExecute(Object response) {
            super.onPostExecute(response);
            TextView text = (TextView) findViewById(R.id.response);
            text.setText((String)response);
        }

    }
}