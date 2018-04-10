Feature:
As a user
I want to login crm system
So that I can add note to case

Scenario: Add note to case
  Given I create a case on crm
  When I open the broswer
  And I enter to crm address http://crm-test.uprightlaw.com
  And I login with admin account
  And I find the case
  And I add a note
  And I find note in note&activity
  Then I close broswer and delete data