package cat.dbuenov.app.errors;

public class EmpleatNotFoundException extends RuntimeException{
	
	public EmpleatNotFoundException(Long id) {
		super("No he trobat l'empleat "+id);
	}

}
