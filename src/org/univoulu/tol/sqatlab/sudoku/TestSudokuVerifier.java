package org.univoulu.tol.sqatlab.sudoku;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSudokuVerifier {
	
	String correctString;
	String incorrectString;
	SudokuVerifier sudoku;
	String notNumericString;
	
	@Before
	public void setup() {
		correctString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		incorrectString = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
		notNumericString = "C234567899123456788912345I778912345667891234556789123445A78912334567891223456789O";
		sudoku= new SudokuVerifier();
	}
	
	@Test
	public void isNumericTest() {
		assertEquals(0, sudoku.verify(correctString));
		assertEquals(-2, sudoku.verify(incorrectString));
		assertEquals(-1, sudoku.verify(notNumericString));
	}
	
	@Test
	public void onceInAGridTest()
	{
		assertEquals(0, sudoku.verify(correctString));
		assertEquals(-2, sudoku.verify(incorrectString));
		assertEquals(-1, sudoku.verify(notNumericString));
	}
}
