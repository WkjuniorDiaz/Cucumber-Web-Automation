Feature: Booking a flight

  Background:
    Given user close switch modal

  Scenario Outline: TC - User book for a flight
    Given user search for a flight with origin <origin>, destination <destination>, departure date <departureDate> and return date <returnDate>
    When choose a departure flight base on start feature <starFeature> of the flight
    And select type of luggage <luggage>
    And choose a return flight base on start feature <starFeature> of the flight
    And select type of luggage <luggage>
    And select button to select seats
    And user continue the booking process choosing to select seats later
    And user continue to payment options

    Examples:
      | origin | destination | departureDate | returnDate | luggage | starFeature |
      | "Bogota" | "Santiago de chile" | "March 24, 2023" | "March 28, 2023" | "plus" | "Earlier" |


