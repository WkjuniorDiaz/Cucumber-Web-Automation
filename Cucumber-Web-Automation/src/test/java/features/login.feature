Feature: Login

  Scenario Outline: User log in to salesforce
    When user type username <username>
    And user type password <password>
    And user select button login
    Then user log into setup page
    Examples:
      | username | password |
      | "test" | "test" |