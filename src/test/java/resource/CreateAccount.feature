Feature: Create Account Module

#Use Case 1
 Scenario:  Create a new account
 Given a new user is on the website "http://automationpractice.com/index.php"
 When the user clicks Signin
 Then they see option to create a new account
 And  enters the details to register
 Then user is registered
