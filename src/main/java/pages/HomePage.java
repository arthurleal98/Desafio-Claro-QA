package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private final WebDriver driver;
    By iconeMenuButton = By.id("menu-icon");
    By myAccountButton = By.id("menu-item-50");
    Wait<WebDriver> wait;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clicarMenuButton() {
        //adicionando um wait explicito
        wait.until(driver -> driver.findElement(iconeMenuButton).isDisplayed());
        this.driver.findElement(iconeMenuButton).click();
    }

    public void clicarMyAccount() {
        wait.until(driver -> driver.findElement(myAccountButton).isDisplayed());
        this.driver.findElement(myAccountButton).click();
    }




}
