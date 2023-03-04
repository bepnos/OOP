package matrix;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatrixTest {

	@Test
	void test() {
		double[] getallen = {1.5, 3, 5, 7};
		Matrix mijnMatrix = new Matrix(2, 2, getallen ); 
		
		assertEquals(2, mijnMatrix.getRows());
		assertEquals(2, mijnMatrix.getRows());
		
		assertArrayEquals( new double[]{1.5, 3}, mijnMatrix.getElementsAtRow(1));
		assertArrayEquals( new double[]{5, 7}, mijnMatrix.getElementsAtRow(2));
		
		assertArrayEquals( new double[] {1.5, 5}, mijnMatrix.getElementsAtColumn(1));
		assertArrayEquals( new double[] {3, 7}, mijnMatrix.getElementsAtColumn(2));
		
		assertEquals(3, mijnMatrix.getElementAt(1, 2));
		
		mijnMatrix.getMatrixRowMajor();
		mijnMatrix.getMatrixColumnMajor();
		
	}

}
