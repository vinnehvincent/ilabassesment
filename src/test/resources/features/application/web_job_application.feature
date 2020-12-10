Feature: Job Application
  In order to be considered as an interview candidate
  As an I applicant
  I need to make an online application for the job

  Scenario: Relevant files are not uploaded
    Given "Vincent" applies for a job online
    When  he fills the form with the following information:
    |name   |email                               |
    |Vincent|automationAssessment@iLABQuality.com|
    And submits the form
    Then he should see the message "You need to upload at least one file."