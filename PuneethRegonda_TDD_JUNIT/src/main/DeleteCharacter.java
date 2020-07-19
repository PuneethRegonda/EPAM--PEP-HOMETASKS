package main;

public class DeleteCharacter {

	public String deleteA(String string) {
		// String result = null;
		if (string.length() < 1) {
			return string;
		} else if (string.charAt(0) == 'A' && string.charAt(1) == 'A') {
			return string.substring(2, string.length());
		} else if (string.charAt(0) == 'A') {

			return string.substring(1, string.length());

		} else if (string.charAt(1) == 'A') {
			return string.substring(0, 1) + string.substring(2, string.length());
		} else {
			return string;
		}
	}

}
