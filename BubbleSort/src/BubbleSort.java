import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BubbleSort {

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
		doBubbleSort(input);
		System.out.println("*** Output : " + input.toString());
	}

	private static void doBubbleSort(List<Integer> input) {
		boolean hasModification = true;
		while(hasModification) {
			hasModification = false;
			for(int i = 0; i < input.size() - 1; i++) {
				int first = input.get(i);
				int second = input.get(i + 1);
				if(first > second) {
					input.set(i, second);
					input.set(i + 1, first);
					hasModification = true;
				}
			}
		}
	}
}
