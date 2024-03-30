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
	
	//criando o metodo SETUP q por ter a ANNOTATION @BEFOREEACH ele sera iniciado
	//antes de cada METODO de TEST
	@BeforeEach
	void setup() {
		//Given / Arrange

		// para a VAR/OBJ MOCKSERVICE nos chamamos o MOCK e passamos a CLASS/INTERFACE q QUEREMOS MOCKAR
		//ou seja SIMULAR...
		mockService = mock(CourseService.class);
		
		//criando uma instancia de COURSEBUSINESS de nome BUSINESS q ira receber o retorno
		//de COURSEBUSINESS passando o nosso OBJ/VAR MOCKSERVICE criado ali em cima, e ele
		//tem a SIMULACAO/MOCK da classe COURSERVICE
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
	
	
	//Metodo para testar se apos passar um Student esta retornando apenas cursos com Spring no nome
	@Test
	void testCourseRelatedToSpring_When_UsingAMock() {

		//no WHEN nos passamos o OBJ/VAR MOCKSERVICE e chamamos o metodo RETRIVECOURSES
		//passando como argumento um NOME DE ESTUDANTE ALEARTORIO LEANDRO
		//quando isso acima acontecer dai ele THEN (vai retornar) a LISTA de COURSES 
		when(mockService.retrieveCourses("Leandro"))
			.thenReturn(courses);
		
		//When / Act
		var filteredCourses = business.retrieveCoursesRelatedToSpring("Leandro");
			
		//Then / Assert
		//primeiro ASSEERT EQUAL e para ver o TAMANHO da LISTA... Tem q retornar 4
		//pois temos 4 CURSOS q tem a PALVRA SPRING no MEIO DO NOME do CURSO
		assertEquals(4, filteredCourses.size());
		
	}
	
	
}