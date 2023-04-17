package others;

import java.util.Scanner;


public class InputValidator {
	public int askInput(Scanner sc) {
		try {
			return Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {}
		return 0;
	}
}
