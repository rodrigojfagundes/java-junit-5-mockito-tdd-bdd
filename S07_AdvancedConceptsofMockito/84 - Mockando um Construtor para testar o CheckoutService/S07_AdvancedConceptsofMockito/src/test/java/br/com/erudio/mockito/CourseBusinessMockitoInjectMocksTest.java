package br.com.erudio.mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.erudio.business.CourseBusiness;
import br.com.erudio.service.CourseService;


//								MOCKS USANDO O CONCEITO DE BDD
//								BEHAVIOR DRIVEN DEVELOPMENT
//

@ExtendWith(MockitoExtension.class)
class CourseBusinessMockitoInjectMocksTest {

	@Mock
	CourseService mockService;
	@InjectMocks
	CourseBusiness business;
	
	@Captor
	ArgumentCaptor<String> argumentCaptor;
	List<String> courses;
	
	//criando o metodo STUP q por ter a ANNOTATION @BEFOREEACH ele sera iniciado
	//antes de cada METODO de TEST
	@BeforeEach
	void setup() {
		//Given / Arrange

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
	
	
	@DisplayName("Delete Courses not Related to Spring Using Mockito should call Method deleteCourse")
	@Test
	void testDeleteCourseNotRelatedToSpring_UsingMockitoVerify_CallMethod_deleteCourse() {
		
		//Given / Arrange
			given(mockService.retrieveCourses("Leandro"))
				.willReturn(courses);
		
		
		//When / Act
			business.deleteCoursesNotRelatedToSpring("Leandro");
			
			
		//Then / Assert
			verify(mockService, times(1)).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
			
			verify(mockService, atLeast(1)).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");

			verify(mockService).deleteCourse("Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#");
			
	}
	
	@DisplayName("Delete Courses not Related to Spring Using Mockito should call Method deleteCourse V2")
	@Test
	void testDeleteCourseNotRelatedToSpring_UsingMockitoVerify_CallMethod_deleteCourseV2() {
		
		//Given / Arrange
			given(mockService.retrieveCourses("Leandro"))
				.willReturn(courses);

		 String agileCourse = "Agile Desmistificado com Scrum, XP, Kanban e Trello";
		 String architetureCourse = "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#";
		 String restSpringCourse = "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker";			
		
		//When / Act
		business.deleteCoursesNotRelatedToSpring("Leandro");
						
		//Then / Assert
		then(mockService).should().deleteCourse(agileCourse);		
		then(mockService).should().deleteCourse(architetureCourse);
		then(mockService).should(never()).deleteCourse(restSpringCourse);

	}

	@DisplayName("Delete Courses not Related to Spring Capturing Arguments should call Method deleteCourse V2")
	@Test
	void testDeleteCourseNotRelatedToSpring_CapturingArguments_CallMethod_deleteCourseV2() {
		
		//Given / Arrange
			given(mockService.retrieveCourses("Leandro"))
				.willReturn(courses);
					
		//When / Act
			business.deleteCoursesNotRelatedToSpring("Leandro");
			then(mockService).should(times(7)).deleteCourse(argumentCaptor.capture());

			 assertThat(argumentCaptor.getAllValues().size(), is(7));

	}
	
}