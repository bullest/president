package com.bullest.president;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.bullest.president.home.HomeFragment;
import com.bullest.president.news.NewsFragment;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import cn.bmob.v3.Bmob;

public class MainActivity extends AppCompatActivity {
    Toolbar mToolbar;
    FragmentManager fm;
    Fragment fragment;
    Drawer drawer;
    private long mLastBackPressTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = findViewById(R.id.toolbar);

        Bmob.initialize(this, "4bed46db97b563d4c4c7bb21e2e83a3f");

        configDrawer();

        fm = getSupportFragmentManager();

        fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = new HomeFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
            mToolbar.setTitle("首页");
        }

    }

    private void configDrawer() {
        new DrawerBuilder().withActivity(this).build();
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName(R.string.drawer_item_home).withIcon(R.drawable.trump);
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName(R.string.drawer_item_twitter).withIcon(R.drawable.trumtter);
        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(3).withName(R.string.drawer_item_news).withIcon(R.drawable.news);
        PrimaryDrawerItem item4 = new PrimaryDrawerItem().withIdentifier(4).withName(R.string.drawer_item_weekly_address);

        drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(mToolbar)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
                        item2,
                        new DividerDrawerItem(),
                        item3,
                        new DividerDrawerItem(),
                        item4,
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_settings)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        Fragment fragment = null;

                        switch (position) {
                            case 0:
                                fragment = new HomeFragment();
                                mToolbar.setTitle(getString(R.string.drawer_item_home));
                                break;
                            case 2:
                                fragment = new TwitterFragment();
                                mToolbar.setTitle(getString(R.string.drawer_item_twitter));
                                break;
                            case 4:
                                fragment = new NewsFragment();
                                mToolbar.setTitle(getString(R.string.drawer_item_news));

                        }

                        if (fragment != null) {
                            fm.beginTransaction().replace(R.id.fragment_container, fragment).commit();
                            drawer.closeDrawer();
                        }
                        return true;
                    }
                })
                .build();
    }

    @Override
    public void onBackPressed() {
        if (drawer != null && drawer.isDrawerOpen()){
            drawer.closeDrawer();
        } else {
            long currentTime = System.currentTimeMillis();
            if (currentTime - mLastBackPressTime > 3500) {
                Toast.makeText(getBaseContext(), "Press back again to exit.", Toast.LENGTH_LONG).show();
                mLastBackPressTime = currentTime;
            } else {
                finishAffinity();
            }
        }
    }

}
