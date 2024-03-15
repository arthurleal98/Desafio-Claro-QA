package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;
    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By loginButton = By.xpath("//input[@name='login']");

    //preciso de um costrutor que receba o webdriver do selenum

    LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void inserirUsername(String username){
        this.driver.findElement(this.usernameField).sendKeys(username);
    }
    public void inserirPassword(String password){
        this.driver.findElement(this.passwordField).sendKeys(password);
    }
    public void clicarLogin(){
        this.driver.findElement(this.loginButton).click();
    }


}
