package com.student.controller;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.student.model.Student;

public class StudentServiceTest {

	@Before
	public void setUp() throws Exception {
	}
		
	public  final String REST_SERVICE_URI = "http://localhost:8091/student";
    
    /* GET */
	@Test
    @SuppressWarnings("unchecked")
    public  void listAllStudents(){
        System.out.println("Testing listAllStudents API-----------");
         
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> studentsMap = restTemplate.getForObject(REST_SERVICE_URI+"/get", List.class);
         
        if(studentsMap!=null){
            for(LinkedHashMap<String, Object> map : studentsMap){
                System.out.println("Student : id="+map.get("id")+", Name="+map.get("name")+", Age="+map.get("age")+", Salary="+map.get("salary"));;
            }
        }else{
            System.out.println("No Student exist----------");
        }
    }
     
    /* GET */
    @Test
    public  void getStudent(){
        System.out.println("Testing getStudent API----------");
        RestTemplate restTemplate = new RestTemplate();
        Student Student = restTemplate.getForObject(REST_SERVICE_URI+"/1", Student.class);
        System.out.println(Student);
    }
     
    /* POST */
    public  void createStudent() {
        System.out.println("Testing create Student API----------");
        RestTemplate restTemplate = new RestTemplate();
        Student student = new Student();
        student.setId(1);
        student.setName("Naresh");
        student.setAddress("epam");
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/create", student, Student.class);
        System.out.println("Location : "+uri.toASCIIString());
    }
 
    /* PUT */
    @Test
    public  void updateStudent() {
        System.out.println("Testing update Student API----------");
        RestTemplate restTemplate = new RestTemplate();
        Student student  = new Student();
        student.setId(1);
        student.setName("sathish");
        student.setAddress("epam");
        restTemplate.put(REST_SERVICE_URI+"update", student);
        System.out.println(student);
    }
 
    /* DELETE */
    @Test
    public  void deleteStudent() {
        System.out.println("Testing delete Student API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/3");
    }
 
 
    /* DELETE */
    @Test
    public  void deleteAllStudents() {
        System.out.println("Testing all delete Students API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/");
    }
 

}
