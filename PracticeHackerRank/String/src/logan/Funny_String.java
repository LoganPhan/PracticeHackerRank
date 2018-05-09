/**
 * 
 */
package logan;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import javax.annotation.processing.ProcessingEnvironment;

/**
 * @author longphan
 *
 */
public class Funny_String {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "ivvkx";
		System.out.println(funnyString(s));
	}

	static String funnyString(String s){
		char[] charArrays = s.toCharArray();
		char[] rArrays = new StringBuilder(s).reverse().toString().toCharArray();
		for (int i = 1; i < charArrays.length; i++) {
				int currentNum = charArrays[i];
				int perviousNum = charArrays[i - 1];
				int totalFirst = currentNum - perviousNum;
				
				int currentCompareNum = rArrays[i];
				int perviousCompareNum = rArrays[i - 1];
				int totalCompare = currentCompareNum - perviousCompareNum;
				
				if(Math.abs(totalFirst) != (Math.abs(totalCompare))) {
					return "Not Funny";
				}else {
					i += 1;
				}
		}
		
		return "Funny";
    }
}
