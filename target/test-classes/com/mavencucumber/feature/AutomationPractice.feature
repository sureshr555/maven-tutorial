      @AutomationPractice
      Feature: AutomationPractice End To End TestCase
      Scenario: Verify User Is Able To Log In To The Application 
      Given User launched the automationpratice.com  application
      When User clicks on signin button in the header
      And User enters email id in signin page 
      And User enters password in signin page
      And User clicks signin button in signin page
      Then User verify the username in the header
      
      @LogInwithStepData
      Scenario: Verify User Is Able To Login The Application with step data
      Given User launched the automationpratice.com  application
      When User clicks on signin button in the header
      And User enter emailid 'kkgan@gmail.com' in the signin page
      And User enter password 'qwerty' in the signin page
      And User clicks signin button in signin page
      Then User verify username 'kakkaak dadaefa' displayed in the header
      @LogInWithExampleKeyword
      Scenario Outline: Verify user can login with datatable
      Given User launched the automationpratice.com  application
      When User clicks on signin button in the header
      And User enter emailid '<EmailId>' in the signin page
      And User enter password '<Password>' in the signin page
      And User clicks signin button in signin page
      Then User verify username '<UserName>' displayed in the header
      
      Examples:
      |EmailId|Password|UserName|
      |kkgan@gmail.com|qwerty|kakkaak dadaefa|
      |mahesathya12@gmail.com|121291|Sathya Mahe|
      
     