package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.MyAccountPage;
import utils.WebDriverFactory;

public class CadastroSteps {
    WebDriver driver;
    MyAccountPage myAccountPage;
    @Before
    public void setup() {
        driver = WebDriverFactory.createDriver();
        myAccountPage = new MyAccountPage(this.driver);
    }

    //Cenario: Cadastro com sucesso
    @Given("eu estou na pagina de cadastro")
    public void euEstouNaPaginaDeCadastro() {
        this.driver.get("https://practice.automationtesting.in/my-account/");
        Assert.assertEquals("My Account – Automation Practice Site", this.driver.getTitle());
    }

    @When("eu preencho o campo email com {string}")
    public void euPreenchoOCampoEmailCom(String string) {
        this.myAccountPage.inserirEmail(string);
    }

    @And("eu preencho o campo senha com {string}")
    public void euPreenchoOCampoSenhaCom(String string) {
        this.myAccountPage.inserirPasswordRegister(string);
    }

    @And("eu clico no botao de cadastrar")
    public void euClicoNoBotaoDeCadastrar() {
        this.myAccountPage.clicarRegister();
    }

    @Then("eu devo ser redirecionado para a pagina de login")
    public void euDevoSerRedirecionadoParaAPaginaDeLogin() {
        //deve verificar se na pagina atual tem o texto "Hello"
        Assert.assertTrue(this.myAccountPage.obterMensagemBoasVindas().contains("Hello"));
    }

    //Cenario 2: Cadastro com email invalido

    @Then("eu devo ver uma mensagem de erro")
    public void euDevoVerUmaMensagemDeErro() {
        //deve verificar se na pagina atual tem o texto "Error"
        Assert.assertTrue(this.myAccountPage.obterMensagemDeErro().contains("Error"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Then("eu devo ver uma mensagem {string}")
    public void euDevoVerUmaMensagem(String arg0) {
    }

    @Then("eu devo ver uma mensagem de erro {string}")
    public void euDevoVerUmaMensagemDeErro(String arg0) {
    }
}
