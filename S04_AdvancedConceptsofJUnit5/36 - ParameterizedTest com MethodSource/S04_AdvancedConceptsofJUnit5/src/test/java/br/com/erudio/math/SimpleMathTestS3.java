package br.com.erudio.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


//BDD Style - Behavior-driven development
// ou AAA -> Arrange, Act, Assert

//Criterios de aceitação

//Given -> Contexto/cenario inicial das classes, onde e setado as 
//configurações, inicializar as var, etc...
//
//When -> onde dispara o gatilho e inicia a execução do cenario
//
//Then -> avaliação se o resultado corresponde ao esperado



//classe q ira testar os METODOS da CLASSE SIMPLEMATHTEST
@DisplayName("Test Math Operations in Simple Math Class")
class SimpleMathTestS3 {

	SimpleMath math;

	@BeforeAll
	static void setup() {
		System.out.println("Running @BEFOREALL method!");
	}
	
	@AfterAll
	static void clenup() {
		System.out.println("Running @AFTERALL method!");
	}
	

	@BeforeEach
	void beforeEachMethod() {
		System.out.println("Running @BEFOREEACH method!");
		math = new SimpleMath();
	}
	

	@AfterEach
	void afterEachMethod() {
		System.out.println("Running @AFTEREACH method!");
	}
	
	@Test
	@DisplayName("Test 6.2 + 2 = 8.2")
	void testSum_When_SixDotTwoIsAddedByTwo_ShouldReturnEightDotTwo() {
		
		System.out.println("Test 6.2 + 2 = 8.2");

		double firstNumber = 6.2D;
		double secondNumber = 2D;
		Double expected = 8.2D;
		Double actual = math.sum(firstNumber, secondNumber);

		assertEquals(expected, actual, 
				() -> firstNumber + "+" + secondNumber +"   not produce " + expected);

	}
	

	//metodo para TESTAR o metodo SUBSTRACTION q ta na classe SIMPLEMATH
	//
	@Test
	@DisplayName("Test 6.2 - 2 = 4.2")
	void testSubtraction() {
		
		System.out.println("Test 6.2 - 2 = 4.2");

		double firstNumber = 6.2D;
		double secondNumber = 2D;
		Double actual = math.subtraction(firstNumber, secondNumber);
		Double expected = 4.2D;

		assertEquals(expected, actual, 
				() -> firstNumber + "-" + secondNumber +"   not produce " + expected);
	}
	

	@Test
	@DisplayName("Test 6.2 * 2 = 12.4")
	void testMultiplication() {
		
		System.out.println("Test 6.2 * 2 = 12.4");

		double firstNumber = 6.2D;
		double secondNumber = 2D;
		Double actual = math.multiplication(firstNumber, secondNumber);
		Double expected = 12.4D;

		assertEquals(expected, actual, 
				() -> firstNumber + "*" + secondNumber +"   not produce " + expected);
	}
	

	@Test
	@DisplayName("Test 6.2 / 2 = 3.1")
	void testDivision() {
		
		System.out.println("Test 6.2 / 2 = 3.1");

		double firstNumber = 6.2D;
		double secondNumber = 2D;
		Double actual = math.division(firstNumber, secondNumber);
		Double expected = 3.1D;
		
		assertEquals(expected, actual, 
				() -> firstNumber + "/" + secondNumber +"   not produce " + expected);
	}

	@Test
	@DisplayName("Test Division By Zero")
	void testDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticException() {
		
		double firstNumber = 6.2D;
		double secondNumber = 0D;
		var expectedMessage = "Impossible to divide by zero";

		ArithmeticException actual = assertThrows(ArithmeticException.class, () -> {
		math.division(firstNumber, secondNumber);
		}, () -> "Division by zero should throw an AritmeticException");

		assertEquals(expectedMessage, actual.getMessage(),
				() -> "Unexpected exception message!");
		
	}


	@Test
	@DisplayName("Test (6.2 + 2) / 2 = 4.1")
	void testMean() {
		
		System.out.println("Test (6.2 + 2) / 2 = 4.1");

		double firstNumber = 6.2D;
		double secondNumber = 2D;

		Double actual = math.mean(firstNumber, secondNumber);
		Double expected = 4.1D;
		
		assertEquals(expected, actual, 
				() -> "(" + firstNumber + "+" + secondNumber + ")/2" +
				"did not produce " + expected + "!");
	}
	

	@Test
	@DisplayName("Test Square Root of 81 = 9")
	void testSquareRoot() {
		
		System.out.println("Test 81 = 9");
		double number = 81D;
		Double expected = 9D;

		Double actual = math.squareRoot(number);
		
		assertEquals(expected, actual, 
				()-> "Square Root of" + number +
				"did not produce " + expected + "!");
	}
	
	
}
