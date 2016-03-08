import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectionSort {

	public static void main(String[] args) {
		if(args.length != 1) {
			throw new IllegalArgumentException("expecting one argument");
		}
		List<Integer> input = new ArrayList<>();
		Scanner scanner = new Scanner(args[0]);
		while(scanner.hasNextInt()) {
			input.add(scanner.nextInt());
		}
		scanner.close();
		System.out.println("*** Input : " + input.toString());
		doSelectionSort(input);
		System.out.println("*** Output : " + input.toString());
	}

	private static void doSelectionSort(List<Integer> input) {
		for(int i = 0; i < input.size(); i++) {
			// find smallest number from unsorted set
			int smallestNumber = Integer.MAX_VALUE;
			int smallestNumberLocation = -1;
			for(int j = i; j < input.size(); j++) {
				int checkNumber = input.get(j);
				if(checkNumber < smallestNumber) {
					smallestNumber = checkNumber;
					smallestNumberLocation = j;
				}
			}
			// swap that smallest number with first unsorted number
			int firstUnsortedNumber = input.get(i);
			input.set(i, smallestNumber);
			input.set(smallestNumberLocation, firstUnsortedNumber);
		}
	}
}
