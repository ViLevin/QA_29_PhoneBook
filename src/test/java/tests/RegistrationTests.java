package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {
    @BeforeMethod
    public void preCondition() {

        //if 'Sign Out' present ---> logout
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void registrationSuccess() {

        int z = (int) ((System.currentTimeMillis() - 1000) % 3600);
        System.out.println(System.currentTimeMillis());
        System.out.println(z);

        User user = new User()
                .withEmail("test" + z + "@gmail.com")
                .withPassword("vilevinQa!1234");


        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationFormObj(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());
    }


    @Test() //description = "Bug report #11132 (=> Fixed)", enabled = false) --->  makes test enabled
    public void registrationWrongEmail() {

        User user = new User()
                .withEmail("testgmail.com")
                .withPassword("vilevinQa!1234");


        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationFormObj(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
    }


    @Test
    public void registrationWrongPassword() {
        User user = new User()
                .withEmail("test@gmail.com")
                .withPassword("vinQ!14");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationFormObj(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
    }


    @Test
    public void registrationExistUser() {
        User user = new User()
                .withEmail("test12@gmail.com")
                .withPassword("vilevinQa!1234");


        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationFormObj(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));


    }


}
