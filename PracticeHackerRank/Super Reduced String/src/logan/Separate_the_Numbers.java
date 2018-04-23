/**
 * 
 */
package logan;

/**
 * @author longphan
 *
 */
public class Separate_the_Numbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "810910";
		
		// System.out.println(Character.getNumericValue(57));
		beautiful(s);
	}

/*	static void separateNumbers(String s) {
		char[] arrays = s.toCharArray();
		int index = 0;
		int secondIndex = 1;
		recursionString(arrays, index, secondIndex);
	}*/
	
	public static void beautiful(String s) {
	    int n = s.length();
	    loop :
	    for(int i = 1; i <= n/2; i ++) {
	        long start = Long.valueOf(s.substring(0,i));
	        long next = start;
	        String remaining = s.substring(i);
	        while(remaining.length() != 0) {
	            next ++;
	            String pattern = "^" + next;
	            String[] a = remaining.split(pattern + ".*");
	            if(remaining.matches(pattern + ".*")){
	                remaining = remaining.replaceAll(pattern, "");
	            } else {
	                continue loop;
	            }
	        }
	        System.out.println("YES " + start);
	        return;
	    }
	    System.out.println("NO");
	}
	
	/*static void recursionString(char[] arrays, int firstIndex, int secondIndex) {
		if(secondIndex == arrays.length) {
			System.out.println("YES");
		}else {
			String firstElement = String.valueOf(arrays[firstIndex]);
			String secondElement = String.valueOf(arrays[secondIndex]);
			
			if(firstElement.startsWith("0")) {
				System.out.println("NO");
			}
			else if(secondElement.startsWith("0")) {
				System.out.println("NO");
			}else {
				int first = Integer.valueOf(firstElement);
				int second = Integer.valueOf(secondElement);
				if(second - first == 1) {
					recursionString(arrays, secondIndex, ++secondIndex);
				}
			}
		}
	
	}*/
}
