package com.example.thewhites.myslhs;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class SimpleRssReaderActivity extends ListActivity {

    List headlines;
    List links;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //Initializing instance variables
        headlines = new ArrayList();
        links = new ArrayList();

        new Thread(new Runnable() {
            public void run() {

                try {
                    URL url = new URL(" http://www.slpacers.org/news_rss_feed?tags=918215%2C920667%2C920755%2C920749%2C920751%2C920752%2C920732%2C920745%2C920763%2C922138%2C920737%2C919862%2C919861%2C921759%2C921756%2C921762%2C919866%2C921766%2C921767%2C928557%2C928561%2C930267%2C928551%2C928554\n");
                    XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                    factory.setNamespaceAware(false);
                    XmlPullParser xpp = factory.newPullParser();

                    xpp.setInput(getInputStream(url), "UTF_8");

                    boolean insideItem = false;

                    int eventType = xpp.getEventType();
                    while (eventType != XmlPullParser.END_DOCUMENT) {
                        if (eventType == XmlPullParser.START_TAG) {
                            if (xpp.getName().equalsIgnoreCase("item")) {
                                insideItem = true;
                            } else if (xpp.getName().equalsIgnoreCase("title")) {
                                if (insideItem)
                                    headlines.add(xpp.nextText());
                            } else if (xpp.getName().equalsIgnoreCase("link")) {
                                if (insideItem)
                                    links.add(xpp.nextText());
                            }
                        } else if (eventType == XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase("item")) {
                            insideItem = false;
                        }

                        eventType = xpp.next();
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, headlines);

        setListAdapter(adapter);
    }

    public InputStream getInputStream(URL url) {
        try {
            return url.openConnection().getInputStream();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Do something when a list item is clicked
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
