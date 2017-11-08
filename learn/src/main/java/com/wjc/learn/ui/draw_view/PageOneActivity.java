package com.wjc.learn.ui.draw_view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.wjc.learn.R;
import com.wjc.learn.data.PageModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Project_NAME : todoapp
 * Package_NAME : com.wjc.learn.ui.draw_view.draw_1
 * File_NAME : PageOneActivity
 * Created by WJC on 2017/11/7 14:18
 * Describe : TODO
 */

public class PageOneActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    List<PageModel> pageModels = new ArrayList<>();{
        pageModels.add(new PageModel(R.layout.sample_color,R.layout.practice_color,R.string.title_draw_color));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pageone);

        viewPager =(ViewPager)findViewById(R.id.pager);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                PageModel pageModel = pageModels.get(position);
                return PageFragment.newInstance(pageModel.getSampleLayoutRes(),pageModel.getPracticeLayoutRes());
            }

            @Override
            public int getCount() {
                return pageModels.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(pageModels.get(position).getTitleRes());
            }

        });

        tabLayout = (TabLayout)findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

//
//    private class PageModel {
//        @LayoutRes int sampleLayoutRes;
//        @LayoutRes int practiceLayoutRes;
//        @LayoutRes int titleRes;
//
//        public PageModel(int sampleLayoutRes, int practiceLayoutRes, int titleRes) {
//            this.sampleLayoutRes = sampleLayoutRes;
//            this.practiceLayoutRes = practiceLayoutRes;
//            this.titleRes = titleRes;
//        }
//    }
}

