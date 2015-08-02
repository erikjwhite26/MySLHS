package com.example.thewhites.myslhs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class Help extends Activity {

    ImageView mShorelandLogo;
    TextView mSubStatement;
    ImageView mCalling;
    ImageView mDirections;
    ImageView mNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        mShorelandLogo = (ImageView) findViewById(R.id.shorelandLogo);
        mSubStatement = (TextView) findViewById(R.id.subStatement);
        mCalling = (ImageView) findViewById(R.id.callingLogo);
        mDirections = (ImageView) findViewById(R.id.directionsLogo);
        mNavigation = (ImageView) findViewById(R.id.navigationLogo);

        mShorelandLogo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        mSubStatement.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Help.class));
            }
        });
    }

    public void showCallingDialog1(final View v){
        final AlertDialog.Builder AlertDialog = new AlertDialog.Builder(this);

        AlertDialog.setTitle("Calling Directions");
        AlertDialog.setMessage("Click on the address to call Shoreland Lutheran");
        AlertDialog.setView(R.layout.help_c1);
        AlertDialog.setPositiveButton("Next", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                showCallingDialog2(v);
            }
        });

        AlertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog.show();
    }

    private void showCallingDialog2(final View v){
        AlertDialog.Builder AlertDialog = new AlertDialog.Builder(this);

        AlertDialog.setTitle("Calling Directions");
        AlertDialog.setMessage("Click yes on the Dialog Box to place call");
        AlertDialog.setView(R.layout.help_c2);
        AlertDialog.setPositiveButton("Next", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                showCallingDialog3(v);
            }
        });

        AlertDialog.setNeutralButton("Back", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                showCallingDialog1(v);
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog.show();
    }

    private void showCallingDialog3(final View v){
        AlertDialog.Builder AlertDialog = new AlertDialog.Builder(this);

        AlertDialog.setTitle("Calling Directions");
        AlertDialog.setMessage("You are now calling Shoreland Lutheran");
        AlertDialog.setView(R.layout.help_c3);
        AlertDialog.setPositiveButton("Repeat Instructions", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                showCallingDialog1(v);
            }
        });

        AlertDialog.setNeutralButton("Back", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                showCallingDialog2(v);
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog.show();
    }

    public void showDirectionsDialog1(final View v){
        AlertDialog.Builder AlertDialog = new AlertDialog.Builder(this);

        AlertDialog.setTitle("Directions Instructions");
        AlertDialog.setMessage("Click Directions button");
        AlertDialog.setView(R.layout.help_d1);
        AlertDialog.setPositiveButton("Next", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                showDirectionsDialog2(v);
            }
        });

        AlertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog.show();
    }

    public void showDirectionsDialog2(final View v){
        AlertDialog.Builder AlertDialog = new AlertDialog.Builder(this);

        AlertDialog.setTitle("Directions Instructions");
        AlertDialog.setMessage("Click the red marker above Shoreland");
        AlertDialog.setView(R.layout.help_d2);
        AlertDialog.setPositiveButton("Next", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                showDirectionsDialog3(v);
            }
        });

        AlertDialog.setNeutralButton("Back", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                showDirectionsDialog1(v);
            }
        });

        AlertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog.show();
    }

    public void showDirectionsDialog3(final View v){
        AlertDialog.Builder AlertDialog = new AlertDialog.Builder(this);

        AlertDialog.setTitle("Directions Instructions");
        AlertDialog.setMessage("Click the blue directions tab in the bottom corner");
        AlertDialog.setView(R.layout.help_d3);
        AlertDialog.setPositiveButton("Next", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                showDirectionsDialog4(v);
            }
        });

        AlertDialog.setNeutralButton("Back", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                showDirectionsDialog2(v);
            }
        });

        AlertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog.show();
    }

    public void showDirectionsDialog4(final View v){
        AlertDialog.Builder AlertDialog = new AlertDialog.Builder(this);

        AlertDialog.setTitle("Directions Instructions");
        AlertDialog.setMessage("If prompted, click 'yes' to allow location services");
        AlertDialog.setView(R.layout.help_d4);
        AlertDialog.setPositiveButton("Next", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                showDirectionsDialog5(v);
            }
        });

        AlertDialog.setNeutralButton("Back", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                showDirectionsDialog3(v);
            }
        });

        AlertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog.show();
    }

    public void showDirectionsDialog5(final View v){
        AlertDialog.Builder AlertDialog = new AlertDialog.Builder(this);

        AlertDialog.setTitle("Directions Instructions");
        AlertDialog.setMessage("You are then receiving directions to Shoreland from your current location");
        AlertDialog.setView(R.layout.help_d5);
        AlertDialog.setPositiveButton("Repeat Instructions", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                showDirectionsDialog1(v);
            }
        });

        AlertDialog.setNeutralButton("Back", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                showDirectionsDialog4(v);
            }
        });

        AlertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog.show();
    }

    public void showNavigationDialog1(final View v){
        AlertDialog.Builder AlertDialog = new AlertDialog.Builder(this);

        AlertDialog.setTitle("Helpful Hints: SLHS Logo");
        AlertDialog.setMessage("By pressing the logo on top, it takes you back to the main menu");
        AlertDialog.setView(R.layout.help_n1);
        AlertDialog.setPositiveButton("Next", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                showNavigationDialog2(v);
            }
        });

        AlertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog.show();
    }

    public void showNavigationDialog2(final View v){
        AlertDialog.Builder AlertDialog = new AlertDialog.Builder(this);

        AlertDialog.setTitle("Helpful Hints: SLHS Logo");
        AlertDialog.setMessage("You are back at the main menu");
        AlertDialog.setView(R.layout.help_n2);
        AlertDialog.setPositiveButton("Next", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                showNavigationDialog3(v);
            }
        });

        AlertDialog.setNeutralButton("Back", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                showNavigationDialog1(v);
            }
        });

        AlertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog.show();
    }

    public void showNavigationDialog3(final View v){
        AlertDialog.Builder AlertDialog = new AlertDialog.Builder(this);

        AlertDialog.setTitle("Helpful Hints: Substatement");
        AlertDialog.setMessage("By pressing the substatement underneath the logo, you will refresh the page you are on");
        AlertDialog.setView(R.layout.help_n3);
        AlertDialog.setPositiveButton("Next", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                showNavigationDialog4(v);
            }
        });

        AlertDialog.setNeutralButton("Back", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                showNavigationDialog2(v);
            }
        });

        AlertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog.show();
    }

    public void showNavigationDialog4(final View v){
        AlertDialog.Builder AlertDialog = new AlertDialog.Builder(this);

        AlertDialog.setTitle("Helpful Hints: Substatement");
        AlertDialog.setMessage("The page returns to its original state as when you initially opened it");
        AlertDialog.setView(R.layout.help_n4);
        AlertDialog.setPositiveButton("Repeat Instructions", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                showNavigationDialog1(v);
            }
        });

        AlertDialog.setNeutralButton("Back", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                showNavigationDialog3(v);
            }
        });

        AlertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_help, menu);
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
