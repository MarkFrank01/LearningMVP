package com.wjc.learn.ui.learning.first;

import java.util.List;

/**
 * Project_NAME : todoapp
 * Package_NAME : com.wjc.learn.first
 * File_NAME : FirstPresenter
 * Created by WJC on 2017/11/2 12:00
 * Describe : TODO
 */

public class FirstPresenter implements FirstContract.Presenter, ToFindItemsInteractor.OnFinishedListener {

    private FirstContract.View first_view;
    private ToFindItemsInteractor findItemsInteractor;

    public FirstPresenter(FirstContract.View first_view, ToFindItemsInteractor findItemsInteractor) {
        this.first_view = first_view;
        this.findItemsInteractor = findItemsInteractor;
        this.first_view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void onResume() {
        if (first_view != null) {
            first_view.showProgress();
        }

        findItemsInteractor.findItems(this);
    }

    @Override
    public void onItemClicked(int position) {
        if (first_view != null) {
            first_view.showMessage(String.format("I checked %d", position + 1));
        }
    }

    @Override
    public void onDestroy() {
        first_view = null;
    }

    @Override
    public void onFinished(List<String> items) {
        if (first_view!=null){
            first_view.setItems(items);
            first_view.hideProgress();
        }
    }
}
