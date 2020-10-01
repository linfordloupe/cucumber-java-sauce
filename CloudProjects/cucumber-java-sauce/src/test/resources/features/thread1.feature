@Parallel
Feature: Scenarios feature file

  Scenario: Scenario Number One
    Given Step from 'Scenario 1' in 'scenarios' feature file
    And I print the scenario 'thread1'

  Scenario: Scenario Number Two
    Given Step from 'Scenario 2' in 'scenarios' feature file
    And I print the scenario 'thread1_2'