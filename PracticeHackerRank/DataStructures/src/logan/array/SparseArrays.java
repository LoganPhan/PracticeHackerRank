package logan.array;

public class SparseArrays {

	public static void main(String[] args) {
		String[] strings = {"aba", "baba", "aba", "xzxb"};
		String[] queries = {"aba", "xzxb", "ab"};
		int[] result = solve(strings, queries);
		for (int i : result) {
			System.out.println(i);
		}
		
	}
	
	static int[] solve(String[] strings, String[] queries) {
		return null;
	}
	
	/*static int[] solve(String[] strings, String[] queries) {
		int length = queries.length;
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = countOccurence(0, queries[i], strings, 0);
		}
		return result;
	}
	
	static int countOccurence(int count, String str, String[] strings, int index) {
		if(index >= strings.length) {
			return count;
		}
		else {
			String strInd = strings[index];
			if(str.equals(strInd)) {
				return countOccurence(++count, str, strings,  ++index);
			}else {
				return countOccurence(count, str, strings,  ++index);
			}
		}
	}*/
}
