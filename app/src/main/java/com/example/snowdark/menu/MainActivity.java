package com.example.snowdark.menu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.example.snowdark.menu.adapter.MainPagerAdapter;
import com.example.snowdark.menu.fragment.FavouriteFragment;
import com.example.snowdark.menu.fragment.HomeFragment;
import com.example.snowdark.menu.fragment.ProfileFragment;
import com.example.snowdark.menu.utils.control.SlidingTabLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends FragmentActivity {
    @InjectView(R.id.mViewPager)
    ViewPager mViewPager;
    @InjectView(R.id.mSlidingTab)
    SlidingTabLayout mSlidingTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        setViewPager();
    }

    Fragment[] fragments;

    private void setViewPager() {
        fragments = new Fragment[3];
        fragments[0] = new HomeFragment().newInstance();
        fragments[1] = new FavouriteFragment().newInstance();
        fragments[2] = new ProfileFragment().newInstance();
        mViewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(), this, fragments));
        mSlidingTab.setCustomTabView(R.layout.custom_tab, 0);
        mSlidingTab.setViewPager(mViewPager);

        mSlidingTab.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return 0xFFFFFFFF;
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
