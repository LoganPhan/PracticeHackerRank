package logan;

public class Pangrams {
	
	
	public static void main(String[] args) {
		String s = "We promptly judged antique ivory@#@$ buckles for the next prize  ";
		 String result = pangrams(s);
		 recusionString(s, 65);
		 System.out.println(result);
	}
	
	 /*
     * Complete the pangrams function below.
     */
    static String pangrams(String s) {
    	return recusionString( s,  65);
    }
    
    static String recusionString(String str, int index) {
    	str = str.toUpperCase();
    	if(index > 90) {
    		return "pangram";
    	}
    	if(str.indexOf(index) != -1) {
    		return recusionString(str, ++index);
    	}else {
    		
    	}
    	return "not pangram";
    }
}
