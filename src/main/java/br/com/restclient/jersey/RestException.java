package br.com.restclient.jersey;

/**
 * Checked exception for specific application purpose.
 * 
 * @author giuliana.bezerra
 *
 */
public class RestException extends Exception {
	private static final long serialVersionUID = -285309851156081335L;

	public RestException(String msg) {
		super(msg);
	}

	public RestException(Exception ex) {
		super(ex);
	}
}
