package com.bwie.day0520_oldweekexam3_a;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bwie.day0520_oldweekexam3_a.adapter.MyAdapter;

public class MainActivity extends FragmentActivity {

    private ViewPager vp;
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = (ViewPager) findViewById(R.id.vp);

        rg = (RadioGroup) findViewById(R.id.rg);

        //http://www.meirixue.com/api.php?c=category&a=getall

        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());

        vp.setAdapter(adapter);

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                RadioButton rb = (RadioButton) rg.getChildAt(position);

                rg.check(rb.getId());

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i = 0; i < 4; i++) {
                    if (checkedId == rg.getChildAt(i).getId()){
                        vp.setCurrentItem(i);
                    }
                }
            }
        });

    }
}
