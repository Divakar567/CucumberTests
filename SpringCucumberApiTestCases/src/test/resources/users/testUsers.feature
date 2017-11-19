Feature: checking Users API
	Scenario: Sending GET request to /users/ for registering user List
		When get request sent to this URI http://localhost:8000/2016101819336/users/
    	Then check the response Http status code as 200
    	And check the get response is Success
    
  	Scenario: Sending POST request to /users/ for registering user
    	When the user is new user
    	Then check the response Http status code as 400
    	And check the post response as {"status":"failed","response":"users.user_actions.post.email_already_exist"}