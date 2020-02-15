package com.example.android.webtech;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;


public class SettingsFragment extends PreferenceFragment  {



    @Override
    public void onCreate( @Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_frag);
       
    }




}
