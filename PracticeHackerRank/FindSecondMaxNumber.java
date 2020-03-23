public static void main(String[] args) throws NumberFormatException, IOException {
		int[] arr = {10, 10, 9, 8, 2}; // output: 10,9
    //int[] arr = {10, 10, 9, 8, 2, 13}; // output: 13,10
    //int[] arr = {10, 10, 9, 8, 2, 13, 12}; //output: 13,12
    //int[] arr = {-1, 10, 10, 9, 8, 2}; // output: 10,9
		//int[] result = solution(arr);
		Arrays.stream(result).forEach(ite -> System.out.println(ite));

	}

	public static int[] solution(int[] arr) {
		int max1 = arr[0];
		int max2 = arr[0];
		for (int i = 1; i < arr.length; i++) {
			int num = arr[i];
			if(max1 == max2 && num < max2) {
				max2 = num;
			}
			else if(num > max1) {
				max2 = max1;
				max1 = num;
			}
			else if(num > max2){
				max2 = num;
			}
		}
		return new int[] {max1, max2};;
	}

}
