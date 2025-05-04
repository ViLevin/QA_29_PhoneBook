package tests;

import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginSuccess() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("test12@gmail.com", "vilevinQa!1234");
        app.getHelperUser().submitLogin();

    }

}
