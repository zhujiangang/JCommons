package org.jcommons.common;

public class ArrayUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static double[][] fill(double[][] mat, double v){
		if(mat==null)
			return null;
		int m = mat.length;
		int n = mat[0].length;
		for (int i = 0; i < m; i++) {
			if (mat[i].length != n) {
				throw new IllegalArgumentException(
						"All rows must have the same length.");
			}
			for(int j=0; j<n; j++)
				mat[i][j] = v;
		}
		return mat;
	}
}
