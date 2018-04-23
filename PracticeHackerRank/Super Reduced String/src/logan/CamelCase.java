/**
 * 
 */
package logan;

/**
 * @author longphan
 *
 */
public class CamelCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String string = "engIneerIng";
		String a = string.replaceAll("[A-Z]","");
		int count = string.length() - string.replaceAll("[A-Z]","").length();
				System.out.println(count);
	}
	static int camelCase(String s) {
		int count = 1 + s.length() - s.replaceAll("[A-Z]","").length();
        return count;
    }
}
