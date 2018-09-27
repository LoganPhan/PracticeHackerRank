package logan;

public class ToogleString {
	
	public static void main(String[] args) {
		
	/*	String abc = "Logan is a student Logan is 20 years old";
		String splite = splitString(abc);
		
		System.out.println(splite);*/
		toogleString("abcdE");
	}
	
	static void toogleString(String str) {
		char[] arrays = str.toCharArray();
		for (char c : arrays) {
			if(c > 90) {
				System.out.print((char)(90 - (122 - c)));
			}else {
				System.out.print((char)(122 - (90 - c)));
			}
		}
	}
}
