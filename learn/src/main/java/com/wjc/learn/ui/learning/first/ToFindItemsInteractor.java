package com.wjc.learn.ui.learning.first;

import java.util.List;

/**
 * Project_NAME : todoapp
 * Package_NAME : com.wjc.learn.first
 * File_NAME : ToFindItemsInteractor
 * Created by WJC on 2017/11/2 12:02
 * Describe : TODO
 */

public interface ToFindItemsInteractor {

    interface OnFinishedListener {
        void onFinished(List<String> items);
    }

    void findItems(ToFindItemsInteractor.OnFinishedListener listener);
}
