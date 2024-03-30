package br.com.erudio.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.erudio.service.CourseService;


//Mock e quando cria um objeto q simula o comportamento de um objeto real
//
//diferentemente dos STUBS os MOCKS podem ser criados dinamicamente em runtime

class CourseBusinessMockTest {

	CourseService mockService;
	CourseBusiness business;
	List<String> courses;
	
	//criando o metodo STUP q por ter a ANNOTATION @BEFOREEACH ele sera iniciado
	//antes de cada METODO de TEST
	@BeforeEach
	void setup() {
		//Given / Arrange

		// para a VAR/OBJ MOCKSERVICE nos chamamos o MOCK e passamos a CLASS/INTERFACE q QUEREMOS MOCKAR ou seja SIMULAR...
		mockService = mock(CourseService.class);

		business = new CourseBusiness(mockService);
		
		courses = Arrays.asList(
				"REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "Spotify Engineering Culture Desmistificado",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
                "Docker do Zero à Maestria - Contêinerização Desmistificada",
                "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
                "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker"
                );
				
	}
	
	
	//criando o TEST para saber a quantidade de CURSOS com SPRING no NOME
	//
	//test[System Under Test]_[Condition or State Change]_[Expected Result]
	@Test
	void testCourseRelatedToSpring_When_UsingAMock() {

		//quando o RETRIVIECOURSES for CHAMADO
		//
		//no WHEN nos passamos o OBJ/VAR MOCKSERVICE e chamamos o metodo RETRIVECOURSES
		//passando como argumento um NOME DE ESTUDANTE ALEARTORIO LEANDRO
		//
		//quando isso acima acontecer dai ele THEN (vai retornar) a LISTA de COURSES 
		when(mockService.retrieveCourses("Leandro"))
			.thenReturn(courses);
		
		
			//When / Act
			//aqui nos vamos FILTRAR os CURSOS
		//
		//a VAR FILTEREDCURSES vai receber o retorno do METODO REATRIVECOURSESRELATEDTOSPRING
		//q ta no BUSINESS q é o OBJ/VAR q recebe o retorno do COURSEBUSINESS apos passar a LISTA
		//de CURSOS q ta no STUBSERVICE
		var filteredCourses = business.retrieveCoursesRelatedToSpring("Leandro");
		
		
			//Then / Assert
		//
		//aqui nos vamos realmente TESTAR
		//
		//primeiro ASSEERT EQUAL e para ver o TAMANHO da LISTA... Tem q retornar 4
		//pois temos 4 CURSOS q tem a PALVRA SPRING no MEIO DO NOME do CURSO
		assertEquals(4, filteredCourses.size());
		
	}
	
	
}