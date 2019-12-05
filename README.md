# AGLCodingChallenge

About the Project- 

1. This is a Java client that calls a web service, parses the returned JSON object and outputs a list of all the cats in alphabetical order under a heading of the gender of their owner.
2. The code has been made generic and modular resulting in efficient code reuse. 
3. Comments have been added throughout the project to enhance readability and maitainability of code.
4. Java's Collection Framework has been used to handle JSON objects.
5. Unit tests have been written using JUnit Library.

# Frameworks/Tools Used

1. Build tool - maven
2. JSON parser - org.json
3. Unit testing - JUnit 4
4. IDE - Eclipse
5. Source Control - Git (Sourcetree)

# Working

ConsumeWebService.java is the main class that contains the following three functions
1. getJSONfromService(String input_url) - sends a request to a webservice, gets a response and then returns the JSON object as a String.
2. parseJSONResponse(String json_string, String gender, String pet_type) - parses the JSON and collects all pet names in an ArrayList based on pet type and owner gender.
3. sortAndPrint(ArrayList<String> pet_names) - sorts and prints the array list.
  
ConsumeWebServiceTest.java contains all unit test cases.

# Screenshots
Screenshots can be found in the 'screenshots' folder.

