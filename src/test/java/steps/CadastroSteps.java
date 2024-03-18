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
    public void eu_estou_na_pagina_de_cadastro() {
        this.driver.get("https://practice.automationtesting.in/my-account/");
        Assert.assertEquals("My Account – Automation Practice Site", this.driver.getTitle());
    }

    @When("eu preencho o campo email com {string}")
    public void eu_preencho_o_campo_email_com(String string) {
        this.myAccountPage.inserirEmail(string);
    }

    @And("eu preencho o campo senha com {string}")
    public void eu_preencho_o_campo_senha_com(String string) {
        this.myAccountPage.inserirPasswordRegister(string);
    }

    @And("eu clico no botao de cadastrar")
    public void eu_clico_no_botao_de_cadastrar() {
        this.myAccountPage.clicarRegister();
    }

    @Then("eu devo ser redirecionado para a pagina de login")
    public void eu_devo_ser_redirecionado_para_a_pagina_de_login() {
        //deve verificar se na pagina atual tem o texto "Hello"
        Assert.assertTrue(this.myAccountPage.obterMensagemBoasVindas().contains("Hello"));
    }

    //Cenario 2: Cadastro com email invalido

    @Then("eu devo ver uma mensagem de erro")
    public void eu_devo_ver_a_mensagem_de_erro() {
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
