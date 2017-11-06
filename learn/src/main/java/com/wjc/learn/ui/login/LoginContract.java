package com.wjc.learn.ui.login;

import com.wjc.learn.BasePresenter;
import com.wjc.learn.BaseView;

/**
 * Project_NAME : todoapp
 * Package_NAME : com.wjc.learn.ui.login
 * File_NAME : LoginContract
 * Created by WJC on 2017/11/6 13:56
 * Describe : TODO
 */

public interface LoginContract {

    interface View extends BaseView<Presenter>{
        void openMainActivity();

        void empty_email();

        void invalid_email();

        void empty_password();
    }

    interface Presenter extends BasePresenter{
        void onServerLoginClick(String email, String password);

        void onGithubClick();

        void onBlogClick();

    }
}
