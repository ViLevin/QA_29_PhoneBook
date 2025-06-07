package tests;

import manager.DataProviderContact;
import models.Contact;
import models.User;
import org.checkerframework.checker.units.qual.C;
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
        logger.info("Start");
        int i = (int) (Math.random() * 9000 + 1000);

        Contact contact = Contact.builder()
                .name("Ben" + i)
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
        logger.info("End");
    }

    @Test(dataProvider = "contactCSV", dataProviderClass = DataProviderContact.class)
    public void addNewContactSuccessAllCSV(Contact contact) {
        int i = (int) (Math.random() * 9000 + 1000);

        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillContactForm(contact);
//        app.getHelperContact().pause(15000);
        app.getHelperContact().getScreen("src/test/screenshots/AddNewCont" + i + ".png");
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));
        logger.info("End");
    }

    @Test
    public void addNewContactSuccessRequired() {
        logger.info("Start");
        int i = (int) (Math.random() * 9000 + 1000);

        Contact contact = Contact.builder()
                .name("Ben" + i)
                .lastName("Adam")
                .email("ben" + i + "@gmail.com")
                .phone("05012300" + i)
                .address("Israel, KfarSaba, Street, 5")
                .build();
        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().getScreen("src/test/screenshots/screen-" + i + ".png");
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));
        logger.info("End");
    }

    @Test
    public void AddNewContactWrongName() {
        logger.info("Start");
        int i = (int) (Math.random() * 9000 + 1000);

        Contact contact = Contact.builder()
                .name("")
                .lastName("Adam")
                .email("ben@gmail.com")
                .phone("050123234589")
                .address("Israel, KfarSaba, Street, 5")
                .description("wrong name")
                .build();

        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillContactForm(contact);
//        app.getHelperContact().pause(15000);
        app.getHelperContact().getScreen("src/test/screenshots/screen-" + i + ".png");
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isAddNewContactPageStillDisplayed());
        logger.info("End");
    }

    @Test
    public void AddNewContactWrongLastname() {
        logger.info("Start");
        int i = (int) (Math.random() * 9000 + 1000);

        Contact contact = Contact.builder()
                .name("Ben")
                .lastName("")
                .email("ben@gmail.com")
                .phone("050123234580")
                .address("Israel, KfarSaba, Street, 5")
                .description("wrong last name")
                .build();

        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().getScreen("src/test/screenshots/screen-" + i + ".png");
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddNewContactPageStillDisplayed());
        logger.info("End");
    }

    @Test(dataProvider = "contactWrongPhone", dataProviderClass = DataProviderContact.class)
    public void AddNewContactWrongPhone(Contact contact) {
        int i = (int) (Math.random() * 9000 + 1000);
        logger.info("Test run with data: " + contact.toString());
        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillContactForm(contact);
//        app.getHelperContact().pause(15000);
        app.getHelperContact().getScreen("src/test/screenshots/wrongPhone" + i + ".png");
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isAddNewContactPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent(" Phone not valid:"));
        logger.info("End");
    }

    @Test
    public void AddNewContactWrongPhone2() {
        logger.info("Start");
        int i = (int) (Math.random() * 9000 + 1000);

        Contact contact = Contact.builder()
                .name("Ben")
                .lastName("Adam")
                .email("ben@gmail.com")
                .phone("12345")
                .address("Israel, KfarSaba, Street, 5")
                .description("wrong ph2")
                .build();

        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillContactForm(contact);
//        app.getHelperContact().pause();
        app.getHelperContact().getScreen("src/test/screenshots/screen-" + i + ".png");
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isAddNewContactPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent(" Phone not valid:"));
        logger.info("End");
    }

    @Test
    public void AddNewContactWrongEmail() {
        logger.info("Start");
        int i = (int) (Math.random() * 9000 + 1000);

        Contact contact = Contact.builder()
                .name("Ben")
                .lastName("Adam")
                .email("ben123gmail.com")
                .phone("050123234589")
                .address("Israel, KfarSaba, Street, 5")
                .description("wrong email")
                .build();

        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().getScreen("src/test/screenshots/screen-" + i + ".png");
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isAddNewContactPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent("Email not valid: must be a well-formed email address"));
        logger.info("End");
    }

    @Test(enabled = false) //---> bug
    public void AddNewContactWrongEmail2() {
        logger.info("Start");
        int i = (int) (Math.random() * 9000 + 1000);

        Contact contact = Contact.builder()
                .name("Ben")
                .lastName("Adam")
                .email("")
                .phone("050123234589")
                .address("Israel, KfarSaba, Street, 5")
                .description("wrong email2")
                .build();

        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().getScreen("src/test/screenshots/screen-" + i + ".png");
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isAddNewContactPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent(" Email not valid"));
        logger.info("End");
    }

    @Test
    public void AddNewContactWrongAddress() {
        logger.info("Start");
        int i = (int) (Math.random() * 9000 + 1000);

        Contact contact = Contact.builder()
                .name("Ben")
                .lastName("Adam")
                .email("ben@gmail.com")
                .phone("050123234589")
                .address("")
                .description("wrong address")
                .build();

        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().getScreen("src/test/screenshots/screen-" + i + ".png");
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isAddNewContactPageStillDisplayed());
        logger.info("End");
    }


}
