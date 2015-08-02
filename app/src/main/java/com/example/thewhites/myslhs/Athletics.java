package com.example.thewhites.myslhs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
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

import com.google.android.gms.maps.model.LatLng;

public class Athletics extends Activity {

    private int selectedItem = -1;

    ImageView mShorelandLogo;
    TextView mSubStatement;
    RelativeLayout mAthleticsLayout;
    RelativeLayout mDirectoryLayout;
    RelativeLayout mStandardLayout;
    MapsActivity mapsActivity = new MapsActivity();

    Button mApparel1;
    Button mDirectory1;
    Button mAthleticsDirections1;
    Button mWisSports1;
    Button mAthleticCalendar1;
    Button mAthleticNews1;

    Button mApparel2;
    Button mDirectory2;
    Button mAthleticsDirections2;
    Button mWisSports2;
    Button mAthleticCalendar2;
    Button mAthleticNews2;

    //direcotry buttons
    Button mBaseball;
    Button mBasketballBoys;
    Button mBasketballGirls;
    Button mCheer;
    Button mCrossCountry;
    Button mFootball;
    Button mGolf;
    Button mSoccerBoys;
    Button mSoccerGirls;
    Button mSoftball;
    Button mStrengthTraining;
    Button mTrackField;
    Button mVolleyball;
    Button mWrestling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athletics);
        mShorelandLogo = (ImageView)findViewById(R.id.shorelandLogo);
        mSubStatement = (TextView)findViewById(R.id.subStatement);
        mAthleticsLayout = (RelativeLayout)findViewById(R.id.athleticsLayout);
        mDirectoryLayout = (RelativeLayout)findViewById(R.id.directoryLayout);
        mStandardLayout = (RelativeLayout)findViewById(R.id.standardLayout);

        //Athletic Layout's buttons
        //Standard
        mApparel1 = (Button)findViewById(R.id.apparel1);
        mDirectory1 = (Button)findViewById(R.id.athleticsDirectory1);
        mAthleticsDirections1 = (Button)findViewById(R.id.athleticDirections1);
        mWisSports1 = (Button)findViewById(R.id.wissports1);
        mAthleticCalendar1 = (Button)findViewById(R.id.athleticsCalendar1);
        mAthleticNews1 = (Button)findViewById(R.id.athleticsNews1);


        //Directory
        mApparel2 = (Button)findViewById(R.id.apparel);
        mDirectory2 = (Button)findViewById(R.id.athleticsDirectory);
        mAthleticsDirections2 = (Button)findViewById(R.id.athleticDirections2);
        mWisSports2 = (Button)findViewById(R.id.wissports);
        mAthleticCalendar2 = (Button)findViewById(R.id.athleticsCalendar);
        mAthleticNews2 = (Button)findViewById(R.id.athleticsNews);

        //Directory Layout buttons:
        mBaseball = (Button)findViewById(R.id.baseball);
        mBasketballBoys = (Button)findViewById(R.id.basketballBoys);
        mBasketballGirls = (Button)findViewById(R.id.basketballGirls);
        mCheer = (Button)findViewById(R.id.cheer);
        mCrossCountry = (Button)findViewById(R.id.crossCountry);
        mFootball = (Button)findViewById(R.id.football);
        mGolf = (Button)findViewById(R.id.golf);
        mSoccerBoys = (Button)findViewById(R.id.soccerBoys);
        mSoccerGirls = (Button)findViewById(R.id.soccerGirls);
        mSoftball = (Button)findViewById(R.id.softball);
        mStrengthTraining = (Button)findViewById(R.id.strengthTraining);
        mTrackField = (Button)findViewById(R.id.trackField);
        mVolleyball = (Button)findViewById(R.id.volleyball);
        mWrestling = (Button)findViewById(R.id.wrestling);

        mShorelandLogo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mSubStatement.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Athletics.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        //Standard Layout buttons:
        mDirectory1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mDirectoryLayout.setVisibility(View.VISIBLE);
                mStandardLayout.setVisibility(View.INVISIBLE);
            }
        });

        mWisSports1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Uri uriUrl = Uri.parse("http://www.wissports.net/");
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        });

        mAthleticsDirections1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(1);
            }
        });

        mAthleticCalendar1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SplashActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mApparel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriUrl = Uri.parse("http://www.mylocker.net/wisconsin/somers/shoreland-lutheran-high-school/index.html?utm_source=rschooltoday&utm_medium=rschooltoday&utm_term=WI5317110588&utm_content=145x175&utm_campaign=schoolpage");
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        });

        mAthleticNews1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SplashActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        //Directory (2) Layout buttons:
        mDirectory2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mDirectoryLayout.setVisibility(View.INVISIBLE);
                mStandardLayout.setVisibility(View.VISIBLE);
            }
        });

        mWisSports2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Uri uriUrl = Uri.parse("http://www.wissports.net/");
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        });

        mAthleticsDirections2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(1);
            }
        });

        mAthleticCalendar2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SplashActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mApparel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriUrl = Uri.parse("http://www.mylocker.net/wisconsin/somers/shoreland-lutheran-high-school/index.html?utm_source=rschooltoday&utm_medium=rschooltoday&utm_term=WI5317110588&utm_content=145x175&utm_campaign=schoolpage");
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        });

        mAthleticNews2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SplashActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        //Directory Sports
        mBaseball.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Baseball.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mBasketballBoys.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), BasketballBoys.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mBasketballGirls.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), BasketballGirls.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mCheer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Cheer.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mCrossCountry.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CrossCountry.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mFootball.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Football.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mGolf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Golf.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
        mSoccerBoys.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SoccerBoys.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mSoccerGirls.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SoccerGirls.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mSoftball.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Softball.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mStrengthTraining.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), StrengthTraining.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mTrackField.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TrackField.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mVolleyball.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Volleyball.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mWrestling.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Wrestling.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
        //End of Sports
    }


    //This is called when Directions(1)(2) is clicked.
    // It opens an Alert Dialog that contains 9 radio buttons
    //Each radio  button is connected to a MCC school
    //The corresponding buttons open up Google Maps zoomed in on that school
    @Override
    protected Dialog onCreateDialog(int id) {

        switch (id) {
            case 1:
                return createExampleDialog();

            default:
                return null;
        }
    }

    /**
     * If a dialog has already been created,
     * this is called to reset the dialog
     * before showing it a 2nd time. Optional.
     */
    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {

        switch (id) {
            case 1:
               //clear edit text
        }
    }

    /**
     * Create and return an example alert dialog with an edit text box.
     */
    private Dialog createExampleDialog() {

        AlertDialog schoolDialog;

        final String[] items = {
            " Catholic Central ",
            " Dominican ",
            " Martin Luther ",
            " Racine Lutheran ",
            " Racine Saint Catherine's",
            " Shoreland Lutheran ",
            " St. Joseph Catholic Academy ",
            " St. Thomas More ",
            " The Prairie School "
        };

        //lat langs match up with titles above
        final LatLng[] latLngs = {
                new LatLng(42.67495,-88.28177),
                new LatLng(43.119455,-87.909530),
                new LatLng(42.949182,-88.010364),
                new LatLng(42.73039,-87.80605),
                new LatLng(42.7180754,-87.7862634),
                new LatLng(42.640387,-87.918690),
                new LatLng(42.570574,-87.838123),
                new LatLng(42.979362,-87.876592),
                new LatLng(42.77276,-87.77568)
        };

        // Creating and Building the Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select The School You Would Like Directions To");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                selectedItem = item;

            }
        });

        builder.setPositiveButton("Next", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int whichButton) {
                if(selectedItem > 0) {
                    Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                    intent.putExtra("latlng", latLngs[selectedItem]);
                    intent.putExtra("title", items[selectedItem]);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        return builder.create();
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
