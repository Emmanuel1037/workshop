import java.util.*;

public class BinaryConverterWithRecursion {
	public static void main(String[] args) {
		Scanner openSesame = new Scanner(System.in);
		System.out.print("Give me a binary number to convert to decimal: ");
		String binary = openSesame.next();
		System.out.printf("The program has declared that %d is the correct answer.", BinaryConv(binary));
	}
	
	public static int BinaryConv(String binary, int... params) {
		int position = params[0];
		int power = params[1];
		int sum = params[2];
		int temp = Integer.parseInt(Character.toString(binary.charAt(position))) * (int)Math.pow(2, power);
		sum += temp;
		power++;
		position--;
		if (position < 0)
			return sum;
		else
			return BinaryConv(binary, position, power, sum);
	}
	
	public static int BinaryConv(String binary) {
		if (!isBinary(binary)) {
			System.out.print("Oops! Damn nigga you sold. Try again.\n");
			Scanner retry = new Scanner(System.in);
			return BinaryConv(retry.next());
		}
		else {
			while (binary.startsWith("0")) {
				binary = binary.substring(1);
			}
			int position = binary.length() - 1;
			return BinaryConv(binary, position, 0, 0);
		}
	}
	
	public static boolean isBinary(String binary) {
		boolean hope = true;
		for (int i = 0; i < binary.length(); i++) {
			if (binary.charAt(i) != '0' && binary.charAt(i) != '1') {
				hope = false;
				break;
			}
			else {
				hope = true;
			}
		}
		return hope;
	}
}
