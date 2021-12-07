package com.andrei.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
//Only need jackson-databind dependency in pom.xml. No Spring . Run as java application. 
//All this package is for first REST example
public class Driver {

	public static void main(String[] args) {
		
		try {
			//create object mapper
			
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON file and map/convert to Java POJO
			Employee employee = mapper.readValue(new File("data/sample-full.json"), Employee.class);
			
			System.out.println("First name: " + employee.getFirstName());
			
			Address address = employee.getAddress();
			System.out.println("City: " + address.getCity());
			
			for(String language: employee.getLanguages()) {
				System.out.println(language);
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
