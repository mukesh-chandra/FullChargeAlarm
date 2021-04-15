package com.readytofire.fullchargealarm;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.RingtonePreference;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.readytofire.fullchargealarm.helper.LocaleManager;
import psquare.FullChargeAlarm.R;

public class SettingsActivity extends AppCompatPreferenceActivity {
    public static OnPreferenceChangeListener sBindPreferenceSummaryToValueListener = new OnPreferenceChangeListener() {
        public boolean onPreferenceChange(Preference preference, Object value) {
            String stringValue = value.toString();
            if (preference instanceof ListPreference) {
                ListPreference listPreference = (ListPreference) preference;
                int index = listPreference.findIndexOfValue(stringValue);
                preference.setSummary(index >= 0 ? listPreference.getEntries()[index] : null);
            } else if (!(preference instanceof RingtonePreference)) {
                preference.setSummary(stringValue);
            } else if (TextUtils.isEmpty(stringValue)) {
                preference.setSummary(R.string.pref_ringtone_silent);
            } else {
                Ringtone ringtone = RingtoneManager.getRingtone(preference.getContext(), Uri.parse(stringValue));
                if (ringtone == null) {
                    preference.setSummary("Default");
                } else {
                    preference.setSummary(ringtone.getTitle(preference.getContext()));
                }
            }
            return true;
        }
    };
    private int STORAGE_PERMISSION_CODE = 23;

    public static class GeneralPreferenceFragment extends PreferenceFragment {
        private Preference btrysv;
        ListPreference listpref;

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.set);
            setHasOptionsMenu(true);
            Preference prefer = findPreference("key_er");
            Preference fdbk = findPreference("key_send_feedback");
            Preference abt = findPreference("key_ab");
            Preference lng = findPreference("key_lang");
            this.btrysv = findPreference("key_btry");
            prefer.setOnPreferenceClickListener(new OnPreferenceClickListener() {
                public boolean onPreferenceClick(Preference preference) {
                    Builder alertbox;
                    if (VERSION.SDK_INT >= 21) {
                        alertbox = new Builder(GeneralPreferenceFragment.this.getPreferenceScreen().getContext(), R.style.MyAlertDialogfaq);
                    } else {
                        alertbox = new Builder(GeneralPreferenceFragment.this.getPreferenceScreen().getContext());
                    }
                    alertbox.setTitle((CharSequence) GeneralPreferenceFragment.this.getResources().getString(R.string.set_er_hd));
                    alertbox.setIcon((int) R.drawable.ic_err);
                    alertbox.setMessage((CharSequence) GeneralPreferenceFragment.this.getResources().getString(R.string.set_ques));
                    alertbox.setNegativeButton((CharSequence) GeneralPreferenceFragment.this.getResources().getString(R.string.set_er_btn_neg), (OnClickListener) new OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Device Info:");
                            sb.append("\n OS Version: ");
                            sb.append(System.getProperty("os.version"));
                            sb.append("(");
                            sb.append(VERSION.INCREMENTAL);
                            String str = ")";
                            sb.append(str);
                            String deviceInfo = sb.toString();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(deviceInfo);
                            sb2.append("\n OS API Level: ");
                            sb2.append(VERSION.SDK_INT);
                            String deviceInfo2 = sb2.toString();
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(deviceInfo2);
                            sb3.append("\n Device: ");
                            sb3.append(Build.DEVICE);
                            String deviceInfo3 = sb3.toString();
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(deviceInfo3);
                            sb4.append("\n Model (and Product): ");
                            sb4.append(Build.MODEL);
                            sb4.append(" (");
                            sb4.append(Build.PRODUCT);
                            sb4.append(str);
                            String deviceInfo4 = sb4.toString();
                            Intent emailIntent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", "psquare.apps@gmail.com", null));
                            emailIntent.putExtra("android.intent.extra.SUBJECT", "FcA Error Report");
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(deviceInfo4);
                            sb5.append("\n\nPlease Describe Your Issue or Problem Here\n:-");
                            emailIntent.putExtra("android.intent.extra.TEXT", sb5.toString());
                            GeneralPreferenceFragment.this.startActivity(Intent.createChooser(emailIntent, "Send email..."));
                        }
                    });
                    alertbox.setPositiveButton((CharSequence) GeneralPreferenceFragment.this.getResources().getString(R.string.set_er_btn_pos), (OnClickListener) new OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            arg0.dismiss();
                        }
                    });
                    alertbox.show();
                    return false;
                }
            });
            fdbk.setOnPreferenceClickListener(new OnPreferenceClickListener() {
                public boolean onPreferenceClick(Preference preference) {
                    Intent emailIntent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", "psquare.apps@gmail.com", null));
                    emailIntent.putExtra("android.intent.extra.SUBJECT", "FcA Feedback");
                    GeneralPreferenceFragment.this.startActivity(Intent.createChooser(emailIntent, "Send email..."));
                    return false;
                }
            });
            abt.setOnPreferenceClickListener(new OnPreferenceClickListener() {
                public boolean onPreferenceClick(Preference preference) {
                    GeneralPreferenceFragment generalPreferenceFragment = GeneralPreferenceFragment.this;
                    generalPreferenceFragment.startActivity(new Intent(generalPreferenceFragment.getPreferenceScreen().getContext(), about.class));
                    return false;
                }
            });
            lng.setOnPreferenceClickListener(new OnPreferenceClickListener() {
                public boolean onPreferenceClick(Preference preference) {
                    GeneralPreferenceFragment generalPreferenceFragment = GeneralPreferenceFragment.this;
                    generalPreferenceFragment.startActivity(new Intent(generalPreferenceFragment.getPreferenceScreen().getContext(), langAct.class).putExtra("act", "set"));
                    return false;
                }
            });
            this.btrysv.setOnPreferenceClickListener(new OnPreferenceClickListener() {
                public boolean onPreferenceClick(Preference preference) {
                    try {
                        GeneralPreferenceFragment.this.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:psquare.FullChargeAlarm")));
                    } catch (Exception e) {
                    }
                    return false;
                }
            });
            SettingsActivity.bindPreferenceSummaryToValue(findPreference("example_text"));
            SettingsActivity.bindPreferenceSummaryToValue(findPreference("example_list"));
            SettingsActivity.bindPreferenceSummaryToValue(findPreference("key_low_lvl"));
            SettingsActivity.bindPreferenceSummaryToValue(findPreference("notifications_new_message_ringtone"));
        }

        public boolean onOptionsItemSelected(MenuItem item) {
            if (item.getItemId() != 16908332) {
                return super.onOptionsItemSelected(item);
            }
            getActivity().finish();
            return true;
        }
    }

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    private static boolean isXLargeTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 4;
    }

    /* access modifiers changed from: private */
    public static void bindPreferenceSummaryToValue(Preference preference) {
        preference.setOnPreferenceChangeListener(sBindPreferenceSummaryToValueListener);
        sBindPreferenceSummaryToValueListener.onPreferenceChange(preference, PreferenceManager.getDefaultSharedPreferences(preference.getContext()).getString(preference.getKey(), BuildConfig.FLAVOR));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        Builder alertbox;
        super.onCreate(savedInstanceState);
        setupActionBar();
        resetTitles();
        if (isReadStorageNotAllowed()) {
            if (VERSION.SDK_INT >= 21) {
                alertbox = new Builder(this, R.style.MyAlertDialogfaq);
            } else {
                alertbox = new Builder(this);
            }
            alertbox.setTitle((CharSequence) getResources().getString(R.string.strg_pm_title));
            alertbox.setMessage((CharSequence) getResources().getString(R.string.strg_pm_message));
            alertbox.setPositiveButton((CharSequence) getResources().getString(R.string.strg_pm_give), (OnClickListener) new OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    SettingsActivity.this.requestStoragePermission();
                }
            });
            alertbox.setNegativeButton((CharSequence) getResources().getString(R.string.set_er_btn_pos), (OnClickListener) new OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertbox.show();
        }
        getFragmentManager().beginTransaction().replace(16908290, new GeneralPreferenceFragment()).commit();
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public boolean onIsMultiPane() {
        return isXLargeTablet(this);
    }

    /* access modifiers changed from: protected */
    public boolean isValidFragment(String fragmentName) {
        return PreferenceFragment.class.getName().equals(fragmentName) || GeneralPreferenceFragment.class.getName().equals(fragmentName);
    }

    private boolean isReadStorageNotAllowed() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void requestStoragePermission() {
        String str = "android.permission.READ_EXTERNAL_STORAGE";
        ActivityCompat.shouldShowRequestPermissionRationale(this, str);
        ActivityCompat.requestPermissions(this, new String[]{str}, this.STORAGE_PERMISSION_CODE);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode != this.STORAGE_PERMISSION_CODE) {
            return;
        }
        if (grantResults.length <= 0 || grantResults[0] != 0) {
            Toast.makeText(this, "Permission denied custom ringtone may not work", 1).show();
        } else {
            Toast.makeText(this, "Now you can set your own ringtone", 1).show();
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleManager.setLocale(base));
    }

    private void resetTitles() {
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), 128);
            if (info.labelRes != 0) {
                setTitle(info.labelRes);
            }
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
