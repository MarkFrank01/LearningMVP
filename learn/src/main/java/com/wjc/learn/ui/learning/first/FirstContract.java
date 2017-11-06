package com.wjc.learn.ui.learning.first;

import com.wjc.learn.BasePresenter;
import com.wjc.learn.BaseView;

import java.util.List;

/**
 * Project_NAME : todoapp
 * Package_NAME : com.wjc.learn.first
 * File_NAME : FirstContract
 * Created by WJC on 2017/11/2 11:53
 * Describe : TODO
 */

public interface FirstContract {

    interface View extends BaseView<Presenter>{
        void showProgress();

        void hideProgress();

        void setItems(List<String> items);

        void showMessage(String message);
    }

    interface Presenter extends BasePresenter{
        void onResume();

        void onItemClicked(int position);

        void onDestroy();
    }
}
