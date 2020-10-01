@Test2 @Regression
Feature: This is another kickass feature test

  @test
  Scenario: some more quality testing here!
    Given I click the forgot password link
    When I select the retrieve password button
    Then The email sent message is displayed
    And I print the scenario 'Test2'