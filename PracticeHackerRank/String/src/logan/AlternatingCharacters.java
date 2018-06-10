package logan;

public class AlternatingCharacters {

	public static void main(String[] args) {
		String s = "AAAABBABA";
		System.out.println(alternatingCharacters(s));
	}

	  static int alternatingCharacters(String s){
        StringBuilder builder = new StringBuilder(s);
        int count = 0;
        for (int i = 1; i < builder.length(); i++) {
        	if(builder.charAt(i) == builder.charAt(i - 1)) {
        		count++;
        	}
		}
        return count;
	  } 
	  
}
