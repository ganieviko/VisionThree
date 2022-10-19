Feature: Filling up Product Module Page

  Background:
    Given setUp driver

  Scenario Outline: Filling Up form
    Given I navigate to Vision Three website "https://visionthree.com/"
    When I click Product button
    And I click 'lets' connect button
    And I filled out with <name> <email> <message> <captcha>
    And I click 'V3TOUCH' connect button and click submit
    Then I see the message <errorMessage>

    Examples:
      | name    | email                 | message       | captcha | errorMessage                             |
      | "Artur" | "ganieviko@yahoo.com" | "Let me join" | "12"    | "You entered the wrong number in captcha." |
      | "Artur" | "Nate@yahoo.com"      | "Let me join" | "12"    | "You entered the wrong number in captcha." |
      | "Artur" | "Greg@yahoo.com"      | "Let me join" | "12"    | "Invalid email"                          |