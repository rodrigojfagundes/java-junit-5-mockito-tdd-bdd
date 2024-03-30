package br.com.erudio.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


//classe q ira testar o CLASSE SIMPLEMATHTEST
class SimpleMathTest {

	//vamos testar o METODO SUM da classe SIMPLEMATH
	//
	@Test
	void testSum() {

		SimpleMath math = new SimpleMath();

		double firstNumber = 6.2D;
		double secondNumber = 2D;

		Double actual = math.sum(firstNumber, secondNumber);
		Double expected = 8.2D;

		assertEquals(expected, actual, 
				() -> firstNumber + "+" + secondNumber +"   not produce " + expected);

		assertNotNull(actual);
	}
	

	//metodo para TESTAR o metodo SUBSTRACTION q ta na classe SIMPLEMATH
	//
	@Test
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
	void testDivision() {

		SimpleMath math = new SimpleMath();

		double firstNumber = 6.2D;
		double secondNumber = 2D;

		Double actual = math.division(firstNumber, secondNumber);
		Double expected = 3.1D;
		
		assertEquals(expected, actual, 
				() -> firstNumber + "/" + secondNumber +"   not produce " + expected);
	}
	
	
	
	//metodo para TESTAR o metodo MEAN q ta na classe SIMPLEMATH
	//
	@Test
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
	void testSquareRoot() {

		SimpleMath math = new SimpleMath();

		double number = 81D;

		Double expected = 9D;

		Double actual = math.squareRoot(number);
		
		assertEquals(expected, actual, 
				()-> "Square Root of" + number +
				"did not produce " + expected + "!");
	}
	
}
