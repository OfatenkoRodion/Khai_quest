package ro.khai_quest;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import Fragments.ScannerFragment;
import Fragments.QrCodesFragment;
import Fragments.MessageFragment;


public class StartActivity extends AppCompatActivity
{

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        ScannerFragment scanerFragment=new ScannerFragment();

        if (getIntent()!=null)
        {
            scanerFragment.setResult(getIntent().getStringExtra("qr_code"));
        }

        adapter.addFragment(scanerFragment, "Сканер");
        adapter.addFragment(new MessageFragment(), "Задания");
        adapter.addFragment(new QrCodesFragment(), "Журнал");
        viewPager.setAdapter(adapter);
    }

}
