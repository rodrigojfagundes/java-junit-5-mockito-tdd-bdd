package br.com.erudio.services.stubs;

import java.util.Arrays;
import java.util.List;

import br.com.erudio.service.CourseService;

public class CourseServiceStub implements CourseService {
	
	
	
	//implementando o metodo q ta na INTERFACE COUSESERVICE
	//
	public List<String> retrieveCourses(String student) {
		
		//mockando a lista de CURSOS... Dai dessa forma quando for solicitado 
		//uma LISTA de CURSOS em vez de IR no BANCO de DADOS pegar uma LISTA com VARIOS CURSO
		//ele vai vir aqui nessa LISTA E PEGAR OS CURSOS Q ESTAO AQUI...
		return Arrays.asList(
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

	@Override
	public List<String> doSomeThings(String student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCourse(String course) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
