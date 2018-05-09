/**
 * 
 */
package logan;

/**
 * @author longphan
 *
 */
public class Gemstones {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s = "aabcdde";
		String[] str = s.split("[^a.*]");
		String[] sa = {"abcdde", "baccd", "eeabg"};
		gemstones(sa);
		System.out.println(str[0]);
	}
	
	static int gemstones(String[] arr){
		int count = 0;
		for (String string : arr) {
			String s = string.substring(0, 1);
			String[] str = string.split("[^"+ s +".*]");
			if(str[0].length() == 1) {
				count++;
			}
		}
		return count;
		
    }
	
}
