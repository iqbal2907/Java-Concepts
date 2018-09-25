package com.concept.genralprograms;

public class RotateMatrixByNintyDegree {

	public static void main(String[] args) {
		int[][] mat = new int[][]{
									{1,2,3,0,1,2,3},
									{4,5,6,0,4,5,6},
									{7,8,9,0,7,8,9}
								  };
								  
		printMatrix(mat);
		System.out.println("\nRotated Matrix is : \n");
		rotateMatrix(mat);
		System.out.println("\nDiagonal traveral of Matrix is : \n");
		traverseDiagonally(mat);
	}

	private static void traverseDiagonally(int[][] matrix) {
		
		int rowCount = matrix.length;
		  int columnCount = matrix[0].length;
		  
		  for (int r = 0; r < rowCount; r++) {
		   for (int row = r, col = 0; row >= 0 && col < columnCount; row--, col++) {
		    System.out.print(matrix[row][col] + " "); 
		   }
		   System.out.println();
		  }
		   
		  for (int c = 1; c < columnCount; c++) {
		   for (int row = rowCount-1, col = c; row >= 0 && col < columnCount; row--, col++) {
		    System.out.print(matrix[row][col] + " "); 
		   }
		   System.out.println();
		  }
		
		  System.out.println("*************************************************");
		  
		for (int i = 0; i < matrix.length; i++) {
			int x = i;
			for (int j = 0; j < matrix.length && x>=0; j++,x--) {
				System.out.print(matrix[x][j]+" ");
			}
			System.out.println();
		}
		
		for (int x = 1; x < matrix[matrix.length-1].length; x++) {
			int j = matrix.length-1;
			for (int i = x; i < matrix[matrix.length-1].length && j>=0; i++,j--) {
				System.out.print(matrix[j][i]+" ");
			}
			System.out.println();
		}

		
	}

	private static void rotateMatrix(int[][] mat) {

		int[][] rotated = new int[mat[0].length][mat.length];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				rotated[j][mat.length-i-1]=mat[i][j];
			}
		}
		
		printMatrix(rotated);
	}

	public static void printMatrix(int[][] mat){
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
}
