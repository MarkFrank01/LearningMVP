package com.wjc.learn.ui.learning.first;

import android.os.Handler;

import java.util.Arrays;
import java.util.List;

/**
 * Project_NAME : todoapp
 * Package_NAME : com.wjc.learn.first
 * File_NAME : ToFindItemsInteractorImpl
 * Created by WJC on 2017/11/2 12:02
 * Describe : TODO
 */

public class ToFindItemsInteractorImpl implements ToFindItemsInteractor {
    @Override
    public void findItems(final OnFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onFinished(createArrayList());
            }
        },2000);
    }

    private List<String> createArrayList(){
        return Arrays.asList(
                "Item 1",
                "Item 2",
                "Item 3",
                "Item 4",
                "Item 5",
                "Item 6",
                "Item 7",
                "Item 8",
                "Item 9",
                "Item 10");
    }
}
