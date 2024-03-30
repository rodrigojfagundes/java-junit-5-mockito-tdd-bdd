package br.com.erudio.business;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.erudio.service.CourseService;


//								MOCKS USANDO O CONCEITO DE BDD
//								BEHAVIOR DRIVEN DEVELOPMENT
//
//Mock e quando cria um objeto q simula o comportamento de um objeto real
//
//diferentemente dos STUBS os MOCKS podem ser criados dinamicamente em runtime

class CourseBusinessMockWithBDDTest {

	CourseService mockService;
	CourseBusiness business;
	List<String> courses;
	
	//criando o metodo STUP q por ter a ANNOTATION @BEFOREEACH ele sera iniciado
	//antes de cada METODO de TEST
	@BeforeEach
	void setup() {
		//Given / Arrange

		// para a VAR/OBJ MOCKSERVICE nos chamamos o MOCK e passamos a CLASS/INTERFACE q QUEREMOS MOCKAR
		//ou seja SIMULAR...
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
	
	
	//test[System Under Test]_[Condition or State Change]_[Expected Result]
	//Metodo para testar se apos passar um Student esta retornando apenas cursos com Spring no nome 
	@Test
	void testCourseRelatedToSpring_When_UsingAMock() {

		//GIVEN (quando) chamar o metodo RETRIEVECOURSE do MOCKSERVICE e passar o ARGUMENTO
		//LEANDRO, VAI RETORNAR (WILLRETURN) a lista de CURSOS q tem o NOME SPRING
		given(mockService.retrieveCourses("Leandro"))
			.willReturn(courses);
		
		//When / Act
		var filteredCourses = business.retrieveCoursesRelatedToSpring("Leandro");
		
		//Then / Assert
		//ASSERTTHAT no qual nos passamos O Q SERA EXECUTADO e o RESULTADO Q ESPERAMOS (IS(4))
		//dai dessa forma nos testamos...
		assertThat(filteredCourses.size(), is(4));
		
	}
	
	//TESTANDO o METODO deleteCoursesNotRelatedToSpring q ta no COURSEBUSINESS.JAVA
	@DisplayName("Delete Courses not Related to Spring Using Mockito should call Method deleteCourse")
	@Test
	void testDeleteCourseNotRelatedToSpring_UsingMockitoVerify_CallMethod_deleteCourse() {
		
		//Given / Arrange
		//GIVEN (quando) chamar o metodo RETRIEVECOURSE do MOCKSERVICE e passar o ARGUMENTO
		//LEANDRO, VAI RETORNAR (WILLRETURN) a lista de CURSOS
			given(mockService.retrieveCourses("Leandro"))
				.willReturn(courses);
		
		//When / Act
			business.deleteCoursesNotRelatedToSpring("Leandro");
			
		//Then / Assert
			verify(mockService, times(1)).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
			
			verify(mockService, atLeast(1)).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
			
			verify(mockService).deleteCourse("Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#");


	}
	
}