Feature: Skeleton feature

  Scenario: Skeleton scenario
    Given the following create skeleton request is made
      | name | bones |
      | name | 206   |
    Then the following entities exist in the skeleton table
      | name | bones |
      | name | 206   |
    And the response status code is 201
    And the skeleton create response has the following body
      | name | bones |
      | name | 206   |
    And the following message is published to skeleton-v1 topic
      | name | bones |
      | name | 206   |
