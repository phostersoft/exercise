import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		if(args.length != 2) {
			throw new IllegalArgumentException("expecting two arguments");
		}
		List<Integer> array = new ArrayList<>();
		Scanner scanner = new Scanner(args[0]);
		while(scanner.hasNextInt()) {
			array.add(scanner.nextInt());
		}
		scanner.close();
		int toSearch = Integer.valueOf(args[1]);
		boolean result = binarySearch(array, toSearch, 0, array.size() - 1);
		System.out.println("*** Searching for " + toSearch + " in " + array + " : " + result);
	}

	public static boolean binarySearch(List<Integer> array, int toSearch,
			int minIndex, int maxIndex) {
		System.out.println("* Index " + minIndex + " to " + maxIndex);
		if(minIndex >= maxIndex) {
			return false;
		}
		int midIndex = (minIndex + maxIndex + 1) / 2;
		int midValue = array.get(midIndex);
		if(midValue == toSearch) {
			return true;
		}
		if(toSearch < midValue) {
			return binarySearch(array, toSearch, minIndex, midIndex - 1);
		} else {
			return binarySearch(array, toSearch, midIndex + 1, maxIndex);
		}
	}
}
