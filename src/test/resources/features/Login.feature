Feature: Login
  Scenario: Realizar login com sucesso
    Given que estou na tela de login
    When preencho o campo login com "teste"
    And preencho o campo senha com "teste"
    And clico no botão de login
    Then devo ser redirecionado para a tela de home
    And devo ver a mensagem de boas vindas com o usuário "teste"

    Scenario: Realizar login com falha
    Given que estou na tela de login
    When preencho o campo login com "teste"
    And preencho o campo senha com "teste"
    And clico no botão de login
    Then devo ver a mensagem de erro "Usuário ou senha inválidos"

      Scenario: Realizar login com campo login vazio
    Given que estou na tela de login
    When preencho o campo senha com "teste"
    And clico no botão de login
    Then devo ver a mensagem de erro "O campo login é obrigatório"

Scenario: Realizar login com campo senha vazio
    Given que estou na tela de login
    When preencho o campo login com "teste"
    And clico no botão de login
    Then devo ver a mensagem de erro "O campo senha é obrigatório"

  Scenario: Realizar login com campo login e senha vazios
    Given que estou na tela de login
    When clico no botão de login
    Then devo ver a mensagem de erro "O campo login é obrigatório"
    And devo ver a mensagem de erro "O campo senha é obrigatório"
