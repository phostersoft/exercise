
// https://community.topcoder.com/stat?c=problem_statement&pm=14182

public class TC14182 {

	public static void main(String[] args) {
		int[] a = new int[]{3, 10, 0, 4, 0, 0, 0, 1, 0};
		int[] b = new int[]{5, 5, 0, 7, 0, 0, 0, 0, 1};
		System.out.println("*** Result : " + calculate(a, b));
	}

	private static int calculate(int[] a, int[] b) {
		int move = 0;
		int[] c = new int[a.length];
		for(int i = 0; i < a.length; i++) {
			c[i] = a[i] - b[i];
		}
		int runningCount = c[0];
		for(int i = 1; i < a.length; i++) {
			if(runningCount < 0) {
				move -= runningCount;
			} else {
				move += runningCount;
			}
			runningCount += c[i];
		}
		if(runningCount != 0) {
			return -1;
		}
		return move;
	}
}
