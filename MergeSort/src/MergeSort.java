import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergeSort {

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
		input = doMergeSort(input);
		System.out.println("*** Output : " + input.toString());
	}

	private static List<Integer> doMergeSort(List<Integer> input) {
		System.out.println("Sorting " + input.toString());
		if(input.size() <= 1) {
			System.out.println("Sorted " + input.toString());
			return input;
		}
		int midPoint = input.size() / 2;
		List<Integer> firstHalf = new ArrayList<>();
		for(int i = 0; i < midPoint; i++) {
			firstHalf.add(input.get(i));
		}
		List<Integer> secondHalf = new ArrayList<>();
		for(int i = midPoint; i < input.size(); i++) {
			secondHalf.add(input.get(i));
		}
		
		System.out.println("Splitting to " + firstHalf.toString() +
				" and " + secondHalf.toString());
		List<Integer> firstHalfSorted = doMergeSort(firstHalf);
		List<Integer> secondHalfSorted = doMergeSort(secondHalf);
		System.out.println("Merging " + firstHalfSorted.toString() +
				" with " + secondHalfSorted.toString());

		List<Integer> sorted = new ArrayList<>();
		int firstHalfIndex = 0;
		int secondHalfIndex = 0;
		while(true) {
			int firstHalfNumber = firstHalfSorted.get(firstHalfIndex);
			int secondHalfNumber = secondHalfSorted.get(secondHalfIndex);
			if(firstHalfNumber < secondHalfNumber) {
				sorted.add(firstHalfNumber);
				firstHalfIndex++;
			} else {
				sorted.add(secondHalfNumber);
				secondHalfIndex++;
			}
			if(firstHalfIndex == firstHalfSorted.size()) {
				for(int i = secondHalfIndex; i < secondHalfSorted.size(); i++) {
					sorted.add(secondHalfSorted.get(i));
				}
				break;
			}
			if(secondHalfIndex == secondHalfSorted.size()) {
				for(int i = firstHalfIndex; i < firstHalfSorted.size(); i++) {
					sorted.add(firstHalfSorted.get(i));
				}
				break;
			}
		}
		System.out.println("Sorted " + sorted.toString());
		return sorted;
	}
}
