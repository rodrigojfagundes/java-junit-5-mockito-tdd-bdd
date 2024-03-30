package br.com.erudio.mockito.services;

import static org.junit.jupiter.api.Assertions.*;

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
	
	@DisplayName("Should Include Randon Order Id When No Order Id Exists")
	@Test
	void testShouldIncludeRandonOrderId_When_NoOrderIdExists() {
		
		//Given / Arrange
		try(MockedStatic<UUID> mockedUuid = mockStatic(UUID.class)) {
			mockedUuid.when(UUID::randomUUID).thenReturn(defaultUuid);
		
		//When / Act
		Order result = service.createOrder("MacBook Pro", 2L, null);

		//Then / Assert
		assertEquals(defaultUuid.toString(), result.getId());
		

		}
	}
	
	
	
}
