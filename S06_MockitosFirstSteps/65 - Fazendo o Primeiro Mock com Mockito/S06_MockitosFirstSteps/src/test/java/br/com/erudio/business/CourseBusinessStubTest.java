package br.com.erudio.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.erudio.service.CourseService;
import br.com.erudio.services.stubs.CourseServiceStub;

class CourseBusinessStubTest {
	
	
	//test[System Under Test]_[Condition or State Change]_[Expected Result]

	//Metodo para testar se apos passar um Student esta retornando apenas cursos com Spring no nome 
	@Test
	void testCourseRelatedToSpring_When_UsingAStub() {
		
		//Given / Arrange
		CourseService stubService = new CourseServiceStub();
		CourseBusiness business = new CourseBusiness(stubService);
		
		//When / Act
		var filteredCourses = business.retrieveCoursesRelatedToSpring("Leandro");
			
		//Then / Assert
		assertEquals(4, filteredCourses.size());
		
	}
	
	
	//criando o TEST para RETORNAR NADA se passar um NOME DIFERENTE DE LEANDRO
	//no caso sera passado o nome FOO BAR
	@Test
	void testCourseRelatedToSpring_When_UsingAFooBarStudent() {
		
		//Given / Arrange
		CourseService stubService = new CourseServiceStub();

		CourseBusiness business = new CourseBusiness(stubService);
		
		//When / Act
		var filteredCourses = business.retrieveCoursesRelatedToSpring("Foo Bar");
				
		//Then / Assert
		assertEquals(0, filteredCourses.size());
		
	}
}