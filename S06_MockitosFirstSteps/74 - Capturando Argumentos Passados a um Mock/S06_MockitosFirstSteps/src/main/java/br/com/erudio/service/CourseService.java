package br.com.erudio.service;

import java.util.List;


public interface CourseService {

	public List<String> retrieveCourses (String student);

	public List<String> doSomeThings (String student);
	
	public void deleteCourse(String course);
	
}
