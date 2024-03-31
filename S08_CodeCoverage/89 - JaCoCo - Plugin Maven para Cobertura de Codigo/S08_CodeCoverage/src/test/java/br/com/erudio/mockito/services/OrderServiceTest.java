package br.com.erudio.mockito.services;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.UUID;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;


//classe para TESTAR a ORDERSERVICE
//
class OrderServiceTest {
	
	private final OrderService service = new OrderService();
	
	private final UUID defaultUuid = UUID.fromString("8d8b30e3-de52-4f1c-a71c-9905a8043dac");
	private final LocalDateTime defaultLocalDateTime = LocalDateTime.of(2023, 7, 4, 15, 50);

	@DisplayName("Should Include Randon Order Id When No Order Id Exists")
	@Test
	void testShouldIncludeRandonOrderId_When_NoOrderIdExists() {
		
		//Given / Arrange
		
		//criando um MOCK STACICO do tipo da CLASS UUID (class q gera um ID aleartorio no
		//ORDERSERVICE.JAVA) para isso nos vamos chamar o METODO MOCKSTATIC do MOCKITO,
		//e o METODO MOCKSTATIC recebe como parametro a CLASS UUID.class para assim ele SIMULAR
		try(MockedStatic<UUID> mockedUuid = mockStatic(UUID.class)) {

			//chamando o OBJ/VAR MOCKEDUUID e QUANDO (WHEN) chamar o METODO RANDOMUUID da class
			//UUID (q gera ID aleartorio) entao vai ser mockado (OU SEJA O VALOR Q O 
			//UUI.DRANDON vai GERAR de ID é o VALOR Q TA NO DEFAULTUUID) 
			//SE ISSO REALMENTE ACONTECER SIGNIFICA Q A CLASS ORDERSERVICE TA FUNCIONANDO
			//E Q TA CHAMANDO CORRETAMENTE O METODO Q GERA O ID
			mockedUuid.when(UUID::randomUUID).thenReturn(defaultUuid);
		
		
		//When / Act
		Order result = service.createOrder("MacBook Pro", 2L, null);

		//Then / Assert
		//
		//executando uma ASSERTION para verificarmos SE o valor q esperamos q é o q ta na VAR
		//DEFAULTUUID é o mesmo o valor q foi retornado(no RESULt)
		assertEquals(defaultUuid.toString(), result.getId());
		

		}
	}
	
	@DisplayName("Should Include Current Time When Create a NewOrder")
	@Test
	void testShouldIncludeCurrentTime_When_CreateANewOrder() {
		
		//Given / Arrange
		try(MockedStatic<LocalDateTime> mockedUuid = mockStatic(LocalDateTime.class)) {
			mockedUuid.when(LocalDateTime::now).thenReturn(defaultLocalDateTime);
				
		//When / Act
		Order result = service.createOrder("MacBook Pro", 2L, null);

		//Then / Assert
		assertEquals(defaultLocalDateTime, result.getCreationDate());
		

		}
	}
	
	
}
