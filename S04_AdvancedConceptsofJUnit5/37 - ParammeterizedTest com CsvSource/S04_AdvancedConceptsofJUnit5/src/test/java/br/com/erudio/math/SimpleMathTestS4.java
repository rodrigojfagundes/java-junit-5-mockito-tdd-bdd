package br.com.erudio.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;


//BDD Style - Behavior-driven development
// ou AAA -> Arrange, Act, Assert
//
//Given -> Contexto/cenario inicial das classes, onde e setado as 
//configurações, inicializar as var, etc...
//When -> onde dispara o gatilho e inicia a execução do cenario
//Then -> avaliação se o resultado corresponde ao esperado


//classe q ira testar os METODOS da CLASSE SIMPLEMATHTEST
//
@DisplayName("Test Math Operations in Simple Math Class")
class SimpleMathTestS4 {
	
	SimpleMath math;
		
	@BeforeEach
	void beforeEachMethod() {
		math = new SimpleMath();
	}
	
	
	//metodo para TESTAR o metodo DIVISION q ta na classe SIMPLEMATH
	//
	@DisplayName("Test 6.2 / 2 = 3.1")
	@ParameterizedTest
	//@MethodSource("testDivisionInputParameters")
	//@MethodSource()
	@CsvSource({
		"6.2, 2, 3.1",
		"71, 14, 5.07",
		"18.3, 3.1, 5.90", 
	})
	void testDivision(double firstNumber, double secondNumber, double expected) {
		
		System.out.println("Test " + firstNumber + "/" + 
		secondNumber + " = " + expected + "!");
		Double actual = math.division(firstNumber, secondNumber);

		assertEquals(expected, actual, 2D,
				() -> firstNumber + "/" + secondNumber +"   not produce " + expected);
	}
	
	
	//criando o metodo TESTDIVISIONINPUTPARAMETERS, esse metodo irá retornar os PARAMETROS
	//q sao chamados no TESTDIVISION
	//
	//esse metodo vai retornar um STREAM do TIPO ARGUMENTS...
	//public static Stream<Arguments> testDivisionInputParameters() {
	//
	/**
	public static Stream<Arguments> testDivision() {
		//dentro do STREAM vai ter ARGUMENTS com os valores 
		//FIRSTNUMBER = 6.2D, SECONDNUMBER = 2D, EXPECTED = 3.1D... 
		//e assim sucessivamente...
		return Stream.of(
				Arguments.of(6.2D, 2D, 3.1D),
				Arguments.of(71D, 14D, 5.07D),
				Arguments.of(18.3D, 3.1D, 5.90D)
				);
		
	}
	*/
}
