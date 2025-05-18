Feature: Vehicle details

  @test
  Scenario: Validate vehicle details on car-checking website
    Given extract all vehicle registration numbers present in "car_input - V6.txt" file
    When user navigate to vehicle valuation website "https://car-checking.com"
    Then user should be on the car checking homepage
    Then user verifies vehicle details from file "car_output - V6.txt"

