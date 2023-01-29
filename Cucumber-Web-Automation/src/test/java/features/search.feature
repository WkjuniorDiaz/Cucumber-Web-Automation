Feature: Search for a flight

  Background:
    Given user close switch modal


  @Search @Regression @Smoke
  Scenario Outline: User search for a flight with Origin - Destination
    Given user select type of trip <trip>
    And user select type of cabin <cabin>
    When user select origin field
    And user type origin <origin>
    And user select destination origin <origin>
    And user type destination <destination>
    And user select destination <destination>
    And user select departure field
    And user select departure date <departureDate>
    And user select return date <returnDate>
    And user select search button
    And user close switch modal
    Then title of available flights page is displayed
    And user should see available flight list

    Examples:
      | trip | cabin | origin | destination | departureDate | returnDate |
      | "Round Trip" | "Economy"  | "Bogota" | "Santiago de chile" | "February 16, 2023" | "February 28, 2023" |
