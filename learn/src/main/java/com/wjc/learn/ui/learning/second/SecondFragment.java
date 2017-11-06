package com.wjc.learn.ui.learning.second;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wjc.learn.R;

/**
 * Project_NAME : todoapp
 * Package_NAME : com.wjc.learn.mydemo.second
 * File_NAME : SecondFragment
 * Created by WJC on 2017/11/2 10:11
 * Describe : TODO
 */

public class SecondFragment extends Fragment{


    public static SecondFragment newInstance(){
        return new SecondFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_frag,container,false);
        TextView textView2 =(TextView) view.findViewById(R.id.text2);
        textView2.setText("22222");
        return view;
    }
}
