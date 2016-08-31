package br.com.restclient;

/**
 * Class of message constants.
 *
 * @author giuliana.bezerra
 *
 */
public class ClientMessage {
	public static final String INVALID_OPTION_VALUE = "Invalid option value! Usage example: java -jar restclient.jar url -u user -p password -j path";
	public static final String ILLEGAL_ARGUMENT_MESSAGE = "Must inform at least 1 argument!";
	public static final String ILLEGAL_OPTIONS_MESSAGE = "Invalid option!";
	public static final String HELP_MESSAGE = "Generic REST client. The program gets 4 parameters: \n\n"
			+ "1. Server URL \n" + "2. -u User \n" + "3. -p Password \n" + "4. -j Path for JSON file \n"
			+ "5. -h Help option \n\n"
			+ "If parameter 4 is omitted, then a get operation will be performed. Otherwise, "
			+ "a POST operation will be performed. The syntax is: java -jar "
			+ "restclient.jar url -u user -p password -j path. Examples: \n\n"
			+ "1. Get URL: java -jar restclient.jar http://localhost:8080 \n"
			+ "2. Get URL using auth: java -jar restclient.jar http://localhost:8080 -u user -p password \n"
			+ "3. Post URL: java -jar restclient.jar http://localhost:8080 -j path \n"
			+ "4. Post URL using auth: java -jar restclient.jar http://localhost:8080 -u user -p password -j path \n";
}
