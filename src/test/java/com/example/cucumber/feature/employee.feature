Feature: List of stories/BR

  Background:
    Given an employee works here
      | Person  |
      | Tiger   |
      | Garrett |
      | Ashton  |
      | Abebe   |

  Scenario Outline: just test the DB

    When the api is invoked
    Then the response code is "<status Code>"
    And an employee with "<id>" with "<salary>"
    And with "<first name>" with "<last name>"
    And "<age>" years old
    And employee "<name>"
    And returned value is "<is saved>"

    Examples:
      | id | salary | first name | last name | status Code | age |
      | 1  | 320800 | Tiger      | Nixon     | success         | 61  |
      | 2  | 170750 | Garrett    | Winters   | success         | 63  |
      | 3  | 86000  | Ashton     | Cox       | success         | 66  |