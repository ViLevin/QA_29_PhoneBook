package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperContact extends HelperBase {
    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openAddContactForm() {
        click(By.xpath("//*a[href = 'add']"));
    }

    public void fillContactForm(Contact contact) {
//private String id;
//    private String name;
//    private String lastName;
//    private String email;
//    private String phone;
//    private String address;
//    private String description;

        type();

    }
}
