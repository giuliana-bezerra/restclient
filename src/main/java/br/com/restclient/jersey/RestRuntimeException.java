package br.com.restclient.jersey;

/**
 * Non-checked exception for specific application purpose.
 * 
 * @author giuliana.bezerra
 *
 */
public class RestRuntimeException extends RuntimeException {
	private static final long serialVersionUID = -6244922114357731942L;

	public RestRuntimeException(String msg) {
		super(msg);
	}
}
