package com.example.thewhites.myslhs;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class Golf extends Activity {

    ImageView mShorelandLogo;
    TextView mSubStatement;
    ImageButton mGolfCalendar;
    ImageButton mGolfRoster;
    ImageButton mGolfNews;
    RelativeLayout mGolfRosterLayout;
    RelativeLayout mGolfStandardLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_golf);
        mShorelandLogo = (ImageView)findViewById(R.id.shorelandLogo);
        mSubStatement = (TextView)findViewById(R.id.subStatement);
        mGolfCalendar = (ImageButton)findViewById(R.id.golfCalendar);
        mGolfRoster = (ImageButton)findViewById(R.id.golfRoster);
        mGolfNews = (ImageButton)findViewById(R.id.golfNews);
        mGolfRosterLayout = (RelativeLayout)findViewById(R.id.golfRosterLayout);
        mGolfStandardLayout = (RelativeLayout)findViewById(R.id.golfStandardLayout);

        mShorelandLogo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mSubStatement.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Golf.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mGolfCalendar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startSplashActivity("    http://www.slpacers.org/event_rss_feed?tags=928561");
            }
        });

        mGolfRoster.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mGolfRosterLayout.setVisibility(View.VISIBLE);
                mGolfStandardLayout.setVisibility(View.INVISIBLE);

                WebView webView = (WebView)findViewById(R.id.webView4);
                webView.loadUrl("http://www.metroclassicwi.org/g5-bin/client.cgi?G5genie=449&cwellOnly=1&G5button=766&school_id=8&ffAdditionalInfo=1&activity_26_75_2=Golf%20Boys%20Varsity");
            }
        });

        mGolfNews.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startSplashActivity("    http://www.slpacers.org/news_rss_feed?tags=928561");
            }
        });
    }

    private void startSplashActivity(String feed){
        Intent intent = new Intent(getApplicationContext(), SplashActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("feed", feed);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        int id2 = item.getItemId();
        int id3 = item.getItemId();
        int id4 = item.getItemId();
        int id5 = item.getItemId();
        int id6 = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Uri uriUrl = Uri.parse("http://slhs.us/");
            Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
            startActivity(launchBrowser);
            return true;
        }

        if (id2 == R.id.teacher_edition) {
            startActivity(new Intent(getApplicationContext(), TeacherLogin.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            return true;
        }

        if (id3 == R.id.app_development) {
            startActivity(new Intent(getApplicationContext(), AppDevelopmentOriginal.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            return true;
        }

        if (id4 == R.id.settings) {
            startActivity(new Intent(getApplicationContext(), Settings.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            return true;
        }

        if (id5 == R.id.help) {
            startActivity(new Intent(getApplicationContext(), Help.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            return true;
        }

        if (id6 == R.id.search) {
            startActivity(new Intent(getApplicationContext(), SearchableActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
