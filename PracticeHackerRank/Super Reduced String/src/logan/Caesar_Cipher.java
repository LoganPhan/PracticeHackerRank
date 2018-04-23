package logan;

public class Caesar_Cipher {

	
	public static void main(String[] args) {
		String s = "middle-Outx";
		int k = 2;
		System.out.println(caesarCipher(s, k));
	}
	
	 static String caesarCipher(String s, int k) {
	     char[] charArrays = s.toCharArray();
	     StringBuilder result = new StringBuilder();
	     int rotated = k % 26;
	     for (char c : charArrays) {
	    	int total = c + rotated;// new char = m + 24 = 133
			if(c >= 65 && c <= 90) {
				if(total > 90) {
					 int newChar = total - 90;
					 char ch = (char) (64 + newChar);
					 result.append(String.valueOf(ch));
				}else {
					 char ch = (char) (c + rotated);
					result.append(String.valueOf(ch));
				}
			}
			else if(c >= 97 && c <= 122) {// new char = m + 24 = 133
				if(total > 122) {
				 int newChar = total - 122;
				 char ch = (char) (96 + newChar);
				 result.append(String.valueOf(ch));
				}else {
					 char ch = (char) (c + rotated);
					result.append(String.valueOf(ch));
				}
			}else {
				 char ch = c;
				result.append(String.valueOf(ch));
			}
		}
		 return result.toString();
    }
}
