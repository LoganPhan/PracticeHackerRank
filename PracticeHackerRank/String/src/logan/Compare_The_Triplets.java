package logan;

import java.util.regex.Pattern;

public class Compare_The_Triplets {

	public static void main(String[] args) {
		
		solve(1, 2, 3, 1, 2, 3);
		
	}

	/*
	 * Complete the solve function below.
	 */
	static int[] solve(int a0, int a1, int a2, int b0, int b1, int b2) {
		StringBuilder builder = new StringBuilder();

		caculate(a0, b0, builder);
		caculate(a1, b1, builder);
		caculate(a2, b2, builder);
		int[] result = { builder.toString().replaceAll("secondParam,|,secondParam", "").split("\\s*,\\s*").length,
				builder.toString().replaceAll("firstParam,|,firstParam", "").split("\\s*,\\s*").length };
		return result;
	}

	static void caculate(int first, int second, StringBuilder builder) {
		if (first > second)
			builder.append("firstParam,");
		else if (first < second)
			builder.append("secondParam,");
		return;
	}
}
