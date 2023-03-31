Feature: Database

  Scenario: Database works
    Given the database is empty
    When entities are created and saved
    Then the entities exist in the database

  Scenario: Database resets
    Then the database is empty
