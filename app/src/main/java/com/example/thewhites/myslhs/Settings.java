package com.example.thewhites.myslhs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class Settings extends Activity {

    MediaPlayer mSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        RadioButton mEnableSounds = (RadioButton)findViewById(R.id.enableSounds);
        RadioButton mEnableNotifications = (RadioButton)findViewById(R.id.enableNotifications);
        RadioButton mOpenOriginal = (RadioButton)findViewById(R.id.showOriginalEdition);
        mSound = MediaPlayer.create(this, R.raw.buttonclick1);
        initSettings();
        initSoundsClick();
        initNotificationsClick();
        initOtherClick();

        if (mEnableSounds.isChecked()) {
            mSound.setVolume(100,100);
        }
        else {
            mSound.setVolume(0,0);
        }

    }

    private void initSettings() {
        String sound = getSharedPreferences("MySLHSPreferences",
                Context.MODE_PRIVATE).getString("sounds","enablesounds");
        String notifications = getSharedPreferences("MySLHSPreferences",
                Context.MODE_PRIVATE).getString("notifications","enablenotifications");
        String other = getSharedPreferences("MySLHSPreferences",
                Context.MODE_PRIVATE).getString("other","openoriginal");

        RadioButton enableSound = (RadioButton)findViewById(R.id.enableSounds);
        RadioButton muteSound = (RadioButton)findViewById(R.id.muteSounds);
        if (sound.equalsIgnoreCase("enablesounds")) {
            enableSound.setChecked(true);
        }
        else {
            muteSound.setChecked(true);
        }

        RadioButton enableNotifications = (RadioButton)findViewById(R.id.enableNotifications);
        RadioButton muteNotifications = (RadioButton)findViewById(R.id.muteNotifications);
        if (notifications.equalsIgnoreCase("enablenotifications")) {
            enableNotifications.setChecked(true);
        }
        else {
            muteNotifications.setChecked(true);
        }

        RadioButton openOriginal = (RadioButton)findViewById(R.id.showOriginalEdition);
        RadioButton openTeacher = (RadioButton)findViewById(R.id.showTeacherEdition);
        if (other.equalsIgnoreCase("openoriginal")) {
            openOriginal.setChecked(true);
        }
        else {
            openTeacher.setChecked(true);
        }
    }

    private void initSoundsClick() {
        RadioGroup rgSounds = (RadioGroup)findViewById(R.id.radioGroupS);
        rgSounds.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton enableSounds = (RadioButton)findViewById(R.id.enableSounds);
                if (enableSounds.isChecked()) {
                    getSharedPreferences("MySLHSPreferences",
                        Context.MODE_PRIVATE).edit()
                            .putString("sounds", "enablesounds").commit();
                }
                else {
                    getSharedPreferences("MySLHSPreferences",
                            Context.MODE_PRIVATE).edit()
                            .putString("sounds", "mutesounds").commit();
                }
            }
        });
    }

    private void initNotificationsClick() {
        RadioGroup rgNotifications = (RadioGroup)findViewById(R.id.radioGroupN);
        rgNotifications.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton enableNotifications= (RadioButton)findViewById(R.id.enableNotifications);
                if (enableNotifications.isChecked()) {
                    getSharedPreferences("MySLHSPreferences",
                            Context.MODE_PRIVATE).edit()
                            .putString("notifications", "enablenotifications").commit();
                }
                else {
                    getSharedPreferences("MySLHSPreferences",
                            Context.MODE_PRIVATE).edit()
                            .putString("notifications", "mutenotifications").commit();
                }
            }
        });
    }

    private void initOtherClick() {
        RadioGroup rgOther = (RadioGroup)findViewById(R.id.radioGroupO);
        rgOther.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton showOriginalEdition = (RadioButton)findViewById(R.id.showOriginalEdition);
                if (showOriginalEdition.isChecked()) {
                    getSharedPreferences("MySLHSPreferences",
                            Context.MODE_PRIVATE).edit()
                            .putString("other", "openoriginal").commit();
                }
                else {
                    getSharedPreferences("MySLHSPreferences",
                            Context.MODE_PRIVATE).edit()
                            .putString("other", "openteacher").commit();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
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
