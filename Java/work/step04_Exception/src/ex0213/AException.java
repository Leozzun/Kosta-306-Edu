package ex0213;

public class AException extends Exception {
	
	static int count;
	
	public AException(String message) {
		super(message);
	}
}
