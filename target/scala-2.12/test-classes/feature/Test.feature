Feature: Web UI testing

  Background:
    Given I navigate to the test website

  Scenario: Happy Path - Adding politicians to database
    When I enter the Politician name 'Terry Lawrence'
    Then  I enter the country 'Spain'
    And I enter the date of birth of 4-7-19
    Then  I enter the position 'MP of Yorkshire'
    Then I enter the source URL 'https://testingtest.co.uk'
    And I select the Risk level to be 'Low'
    And I click on the save button
    Then a pop up will appear


