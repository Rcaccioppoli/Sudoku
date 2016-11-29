package org.univoulu.tol.sqatlab.sudoku;

import java.util.ArrayList;

public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		int result;
		
		if (!isNumeric(candidateSolution))
			result=-1;
		else if (!onceInAGrid(candidateSolution))
			result=-2;
		else if (!onceInARow(candidateSolution))
			result=-3;
		else if (!onceInAColumn(candidateSolution))
			result=-4;
		else
			result=0;
		
		return result;
	}

	private boolean onceInAColumn(String candidateSolution) {
		boolean valid=true;
		ArrayList<String> columns = crateColumns(candidateSolution);
		
		for (int i=0; (i<columns.size() && valid); i++)
		{
			if(!oneDigits(columns.get(i)))
				valid=false;
		}
		
		return valid;
	}

	private ArrayList<String> crateColumns(String candidateSolution) {
		ArrayList<String> columns = new ArrayList<>();
		ArrayList<String> rows = createRows(candidateSolution);
		String toAdd = "";
		
		for (int i=0; i<rows.size(); i++){
			toAdd="";
			for (int j=0; j<rows.size(); j++) {
				toAdd+=rows.get(j).charAt(i);
			}
			columns.add(toAdd);	
		}

		return columns;
	}

	private boolean onceInARow(String candidateSolution) {
		boolean valid=true;
		ArrayList<String> rows = createRows(candidateSolution);
		
		for (int i=0; (i<rows.size() && valid); i++)
		{
			if(!oneDigits(rows.get(i)))
				valid=false;
		}
		
		return valid;
	}

	private ArrayList<String> createRows(String candidateSolution) {
		ArrayList<String> rows = new ArrayList<>();
		String toAdd = "";
		
		for (int j=0; j<candidateSolution.length(); j=j+9){
			toAdd = candidateSolution.substring(j, j+9);
			rows.add(toAdd);
			toAdd = "";
		}

		return rows;
	}

	private boolean onceInAGrid(String candidateSolution) {
		boolean valid=true;
		ArrayList<String> grids = createGrids(candidateSolution);
		
		for (int i=0; (i<grids.size() && valid); i++)
		{
			if(!oneDigits(grids.get(i)))
				valid=false;
		}
		
		return valid;
	}

	private boolean oneDigits(String string) {
		boolean result=true;
		
		for (int i=0; i<string.length(); i++) {
			for (int j=i+1; j<string.length(); j++) {
				if(string.charAt(i)==string.charAt(j) && string.charAt(i)==0)
					result=false;
			}
		}
		
		return result;
	}

	private ArrayList<String> createGrids(String candidateSolution) {
		ArrayList<String> grids = new ArrayList<>();
		ArrayList<String> rows = createRows(candidateSolution);
		ArrayList<String> columns = crateColumns(candidateSolution);
		
		String toAdd = "";
		
		for (int i=0; i<columns.size(); i=i+3) {
			for (int j=0; j<rows.size(); j++) {
				toAdd+=rows.get(j).substring(0, 3);
				
				if (toAdd.length()==9) {
					grids.add(toAdd);
					toAdd = "";
				}
			}			
		}
		
		return grids;
	}

	private boolean isNumeric(String candidateSolution) {
		boolean valid=true;

		for(int i=0; (i<candidateSolution.length() && valid); i++) {
			if (!Character.isDigit(candidateSolution.charAt(i)))
				valid=false;
		}
		
		return valid;
	}
}
