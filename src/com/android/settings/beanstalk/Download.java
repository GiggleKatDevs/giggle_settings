/*
 * Copyright (C) 2014 The Dirty Unicorns Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.beanstalk;

import android.app.ActivityManager;
import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.ContentResolver;
import android.content.res.Resources;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.SeekBarPreference;
import android.provider.Settings;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.Utils;

public class Download extends SettingsPreferenceFragment implements OnPreferenceChangeListener {

    Preference mBSGapps;
    Preference mBSOfficial;
    Preference mSuperSu;
    Preference mPAGapps;
    Preference mXposed;
    Preference mXposeddpi;
    Preference mXposednetflix;
    Preference mXposedMod;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.download);

        final ContentResolver resolver = getActivity().getContentResolver();

        mBSGapps = findPreference("gigglekat_gapps");
        mBSOfficial = findPreference("gigglekat_official");
        mSuperSu = findPreference("supersu");
        mPAGapps = findPreference("pa_gapps");
        mXposed = findPreference("xposed");
        mXposeddpi = findPreference("xposeddpi");
        mXposednetflix = findPreference("xposednetflix");
        mXposedMod = findPreference("xposed_mod");
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        if (preference == mBSGapps) {
            Uri uri = Uri.parse("http://downloads.gigglekat.com/Addons/Gapps/");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
            return true;
        } else if (preference == mPAGapps) {
            Uri uri = Uri.parse("https://www.androidfilehost.com/?w=files&flid=15797");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
            return true;
        } else if (preference == mXposed) {
            Uri uri = Uri.parse("http://downloads.gigglekat.com/Addons/xposed_installer.apk");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
            return true;
        } else if (preference == mXposeddpi) {
            Uri uri = Uri.parse("http://downloads.gigglekat.com/Addons/appsetting.apk");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
            return true;
        } else if (preference == mXposednetflix) {
            Uri uri = Uri.parse("http://downloads.gigglekat.com/Addons/NetflixWorkaround.apk");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
            return true;
        } else if (preference == mXposedMod) {
            Uri uri = Uri.parse("http://goo.gl/5J860t");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
            return true;
        } else if (preference == mBSOfficial) {
            Uri uri = Uri.parse("http://downloads.gigglekat.com/Devices/");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
            return true;
        } else if (preference == mSuperSu) {
            Uri uri = Uri.parse("http://downloads.gigglekat.com/Addons/UPDATE-SuperSU-v2.14.zip");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
            return true;
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }

    public boolean onPreferenceChange(Preference preference, Object value) {
         return true;
    }

    public static class DeviceAdminLockscreenReceiver extends DeviceAdminReceiver {}

}
