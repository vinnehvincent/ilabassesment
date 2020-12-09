Feature: Dog API
  In order to find dog information
  As an api user
  I would like to be able to search the information on the api

  Scenario: A successful message is returned when a Ben searches for random breeds
    Given a user named "Ben" using Dog API
    When  Ben searches for random breeds
    Then  he should get a "success" status

  Scenario: Bulldog is on the list of all breeds
    Given a user named "Ben" using Dog API
    When Ben searches for the list of all breeds
    Then "bulldog" should be in the list

  Scenario: All sub-breeds for bulldogs and their respective images
    Given a user named "Ben" using Dog API
    When he searches for "bulldog" sub-breeds
    Then he should get a "success" status
    And he should get a list of images