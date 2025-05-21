package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
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
                .phone("05012300" + i)
                .address("Israel, KfarSaba, Street, 5")
                .description("BenAdam")
                .build();
        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillContactForm(contact);
//        app.getHelperContact().pause(15000);
        app.getHelperContact().getScreen("src/test/screenshots/screen-" + i + ".png");
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));

    }

    @Test
    public void addNewContactSuccessRequired() {
        int i = (int) (Math.random() * 9000 + 1000);

        Contact contact = Contact.builder()
                .id("12345" + i)
                .name("Ben")
                .lastName("Adam")
                .email("ben" + i + "@gmail.com")
                .phone("05012300" + i)
                .address("Israel, KfarSaba, Street, 5")
                .build();
        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillContactForm(contact);

        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));
    }

    @Test
    public void AddNewContactWrongName() {

        Contact contact = Contact.builder()
                .id("12345")
                .name("Ben")
                .lastName("Adam")
                .email("bengmail.com")
                .phone("050123234589")
                .address("Israel, KfarSaba, Street, 5")
                .build();

        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isAddContactPageStillDisplayed());
    }

    @Test
    public void AddNewContactWrongLastname() {
        Contact contact = Contact.builder()
                .id("12345")
                .name("Ben")
                .lastName("")
                .email("ben@gmail.com")
                .phone("050123234580")
                .address("Israel, KfarSaba, Street, 5")
                .build();

        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddContactPageStillDisplayed());
    }

    @Test
    public void AddNewContactWrongPhone() {
        Contact contact = Contact.builder()
                .id("12345")
                .name("Ben")
                .lastName("Adam")
                .email("ben@gmail.com")
                .phone("")
                .address("Israel, KfarSaba, Street, 5")
                .build();

        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillContactForm(contact);
//        app.getHelperContact().pause();
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isAddContactPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent(" Phone not valid:"));
    }

    @Test
    public void AddNewContactWrongEmail() {
        Contact contact = Contact.builder()
                .id("12345")
                .name("Ben")
                .lastName("Adam")
                .email("ben123gmail.com")
                .phone("050123234589")
                .address("Israel, KfarSaba, Street, 5")
                .build();

        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isAddContactPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent(" Email not valid"));
    }

    @Test
    public void AddNewContactWrongAddress() {
        Contact contact = Contact.builder()
                .id("12345")
                .name("Ben")
                .lastName("Adam")
                .email("ben@gmail.com")
                .phone("050123234589")
                .address("")
                .build();

        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isAddContactPageStillDisplayed());

    }


}
