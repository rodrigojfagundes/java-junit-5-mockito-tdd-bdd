package br.com.erudio.business;

import java.util.ArrayList;
import java.util.List;

import br.com.erudio.service.CourseService;

public class CourseBusiness {
	
	private CourseService service;
	
	public CourseBusiness(CourseService service) {
		this.service = service;
	}	
	
	//Metodo que recebe um Student e retorna os CURSOS com SPRING no NOME
	public List<String> retrieveCoursesRelatedToSpring(String student){

		var filteredCourses = new ArrayList<String>();
		if ("Foo Bar".equals(student)) return filteredCourses;
		var allCourses = service.retrieveCourses(student);
		for (String course : allCourses) {
			if(course.contains("Spring")) {
				filteredCourses.add(course);
			}
		}
		return filteredCourses;
	}
	
	public void deleteCoursesNotRelatedToSpring(String student){

		var allCourses = service.retrieveCourses(student);

		for (String course : allCourses) {
			if(!course.contains("Spring")) {
				service.deleteCourse(course);
			}
			
		}
		
		
		
	}
	
	
	
	
	
	
}
