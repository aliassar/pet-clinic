Feature: Find Pet

  Background: Sample General Preconditions Explanation
    Given There is some predefined pet types like "dog"

  Scenario: Pet is there
    Given There is at least one pet with name like "Meow"
    When Someone performs find pet service to find a pet with id "0"
    Then The pet is found successfully

