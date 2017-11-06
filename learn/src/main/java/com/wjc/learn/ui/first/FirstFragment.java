package com.wjc.learn.ui.first;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.wjc.learn.R;

import java.util.List;

/**
 * Project_NAME : todoapp
 * Package_NAME : com.wjc.learn.first
 * File_NAME : FirstFragment
 * Created by WJC on 2017/11/2 10:11
 * Describe : TODO
 */

public class FirstFragment extends Fragment implements  FirstContract.View,AdapterView.OnItemClickListener {

    private ListView listView;
    private ProgressBar progressBar;
    private FirstContract.Presenter presenter;

    public static FirstFragment newInstance(){
        return new FirstFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_frag,container,false);
        listView = (ListView)view.findViewById(R.id.list);
        listView.setOnItemClickListener(this);

        progressBar = (ProgressBar)view.findViewById(R.id.progress);

//        presenter = new FirstPresenter(this,new ToFindItemsInteractorImpl());
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        presenter.onItemClicked(position);
    }

    @Override
    public void setPresenter(FirstContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        listView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        listView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setItems(List<String> items) {
        listView.setAdapter(new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,items));
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
