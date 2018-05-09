/**
 * 
 */
package logan;import com.sun.istack.internal.FragmentContentHandler;

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
		separateNumbers(s);
	}

	static void separateNumbers(String s) {
		long firstStr = Long.valueOf(s.substring(0, 1));
		long nextNumber = firstStr;
		long secondStr = Long.valueOf(s.substring(1, 2));
		System.out.println(firstStr + " " + secondStr + " " + nextNumber);
	}
	
	static void recursionString(char[] arrays, int firstIndex, int secondIndex) {
		
	}
	
	/*	public static void beautiful(String s) {
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
}*/
}
