package com.lc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class MagicSquaresInGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MagicSquaresInGrid grid = new MagicSquaresInGrid();
		int[][] gridS = new int[][] {{3,10,2,3,4},{4,5,6,8,1},{8,8,1,6,8},{1,3,5,7,1},{9,4,9,2,9}};
		System.out.println(grid.numMagicSquaresInside1(gridS));
		System.out.println(grid.numMagicSquaresInside(gridS));
	}

	public int numMagicSquaresInside(int[][] grid) {
		
		int row=-1, col=0, noOfMagicSquares=0;
		while(row+2<grid.length) {			
			row++;
			col=row;
			//0,0 | 1,1 | 2,2 | 3,3|....iterates horizontally 
			while(col+2<grid[0].length) {
				if (isMagicSquare(grid, row, col))
					noOfMagicSquares++;
				col++;
			}
			
		}
		row=1; col=-1;
		while(col+2<grid[0].length) {	
			col++;
			row=col+1;
			//1,0 | 2,1 | 3,2 | 4,3 ......iterates horizontally
			while(row+2<grid.length) {
				if (isMagicSquare(grid, row, col))
					noOfMagicSquares++;
				row++;
			}
			
		}			
		return noOfMagicSquares;
	}
	
	public int numMagicSquaresInside1(int[][] grid) {
		int count=0; 
		for(int i=0;i<grid.length-2;i++) {
			for(int j=0;j<grid[0].length-2;j++) {
				if(isMagicSquare(grid, i, j)) {
					count++;
				}
			}
		}
		return count;
	}
	
	private boolean isMagicSquare(int[][] grid, int i, int j) {
		/*
		 * if(i+2>=grid.length || j+2 >=grid[0].length) return false;
		 */
		
		//System.out.println(i+":"+j);
		int zero_zero = grid[i][j];
		int zero_one = grid[i][j + 1];
		int zero_two = grid[i][j + 2];
		int one_zero = grid[i + 1][j];
		int one_one = grid[i + 1][j + 1];
		int one_two = grid[i + 1][j + 2];
		int two_zero = grid[i + 2][j];
		int two_one = grid[i + 2][j + 1];
		int two_two = grid[i + 2][j + 2];
		IntStream st = Arrays.stream(new int[] {zero_zero,zero_one,zero_two,one_zero,one_one,one_two,two_zero,two_one,two_two});
		if (st.filter(x->x>0&&x<10).distinct().count() != 9) {
			return false;
		}
		if ((zero_zero + zero_one + zero_two) == (one_zero + one_one + one_two)
				&& (zero_zero + zero_one + zero_two) == (two_zero + two_one + two_two)
				&& (zero_zero + zero_one + zero_two) == (zero_zero + one_zero + two_zero)
				&& (zero_zero + zero_one + zero_two) == (zero_one + one_one + two_one)
				&& (zero_zero + zero_one + zero_two) == (zero_two + one_two + two_two)
				&& (zero_zero + zero_one + zero_two) == (zero_zero + one_one + two_two)
				&& (zero_zero + zero_one + zero_two) == (zero_two + one_one + two_zero)) {
			// magic square
			return true;
		}
		return false;
	}

}
