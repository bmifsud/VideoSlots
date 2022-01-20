Feature: Login
  @UI @login
  Scenario Outline: User attempt login with <Username> & <Password>, will the user be <Granted> access?
    Given the user opens Evernote homepage
    When the user clicks Login
    And the user fills the <Username> and presses continue
    And the user fills the <Password> and presses sign in
    Then depends on the credentials the user is or is not <Granted> access
    And the user exits with logout
    Examples:
      | Username                  | Password          | Granted |
      #Valid
      | Bernard.Mifsud@gmail.com   | q~Wk%R/XPNy~6<j   | true    |
      #Invalid
      | Bernard.Mifsud@gmail.com   | WrongPassword     | false   |
      | WrongUsenrame@gmail.com   | q~Wk%R/XPNy~6<j   | false   |
      #Test Validator (Test Expected to fail)
      #| BernardWrong@gmail.com    | q~Wk%R/XPNy~6<j   | true    |


