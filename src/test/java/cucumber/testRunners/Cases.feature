@Regression
Feature: Cases

  Scenario: To verify login in Salesforce
    Given I am on the Salesforce login page
    When I navigate to "https://www.test.salesforce.com"
    Then I wait for 25 seconds and refresh the page

