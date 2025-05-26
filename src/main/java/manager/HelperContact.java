package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperContact extends HelperBase {
    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openAddContactForm() {
        click(By.xpath("//*[text() = 'ADD']"));
    }

    public void fillContactForm(Contact contact) {
//private String id;
//    private String name;
//    private String lastName;
//    private String email;
//    private String phone;
//    private String address;
//    private String description;

        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());

    }

    public void saveContact() {
        click(By.xpath("//*[text()='Save']"));
    }

    public boolean isContactAddedByName(String name) {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el : list) {
            if (el.getText().equals(name)) {
                return true;
            }
        }

        return false;
    }

    public boolean isContactAddedByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement el : list) {
            if (el.getText().equals(phone)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAddNewContactPageStillDisplayed() {
        return isElementPresent(By.cssSelector("a.active[href='/add']"));
    }

//    public void addNewContact() throws InterruptedException {
//        int i = (int) (Math.random() * 9000 + 1000);
//
//        Contact contact = Contact.builder()
//                .name("Ben" + i)
//                .lastName("Adam")
//                .email("ben" + i + "@gmail.com")
//                .phone("05012300" + i)
//                .address("Israel, KfarSaba, Street, 5")
//                .description("BenAdam")
//                .build();
//        openAddContactForm();
////        Thread.sleep(1000);
//        pause(10000);
//        fillContactForm(contact);
////        Thread.sleep(1000);
//        pause(10000);
//        saveContact();

    /// /        Thread.sleep(1000);
//        pause(10000);
//    }
    public Contact returnNewContact() {
        int i = (int) (Math.random() * 9000 + 1000);

        Contact contact = Contact.builder()
                .name("Ben" + i)
                .lastName("Adam")
                .email("ben" + i + "@gmail.com")
                .phone("05012300" + i)
                .address("Israel, KfarSaba, Street, 5")
                .description("BenAdam")
                .build();
        return contact;
    }


    public int removeOneContact() {
        int before = countOfContacts();
        logger.info("Number of contact list before remove is ---> " + before);
        removeContact();
        int after = countOfContacts();
        logger.info("Number of contact list after remove is ---> " + after);

        return before - after;
    }

    private void removeContact() {
        click(By.xpath("//div[@class='contact-item_card__2SOIM']"));
        pause(1500);
        click(By.xpath("//button[text()='Remove']"));
        pause(1500);
    }

    private int countOfContacts() {
        return wd.findElements(By.xpath("//div[@class='contact-item_card__2SOIM']")).size();
    }

    public void removeAllContacts() {
        while (countOfContacts() != 0)
            removeContact();
    }

    public void provideContacts() {
        if (countOfContacts() < 3){
            for(int i = 0; i <3; i++){
                addNewContact();
            }
        }
    }

    private void addNewContact() {
        int i = (int) (Math.random() * 9000 + 1000);
        Contact contact = Contact.builder()
                .name("Ben" + i)
                .lastName("Adam")
                .email("ben" + i + "@gmail.com")
                .phone("05012300" + i)
                .address("Israel, KfarSaba, Street, 5")
                .description("BenAdam")
                .build();

        openAddContactForm();
        fillContactForm(contact);
        saveContact();
        pause(1000);
    }

}
