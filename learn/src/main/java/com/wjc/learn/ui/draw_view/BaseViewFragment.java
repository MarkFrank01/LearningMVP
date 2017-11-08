package com.wjc.learn.ui.draw_view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wjc.learn.R;
import com.wjc.learn.data.PageModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Project_NAME : todoapp
 * Package_NAME : com.wjc.learn.ui.draw_view.myview1_1
 * File_NAME : BaseViewFragment
 * Created by WJC on 2017/11/7 15:11
 * Describe : TODO
 */

public class BaseViewFragment extends Fragment{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    List<PageModel> pageModels = new ArrayList<>();{
        pageModels.add(new PageModel(R.layout.sample_color,R.layout.practice_color,R.string.title_draw_color));
    }

    public static BaseViewFragment newInstance(){
        return new BaseViewFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base_view,container,false);
        viewPager =(ViewPager)view.findViewById(R.id.pager);
        viewPager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
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

        tabLayout = (TabLayout)view.findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }
}
