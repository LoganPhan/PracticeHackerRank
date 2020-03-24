package PracticeHackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* Find the factors of given number(n) by index(p)
* exp: given n = 10 p = 1. Output: should be 2.
* other testcase: n = 22876792454961 and p = 28

*
*/
public class ThirdBiggestNumber5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.valueOf(inp.readLine());
		long p = Long.valueOf(inp.readLine());
		System.out.println(pthFactor(n, p));

	}

	public static long pthFactor(long n, long p) {
		List<Long> result = new ArrayList<>();
		if (n > 1) {
			doFactor(result, 0, n, n);
		} else {
			return 1;
		}
		int indexOfP = Long.valueOf(p).intValue();
		if (indexOfP >= result.size()) {
			return 0;
		}
		return result.get(indexOfP);
	}

	public static void doFactor(List<Long> result, long low, long hight, long n) {
		for (long i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				if (n / i == i)
					result.add(i);
				else {
					result.add(i);
					result.add(n / i);
				}
			}
		}
		Collections.sort(result);
	}
}
