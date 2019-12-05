# AGLCodingChallenge

About the Project- 

This is a Java client that consumes a web service and processes the data returned by the service.

# Frameworks/Tools Used

1. Build tool - maven
2. JSON parser - org.json
3. Unit testing - JUnit 4
4. IDE - Eclipse

# Working

ConsumeWebService.java is the main class that contains the following three functions
1. getJSONfromService(String input_url) - sends a request to a webservice, gets a response and then returns the JSON object as a String
2.parseJSONResponse(String json_string, String gender, String pet_type) - parses the JSON and collects all pet names in an ArrayList based on pet type and owner gender
3. sortAndPrint(ArrayList<String> pet_names) - sorts and prints the array list
  
ConsumeWebServiceTest.java contains all unit test cases.

# Screenshots
Screenshots can be found in the 'screenshots' folder.
