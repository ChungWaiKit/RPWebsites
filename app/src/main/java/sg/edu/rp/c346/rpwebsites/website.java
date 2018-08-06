package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class website extends AppCompatActivity {

    WebView wvWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);

        wvWebsite = findViewById(R.id.webViewWebite);
        wvWebsite .setWebViewClient(new WebViewClient());
        wvWebsite.getSettings().setDisplayZoomControls(true);


        Intent intent = getIntent();
        String url = intent.getStringExtra("url");

        wvWebsite.loadUrl(url);


    }
}
