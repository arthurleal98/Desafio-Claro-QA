Feature: Cadastro
  Scenario: Cadastro com sucesso
    Given eu estou na pagina de cadastro
    When eu preencho o campo email com "arthur1@arthur.com"
    And eu preencho o campo senha com "Arthur_Leal98"
    And eu clico no botao de cadastrar
    And eu devo ser redirecionado para a pagina de login
    Then eu devo ver uma mensagem "Cadastro realizado com sucesso"



    Scenario: Cadastro com email invalido
    Given eu estou na pagina de cadastro
    When eu preencho o campo email com "arthur1"
    And eu preencho o campo senha com "Teste@12345"
    And eu clico no botao de cadastrar
    Then eu devo ver uma mensagem de erro "Email invalido"

    Scenario: Cadastro com senha invalida
    Given eu estou na pagina de cadastro
    When eu preencho o campo email com "arthur1@arthur.com"
    And eu preencho o campo senha com "arthur"
    And eu clico no botao de cadastrar
    Then eu devo ver uma mensagem de erro "Senha invalida"

    Scenario: Cadastro com email ja cadastrado
    Given eu estou na pagina de cadastro
    When eu preencho o campo email com "arthur1@arthur.com"
    And eu preencho o campo senha com "Teste@12345"
    And eu clico no botao de cadastrar
    Then eu devo ver uma mensagem de erro "Email ja cadastrado"