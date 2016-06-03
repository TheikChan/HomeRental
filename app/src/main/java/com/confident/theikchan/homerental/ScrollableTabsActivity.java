package com.confident.theikchan.homerental;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.confident.theikchan.homerental.fragments.FragmentAll;
import com.confident.theikchan.homerental.fragments.FragmentFilter;
import com.confident.theikchan.homerental.fragments.OneFragment;
import com.confident.theikchan.homerental.fragments.ThreeFragment;
import com.confident.theikchan.homerental.fragments.TwoFragment;

import java.util.ArrayList;
import java.util.List;


public class ScrollableTabsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);

        setContentView(R.layout.activity_scrollable_tabs);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ///////////////// for transparent ////////////////////////////////

        //ActionBar actionBar = getSupportActionBar();
       // actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#330000ff")));
       // actionBar.setStackedBackgroundDrawable(new ColorDrawable(Color.parseColor("#550000ff")));

       // getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getSupportActionBar().setElevation(0);



        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new FragmentAll(), "ALL");
        adapter.addFrag(new OneFragment(), "FLATMATE");
        adapter.addFrag(new TwoFragment(), "RENT");
        adapter.addFrag(new ThreeFragment(), "PG/HOSTEL");

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id){
            case R.id.action_filter:
                FragmentManager fragManager = getSupportFragmentManager();
                FragmentFilter fragFilter = new FragmentFilter()
                        .newInstance();
        /*Bundle args=new Bundle();
        args.putString("fri_uid",uid);
        args.putInt("fri_id",fid);
        dfragment.setArguments(args);*/

                fragFilter.show(fragManager, "fragment_name");
                break;
            case R.id.action_home:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
