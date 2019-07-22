
Feature: To verify API automation with Rest Assured

@API_Test  
Scenario: To verify success for correct employee code
Given User calls web service to get Employees
When  a user retrieves the Employees List 
Then Respose status code should be "200"

@API_Test @test
Scenario: To verify success for correct employee code
Given User calls web service to get Employees
When To initiate Rest service to get employee details with code as "17479"
Then Respose status code should be "200"

@API_Test
Scenario Outline: To verify error for incorrect employee code
Given User calls web service to get Employees
When To initiate Rest service to get employee details with code as <id> 
Then Respose status code should be "400"

Examples:
   |id     | 
   | @#$$  |
   | aa45  |
   | 153615|
   | BG    |   
   
@API_Test 
Scenario Outline: To verify error for incorrect employee code
Given User calls web service to get Employees
When To initiate Rest service to get employee details with code as
Then Respose status code should be "400"

Examples:
   | id   | Password |
    | 12345 | Test@153 |
    |435676 | Test@154 |
  
  