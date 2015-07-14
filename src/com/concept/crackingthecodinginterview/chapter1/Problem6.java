package com.concept.crackingthecodinginterview.chapter1;

public class Problem6 {

	public static void main(String[] args) {

/*		char[][] matrix = {{'a','b','c'},{'d','e','f'},{'g','h','i'}};
		char[][] result= {{'.','.','.'},{'.','.','.'},{'.','.','.'}};
*/		
/*		char[][] matrix = {{'a','b','c','d'},{'e','f','g','h'},{'i','j','k','l'},{'m','n','o','p'}};
		char[][] result= {{'.','.','.','.'},{'.','.','.','.'},{'.','.','.','.'},{'.','.','.','.'}};
*/
		int[][] image = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		char[][] matrix = {{'a','b','c','d','e'},{'f','g','h','i','j'},{'k','l','m','n','o'},{'p','q','r','s','t'},{'u','v','w','x','y'}};
		char[][] result = {{'.','.','.','.','.'},{'.','.','.','.','.'},{'.','.','.','.','.'},{'.','.','.','.','.'},{'.','.','.','.','.'}};
		
		System.out.println("\nMatrix before rotation :");
		printMatrix(image);

		rotate(image, image.length);
		
		System.out.println("\nMatrix after rotation :");
		printMatrix(image);

/*		
		//Inplace Rotation logic (Not complete. Work for outer edge only)
		int len = matrix.length-1;
		for (int i = 0; i < (matrix.length)/2; i++) {
			for (int j = i; j < len; j++) {
		System.out.println("i="+i);
		System.out.println("j="+j);
		System.out.println("len="+len);
		char ch = matrix[i][j];
		matrix[i][j] = matrix[j][len];
		matrix[j][len] = matrix[len][len-j];
		matrix[len][len-j] = matrix[len-j][i];
		matrix[len-j][i] = ch;
			}
			len-=1;
		}
	
*/

/*
		//Rotation logic with extra memory (complete solution and it will work for any dimension)
		int length = matrix.length-1;
		for (int i = 0; i <= length; i++) {
			for (int j = 0; j <= length; j++) {
				result[j][length-i] = matrix[i][j];
			}
		}
		
		
		System.out.println("\nResultant matrix after rotation :");
		System.out.println("\nMatrix after rotation :");
		print(matrix);
*/
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void rotate(int[][] matrix, int n) {
		
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i < last; ++i) {
				int offset = i - first;
				int top = matrix[first][i]; // save top
				// left -> top
				matrix[first][i] = matrix[last-offset][first];
				// bottom -> left
				matrix[last-offset][first] = matrix[last][last - offset];
				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];
			} 
		} 
	} 


}
