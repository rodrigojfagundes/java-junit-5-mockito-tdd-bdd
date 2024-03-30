package br.com.erudio.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.erudio.service.CourseService;
import br.com.erudio.services.stubs.CourseServiceStub;


//Mock e quando cria um objeto q simula o comportamento de um objeto real
//
//diferentemente dos STUBS os MOCKS podem ser criados dinamicamente em runtime

class CourseBusinessMockTest {
	
	CourseService mockService;
	CourseBusiness business;
	
	//criando o metodo STUP q por ter a ANNOTATION @BEFOREEACH ele sera iniciado
	//antes de cada METODO de TEST
	@BeforeEach
	void stup() {
		mockService = mock(CourseService.class);
		business = new CourseBusiness(mockService);
				
	}
	
	//test[System Under Test]_[Condition or State Change]_[Expected Result]

	//Metodo para testar se apos passar um Student esta retornando apenas cursos com Spring no nome 
	@Test
	void testCourseRelatedToSpring_When_UsingAMock() {
	
		//When / Act
		var filteredCourses = business.retrieveCoursesRelatedToSpring("Leandro");
			
		//Then / Assert
		assertEquals(4, filteredCourses.size());
		
	}
	
	
}