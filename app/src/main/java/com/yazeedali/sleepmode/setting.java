package com.yazeedali.sleepmode;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class setting extends AppCompatActivity implements SettingListFragment.Callbacks{
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        mToolbar = (Toolbar) findViewById(R.id.MToolbar);
        mToolbar.setTitle(R.string.action_settings);
        setSupportActionBar(mToolbar);
        getFragmentManager().beginTransaction().replace(R.id.container, new SettingListFragment() ).commit();
    }


    @Override
    public void onCategorySelected(String key) {

    }
}
