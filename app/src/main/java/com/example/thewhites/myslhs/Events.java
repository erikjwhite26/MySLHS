package com.example.thewhites.myslhs;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Events extends Activity {

    Button showNotificationBut, alertButton;
    NotificationManager notificationManager;
    TimePicker pickerTime;
    DatePicker pickerDate;

    int notifID = 33;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        showNotificationBut = (Button)findViewById(R.id.showNotificationBut);
        alertButton = (Button)findViewById(R.id.alertButton);
        pickerDate = (DatePicker)findViewById(R.id.datePicker);
        pickerTime = (TimePicker)findViewById(R.id.timePicker);

        Calendar now = Calendar.getInstance();

        pickerDate.init(
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH),
                null);

        pickerTime.setCurrentHour(now.get(Calendar.HOUR_OF_DAY));
        pickerTime.setCurrentMinute(now.get(Calendar.MINUTE));
    }


    public void showNotification(View view) {

        NotificationCompat.Builder notificBuilder = new
                NotificationCompat.Builder(this)
                .setContentTitle("MySLHS Event")
                .setContentText("Tyler is awesome")
                .setTicker("MySLHS Event")
                .setSmallIcon(R.drawable.notification_icon);

        Intent moreInfoIntent = new Intent(this, Events.class);

        TaskStackBuilder tStackBuilder = TaskStackBuilder.create(this);
        tStackBuilder.addParentStack(Events.class);
        tStackBuilder.addNextIntent(moreInfoIntent);

        PendingIntent pendingIntent = tStackBuilder.getPendingIntent(0,
                PendingIntent.FLAG_UPDATE_CURRENT);

        notificBuilder.setContentIntent(pendingIntent);
        notificBuilder.setDefaults(NotificationCompat.DEFAULT_ALL);
        notificBuilder.setAutoCancel(true);

        notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(notifID, notificBuilder.build());

    }

    public void setAlarm(View view) {
        Calendar current = Calendar.getInstance();

        Calendar cal = Calendar.getInstance();
        cal.set(pickerDate.getYear(),
                pickerDate.getMonth(),
                pickerDate.getDayOfMonth(),
                pickerTime.getCurrentHour(),
                pickerTime.getCurrentMinute(),
                00);

        if (cal.compareTo(current) <= 0) {
            //The set Date/Time already passed
            Toast.makeText(getApplicationContext(),
                    "Invalid Date/Time",
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(),
                    "Alarm Set",
                    Toast.LENGTH_LONG).show();
            setAlarm2(cal);
        }
    }

    private void setAlarm2(Calendar targetCal) {

        Intent alertIntent = new Intent(this, AlertReceiver.class);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(),
                PendingIntent.getBroadcast(this, 1, alertIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT));
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
