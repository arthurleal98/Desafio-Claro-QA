package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.MyAccountPage;
import utils.WebDriverFactory;

public class LoginSteps {

    WebDriver driver;
    MyAccountPage myAccountPage;

    @Before
    public void setup() {
        driver = new FirefoxDriver();
        myAccountPage = new MyAccountPage(this.driver);
    }
    @Given("que estou na tela de login")
    public void queEstouNaTelaDeLogin() {
        this.driver.get("https://practice.automationtesting.in/my-account/");
    }

    @When("preencho o campo login com {string}")
    public void preenchoOCampoLoginCom(String arg0) {
        myAccountPage.inserirUsername(arg0);
    }

    @And("preencho o campo senha com {string}")
    public void preenchoOCampoSenhaCom(String arg0) {
        myAccountPage.inserirPassword(arg0);
    }

    @And("clico no botão de login")
    public void clicoNoBotaoDeLogin() {
        myAccountPage.clicarLogin();
    }

    @Then("devo ser redirecionado para a tela de home")
    public void devoSerRedirecionadoParaATelaDeHome() {

    }

    @Then("devo ver a mensagem de erro {string}")
    public void devoVerAMensagemDeErro(String arg0) {
        Assert.assertTrue(myAccountPage.obterMensagemDeErro().contains(arg0));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @And("devo ver a mensagem de boas vindas com o usuário {string}")
    public void devoVerAMensagemDeBoasVindasComOUsuario(String arg0) {
        Assert.assertTrue(myAccountPage.obterMensagemBoasVindas().contains(arg0));
    }
}
