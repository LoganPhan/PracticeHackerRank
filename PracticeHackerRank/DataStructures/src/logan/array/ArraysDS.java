/**
 * 
 */
package logan.array;

/**
 * @author longphan
 *
 */
public class ArraysDS {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		int[] myIntArray = {1,2,3};
		reverseArray(myIntArray);
	}
	
	 /*
     * Complete the reverseArray function below.
     */
    static int[] reverseArray(int[] a) {
      int x = a.length;
      int[] result = new int[x];
      int index = 0;
      	for (int i = a.length - 1 ; i >= 0; i--) {
      		result[index] = a[i];
      		index++;
		}
    	return result;
    }
}
