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
      | name      | email                 | message                | captcha | errorMessage                               |
      | "Artur"   | "ganieviko@yahoo.com" | "Let me join"          | "12"    | "You entered the wrong number in captcha." |
      | "Maximus" | "Nate@yahoo.com"      | "You company the best" | "12"    | "You entered the wrong number in captcha." |
      | "Miles"   | "Greg@yahoo.com"      | "Let me be your team"  | "12"    | "Invalid email"                            |
      | "Chris"   | "Chris@yahoo.com"     | "Let me be your team"  | "12"    | "You entered the wrong number in captcha." |