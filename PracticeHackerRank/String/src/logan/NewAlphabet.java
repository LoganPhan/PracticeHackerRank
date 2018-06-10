package logan;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class NewAlphabet {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int str = scanner.nextInt();
		int count = 0;
		for (int i = 0; i < str; i++) {
			System.out.println(scanner.nextInt());
		}
		//System.out.println(toNewAlphabet(str));
	}
	
	static String toNewAlphabet(String str) {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("a", "@");
		map.put("b", "8");
		map.put("c", "(");
		map.put("d", "|)");
		map.put("e", "3");
		map.put("f", "#");
		map.put("g", "6");
		map.put("h", "[-]");
		map.put("i", "|");
		map.put("j", "_|");
		map.put("k", "|<");
		map.put("l", "1");
		map.put("m", "[]\\/[]");
		map.put("n", "[]\\[]");
		map.put("o", "0");
		map.put("p", "|D");
		map.put("q", "(,)");
		map.put("r", "|Z");
		map.put("s", "$");
		map.put("t", "']['");
		map.put("u", "|_|");
		map.put("v", "\\/");
		map.put("w", "\\/\\/");
		map.put("x", "}{");
		map.put("y", "`/");
		map.put("z", "2");
		str = str.toLowerCase();
		for (Entry<String, String> iterable_element : map.entrySet()) {
			str = str.replace(iterable_element.getKey(), iterable_element.getValue());
			
		}
		return str;
	}

}
