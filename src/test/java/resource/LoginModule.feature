# Use Case 1
Feature: User Logged into the application
Scenario: Login Valid Use Case
Given a new user is on the website "http://automationpractice.com/index.php"
When the user clicks Signin
And user enters signin details
Then user is logged in
# Use Case 2
Scenario: Find the most expensive dress and add it to the cart
Given a new user is on the website "http://automationpractice.com/index.php"
Then user validate and adds expensive dress into the cart
When the user clicks Signin
And user enters signin details
Then user is logged in
#  Use Case 3
Scenario: User Log out and backs in again, ensuring the dress is still in the cart
Given a new user is on the website "http://automationpractice.com/index.php"
When the user clicks Signin
And user enters signin details
Then user is logged in
And validate the item in cart