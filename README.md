# 09-spring-rest-demo
Spring REST Learning Project.  
Create a REST Server that will use a list of students and show  one or all via endpoints in JSON format.

About the project:  
Maven project with java config.  
Two branches    

   - Second. Crate a java class for Student ; create a REST SERVICE that will return  JASON endpoints  
           - retrieve a list of students :  /api/students   
           - retrieve a single student:    /Api/students/{studentId}  
           - handling exception and return error as JSON  
   
   - First. REST demo java app.: com.andrei.jackson.json.demo.Driver.java - > run as java app.
      Employee.java class  set its variable by reading  a JSON file  

Learning notes:	   

  REST = Representational State Transfer  
  JSON = Java Script Object Notation  
  JAKSON Project – handle data binding between JSON and POJO

To crate a java object form a JSON file we create the java class with suitable fields and use JAKSON to do the binding.  
If we do not need all JSON fields we add @JsonIgnoreProperties(ignoreUnknown=true) on java class.


Rest API Naming conventions for endpoint: plural of the main resource/entity : 	/api/customers  
  
Don’t include actions in the endpoint, instead use http methods to assign actions(ex: Get, POST, PUT, DELETE) - ex: /api/customersList = wrong ; /api/customers = good    
  
Http method for Database action:  Post-CREATE, Get-READ, Put-UPDATE, Delete-DELETE

@PathVariable:  	public Student getStudent(@PathVariable int studentId)  
   -   retrieve path variable value from url

@RequestBody: 	 public Customer updateCustomer(@RequestBody Customer customer )  
   - retrieve JSON data from rest client

Error management:   
  - Error class,  simple java POJO that will be returns as  JSON  response in case of error;  
  - Exception class,   
  - Exception Handler class(bind exception with error)  



   1 JSON Data Binding with Jackson:
				-add java config two classes.
				- create DemoRestController
				- run as java application

	2 REST Controller  -pom.xml: add dependency: sping-webmvc, javax.servlet-api
				- create package :com.andrei.jakson.json.demo with three classes Employee.java, Adress.java, Driver.java 
				- pom.xml: only need jackson-databind dependency . No Spring .
				- run on server
	3 Spring REST Service – Students
			- pom.xml : javax.annotation-api (for @PostConstruct)  

[BACK TO START PAGE](https://github.com/FlorescuAndrei/Start.git) 

