package com.trappist.logintdd.presenter;

import android.util.Log;

/**
 * Created by Raj Forhad on 06/01/2018.
 */

public class LoginPresenter {

    private static final int MAX_LOGIN_ATTEMPT = 3;
    private int loginAttempt;

    public int incrementLoginAttempt() {
        loginAttempt = loginAttempt + 1;
        return loginAttempt;
    }

    public boolean isLoginAttemptExceeded() {
        return loginAttempt >= MAX_LOGIN_ATTEMPT;
    }

    public boolean isLoginAttemptNotExceeded() {
        return loginAttempt <= MAX_LOGIN_ATTEMPT;
    }

    public boolean isLoginSuccess(String username, String password) {

        if(isLoginAttemptExceeded()){
            return false;
        }

        if(username.equals("rajforhad") && password.equals("123456")){
            return true;
        }

        // increment for failed login
        incrementLoginAttempt();

        return false;
    }
}
