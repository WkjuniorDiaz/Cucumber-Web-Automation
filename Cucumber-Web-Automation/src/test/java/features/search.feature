Feature: Search for a flight

  Background:
    Given user close switch modal


  @Search
  Scenario Outline: User search for a flight with Origin - Destination
    Given user select type of trip <trip>
    And user select type of cabin <cabin>
    When user select origin field
    And user type origin <origin>
    Examples:
      | trip | cabin | origin |
      | "Round Trip" | "Economy"  | "Bogota" |
