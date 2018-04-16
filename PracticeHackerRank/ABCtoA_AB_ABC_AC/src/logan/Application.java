package logan;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
/**
 * 
 * @author longphan
 *
 */
public class Application {

	public static void main(String[] args) {
		String s = "bacd";
		String[] result = buildSubSequence(s);
		for (String string : result) {
			System.out.println(string);
		}

	}
	static String[] buildSubSequence(String s) {
		Set<String> setStrs = new LinkedHashSet<>();
		if (s.startsWith("a"))
			setStrs = startWithA(s);
		else
			setStrs = startNotA(s);
		return setStrs.toArray(new String[setStrs.size()]);
	}

	static Set<String> startWithA(String str) {
		Set<String> setStrs = new LinkedHashSet<>();
		char[] characters = removeDuplicate(str).toCharArray();
		Arrays.sort(characters);
		for (int index = 0; index < characters.length; index++) {
			int nextIndex = index;
			String prefixStr = String.valueOf(characters[index]);
			setStrs.add(prefixStr);// add a first
			recusionStartWithA(prefixStr, characters, index, setStrs);// add second b -> ab, abc,
			recusionStartWithA(prefixStr, characters, ++nextIndex, setStrs);// add third c -> ac...
		}
		return setStrs;
	}

	static Set<String> startNotA(String str) {
		Set<String> setStrs = new LinkedHashSet<>();
		if (str.contains("a")) {
			char[] characters = removeDuplicate(str).toCharArray();
			setStrs.add("a");
			for (int index = 0; index < characters.length; index++) {
				String prefixStr = String.valueOf(characters[index]);
				if (!prefixStr.equals("a")) {
					setStrs.add(prefixStr);// add a first
					recusionStartWithA(prefixStr, characters, index, setStrs);
				}
			}
		}
		return setStrs;
	}

	static void recusionStartWithA(String prefixStr, char[] chars, int index, Set<String> setStrs) {
		if (index >= (chars.length - 1)) {
			return;
		} else {
			String nextStr = String.valueOf(chars[++index]);
			String result = prefixStr + nextStr;
			setStrs.add(result);
			recusionStartWithA(result, chars, index, setStrs);
		}
	}

	static String removeDuplicate(String s) {
		char[] charArray = s.toCharArray();
		Set<String> charSet = new LinkedHashSet<>();
		for (Character chars : charArray) {
			charSet.add(String.valueOf(chars));
		}
		return String.join("", charSet);
	}
}
