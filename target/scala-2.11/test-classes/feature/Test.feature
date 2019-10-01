Feature: Web UI testing

  Scenario: Happy Path - Adding politicians to database
    Given I navigate to the test website
    When  I enter the Politician name 'Terry Lawrence'
    Then  I enter the country 'Spain'
    And   I enter the date of birth of 4-7-2019
    Then  I enter the position 'MP of Yorkshire'
    Then  I enter the source info URL 'https://testingtest.co.uk'
    And   I select the Risk level to be 'HUGE'
    And   I click on the save button
    Then  a pop up will appear and the name will be correct

#  Scenario: Testing put endpoint
#    Given I have added a politician to the database via the API
#    Then I can retrieve the latest 5 politicians
#    Then I grab the latest Politician from the list



