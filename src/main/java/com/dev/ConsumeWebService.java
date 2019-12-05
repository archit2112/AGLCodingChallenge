package com.dev;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;

import org.json.JSONArray;
import org.json.JSONException;


public class ConsumeWebService {
	
	//function that sends a request to a webservice, gets a response and then return the JSON object as a String
    public String getJSONfromService(String input_url){
    	String JSON_string="";
    	
    	try {
    		//URL to be supplied
    		URL url = new URL(input_url);
    		//Create a connection
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//Setting parameters
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			//if the webservice is not found or unexpected response is received
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			//Get the stream
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			//System.out.println("Output from Server .... \n");
			//Parse the stream and get the final JSON string
			while ((output = br.readLine()) != null) { 
				//System.out.println("1");
				//System.out.println(output);
				JSON_string = JSON_string + output;
			}
			//Close the connection
			conn.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	//System.out.println("2");
    	return JSON_string;
    }
	
    //funtion that parses the JSON and collects all pet names in an ArrayList based on pet type and owner gender
    public ArrayList<String> parseJSONResponse(String json_string, String gender, String pet_type){
    	System.out.println(gender.toUpperCase());
    	ArrayList<String> pet_names = new ArrayList<String>();
    	try {
			JSONArray jsonArray = new JSONArray(json_string);
			  for (int i = 0; i < jsonArray.length(); i++) {
				  //get all json objects for a particular owner gender - male or female
		           if(jsonArray.getJSONObject(i).getString("gender").equalsIgnoreCase(gender)) {
		        	   //check if the owner has pets (check if "pets" field is an array)
		        	   if(jsonArray.getJSONObject(i).getString("pets") != "null"){
		        		   JSONArray jsonArray_pets = jsonArray.getJSONObject(i).getJSONArray("pets");
			        	   for (int j = 0; j < jsonArray_pets.length(); j++) {
			        		   //get names of pet of a particular type (in this case - cats) that belong to a particular owner gender
			        		   if(jsonArray_pets.getJSONObject(j).getString("type").equalsIgnoreCase(pet_type)){
			        			   pet_names.add(jsonArray_pets.getJSONObject(j).getString("name"));
			        		   }
			        	   }
		        	   }  		        	   
		           }		        	  
		        }
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return pet_names;   	
    }
	
    //sorts and prints the array list
    public void sortAndPrint(ArrayList<String> pet_names){
    	Collections.sort(pet_names);
    	int count = 1;
    	for (String element : pet_names) {
    	    System.out.println(" "+ count +". "+ element);
    	    count++;
    	} 	
    	System.out.println(" ");
    }
    
    public static void main(String[] args){
		ConsumeWebService cws = new ConsumeWebService();
		
		String service_url = "http://agl-developer-test.azurewebsites.net/people.json";
		//Call the function get the JSON String from the web service
		String JSON_String = cws.getJSONfromService(service_url); 
		
		//Call the function to Parse JSON string for owner gender = male and pet type = cat
		ArrayList<String> pet_names_unordered_male = cws.parseJSONResponse(JSON_String, "Male","cat");
		//call the function to sort and print pet names
		cws.sortAndPrint(pet_names_unordered_male);
		
		//Repeat above steps for gender = Female and pet type = cat
		ArrayList<String> pet_names_unordered_female = cws.parseJSONResponse(JSON_String, "Female","cat");
		cws.sortAndPrint(pet_names_unordered_female);
		
	}

}
