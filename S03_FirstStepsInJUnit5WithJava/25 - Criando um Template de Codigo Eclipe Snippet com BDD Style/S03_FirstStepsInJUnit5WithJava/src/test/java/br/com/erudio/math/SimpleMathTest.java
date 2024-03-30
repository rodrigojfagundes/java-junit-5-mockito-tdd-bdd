package br.com.erudio.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


//BDD Style - Behavior-driven development
// ou AAA -> Arrange, Act, Assert
//Criterios de aceitação
//Given -> Contexto/cenario inicial das classes, onde e setado as 
//configurações, inicializar as var, etc...
//When -> onde dispara o gatilho e inicia a execução do cenario
//Then -> avaliação se o resultado corresponde ao esperado

//Como nomear os TESTES
//
//test[System Under Test]_[Condition or State Chance]_[Expected Result]
//

//classe q ira testar os METODOS da CLASSE SIMPLEMATHTEST
//
@DisplayName("Test Math Operations in Simple Math Class")
class SimpleMathTest {

	//vamos testar o METODO SUM da classe SIMPLEMATH
	//
	@Test
	@DisplayName("Test 6.2 + 2 = 8.2")
	void testSum_When_SixDotTwoIsAddedByTwo_ShouldReturnEightDotTwo() {
		
		//Given/Arrange
		//
		SimpleMath math = new SimpleMath();
		
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		Double expected = 8.2D;
		
		//When/Act
	
		Double actual = math.sum(firstNumber, secondNumber);

		//Then/Assert

		assertEquals(expected, actual, 
				() -> firstNumber + "+" + secondNumber +"   not produce " + expected);

	}
	
	
	
	//metodo para TESTAR o metodo SUBSTRACTION q ta na classe SIMPLEMATH
	//
	@Test
	@DisplayName("Test 6.2 - 2 = 4.2")
	void testSubtraction() {

		SimpleMath math = new SimpleMath();

		double firstNumber = 6.2D;
		double secondNumber = 2D;

		Double actual = math.subtraction(firstNumber, secondNumber);		
		Double expected = 4.2D;

		assertEquals(expected, actual, 
				() -> firstNumber + "-" + secondNumber +"   not produce " + expected);
	}
	
	
	
	//metodo para TESTAR o metodo MULTIPLICATION q ta na classe SIMPLEMATH
	//
	@Test
	@DisplayName("Test 6.2 * 2 = 12.4")
	void testMultiplication() {

		SimpleMath math = new SimpleMath();

		double firstNumber = 6.2D;
		double secondNumber = 2D;
		
		Double actual = math.multiplication(firstNumber, secondNumber);
		Double expected = 12.4D;

		assertEquals(expected, actual, 
				() -> firstNumber + "*" + secondNumber +"   not produce " + expected);
	}
	
	
	//metodo para TESTAR o metodo DIVISION q ta na classe SIMPLEMATH
	//
	@Test
	@DisplayName("Test 6.2 / 2 = 3.1")
	void testDivision() {

		SimpleMath math = new SimpleMath();

		double firstNumber = 6.2D;
		double secondNumber = 2D;
		Double actual = math.division(firstNumber, secondNumber);
		
		Double expected = 3.1D;
		
		assertEquals(expected, actual, 
				() -> firstNumber + "/" + secondNumber +"   not produce " + expected);
	}
	
	
	//testando o METODO DIVISION passando um valor de 0... Ou seja testando a divisao por ZERO
	//ele deve retornar uma EXCEPTION ARITMETICA
	@Test
	@DisplayName("Test Division By Zero")
	void testDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticException() {
		fail();
	}

	
	
	//metodo para TESTAR o metodo MEAN q ta na classe SIMPLEMATH
	//
	@Test
	@DisplayName("Test (6.2 + 2) / 2 = 4.1")
	void testMean() {

		SimpleMath math = new SimpleMath();

		double firstNumber = 6.2D;
		double secondNumber = 2D;

		Double actual = math.mean(firstNumber, secondNumber);
		
		Double expected = 4.1D;
		
		assertEquals(expected, actual, 
				() -> "(" + firstNumber + "+" + secondNumber + ")/2" +
				"did not produce " + expected + "!");
	}
	
	
	//metodo para TESTAR o metodo SQUAREROOT(RAIZ QUADRADA) q ta na classe SIMPLEMATH
	//
	@Test
	@DisplayName("Test Square Root of 81 = 9")
	void testSquareRoot() {

		SimpleMath math = new SimpleMath();

		double number = 81D;
		Double expected = 9D;
		Double actual = math.squareRoot(number);
		
		assertEquals(expected, actual, 
				()-> "Square Root of" + number +
				"did not produce " + expected + "!");
	}
	
	

	//test[System Under Test]_[Condition or State Change]_[Expected Result]
	@DisplayName("Display Name")
	@Test
	void testABCD_When_XYZ_Should() {
		//Given / Arrange
		//When / Act
		//Then / Assert

	}
	
	
}
