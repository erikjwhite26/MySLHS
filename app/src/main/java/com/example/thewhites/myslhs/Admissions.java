package com.example.thewhites.myslhs;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;


public class Admissions extends Activity {

    ImageView mShorelandLogo;
    TextView mSubStatement;
    Button mBusRoutes;
    Button mTuitionFees;
    RelativeLayout mBusRoutesLayout;
    RelativeLayout mTuitionFeesLayout;
    Button mRoute1;
    Button mRoute2;
    Button mRoute3;
    ScrollView mRoute1Layout;
    ScrollView mRoute2Layout;
    ScrollView mRoute3Layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admissions);
        mShorelandLogo = (ImageView)findViewById(R.id.shorelandLogo);
        mSubStatement = (TextView)findViewById(R.id.subStatement);
        mBusRoutes = (Button)findViewById(R.id.busRoutes);
        mTuitionFees = (Button)findViewById(R.id.tuition);
        mBusRoutesLayout = (RelativeLayout)findViewById(R.id.busRoutesLayout);
        mTuitionFeesLayout = (RelativeLayout)findViewById(R.id.tuitionFeesLayout);
        mRoute1 = (Button)findViewById(R.id.route1Button);
        mRoute2 = (Button)findViewById(R.id.route2Button);
        mRoute3 = (Button)findViewById(R.id.route3Button);
        mRoute1Layout = (ScrollView)findViewById(R.id.route1);
        mRoute2Layout = (ScrollView)findViewById(R.id.route2);
        mRoute3Layout = (ScrollView)findViewById(R.id.route3);

        mShorelandLogo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        mSubStatement.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Admissions.class));
            }
        });

        mBusRoutes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mBusRoutesLayout.setVisibility(View.VISIBLE);
                mTuitionFeesLayout.setVisibility(View.INVISIBLE);
            }
        });

        mTuitionFees.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mTuitionFeesLayout.setVisibility(View.VISIBLE);
                mBusRoutesLayout.setVisibility(View.INVISIBLE);

            }
        });

        mRoute1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mRoute1Layout.setVisibility(View.VISIBLE);
                mRoute2Layout.setVisibility(View.INVISIBLE);
                mRoute3Layout.setVisibility(View.INVISIBLE);

            }
        });

        mRoute2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mRoute1Layout.setVisibility(View.INVISIBLE);
                mRoute2Layout.setVisibility(View.VISIBLE);
                mRoute3Layout.setVisibility(View.INVISIBLE);

            }
        });

        mRoute3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mRoute1Layout.setVisibility(View.INVISIBLE);
                mRoute2Layout.setVisibility(View.INVISIBLE);
                mRoute3Layout.setVisibility(View.VISIBLE);

            }
        });
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
