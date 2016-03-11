import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DPElementary {

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
		System.out.println("* Input : " + input.toString());
		findLongestSubsequence(input);
	}

	private static void findLongestSubsequence(List<Integer> input) {
		int[] memory = new int[input.size()];
		for(int i = 0; i < input.size(); i++) {
			if(i == 0) {
				memory[0] = 1;
			} else {
				int memoryToTake = -1;
				int currentNumber = input.get(i);
				int longestSequence = Integer.MIN_VALUE;
				for(int j = 0; j < i; j++) {
					int length = memory[j];
					int lastNumber = input.get(j);
					if(currentNumber > lastNumber && length > longestSequence) {
						longestSequence = length;
						memoryToTake = j;
					}
				}
				if(memoryToTake == -1) {
					memory[i] = 1;
				} else {
					memory[i] = memory[memoryToTake] + 1;
				}
			}
		}
		for(int i = 0; i < input.size(); i++) {
			System.out.println("M[" + i + "] = " + memory[i]);
		}
		
		// print sequence
		List<Integer> toPrint = new ArrayList<>();
		int checkLongestSequence = memory[input.size() - 1] + 1;
		for(int i = input.size() - 1; i >= 0; i--) {
			if(memory[i] == checkLongestSequence - 1) {
				toPrint.add(input.get(i));
				checkLongestSequence = memory[i];
			}
		}
		List<Integer> reversedToPrint = new ArrayList<>();
		for(int i = toPrint.size() - 1; i >= 0; i--) {
			reversedToPrint.add(toPrint.get(i));
		}
		System.out.println("*** Longest Sequence : " + reversedToPrint.toString());
	}
}
