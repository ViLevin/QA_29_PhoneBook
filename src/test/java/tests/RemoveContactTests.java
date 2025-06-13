package tests;

import models.User;
//import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RemoveContactTests extends TestBase {
    @BeforeClass
    //login
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("test12@gmail.com").withPassword("vilevinQa!1234"));
        }
    }

    @BeforeMethod
    public void preMethod() {
//  checkUp ContactList
        app.getHelperContact().provideContacts();///if list of contact <3 --> add 3 contacts
    }


//    public void preMethod() throws InterruptedException {
//        Integer contAll = app.getHelperContact().listLocatorSize(By.xpath("//div[@class='contact-item_card__2SOIM']"));
//        System.out.println(contAll);
//
//        while (contAll == null || contAll <= 3) {
//            app.getHelperContact().addNewContact();
//            if (contAll == null) {
//                contAll = 1;
//            } else {
//                contAll = contAll + 1;
//            }
//        }
//    }


    @Test(priority = 1)
    public void removeFirstContact() {

        Assert.assertEquals(app.getHelperContact().removeOneContact(), 1);
    }


//


    @Test
    public void removeAllContacts() {

        app.getHelperContact().removeAllContacts();
        Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());

    }
}
//         public void removeFirstContact() throws InterruptedException {
//        logger.info("Start");
//        Integer contAll1 = app.getHelperContact().listLocatorSize(By.xpath("//div[@class='contact-item_card__2SOIM']"));
//
//        System.out.printf("contAll1: %s\n", contAll1);
//        app.getHelperUser().findExistContactAndRemove();
//
//        app.getHelperUser().pause(10000);
//        Integer contAll2 = app.getHelperContact().listLocatorSize(By.xpath("//div[@class='contact-item_card__2SOIM']"));
//
//        System.out.printf("contAll2: %s\n", contAll2);
//        Assert.assertTrue(contAll2.equals(contAll1 - 1));
//        logger.info("End");
//    }

//public void removeAllContact() throws InterruptedException {
//        logger.info("Start");
//        Integer contAll = app.getHelperContact().listLocatorSize(By.xpath("//div[@class='contact-item_card__2SOIM']"));
//        while (contAll != null && contAll > 0) {
//            app.getHelperUser().findExistContactAndRemove();
//            contAll = app.getHelperContact().listLocatorSize(By.xpath("//div[@class='contact-item_card__2SOIM']"));
//            System.out.printf("contAll: %s\n", contAll);
//        }
//        contAll = app.getHelperContact().listLocatorSize(By.xpath("//div[@class='contact-item_card__2SOIM']"));
//        Assert.assertEquals((int) contAll, 0);
//        logger.info("End");
//    }

