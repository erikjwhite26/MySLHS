package com.example.thewhites.myslhs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class TeacherLogin extends Activity {

    Button mLogin;
    EditText mPassword;
    CheckBox mRememberMe;
    public static final String MyPREFERENCES = "MySLHSPreferences";
    public static final String RememberMe = "rememberMeKey";
    public static final String Password = "passwordKey";
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);
        mLogin = (Button) findViewById(R.id.login);
        mRememberMe = (CheckBox) findViewById(R.id.rememberMe);
        mPassword = (EditText) findViewById(R.id.teacherPassword);
        initSettings();
        initOverride();


        mLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String inputPassword = mPassword.getText().toString();
                String correctPassword = "slhs1971";

                if (mRememberMe.isChecked() && String.valueOf(inputPassword).equals(correctPassword)) {

                    sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

                        getSharedPreferences(MyPREFERENCES,Context.MODE_PRIVATE).edit()
                                .putString(Password, "yes").commit();
                        initSettings();
                } else if (String.valueOf(inputPassword).equals(correctPassword)) {

                    sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

                    getSharedPreferences(MyPREFERENCES,Context.MODE_PRIVATE).edit()
                            .putString(Password, "no").commit();
                    initSettings();
                }

                if (String.valueOf(inputPassword).equals(correctPassword)) {
                    startActivity(new Intent(getApplicationContext(), TeacherEdition.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect Password", Toast.LENGTH_SHORT).show();
                    mPassword.setText("");
                }
                initSave();

            }
        });

        mRememberMe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
               initSave();
            }
        });
    }

    private void initOverride() {

        String override = getSharedPreferences(MyPREFERENCES,
                Context.MODE_PRIVATE).getString(Password, "yes");

        if (String.valueOf(override).equals("yes")) {
            startActivity(new Intent(getApplicationContext(), TeacherEdition.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        }
    }

    private void initSettings() {

        String other = getSharedPreferences(MyPREFERENCES,
                Context.MODE_PRIVATE).getString(RememberMe, "checked");

        if (other.equalsIgnoreCase("checked")) {
            mRememberMe.setChecked(true);
        } else {
            mRememberMe.setChecked(false);
        }
    }

    private void initSave() {

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        if (mRememberMe.isChecked()) {
            getSharedPreferences(MyPREFERENCES,
                    Context.MODE_PRIVATE).edit()
                    .putString(RememberMe, "checked").commit();
            initSettings();
        } else {
            getSharedPreferences(MyPREFERENCES,
                    Context.MODE_PRIVATE).edit()
                    .putString(RememberMe, "notchecked").commit();
            initSettings();
        }
    }
}

