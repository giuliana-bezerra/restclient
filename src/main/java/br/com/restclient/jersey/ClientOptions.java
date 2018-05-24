package br.com.restclient.jersey;

import java.util.Arrays;
import java.util.List;

/**
 * Constants for operations supported.
 *
 * @author giuliana.bezerra
 *
 */
public class ClientOptions {
	public static final String OPTION_USER = "-u";
	public static final String OPTION_PASSWORD = "-p";
	public static final String OPTION_JSON_PATH = "-j";
	public static final String OPTION_HELP = "-h";
	protected static final List<String> OPTIONS = Arrays.asList(OPTION_USER, OPTION_PASSWORD, OPTION_JSON_PATH);

	private ClientOptions() {
		// DO NOTHING.
	}
}
