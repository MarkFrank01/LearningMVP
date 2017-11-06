package com.wjc.learn.ui.login;

/**
 * Project_NAME : todoapp
 * Package_NAME : com.wjc.learn.ui.login
 * File_NAME : LoginPresenter
 * Created by WJC on 2017/11/6 14:07
 * Describe : TODO
 */

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void onServerLoginClick(String email, String password) {
        if (email == null || email.isEmpty()) {
           view.empty_email();
            return;
        }

        if (password == null || password.isEmpty()) {
            view.empty_password();
            return;
        }

        view.openMainActivity();
    }

    @Override
    public void onGithubClick() {

    }

    @Override
    public void onBlogClick() {

    }


}
