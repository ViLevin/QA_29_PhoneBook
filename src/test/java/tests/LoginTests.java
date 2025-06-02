package tests;

import manager.DataProviderUser;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTests extends TestBase {


    @BeforeMethod
    public void preCondition() {

        //if 'Sign Out' present ---> logout
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
            logger.info("Before method finish logout");
        }
    }

    @Test(dataProvider = "loginData", dataProviderClass = DataProviderUser.class)
    public void loginSuccess(String email, String password) {
//        logger.info("Start test with name 'loginSuccess'");
        app.getHelperUser().openLoginRegistrationForm();
//        app.getHelperUser().fillLoginRegistrationForm("test12@gmail.com", "vilevinQa!1234");
//
        app.getHelperUser().fillLoginRegistrationForm(email, password);
        logger.info("TEST DATA --> email: " + email + " passwors: " + password);
        app.getHelperUser().submitLogin();

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is element 'sigh out' present");
    }


    @Test(dataProvider = "loginModels", dataProviderClass = DataProviderUser.class)
    public void loginSuccessModel(User user) {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationFormObj(user);
        logger.info("Test data -->" + user.toString());
        app.getHelperUser().submitLogin();
//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is element 'sigh out' present");
    }

    @Test
    public void loginWrongEmail() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("test12gmail.com", "vilevinQa!1234");
        logger.info("Test data -->   email: 'test12gmail.com' passwors: 'vilevinQa!1234'");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with text 'Wrong email or password'");
    }

    @Test
    public void loginWrongPassword() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("test12@gmail.com", "vilevinQa1234");
        logger.info("Test data -->   email: 'test12@gmail.com' passwors: 'vilevinQa1234'");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with text 'Wrong email or password'");
    }

    @Test
    public void loginWrongUnregisteredUser() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("boris@gmail.com", "Bbor223456$");
        logger.info("Test data -->   email: 'boris@gmail.com' passwors: 'Bbor223456$'");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with text 'Wrong email or password'");
    }

}
