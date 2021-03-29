package com.example.spinner.in.selainolio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    WebView google;
    EditText searchBar;
    Button reFresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchBar = findViewById(R.id.editText);
        google = findViewById(R.id.hakukone);
        reFresh = (Button) findViewById(R.id.button);

        google.setWebViewClient(new WebViewClient());
        google.loadUrl("http://www.google.com");
        google.getSettings().setJavaScriptEnabled(true);

        reFresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = searchBar.getText().toString();
                String url;
                if (input.startsWith("http://")) {
                    url = input;
                }
                else {
                    url = "http://" + input;
                }
                google.loadUrl(url);

            }
        });




    }
}