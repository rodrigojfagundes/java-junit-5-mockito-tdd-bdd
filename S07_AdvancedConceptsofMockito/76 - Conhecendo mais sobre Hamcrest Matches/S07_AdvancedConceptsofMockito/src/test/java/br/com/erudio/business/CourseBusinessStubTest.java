package br.com.erudio.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.erudio.service.CourseService;
import br.com.erudio.services.stubs.CourseServiceStub;

class CourseBusinessStubTest {
		
	//criando o TEST para saber a quantidade de CURSOS com SPRING no NOME
	//
	//test[System Under Test]_[Condition or State Change]_[Expected Result]
	@Test
	void testCourseRelatedToSpring_When_UsingAStub() {
		
		//Given / Arrange
		
		//definir a estrutura, criando um COURSESERVICE de nome STUBSERVICE q recebe um
		//COURSESERVICESTUB q é onde esta a LISTA de COURSE mockada...
		CourseService stubService = new CourseServiceStub();
		
		//criando uma instancia de COURSEBUSINESS de nome BUSINESS q ira receber o retorno
		//de COURSEBUSINESS passando o nosso OBJ/VAR STUBSERVICE q é o OBJ/VAR q tem a LISTA
		//de CURSOS
		CourseBusiness business = new CourseBusiness(stubService);
		var filteredCourses = business.retrieveCoursesRelatedToSpring("Leandro");
			
		//Then / Assert
		assertEquals(4, filteredCourses.size());
	}
	
	//test[System Under Test]_[Condition or State Change]_[Expected Result]
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