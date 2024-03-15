Feature: Login
  Scenario: Realizar o login com falha
    Given que eu estou na página de login
    When eu preencho o campo de usuario com "teste¨
    And eu preencho o campo password com "teste"
    And eu clico no botão "Login"
    Then eu devo ver uma mensagem de erro "Invalid email or password"