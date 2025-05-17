package tests;

import models.Contact;
import models.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase {

    @BeforeClass
    //login
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("test12@gmail.com").withPassword("vilevinQa!1234"));
        }
    }


    @Test
    public void addNewContactSuccessAll() {
        int i = (int) (Math.random() * 9000 + 1000);

        Contact contact = Contact.builder()
                .id("12345" + i)
                .name("Ben")
                .lastName("Adam")
                .email("ben" + i + "@gmail.com")
                .phone("050-123-" + i)
                .address("Israel, KfarSaba, Street, 5")
                .description("BenAdam")
                .build();


    }

    @Test
    public void addNewContactSuccessRequired() {
        int i = (int) (Math.random() * 9000 + 1000);

        Contact contact = Contact.builder()
                .id("12345" + i)
                .name("Ben")
                .lastName("Adam")
                .email("ben" + i + "@gmail.com")
                .phone("050-123-" + i)
                .address("Israel, KfarSaba, Street, 5")
                .build();


    }

}
