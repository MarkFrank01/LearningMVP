package com.wjc.learn.ui.draw_view;

import com.wjc.learn.BasePresenter;
import com.wjc.learn.BaseView;

/**
 * Project_NAME : todoapp
 * Package_NAME : com.wjc.learn.ui.draw_view.draw_1
 * File_NAME : BaseViewContract
 * Created by WJC on 2017/11/7 15:11
 * Describe : TODO
 */

public interface BaseViewContract {

    interface View extends BaseView<Presenter>{
        void showViewPager();

        void showTabLayout();
    }

    interface Presenter extends BasePresenter{

    }
}
