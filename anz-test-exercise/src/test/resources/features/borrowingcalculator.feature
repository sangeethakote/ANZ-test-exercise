Feature: Borrowing calculator

  Scenario: Check Borrowing estimate
    Given I am a user trying to understand ‘How much can I borrow’ using home loan calculator page of ANZ
    And I have entered relevant information in each required field <applicationtype> , <dependents> , <buyinghometo> , <income> , <otherincome> , <livingexpenses> , <currentrepayments> , <otherrepayments> , <commitments> , <creditcardlimits>
    When I click on ‘Workout how much I could borrow’ button
    Then I should see the borrowing estimate displayed as '$479,000'
    Examples: 
    | applicationtype | dependents | buyinghometo | income | otherincome | livingexpenses | currentrepayments | otherrepayments | commitments | creditcardlimits |
		| Single          | '0'        | live in      | '80000'  | '10000'   | '500'          |  '0'              | '100'           | '0'         | '10000'            |    
		
	Scenario: Clear the fields and start over
		Given I am a user trying to understand ‘How much can I borrow’ using home loan calculator page of ANZ
		And I have entered relevant information in each required field '80000' , '10000' , '500' , '0' , '100' , '0' , '10000'
		And I can see the result as per the data entered
		When I click on ‘Start over’ button 
		Then I should see all the data I entered is cleared and the page is refreshed with fields being sets their default values <applicationtype>, <dependents> , <buyinghometo> , <income> , <otherincome> , <livingexpenses> , <currentrepayments> , <otherrepayments> , <commitments> , <creditcardlimits>  
		Examples: 
    | applicationtype | dependents | buyinghometo      | income | otherincome | livingexpenses | currentrepayments | otherrepayments | commitments | creditcardlimits |
		| 'Single'        | '0'        | 'Home to live in' | '0'    | '0'         | '0'            |  '0'              | '0'             | '0'         | '0'              |    
		
	Scenario: Show unable to estimate message
	Given I am a user trying to understand ‘How much can I borrow’ using home loan calculator page of ANZ
	And I have entered Living expenses as '1'
	And leave all other fields to their default values
	When I click on the ‘Workout how much I could borrow’ button
	Then I should see the message  'Based on the details you\'ve entered, we\'re unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500.' 
	