import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DPSimple {

	public static void main(String[] args) {
		if(args.length != 2) {
			throw new IllegalArgumentException("expecting two arguments");
		}
		List<Integer> coins = new ArrayList<>();
		Scanner scanner = new Scanner(args[0]);
		while(scanner.hasNextInt()) {
			coins.add(scanner.nextInt());
		}
		scanner.close();
		int sum = Integer.valueOf(args[1]);
		int minNumberOfCoins = calculateMinNumberOfCoins(coins, sum);
		System.out.println("*** Mininum number of coins is " + minNumberOfCoins);
	}

	private static int calculateMinNumberOfCoins(List<Integer> coins, int sum) {
		int[] memory = new int[sum + 1];
		memory[0] = 0;
		for(int i = 1; i <= sum; i++) {
			memory[i] = Integer.MAX_VALUE;
			for(int j = 0; j < i; j++) {
				for(int coin : coins) {
					if((j + coin == i) && (memory[j] + 1 < memory[i])) {
						memory[i] = memory[j] + 1;
					}
				}
			}
		}
		for(int i = 0; i <= sum; i++) {
			System.out.println("M[" + i + "]=" + memory[i]);
		}
		return memory[sum];
	}
}
