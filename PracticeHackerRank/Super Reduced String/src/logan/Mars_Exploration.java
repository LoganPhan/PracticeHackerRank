/**
 * 
 */
package logan;

/**
 * @author longphan
 *
 */
public class Mars_Exploration {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "OOSDSSOSOSWEWSOSOSOSOSOSOSSSSOSOSOSS";
		marsExploration(s);

	}

	static int marsExploration(String s) {
		String[] str = s.split("(?<=\\G.{3})");
		int count = 0;
		for (String string : str) {
			StringBuilder builder = new StringBuilder(string);
			char firstChar = builder.charAt(0);
			char secondChar = builder.charAt(1);
			char thirChar = builder.charAt(2);
			if(firstChar != 83)
				count++;
			if(secondChar != 79) 
				count ++;
			if(thirChar !=83)
				count++;
		}
		System.out.println(count);
		return count;
	}
}
