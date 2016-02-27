package com.yazeedali.sleepmode;

import android.content.Context;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;

/**
 * Created by مهند on 21/02/16.
 */
public class SettingListFragment extends PreferenceFragment {

    //Toolbar mToolbar;
    private Callbacks mCallbacks = sDummyCallbacks;
    public interface Callbacks {
        /*
         * Callback for when an item has been selected.
         */
        void onCategorySelected(String key);
    }
    private static Callbacks sDummyCallbacks = new Callbacks() {
        @Override
        public void onCategorySelected(String key) {
        }
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref);



    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // Activities containing this fragment must implement its callbacks.
        if (!(context instanceof Callbacks)) {
            throw new IllegalStateException(
                    "Activity must implement fragment's callbacks.");
        }

        mCallbacks = (Callbacks) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();

        // Reset the active callbacks interface to the dummy implementation.
        mCallbacks = sDummyCallbacks;
    }
    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen,
                                         Preference preference) {
        mCallbacks.onCategorySelected(preference.getKey());
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }
}
/*
// Load the preferences from an XML resource
        String category = getArguments().getString("category");
        if (category != null) {
            if (category.equals(R.string.sleep)) {

            } else if (category.equals(R.string.waking)) {

            }
        }
 */