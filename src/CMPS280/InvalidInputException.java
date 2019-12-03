package CMPS280;

@SuppressWarnings("serial")
public class InvalidInputException extends Exception {
//constructors
	public InvalidInputException() {
		super("Input has to be a double");
	}

	public InvalidInputException(String message) {
		super(message);
	}
}
