package com.trappist.logintdd.presenter;

/**
 * Created by Raj Forhad on 06/01/2018.
 */

public interface LoginView {
    void showErrorMessageForWrongUsernamePassword();
    void showErrorMessageForMaxLoginAttempt();
    void showLoginSuccessMessage();
}