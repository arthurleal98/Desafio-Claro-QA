package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage {

    private final WebDriver driver;
    Wait<WebDriver> wait;
    By mensagemBoasVindas = By.className("woocommerce-MyAccount-content");
    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By emailField = By.id("reg_email");
    By passwordRegisterField = By.id("reg_password");
    By registerButton = By.xpath("//input[@name='register']");
    By loginButton = By.xpath("//input[@name='login']");
    By errorMessage = By.xpath("//ul[@class='woocommerce-error']");
    //preciso de um costrutor que receba o webdriver do selenum

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void inserirUsername(String username){
        wait.until(driver -> driver.findElement(usernameField).isDisplayed());
        this.driver.findElement(this.usernameField).sendKeys(username);
    }
    public void inserirPassword(String password){
        wait.until(driver -> driver.findElement(passwordField).isDisplayed());
        this.driver.findElement(this.passwordField).sendKeys(password);
    }
    public void clicarLogin(){
        wait.until(driver -> driver.findElement(loginButton).isDisplayed());
        String disable = this.driver.findElement(loginButton).getAttribute("disabled");
        if (disable.equals("true")){
            System.out.println("Botão de login desabilitado");
            driver.quit();
        }
        this.driver.findElement(this.loginButton).click();
    }

    public void inserirEmail(String email){
        wait.until(driver -> driver.findElement(emailField).isDisplayed());
        this.driver.findElement(this.emailField).sendKeys(email);
    }

    public void inserirPasswordRegister(String password){
        wait.until(driver -> driver.findElement(passwordRegisterField).isDisplayed());
        this.driver.findElement(this.passwordRegisterField).sendKeys(password);
    }


    public String obterMensagemDeErro() {
        try {
        wait.until(driver -> this.driver.findElement(errorMessage).isDisplayed());
        return this.driver.findElement(this.errorMessage).getText();
        } catch (Exception e) {
            return "";
        }

    }

    public void clicarRegister(){
        wait.until(driver -> driver.findElement(registerButton).isDisplayed());
        String disable = this.driver.findElement(registerButton).getAttribute("disabled");
        if (disable.equals("true")){
            System.out.println("Botão de cadastro desabilitado");
            driver.quit();
        }
        this.driver.findElement(this.registerButton).click();
    }

    public String obterMensagemBoasVindas(){
        wait.until(driver -> driver.findElement(mensagemBoasVindas).isDisplayed());
        return this.driver.findElement(this.mensagemBoasVindas).getText();
    }
}
