package com.trappist.logintdd.presenter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        LoginPresenter loginPresenter = new LoginPresenter();
        Assert.assertEquals(1, loginPresenter.incrementLoginAttempt());
        Assert.assertEquals(2, loginPresenter.incrementLoginAttempt());
        Assert.assertEquals(3, loginPresenter.incrementLoginAttempt());

        Assert.assertTrue(loginPresenter.isLoginAttemptExceeded());
    }
}