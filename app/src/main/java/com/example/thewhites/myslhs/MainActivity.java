package com.example.thewhites.myslhs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button mAboutSLHS,mAdmissions,mAcademics,mAthletics,mCalendar, mAnnouncements,mDirections;
    TextView mCallSLHS;
    SearchView mSearchQuery;
    MediaPlayer mSound;
    RadioButton mEnableSounds,mMuteSounds;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        initSettings();
//        initSoundsClick();
        mAboutSLHS = (Button)findViewById(R.id.aboutSLHS);
        mAdmissions = (Button)findViewById(R.id.admissions);
        mAcademics = (Button)findViewById(R.id.academics);
        mAthletics = (Button)findViewById(R.id.athletics);
        mCalendar = (Button)findViewById(R.id.calendar);
        mAnnouncements = (Button)findViewById(R.id.announcements);
        mCallSLHS = (TextView)findViewById(R.id.slhsAddress);
        mDirections = (Button)findViewById(R.id.directions);
        mSearchQuery = (SearchView)findViewById(R.id.search);
        mEnableSounds = (RadioButton)findViewById(R.id.enableSounds);
        mMuteSounds = (RadioButton)findViewById(R.id.muteSounds);
        mSound = MediaPlayer.create(this, R.raw.buttonclick1);
        mCallSLHS.setText("Phone: 262.859.2595"+"\n"+"Address: 9026 12th St."+"\n"+"Somers, WI 53171");

        mDirections.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mSound.start();
                startActivity(new Intent(getApplicationContext(), MapsActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mAboutSLHS.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mSound.start();
                startActivity(new Intent(getApplicationContext(), AboutSLHS.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mAdmissions.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mSound.start();
                startActivity(new Intent(getApplicationContext(), Admissions.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mAcademics.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mSound.start();
                startActivity(new Intent(getApplicationContext(), Academics.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mAthletics.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mSound.start();
                startActivity(new Intent(getApplicationContext(), Athletics.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mCalendar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mSound.start();
                startActivity(new Intent(getApplicationContext(), SLHSCalendar.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mAnnouncements.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mSound.start();
                startActivity(new Intent(getApplicationContext(), LatestNews.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
    }

    //The following three methods are to enable or mute sounds depending on the settings
//    private void noise() {
//        if (mEnableSounds.isChecked()) {
//            mSound = MediaPlayer.create(this, R.raw.buttonclick1);
//            mSound.start();
//        }
//        else {
//           //Mute
//        }
//    }
//
//    private void initSoundsClick() {
//        RadioGroup rgSounds = (RadioGroup)findViewById(R.id.radioGroupS);
//        rgSounds.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                RadioButton enableSounds = (RadioButton)findViewById(R.id.enableSounds);
//                if (enableSounds.isChecked()) {
//                    getSharedPreferences("MySLHSPreferences",
//                            Context.MODE_PRIVATE).edit()
//                            .putString("sounds", "enablesounds").commit();
//                }
//                else {
//                    getSharedPreferences("MySLHSPreferences",
//                            Context.MODE_PRIVATE).edit()
//                            .putString("sounds", "mutesounds").commit();
//                }
//            }
//        });
//    }
//
//    private void initOtherClick() {
//        RadioGroup rgOther = (RadioGroup)findViewById(R.id.radioGroupO);
//        rgOther.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                RadioButton showOriginalEdition = (RadioButton)findViewById(R.id.showOriginalEdition);
//                if (showOriginalEdition.isChecked()) {
//                    getSharedPreferences("MySLHSPreferences",
//                            Context.MODE_PRIVATE).edit()
//                            .putString("other", "openoriginal").commit();
//                }
//                else {
//                    getSharedPreferences("MySLHSPreferences",
//                            Context.MODE_PRIVATE).edit()
//                            .putString("other", "openteacher").commit();
//                }
//            }
//        });
//    }
//
//    private void initSettings() {
//        String sound = getSharedPreferences("MySLHSPreferences",
//                Context.MODE_PRIVATE).getString("sounds","enablesounds");
//
//        String other = getSharedPreferences("MySLHSPreferences",
//                Context.MODE_PRIVATE).getString("other","openoriginal");
//
//        RadioButton enableSound = (RadioButton)findViewById(R.id.enableSounds);
//        RadioButton muteSound = (RadioButton)findViewById(R.id.muteSounds);
//        if (sound.equalsIgnoreCase("enablesounds")) {
//            enableSound.setChecked(true);
//        }
//        else {
//            muteSound.setChecked(true);
//        }
//
//        RadioButton openOriginal = (RadioButton)findViewById(R.id.showOriginalEdition);
//        RadioButton openTeacher = (RadioButton)findViewById(R.id.showTeacherEdition);
//        if (other.equalsIgnoreCase("openoriginal")) {
//            openOriginal.setChecked(true);
//        }
//        else {
//            openTeacher.setChecked(true);
//        }
//    }


    //This is the confirmation to call SLHS by clicking the address
    public void showCallingDialog(View v){
        AlertDialog.Builder AlertDialog = new AlertDialog.Builder(this);

        AlertDialog.setTitle("Confirm Call");

        AlertDialog.setMessage("Are you sure you want to call Shoreland Lutheran?");

        AlertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Calling Shoreland Lutheran", Toast.LENGTH_SHORT).show();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:262-859-2595"));
                startActivity(callIntent);
            }
        });

        AlertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Canceled call", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
//
//        MenuItem searchItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
