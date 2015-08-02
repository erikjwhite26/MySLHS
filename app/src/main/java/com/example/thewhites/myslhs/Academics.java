package com.example.thewhites.myslhs;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class Academics extends Activity {

    ImageView mShorelandLogo;
    TextView mSubStatement;
    Button mGrades;
    Button mClassHours;
    Button mFaculty;
    RelativeLayout mGradesLayout;
    RelativeLayout mClassHoursLayout;
    LinearLayout mFacultyLayout;
    Button mCheckGrades;
    Button mRegular;
    Button mHomeroom;
    Button mLateStart;
    Button mExam;
    ScrollView mRegularSchedule;
    ScrollView mHomeroomSchedule;
    ScrollView mLateStartSchedule;
    ScrollView mExamSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academics);
        mShorelandLogo = (ImageView)findViewById(R.id.shorelandLogo);
        mSubStatement = (TextView)findViewById(R.id.subStatement);
        mGrades = (Button)findViewById(R.id.grades);
        mClassHours = (Button)findViewById(R.id.classHours);
        mFaculty = (Button)findViewById(R.id.faculty);
        mGradesLayout = (RelativeLayout)findViewById(R.id.grades_layout);
        mClassHoursLayout = (RelativeLayout)findViewById(R.id.classHoursLayout);
        mFacultyLayout = (LinearLayout)findViewById(R.id.facultyLayout);
        mCheckGrades = (Button)findViewById(R.id.checkGrades);
        mRegular = (Button)findViewById(R.id.regular);
        mHomeroom = (Button)findViewById(R.id.homeroom);
        mLateStart = (Button)findViewById(R.id.lateStart);
        mExam = (Button)findViewById(R.id.exam);
        mRegularSchedule = (ScrollView)findViewById(R.id.regularSchedule);
        mHomeroomSchedule = (ScrollView)findViewById(R.id.homeroomSchedule);
        mLateStartSchedule = (ScrollView)findViewById(R.id.lateStartSchedule);
        mExamSchedule = (ScrollView)findViewById(R.id.examSchedule);

        mShorelandLogo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mSubStatement.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Academics.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mGrades.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mGradesLayout.setVisibility(View.VISIBLE);
                mClassHoursLayout.setVisibility(View.INVISIBLE);
                mFacultyLayout.setVisibility(View.INVISIBLE);
            }
        });

        mClassHours.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mClassHoursLayout.setVisibility(View.VISIBLE);
                mGradesLayout.setVisibility(View.INVISIBLE);
                mFacultyLayout.setVisibility(View.INVISIBLE);
            }
        });

        mFaculty.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //mFacultyLayout.setVisibility(View.VISIBLE);
                //mClassHoursLayout.setVisibility(View.INVISIBLE);
                //mGradesLayout.setVisibility(View.INVISIBLE);
                startActivity(new Intent(getApplicationContext(), Faculty.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mCheckGrades.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Uri uriUrl = Uri.parse("https://53032netclass.blackbaudondemand.com/NetClassroom7/Forms/login.aspx?ReturnUrl=%2fnetclassroom7%2fdefault.aspx");
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        });

        //Sets and Times Buttons and Layouts
        mRegular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mRegularSchedule.setVisibility(View.VISIBLE);
                mHomeroomSchedule.setVisibility(View.INVISIBLE);
                mLateStartSchedule.setVisibility(View.INVISIBLE);
                mExamSchedule.setVisibility(View.INVISIBLE);
            }
        });

        mHomeroom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mRegularSchedule.setVisibility(View.INVISIBLE);
                mHomeroomSchedule.setVisibility(View.VISIBLE);
                mLateStartSchedule.setVisibility(View.INVISIBLE);
                mExamSchedule.setVisibility(View.INVISIBLE);
            }
        });

        mLateStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mRegularSchedule.setVisibility(View.INVISIBLE);
                mHomeroomSchedule.setVisibility(View.INVISIBLE);
                mLateStartSchedule.setVisibility(View.VISIBLE);
                mExamSchedule.setVisibility(View.INVISIBLE);
            }
        });

        mExam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mRegularSchedule.setVisibility(View.INVISIBLE);
                mHomeroomSchedule.setVisibility(View.INVISIBLE);
                mLateStartSchedule.setVisibility(View.INVISIBLE);
                mExamSchedule.setVisibility(View.VISIBLE);
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
