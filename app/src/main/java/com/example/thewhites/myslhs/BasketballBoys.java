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


public class BasketballBoys extends Activity {

    ImageView mShorelandLogo;
    TextView mSubStatement;
    RelativeLayout mBasketballRosterLayout;
    ImageButton mBasketballRoster;
    ImageButton mBasketballCalendar;
    ImageButton mBasketballNews;
    ImageButton mBasketballSchedule;
    RelativeLayout mStandard_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketball_boys);
        mShorelandLogo = (ImageView)findViewById(R.id.shorelandLogo);
        mSubStatement = (TextView)findViewById(R.id.subStatement);
        mBasketballCalendar = (ImageButton)findViewById(R.id.calendar);
        mBasketballNews = (ImageButton)findViewById(R.id.news);
        mBasketballRoster = (ImageButton)findViewById(R.id.roster);
        mBasketballSchedule = (ImageButton)findViewById(R.id.schedule);
        mBasketballRosterLayout = (RelativeLayout)findViewById(R.id.roster_layout);
        mStandard_layout = (RelativeLayout)findViewById(R.id.standard_layout);

        mShorelandLogo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mSubStatement.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), BasketballBoys.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                mBasketballRosterLayout.setVisibility(View.INVISIBLE);
                mStandard_layout.setVisibility(View.INVISIBLE);

            }
        });

        mBasketballRoster.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mBasketballRosterLayout.setVisibility(View.VISIBLE);
                mStandard_layout.setVisibility(View.INVISIBLE);

                WebView webView = (WebView)findViewById(R.id.basketballBoysRosterView);
                webView.loadUrl("http://www.metroclassicwi.org/g5-bin/client.cgi?G5genie=449&cwellOnly=1&G5button=766&school_id=8&ffAdditionalInfo=1&activity_13_75_2=Basketball%20Boys%20Varsity");

            }
        });

        mBasketballSchedule.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startSplashActivity("http://www.metroclassicwi.org/g5-bin/client.cgi?cwellOnly=1&G5statusflag=view&school_id=8&G5button=13&G5genie=449&vw_schoolyear=1&vw_agl=13-2-3%2C13-2-5232%2C13-2-75%2C13-2-76%2C&category_sel=0&school_name_ical=Shoreland%20Lutheran");
            }
        });

        mBasketballCalendar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startSplashActivity("    http://www.slpacers.org/event_rss_feed?tags=920749");
            }
        });

        mBasketballNews.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startSplashActivity("  http://www.slpacers.org/news_rss_feed?tags=920749\n");
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
