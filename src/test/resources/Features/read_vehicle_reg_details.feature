Feature: As a user of DVLA site, I want to go through all vehicles from my csv file so that I can match them with the expected output on the DVLA site.

  Scenario:
        Given I am on the Get vehicle information from DVLA page
        When I click on Start Now
        And I Enter a vehicle Registration
        And I click on continue
        Then the details of the vehicle should be correctly displayed