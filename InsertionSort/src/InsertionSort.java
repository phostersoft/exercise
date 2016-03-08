import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertionSort {

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
		doInsertionSort(input);
		System.out.println("*** Output : " + input.toString());
	}

	private static void doInsertionSort(List<Integer> input) {
		for(int i = 0; i < input.size(); i++) {
			int currentNumber = input.get(i);
			for(int j = 0; j < i; j++) {
				int checkNumber = input.get(j);
				 // correct location found for currentNumber : j
				if(checkNumber > currentNumber) {
					// shift numbers to make way for currentNumber
					for(int k = i; k > j; k--) {
						int previousNumber = input.get(k - 1);
						input.set(k, previousNumber);
					}
					// insert currentNumber
					input.set(j, currentNumber);
					break;
				}
			}
		}
	}
}
