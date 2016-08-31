package br.com.restclient;

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
	public static final List<String> OPTIONS = Arrays
			.asList(new String[] { OPTION_USER, OPTION_PASSWORD, OPTION_JSON_PATH });
}
