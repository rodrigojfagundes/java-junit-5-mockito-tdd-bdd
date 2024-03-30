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

}
