package logan;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author longphan
 */
public class SuperReducedString {

	public static void main(String[] args) {
/*		Scanner in = new Scanner(System.in);
		String s = in.next();
		String result = superReducedString(s);
		System.out.println(result);*/
		String s = "aaabccdddaaaabbbbsdasdasdsssssssssaaaaaaaaaaaaaaaadddddddddddddwwwwwwwwwwwwwwwwwwweeeeeeeeeeeeeeeeeqqqqqqqqqqqqqqqqqqqwwwwwwwweeeeeeeeeeeeeebsssbsbsbssssdd";//aa, baab

	//	System.out.println(superReducedString(s).toString());
		Long start = System.currentTimeMillis();
		
		System.out.println("Start: " + start);
		System.out.println(superReducedString(s, 0));
		//slitString(s);
		Long end = System.currentTimeMillis();
		System.out.println("END: " + end);
		System.out.println("Total: " + (end - start));
	}


	static String superReducedString(String s, int index) {
		StringBuilder builder = new StringBuilder(s);
		if(s.length()==0) {
			return "Empty String";
		}
		else if(index == (s.length() - 1)) {
			return s;
		}
		else {
			if(builder.charAt(index) == builder.charAt(index + 1)) {
				builder.delete(index, index + 2);
				return superReducedString(builder.toString(), 0);
			}
			else {
				return superReducedString(builder.toString(), index + 1);
			}
		}
		
	}
	
	static void slitString(String ss) {
		StringBuffer s = new StringBuffer(ss);
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)) {
                s.delete(i-1, i+1);
                i = 0;
            }
        }
        if(s.length() == 0) System.out.println("Empty String ");
        else System.out.println(s);
	}
}
