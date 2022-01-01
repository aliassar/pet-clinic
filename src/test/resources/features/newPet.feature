Feature: Add new pet

  Background: Sample General Preconditions Explanation
    Given There is some predefined pet types like "dog"

  Scenario: Add new pet
    Given There is a pet owner called "Amu Gholam"
    When He performs new pet service to add a pet on his list
    Then The pet is saved successfully
