/**
 * 
 */
package logan;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author longphan
 *
 */
public class Gemstones {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.next();
        }
        		
        int result = gemstones(arr);
        System.out.println(result);
		/* Scanner scan = new Scanner(System.in);
		    int t = scan.nextInt();
		    Set<Character> set = convertToSet(scan.next());
		    for(int i=1; i<t ;i++){
		       set.retainAll(convertToSet(scan.next()));
		    }
		    System.out.print(set.size());*/
		
	}
	public static Set<Character> convertToSet(String s) {
		Set<Character> set = new HashSet<Character>(26);
		for (char c : s.toCharArray())
		    set.add(Character.valueOf(c));
		return set;
		}
	
	static int gemstones(String[] arr){
/*		stringlengthComparator(arr);*/
		Set<String> sets = new LinkedHashSet<>();
		for (int i = 0; i < arr[0].length(); i++) {
			sets.add(arr[0].substring(i, i + 1));
		}
		for (int i = 1; i < arr.length; i++) {
			String str = arr[i];
			sets.retainAll(Arrays.asList(str.split("")));
		}
		return sets.size();
    }
	
	static boolean isExisted(String[] arr, String str) {
		boolean existed = true;
		for (String string : arr) {
			if(!string.contains(str))
				return false;
		}
		return existed;
	}
	
	static void stringlengthComparator(String[] arr) {
		Comparator<String> comp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		};
		Arrays.sort(arr, comp);
	}
	
	static void revert(String[] arr) {
		for (int i = 0; i < arr.length/2; i++) {
			String temStr = arr[i];
			arr[i] = arr[arr.length -i - 1];
			arr[arr.length -i -1] = temStr;
		}
	}
}
