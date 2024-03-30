package br.com.erudio.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.erudio.service.CourseService;
import br.com.erudio.services.stubs.CourseServiceStub;

class CourseBusinessStubTest {
	
	
	//Metodo para testar se apos passar um Student esta retornando apenas cursos com Spring no nome 
	@Test
	void testCourseRelatedToSpring_When_UsingAStub() {
		
		//Given / Arrange

		//definir a estrutura, criando um COURSESERVICE de nome STUBSERVICE q recebe um
		//COURSESERVICESTUB q é onde esta a LISTA de COURSE mockada...
		CourseService stubService = new CourseServiceStub();
		CourseBusiness business = new CourseBusiness(stubService);
		
		//When / Act
		var filteredCourses = business.retrieveCoursesRelatedToSpring("Leandro");
		
		//Then / Assert
		//primeiro ASSEERT EQUAL e para ver o TAMANHO da LISTA... Tem q retornar 4
		//pois temos 4 CURSOS q tem a PALVRA SPRING no MEIO DO NOME do CURSO
		assertEquals(4, filteredCourses.size());
		
	}
	
	
	//test[System Under Test]_[Condition or State Change]_[Expected Result]
	@Test
	void testCourseRelatedToSpring_When_UsingAFooBarStudent() {
		
		//Given / Arrange
		//
		//definir a estrutura, criando um COURSESERVICE de nome STUBSERVICE q recebe um
		//COURSESERVICESTUB q é onde esta a LISTA de COURSE mockada...
		CourseService stubService = new CourseServiceStub();
		CourseBusiness business = new CourseBusiness(stubService);
		
		//When / Act
		var filteredCourses = business.retrieveCoursesRelatedToSpring("Foo Bar");
		
		//Then / Assert
		//primeiro ASSEERT EQUAL e para ver o TAMANHO da LISTA... Tem q retornar 0
		//pois temos 0 pois para o ESTUDANTE FOO BAR e zero curso
		assertEquals(0, filteredCourses.size());
		
		
	}
	
	
	
}