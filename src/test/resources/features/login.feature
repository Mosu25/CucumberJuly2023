Feature: User Authentication tests

#  Background:
#    And User click on the login link

  Scenario: Login should be success
    And User enter the username as "Mosu2023"
    And User enter the password as "Welcome@2023"
    When User click on the login button
    Then Login should be success

  Scenario: Login should not be success
    Given User enter the username as "Mosu2023"
    Given User enter the password as "Welcome@23"
    When User click on the login button
    But Login should fail