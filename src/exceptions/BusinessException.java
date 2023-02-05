package exceptions;

public class BusinessException extends RuntimeException { //Essa é minha exceção customizada. Ela herda da classe RuntimeException
	private static final long serialVersionUID = 1L;
	
	public BusinessException (String msg) {
		super(msg);
	}
}
