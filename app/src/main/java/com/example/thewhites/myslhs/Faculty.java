package com.example.thewhites.myslhs;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Faculty extends Activity implements
        OnItemClickListener {

    public static final String[] titles = new String[] {
            "Joy Abitz", "Randy Abitz",
            "Holly Bahr", "Ronda Bailey",
            "Tom Bauer", "Paul Brug",
            "Jody Denzin", "Jeffery Dorn",
            "Lisa Fink", "James Groth",
            "Matthew Grow", "Peter Gumm",
            "Daniel Hahm", "Carol Hermanson",
            "Nathan Hochmuth", "Tracey Honeck",
            "Paul Huebner", "Lisa Jensen",
            "Joy Lee", "Ginny Look",
            "Lynn Luebke", "Stephanie Mackey",
            "Robert Musgrave", "Nichole Neumann",
            "Renee Pappalardo", "Lara Patterson",
            "Rachel Peterson", "George Povich",
            "Susan Salzmann", "Courtney Schmidt",
            "Kathy Schultz", "Daniel Schulz",
            "Paul Scriver", "Susan Scriver",
            "Sarah Siegler", "David Sjuggerud",
            "Paul Strutz", "Timothy Treder",
            "Julie Uher", "Alicia Wasser",
            "Kathy Weiland", "Andrew Willems",
            "Keith Wordell", "Kevin Zimmerman" };

    public static final String[] extentions = new String[] {
            "ext: 122", "ext: 227",
            "ext: 223", "ext: 222",
            "ext: 101", "ext: 104",
            "ext: 103", "ext: 214",
            "ext: 203", "ext: 102",
            "ext: 118", "ext: 204",
            "ext: 110", "ext: 103",
            "ext: 107", "ext: 123",
            "ext: 106", "ext: 210",
            "ext: 202", "ext: 211",
            "ext: 222", "ext: 117",
            "ext: 127", "ext: 212",
            "ext: 119", "ext: 112",
            "ext: 222", "ext: 111",
            "ext: 122", "ext: 116",
            "ext: 109", "ext: 115",
            "ext: 207", "ext: 215",
            "ext: 217", "ext: 225",
            "ext: 206", "ext: 224",
            "ext: 112", "ext: 108",
            "ext: 125", "ext: 219",
            "ext: 218", "ext: 114" };

    public static final String[] descriptions = new String[] {
            "abitzjoy@slhs.us", "abitzr@slhs.us",
            "bahrh@slhs.us", "rbailey@slhs.us",
            "bauert@slhs.us", "brugp@slhs.us",
            "denzinj@slhs.us", "dorn@slhs.us",
            "office@slhs.us", "grothjs@slhs.us",
            "growm@slhs.us", "gummp@slhs.us",
            "hahmd@slhs.us", "chermanson@slhs.us",
            "hochmuthn@slhs.us", "honeckt@slhs.us",
            "huebnerp@slhs.us", "businessclerk@slhs.us",
            "famlee33@aol.com", "glook@slhs.us",
            "ld3plus2@att.net", "mackeys@slhs.us",
            "musgraver@slhs.us", "nneumann@slhs.us",
            "pappalardor@slhs.us", "pattersonl@slhs.us",
            "dpeterson21@att.net", "gpovich@slhs.us",
            "susansalzmann@gmail.com", "cschmidt61@slhs.us",
            "kschultz48@slhs.us", "dschulz@slhs.us",
            "scriver@slhs.us", "scrivers@slhs.us",
            "sieglers@slhs.us", "sjuggerudd@slhs.us",
            "strutz@slhs.us", "ttreder@slhs.us",
            "muher@wi.rr.com", "wasserl@slhs.us",
            "weilandk@slhs.us", "willemsa@slhs.us",
            "wordellk@slhs.us", "zimmermank@slhs.us" };

    public static final Integer[] images = {
            R.drawable.joy_abitz, R.drawable.randy_abitz,
            R.drawable.holly_bahr, R.drawable.ronda_bailey,
            R.drawable.tom_bauer,  R.drawable.paul_brug,
            R.drawable.jody_denzin, R.drawable.jeffery_dorn,
            R.drawable.lisa_fink, R.drawable.james_groth,
            R.drawable.matthew_grow, R.drawable.peter_gumm,
            R.drawable.daniel_hahm, R.drawable.carol_hermanson,
            R.drawable.nathan_hochmuth, R.drawable.tracy_honeck,
            R.drawable.paul_heubner, R.drawable.lisa_jensen,
            R.drawable.joy_lee, R.drawable.ginny_look,
            R.drawable.lynn_luebke, R.drawable.stephanie_mackey,
            R.drawable.robert_musgrave, R.drawable.nichole_neumann,
            R.drawable.renee_pappalardo, R.drawable.lara_patterson,
            R.drawable.rachel_peterson, R.drawable.george_povich,
            R.drawable.susan_salzman, R.drawable.courtney_schmidt,
            R.drawable.kathy_schultz, R.drawable.daniel_schulz,
            R.drawable.paul_scriver, R.drawable.susan_scriver,
            R.drawable.sarah_siegler, R.drawable.david_sjuggerud,
            R.drawable.paul_strutz, R.drawable.timothy_treder,
            R.drawable.julie_uher, R.drawable.alicia_wasser,
            R.drawable.kathy_weiland, R.drawable.andrew_willems,
            R.drawable.keith_wordell, R.drawable.kevin_zimmerman };

    ListView listView;
    List<RowItem> rowItems;
    ImageView mShorelandLogo;
    TextView mSubStatement;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        mShorelandLogo = (ImageView)findViewById(R.id.shorelandFacultyLogo);
        mSubStatement = (TextView)findViewById(R.id.subStatement);

        mShorelandLogo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        mSubStatement.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Faculty.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < titles.length; i++) {
            RowItem item = new RowItem(images[i], titles[i], descriptions[i], extentions[i]);
            rowItems.add(item);
        }

        listView = (ListView) findViewById(R.id.list);
        CustomListViewAdapter adapter = new CustomListViewAdapter(this,
                R.layout.list_item_faculty, rowItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Teacher " + (position + 1) + ": " + rowItems.get(position),
                Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
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