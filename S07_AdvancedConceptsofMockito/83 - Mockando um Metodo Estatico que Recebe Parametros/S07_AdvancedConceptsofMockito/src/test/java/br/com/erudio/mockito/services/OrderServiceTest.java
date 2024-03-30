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

	//test[System Under Test]_[Condition or State Change]_[Expected Result]
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
	
	//test[System Under Test]_[Condition or State Change]_[Expected Result]
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
