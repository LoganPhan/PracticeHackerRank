package logan;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TwoDArrayDS {

	public static void main(String[] args) {
		int[][] arr = {
						{1, 1, 1, 0, 0, 0},
						{0, 1, 0, 0, 0, 0},
						{1, 1, 1, 0, 0, 0},
						{0, 0, 2, 4, 4, 0},
						{0, 0, 0, 2, 0, 0},
						{0, 0, 1, 2, 4, 0}
					};
		array2D(arr);
	}

	 /*
     * Complete the array2D function below.
     */
    static int array2D(int[][] arr) {
        /*
         * Write your code here.
         */
    	Set<Integer> sum = new HashSet<>();
    	for (int row = 0; row <= 3; row++) {
			for (int column = 0; column <= 3; column++) {
				sum.add(arr[row][column] + arr[row][column + 1] + arr[row][column + 2] + 
						arr[row + 1][column + 1] + 
						arr[row + 2][column] + arr[row + 2][column + 1] + arr[row + 2][column + 2]);
						
			}
		}
    	return Collections.max(sum);
    }
}
