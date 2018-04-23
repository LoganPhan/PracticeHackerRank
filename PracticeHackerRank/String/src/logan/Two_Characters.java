/**
 * 
 */
package logan;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author longphan
 *
 */
public class Two_Characters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "pvmaigytciycvjdhovwiouxxylkxjjyzrcdrbmokyqvsradegswrezhtdyrsyhg";
		System.out.println(twoCharaters(s));
	}

	static int twoCharaters(String s) {
		Set<String> set = new LinkedHashSet<>();
		getAlphabets(s, set);
		
		String[] strArray = set.toArray(new String[set.size()]);

		HashMap<String, Integer> result = new HashMap<String, Integer>();
		
		for (int i = 0; i < strArray.length; i++) {
			
			for (int j = i + 1; j < strArray.length; j++) {
				String firstKey = strArray[i];
				String secondKey = strArray[j];
				String afterRemove = removeAllsWithOutTwoChars(s, firstKey, secondKey);
				boolean flag = isConsecutive(afterRemove);
				
				if(flag) {
					result.put(firstKey.concat(secondKey), afterRemove.length());
				}
			}
		}
		if(result.isEmpty()) {
			return 0;
		}
		 int maxValueInMap=(Collections.max(result.values()));  // This will return max value in the Hashmap
		return maxValueInMap;
	}

	static String removeAllsWithOutTwoChars(String str, String firstKey, String secondKey) {
		String result = str.replaceAll("[^" + firstKey + "|^+"+ secondKey +"]", "");
		return result;
	}

	static boolean isConsecutive(String result) {
		StringBuilder builder = new StringBuilder(result);
		boolean flag = true;
		for (int i = 0; i < builder.length(); i++) {
			char firstChar = builder.charAt(i);
			char nextChar = 0;
			if((i + 1) != (builder.length())) {
				nextChar = builder.charAt(i + 1);
			}
			
			if (firstChar == nextChar) {
				return false;
			}
		}
		return flag;
	}

	private static void getAlphabets(String s, Set<String> set) {
		char[] charArrays = s.toCharArray();
		for (char c : charArrays) {
			set.add(String.valueOf(c));
		}
	}
}
