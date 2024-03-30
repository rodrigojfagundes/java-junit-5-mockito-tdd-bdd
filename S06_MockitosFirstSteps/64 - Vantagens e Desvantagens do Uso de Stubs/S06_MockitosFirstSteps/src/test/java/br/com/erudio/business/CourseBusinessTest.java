package br.com.erudio.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.erudio.service.CourseService;
import br.com.erudio.services.stubs.CourseServiceStub;

class CourseBusinessTest {
	

	//test[System Under Test]_[Condition or State Change]_[Expected Result]
	
	//criando o TEST que recebe um Student e retorna a quantidade de CURSOS com SPRING no NOME
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
	
	
	//Metodo de TEST para verificar se RETORNAR NADA quando o NOME passado 
	//e DIFERENTE DE LEANDRO
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