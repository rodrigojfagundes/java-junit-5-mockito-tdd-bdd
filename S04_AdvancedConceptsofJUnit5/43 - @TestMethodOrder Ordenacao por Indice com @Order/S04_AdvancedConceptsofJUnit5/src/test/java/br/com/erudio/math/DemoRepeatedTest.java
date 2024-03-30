package br.com.erudio.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;



//com a classe DEMOREPEATEDTEST, nos vamos TESTAR VARIAS VEZES (REPEATED) o TEST de 
//DIVISION BY ZERO, para garantir q não havera falha mesmo executando o teste varias vezes
//
class DemoRepeatedTest {
	
	
	SimpleMath math;
	
	
	@BeforeEach
	void beforedEachMethod() {
		math = new SimpleMath();
		System.out.println("Running @BeforeEach method!");
	}
	
	
	//testando o METODO DIVISION passando um valor de 0... Ou seja testando a divisao por ZERO
	//ele deve retornar uma EXCEPTION ARITMETICA
	@RepeatedTest(value = 3, name = "{displayName}. Repetition "
			+ "{currentRepetition} of {totalRepetitions}!")
	@DisplayName("Test Division By Zero")
	void testDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticException(
			RepetitionInfo repetitionInfo,
			TestInfo testInfo
			) {

		System.out.println("Repetition Nº " + repetitionInfo.getCurrentRepetition() +
			" of " + repetitionInfo.getTotalRepetitions());
		
		System.out.println("Running " + testInfo.getTestMethod().get().getName());
		
		
		//GIVEN
		//definindo o valor das var
		double firstNumber = 6.2D;
		double secondNumber = 0D;
		var expectedMessage = "Impossible to divide by zero";
		
		//WHEN & THEN

		ArithmeticException actual = assertThrows(ArithmeticException.class, () -> {
		math.division(firstNumber, secondNumber);
		}, () -> "Division by zero should throw an AritmeticException");
		
		assertEquals(expectedMessage, actual.getMessage(),
				() -> "Unexpected exception message!");
		
	}
	
	
}