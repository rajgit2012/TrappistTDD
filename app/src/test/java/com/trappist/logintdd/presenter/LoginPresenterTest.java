package com.trappist.logintdd.presenter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Raj Forhad on 06/01/2018.
 */
public class LoginPresenterTest {

    public LoginPresenterTest() {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void checkIfLoginAttemptIsExceeded(){
        LoginView loginView = mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);

        Assert.assertEquals(1, loginPresenter.incrementLoginAttempt());
        Assert.assertEquals(2, loginPresenter.incrementLoginAttempt());
        Assert.assertEquals(3, loginPresenter.incrementLoginAttempt());

        Assert.assertTrue(loginPresenter.isLoginAttemptExceeded());
    }
    @Test
    public void checkIfLoginAttemptIsNotExceeded(){
        LoginView loginView = mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);

        //Assert.assertEquals(1, loginPresenter.incrementLoginAttempt());
        //Assert.assertEquals(2, loginPresenter.incrementLoginAttempt());
        //Assert.assertEquals(3, loginPresenter.incrementLoginAttempt());
        //Assert.assertEquals(4, loginPresenter.incrementLoginAttempt());

        Assert.assertTrue(loginPresenter.isLoginAttemptExceeded());
    }

    @Test
    public void checkUsernamePasswordIsCorrect(){
        LoginView loginView = mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        loginPresenter.doLogin("rajforhad", "123456");

        verify(loginView).showLoginSuccessMessage();
    }

    @Test
    public void checkIfLoginAttemptIsExceededAndViewMethodCalled()
    {
        LoginView loginView= mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        loginPresenter.doLogin("rajforhads", "123456");
        loginPresenter.doLogin("rajforhads", "123456");
        loginPresenter.doLogin("rajforhads", "123456");
        loginPresenter.doLogin("rajforhads", "123456");

        verify(loginView).showErrorMessageForMaxLoginAttempt();
    }
}