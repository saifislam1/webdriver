Feature: Salesforce API Testing

  Scenario: Verify the api
    Given I am authorized to access the Salesforce API
    When I send a POST request to create a new record with the following data:
      | field1 | value1 |
      | field2 | value2 |
    Then The response code should be 201
    And The response should contain the new record ID
