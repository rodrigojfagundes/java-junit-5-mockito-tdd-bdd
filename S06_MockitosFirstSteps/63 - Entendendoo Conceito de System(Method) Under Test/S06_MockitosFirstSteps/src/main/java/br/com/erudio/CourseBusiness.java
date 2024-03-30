package br.com.erudio;

import java.util.ArrayList;
import java.util.List;

import br.com.erudio.service.CourseService;

//criando a classe COURSEBUSINESS q vai IMPLEMENTAR A INTERFACE COURSESERVICE...
//O COURSEBUSINESS vai ser o nosso SYSTEM UNDER TEST (tbm conhecido como METHOD UNDER TEST)
//
public class CourseBusiness {
	
	private CourseService service;

	public CourseBusiness(CourseService service) {
		this.service = service;
	}	
	
	//Metodo que recebe um Student e retorna a quantidade de CURSOS com SPRING no NOME
	public List<String> retrieveCoursesRelatedToSpring(String student){

		var filteredCourses = new ArrayList<String>();
		var allCourses = service.retrieveCourses(student);
		
		for (String course : allCourses) {
			if(course.contains("Spring")) {
				filteredCourses.add(course);
			}
			
		}
		
		
		return filteredCourses;
	}
	
	
}
