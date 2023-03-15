Feature: Retrieve information about Star Wars characters from the Star Wars API

  Scenario: Retrieve information about Luke Skywalker by ID
    Given the base URL is "https://swapi.dev/api/"
    When I search the character with ID "1"
    Then the response status code should be 200
    And the response should contain the name "Luke Skywalker"
    And the response should contain the gender "male"
