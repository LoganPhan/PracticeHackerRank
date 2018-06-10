package logan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		boolean stop = true;
		Scanner sc = new Scanner(System.in);
		while (stop) {
			LinkedList<String> linked = new LinkedList<>();
			long number = sc.nextLong();
			if (number == 0) {
				
				break;
			} else {
				for (int i = 0; i < number; i++) {
					String str = sc.next();
					linked.add(str);
				}
				sortOfSort(linked.toArray(new String[linked.size()]));
			}
		}
	}
	
	/**
	 * This function sort the String array: A<B<C
	 * @author longphan
	 * @param str
	 */
	static void sortOfSort(String[] str) {
		Map<String, List<String>> map = new HashMap<>();
		for (int i = 0; i < str.length; i++) {
			String key = str[i].substring(0, 2);
			if (!map.containsKey(key)) {
				List<String> value = new ArrayList<>();
				value.add(str[i]);
				for (int j = i + 1; j < str.length; j++) {
					String secondKey = str[j].substring(0, 2);
					if (key.equals(secondKey)) {
						value.add(str[j]);
					}
				}
				map.put(key, value);
			}
		}
		Arrays.sort(str);
		stableSort(str, map);
	}

	/**
	 * Stable sort.
	 * @author longphan
	 * @param str
	 * @param map
	 */
	static void stableSort(String[] str, Map<String, List<String>> map) {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < str.length; ) {
			String key = str[i].substring(0, 2);
			for (Map.Entry<String, List<String>> entry : map.entrySet()) {
				List<String> value = entry.getValue();
				int lenghtValue = value.size();
				if (key.equals(entry.getKey())) {
					for (int j = 0; j < lenghtValue; j++) {
						result.add(value.get(j));
					}
					i = i + lenghtValue;
					break;
				}
			}
		}
		for (String string : result) {
			System.out.println(string);
		}
	}

	static String concatString(String str) {
		int frsCh = str.charAt(0);
		if(str.charAt(1) == 97 || str.charAt(1) == 98 || str.charAt(1) == 99) {
			frsCh = frsCh * 10;
		}
		int ndChar = str.charAt(1);
		return String.valueOf(frsCh) + String.valueOf(ndChar);
	}

	static void swapString(String[] str, int firstIndex, int secondIndex) {
		String temp = str[secondIndex];
		str[secondIndex] = str[firstIndex];
		str[firstIndex] = temp;
	}
}
