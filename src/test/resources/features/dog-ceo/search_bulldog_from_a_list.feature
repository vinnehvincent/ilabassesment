Feature: Dog API
  In order to find dog information
  As an api user
  I would like to be able to search the information on the api

  Scenario: A successful message is returned when a user searches for random breeds
    Given a user named "Ben"
    When  Ben searches for random breeds
    Then  he should get a "success" status