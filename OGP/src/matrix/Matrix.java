package matrix;

import java.util.Arrays;

public class Matrix {
	
	private int rows;
	private int columns;
	private double[] elements;

	public Matrix(int rijen, int kolommen, double[] getallen) {
		rows = rijen;
		columns = kolommen;
		elements = getallen; 
	}
	


	public int getRows() {return this.rows; }
	public int getColumns() {return this.columns; }
	
	public double[] getElementsAtRow(int rij) {
		double[] arr = new double[this.columns];
		int i;
		int j = 0;
		for(i = this.columns*(rij- 1) ; i < this.columns*(rij - 1) + this.columns; i++) {
			arr[j] = this.elements[i];
			j++;
		}
		System.out.println(Arrays.toString(arr));
		return arr;
		
	}
	
	public double[] getElementsAtColumn(int kolom) {
		double[] arr = new double[this.rows]; 
		int i;
		int j = 0;
		for(i = (kolom-1); i < this.elements.length ; i = i + this.columns) {
			arr[j] = this.elements[i];
			j++;
		}
		System.out.println(Arrays.toString(arr));
		return arr;
	}
	
	public double getElementAt(int rij, int kolom) {
		double[] arr = getElementsAtRow(rij);
		double result;
		result = arr[kolom - 1];
		return result;
	}
	
	public double[] getMatrixRowMajor() {
		return this.elements;
	}
	
	public double[] getMatrixColumnMajor() {
		double[] result = new double[this.elements.length];
		int i;
		int j;
		for(i = 0; i < this.columns ; i++) {
			for(j = 0; j < this.rows; j++) {
				result[(i*this.rows) + j] = getElementAt((j+1), (i+1)); 
			}
		}
		System.out.println(Arrays.toString(result));
		return result; 
	}
	
}
