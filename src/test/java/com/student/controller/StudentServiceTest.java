package com.student.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.student.model.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class StudentServiceTest {

	@Autowired
	StudentController studentController;

	private RestTemplate testRestTemplate;

	public final String REST_SERVICE_URI = "http://localhost:" + 8092 + "/student";

	@Before
	public void setUp() throws Exception {
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		messageConverters.add(converter);
		converter.setSupportedMediaTypes(
				Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN));
		testRestTemplate = new RestTemplate();
		testRestTemplate.setMessageConverters(messageConverters);
		//load 2 student values
		for (int i = 0; i < 2; i++) {
			Student student = new Student();
			student.setName("naresh" +i);
			student.setAddress("hyderabad" +i);
			student.setClasses("X" + i);
			studentController.createStudent(student);
		}

	}

	/* GET */
	@Test
	@SuppressWarnings("unchecked")
	public void listAllStudents() {
		System.out.println("Testing listAllStudents API-----------");

		List<LinkedHashMap<String, Object>> studentsMap = testRestTemplate.getForObject(REST_SERVICE_URI + "/get",
				List.class);

		if (studentsMap != null) {
			for (LinkedHashMap<String, Object> map : studentsMap) {
				System.out.println("Student : id=" + map.get("id") + ", Name=" + map.get("name") + ", Address="
						+ map.get("address") + ", Class=" + map.get("classes"));
			}
		} else {
			System.out.println("No Student exist----------");
		}
	}

	/* GET */
	@Test
	public void getStudent() {
		System.out.println("Testing getStudent API----------");

		Student Student = testRestTemplate.getForObject(REST_SERVICE_URI + "/1", Student.class);
		System.out.println(Student);
	}

	/* POST */
	public void createStudent() {
		System.out.println("Testing create Student API----------");

		Student student = new Student();
		student.setId(1);
		student.setName("Naresh");
		student.setAddress("epam");
		URI uri = testRestTemplate.postForLocation(REST_SERVICE_URI + "/create", student, Student.class);
		System.out.println("Location : " + uri.toASCIIString());
	}

	/* PUT */
	@Test
	public void updateStudent() {
		System.out.println("Testing update Student API----------");

		Student student = new Student();
		student.setId(1);
		student.setName("sathish");
		student.setAddress("epam");
		testRestTemplate.put(REST_SERVICE_URI + "/update", student);
		System.out.println(student);
	}

}
