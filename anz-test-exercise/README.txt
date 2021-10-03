Running in eclipse :
Import the existing maven project
Right click -> Run As -> Maven test

Running in command line :
Go to folder location anz-test-exercise
Type mvn test


Results are saved as html report under anz-test-exercise/target/JunitReports/report.html
Note : Scenario 1 is failing because in excercise documentation borrowing amount for given values is given as $479,000 but actual amount after performing action in url is coming as 508,000


1. What other tests would you suggest could be written? You do not need to write
them out in detail or code them.
	Below are the few tests i would like to add :
		- Mandatory feild check
		- Invalid values including 0 and negative

2. If this test was part of a much larger test set, how would you speed it up?
	By building Regression suites and smoke suits

3. Sometimes UI tests can fail unpredictably. For example, the page may not have
fully loaded before test automation attempts to click a button on a webpage. How
would you improve reliability of these tests?
	- By adding Explicit Wait  to tell the Web Driver to wait for certain conditions (Expected Conditions) or maximum time exceeded before throwing exception.
	- Using Design Pattern to manage automated code.


