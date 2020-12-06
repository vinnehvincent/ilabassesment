Feature: Search Pets
  In order to get information about
  As as API user
  I would like to search information on the petstore API

  Scenario: Retrieve all pets and confirm the name and category
    Given  an actor named "Pearl"
    When she gets a list of pets
    Then the list should contain "doggie"
    And the category should be 12