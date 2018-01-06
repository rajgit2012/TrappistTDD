package com.trappist.logintdd.presenter;

/**
 * Created by Raj Forhad on 06/01/2018.
 */

public class LoginPresenter {

    private static final int MAX_LOGIN_ATTEMPT = 3;
    private final LoginView loginView;
    private int loginAttempt;

    public LoginPresenter(LoginView loginView){
        this.loginView = loginView;
    }

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

    public void resetLoginAttempt() {
        loginAttempt = 0;
    }

    public void doLogin(String username, String password) {

        if(isLoginAttemptExceeded()){
            loginView.showErrorMessageForMaxLoginAttempt();
            return;
        }

        if(username.equals("rajforhad") && password.equals("123456")){
            loginView.showLoginSuccessMessage();
            resetLoginAttempt();
            return;
        }

        // increment for failed login
        incrementLoginAttempt();

        loginView.showErrorMessageForWrongUsernamePassword();
    }
}
