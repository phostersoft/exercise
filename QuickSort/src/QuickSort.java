import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuickSort {

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
		doQuickSort(input);
		System.out.println("*** Output : " + input.toString());
	}

	private static void doQuickSort(List<Integer> input) {
		System.out.println("Sorting " + input.toString());
		if(input.size() <= 1) {
			System.out.println("Sorted " + input.toString());
			return;
		}
		int midIndex = (0 + input.size()) / 2;
		int midValue = input.get(midIndex);
		System.out.println("Pivot on index " + midIndex + " with value " + midValue);
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		for(int i = 0; i < input.size(); i++) {
			if(i == midIndex) {
				continue;
			}
			int checkValue = input.get(i);
			if(checkValue < midValue) {
				left.add(checkValue);
			} else {
				right.add(checkValue);
			}
		}
		doQuickSort(left);
		doQuickSort(right);
		input.clear();
		for(int leftValue : left) {
			input.add(leftValue);
		}
		input.add(midValue);
		for(int rightValue : right) {
			input.add(rightValue);
		}
		System.out.println("Sorted " + input.toString());
	}
}
