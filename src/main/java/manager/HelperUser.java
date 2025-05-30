package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {
//        WebElement loginTab = wd.findElement(By.xpath("//a[text()='LOGIN']"));
//        WebElement loginTab = wd.findElement(By.cssSelector("a[href='/login']"));
//        loginTab.click();
        click(By.xpath("//a[text()='LOGIN']"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
//        WebElement emailInput = wd.findElement(By.name("email"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys(email);
        type(By.name("email"), email);

//        WebElement passwordInput = wd.findElement(By.xpath("//input[last()]"));

//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys(password);
//        type(By.xpath("//input[la]"), password);
        type(By.xpath("//input[last()]"), password);
    }

    public void fillLoginRegistrationFormObj(User user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void submitLogin() {
        click(By.xpath("//button[text()='Login']"));
    }

    public void submitRegistration() {
        click(By.xpath("//button[text()='Registration']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }

    public void logout() {
        click(By.xpath("//button[text()='Sign Out']"));
    }

    public boolean isNoContactsHereDisplayed() {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
        return (wait.until(ExpectedConditions.textToBePresentInElement(wd.findElement(By.cssSelector(".contact-page_message__2qafk>h1")), "No Contacts here!")));
    }

    public void login(User user) {
        openLoginRegistrationForm();
        fillLoginRegistrationFormObj(user);
        submitLogin();
    }


    public void findExistContactAndRemove() throws InterruptedException {
        click(By.xpath("//div[@class='contact-item_card__2SOIM']"));
        Thread.sleep(1000);
        click(By.xpath("//button[text()='Remove']"));
        Thread.sleep(1000);
    }
}


