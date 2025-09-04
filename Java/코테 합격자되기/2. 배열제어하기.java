	private static int[] solution(int[] arr) {
		int[] clone = arr.clone();
		Integer[] result = Arrays.stream(clone).boxed().distinct().toArray(Integer[]::new);
 		Arrays.sort(result, Collections.reverseOrder());
 		return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
	}
	
