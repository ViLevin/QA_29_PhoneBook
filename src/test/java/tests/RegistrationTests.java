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
                .setEmail("test" + z + "@gmail.com")
                .setPassword("vilevinQa!1234");


        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationFormObj(user);
        app.getHelperUser().submitRegistration();



        Assert.assertTrue(app.getHelperUser().isLogged());

    }
}
