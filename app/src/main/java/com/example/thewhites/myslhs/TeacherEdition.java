package com.example.thewhites.myslhs;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class TeacherEdition extends Activity {

    Button mEnterGrades;
    Button mSeating;
    Button mEventPlanner;
    Button mLessonPlanner;
    Button mGoogleClassroom;
    Button mMoodle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_edition);
        mEnterGrades = (Button)findViewById(R.id.enterGrades);
        mSeating = (Button)findViewById(R.id.seating);
        mEventPlanner = (Button)findViewById(R.id.eventPlanner);
        mLessonPlanner = (Button)findViewById(R.id.lessonPlanner);
        mGoogleClassroom = (Button)findViewById(R.id.googleClassroom);
        mMoodle = (Button)findViewById(R.id.moodle);

        mEnterGrades.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Uri uriUrl = Uri.parse("https://53032faweb.blackbaudondemand.com/FAWeb7/forms/login.aspx?ReturnUrl=%2ffaweb7%2fdefault.aspx");
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        });

        mSeating.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Seating.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mEventPlanner.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), EventsList.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mLessonPlanner.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Lessons.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mGoogleClassroom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Uri uriUrl = Uri.parse("https://classroom.google.com");
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        });

        mMoodle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Uri uriUrl = Uri.parse("http://myslhs.org");
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_teacher_edition, menu);
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
        int id7 = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Uri uriUrl = Uri.parse("http://slhs.us/");
            Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
            startActivity(launchBrowser);
            return true;
        }

        if (id2 == R.id.original_edition) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            return true;
        }

        if (id3 == R.id.app_development) {
            startActivity(new Intent(getApplicationContext(), AppDevelopmentTeacher.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
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

        if (id7 == R.id.logout) {
            finish();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}