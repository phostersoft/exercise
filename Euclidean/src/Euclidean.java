
public class Euclidean {

	public static void main(String[] args) {
		if(args.length != 2) {
			throw new IllegalArgumentException("expecting two arguments");
		}
		int a = Integer.valueOf(args[0]);
		int b = Integer.valueOf(args[1]);
		System.out.println("*** GCD of " + a + " and " + b + " is " + gcd(a, b));
		System.out.println("*** LCM of " + a + " and " + b + " is " + lcm(a, b));
	}

	private static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	private static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
}
