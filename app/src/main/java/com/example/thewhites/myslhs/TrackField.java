package com.example.thewhites.myslhs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class TrackField extends Activity {

    ImageView mShorelandLogo;
    TextView mSubStatement;
    TextView mNominate;
    TextView mNominate2;
    RelativeLayout mTrackFieldHistoryLayout;
    RelativeLayout mTrackFieldCalendarLayout;
    RelativeLayout mTrackFieldNewsLayout;
    Button mTrackFieldHistory;
    Button mTrackFieldCalendar;
    Button mTrackFieldNews;
    ImageButton mSignUp;
    ImageButton mRecoveryRun;
    ImageButton mProposal;
    private static final String TAG = "TrackField";
    private static final int TEXT_ID = 0;
    private static final int TEXT_ID2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_field);
        mShorelandLogo = (ImageView)findViewById(R.id.shorelandLogo);
        mSubStatement = (TextView)findViewById(R.id.subStatement);
        mNominate = (TextView)findViewById(R.id.nominate);
        mNominate2 = (TextView)findViewById(R.id.nominate2);
        mTrackFieldCalendar = (Button)findViewById(R.id.trackFieldCalendar);
        mTrackFieldCalendarLayout = (RelativeLayout)findViewById(R.id.trackFieldCalendarLayout);
        mTrackFieldNews = (Button)findViewById(R.id.trackFieldNews);
        mTrackFieldNewsLayout = (RelativeLayout)findViewById(R.id.trackFieldNewsLayout);
        mTrackFieldHistory = (Button)findViewById(R.id.trackFieldHistory);
        mTrackFieldHistoryLayout = (RelativeLayout)findViewById(R.id.trackFieldHistoryLayout);
        mSignUp = (ImageButton)findViewById(R.id.meetSignUp);
        mRecoveryRun = (ImageButton)findViewById(R.id.recoveryRun);
        mProposal = (ImageButton)findViewById(R.id.proposal);


        mShorelandLogo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mSubStatement.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TrackField.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                mTrackFieldHistoryLayout.setVisibility(View.INVISIBLE);
                mTrackFieldCalendarLayout.setVisibility(View.INVISIBLE);
                mTrackFieldNewsLayout.setVisibility(View.INVISIBLE);
            }
        });

        mTrackFieldHistory.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mTrackFieldHistoryLayout.setVisibility(View.VISIBLE);
                mTrackFieldCalendarLayout.setVisibility(View.INVISIBLE);
                mTrackFieldNewsLayout.setVisibility(View.INVISIBLE);
            }
        });

        mTrackFieldCalendar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startSplashActivity("    http://www.slpacers.org/event_rss_feed?tags=920745");
            }
        });

        mTrackFieldNews.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startSplashActivity("    http://www.slpacers.org/news_rss_feed?tags=928551");
            }
        });

        mSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Uri uriUrl = Uri.parse("https://docs.google.com/a/slhs.us/spreadsheets/d/1_Dx-S7V3zt1NAiWSJKSxhoblY_2tVQrAxM_gNYe1RR0/edit#gid=10856726");
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);            }
        });

        mRecoveryRun.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Uri uriUrl = Uri.parse("https://docs.google.com/a/slhs.us/spreadsheets/d/1CVRzOp2jDTBQ0BjU9kigR3CVrcHdtkrJzLWBfiMcm4Y/edit");
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);         }
        });

        mProposal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                showDialog(1);
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
    protected Dialog onCreateDialog(int id) {

        switch (id) {
            case 1:
                return createExampleDialog();

            case 2:
                return createExampleDialog2();

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
                // Clear the input box.
                EditText text = (EditText) dialog.findViewById(TEXT_ID);
                text.requestFocus();
                dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

            case 2:
                EditText text2 = (EditText) dialog.findViewById(TEXT_ID2);
                text2.requestFocus();
                dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
                break;
        }
    }

    /**
     * Create and return an example alert dialog with an edit text box.
     */
    private Dialog createExampleDialog() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Carebear Nomination");
        builder.setMessage("I would like to nominate...");

        // Use an EditText view to get user input.
        final EditText input = new EditText(this);
        input.setId(TEXT_ID);
        builder.setView(input);

        //builder.setMessage("...because...");

        // Use an EditText view to get user input.
        //final EditText input2 = new EditText(this);
        //input.setId(TEXT_ID2);
        //builder.setView(input2);

        builder.setPositiveButton("Next", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int whichButton) {
                String value = input.getText().toString();
                //String value2 = input2.getText().toString();
                mNominate.setText(value);
                //mNominate2.setText(value2);
                showDialog(2);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        return builder.create();
    }

    private Dialog createExampleDialog2() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Carebear Nomination");
        builder.setMessage("...because they had...");

        // Use an EditText view to get user input.
        final EditText input2 = new EditText(this);
        input2.setId(TEXT_ID2);
        builder.setView(input2);
        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int whichButton) {
                String value2 = input2.getText().toString();
                mNominate2.setText(value2);
                sendEmail();
            }
        });

        builder.setNeutralButton("Back", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                showDialog(1);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        return builder.create();
    }

    public void sendEmail() {
        Log.i("Send email", "");
        String[] TO = {"elizabeth.proeber@abbvie.com"};
        String[] CC = {"dschulz@slhs.us"};
        String value = mNominate.getText().toString();
        String value2 = mNominate2.getText().toString();
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Carebear Nominations");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "I would like to nominate " + value + " for the Carebear Award because that athlete had " + value2);
        emailIntent.setType("message/rfc822");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail using..."));
            finish();
            Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(TrackField.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }

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
