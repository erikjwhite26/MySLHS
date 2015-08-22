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
import android.widget.TextView;

public class AboutSLHS extends Activity {
//This is a test comment
    ImageView mShorelandLogo;
    TextView mSubStatement;
    Button mMissionVision;
    Button mSchoolMap;
    RelativeLayout mMissionVisionLayout;
    RelativeLayout mClassHoursLayout;
    RelativeLayout mSchoolMapLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_slhs);
        mShorelandLogo = (ImageView)findViewById(R.id.shorelandLogo);
        mSubStatement = (TextView)findViewById(R.id.subStatement);
        mMissionVision = (Button)findViewById(R.id.missionVision);
        mSchoolMap = (Button)findViewById(R.id.schoolMap);
        mMissionVisionLayout = (RelativeLayout)findViewById(R.id.missionVisionLayout);
        mClassHoursLayout = (RelativeLayout)findViewById(R.id.classHoursLayout);
        mSchoolMapLayout = (RelativeLayout)findViewById(R.id.schoolMapLayout);

        mShorelandLogo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mSubStatement.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AboutSLHS.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mMissionVision.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mMissionVisionLayout.setVisibility(View.VISIBLE);
                mSchoolMapLayout.setVisibility(View.INVISIBLE);
            }
        });

               //TODO set map image
        mSchoolMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mSchoolMapLayout.setVisibility(View.VISIBLE);
                mMissionVisionLayout.setVisibility(View.INVISIBLE);
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
