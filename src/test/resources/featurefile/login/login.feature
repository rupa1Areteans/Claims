Feature: Login Test

  # Scenario: Verify Login with valid credentials
  #   Given navigate to application
  #   When enter username as "csinboundagent"
  #   And enter password as "rules"
  #   And click on login button
  #   Then Login is successful
  #   And user should logout
  Scenario: Test
    Given navigate to application
    When enter username as "csinboundagent"
    And enter password as "rules"
    And click on login button
    Then Login is successful
    And user clicks on New menu link
    Then user clicks on inbound call link
   #    Scenario Outline: Verify Login with invalid credentials
    #     Given navigate to application
    #     When enter username as "<Username>"
   #      And enter password as "<Password>"
   #      And click on login button
   #      Then Login should not be successful
   #     Examples:
    #   | Username | Password |
    #   | User1    | Pass1    |
     #  | User2    | Pass2    |
     #  | User3    | Pass3    |
