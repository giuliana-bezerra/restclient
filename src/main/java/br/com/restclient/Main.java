package br.com.restclient;

import static br.com.restclient.ClientMessage.*;
import static br.com.restclient.ClientOptions.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Generic REST client. The program gets 4 parameters: <br/>
 * <br/>
 *
 * 1. Server URL <br/>
 * 2. -u User <br/>
 * 3. -p Password <br/>
 * 4. -j Path for JSON file <br/>
 * 5. -h Help option <br>
 * <br/>
 *
 * If parameter 4 is omitted, then a get operation will be performed. Otherwise,
 * a POST operation will be performed. The syntax is: <b>java -jar
 * restclient.jar url -u user -p password -j path</b>. Examples: <br/>
 * <br/>
 *
 * 1. Get URL: java -jar restclient.jar http://localhost:8080 <br/>
 * 2. Get URL using auth: java -jar restclient.jar http://localhost:8080 -u user
 * -p password <br/>
 * 3. Post URL: java -jar restclient.jar http://localhost:8080 -j path <br/>
 * 4. Post URL using auth: java -jar restclient.jar http://localhost:8080 -u
 * user -p password -j path <br/>
 *
 * @author giuliana.bezerra
 *
 */
public class Main {
	private static RestRequest restRequest;

	public static void main(String[] args) {
		List<String> argsList = Arrays.asList(args);
		if (argsList.contains(OPTION_HELP)) {
			showHelpMessage();
			return;
		}
		validateArguments(argsList);
		buildRequest(argsList);
		RestManager.manageRequest(restRequest);
	}

	private static void showHelpMessage() {
		System.out.println(HELP_MESSAGE);
	}

	private static void buildRequest(List<String> args) {
		restRequest = new RestRequest();
		restRequest.setServerURL(getURL(args));
		restRequest.setUser(getOptionValue(args, OPTION_USER));
		restRequest.setPassword(getOptionValue(args, OPTION_PASSWORD));
		restRequest.setJson(JSONPathUtil.getJSONFromPath(getOptionValue(args, OPTION_JSON_PATH)));
	}

	private static String getOptionValue(List<String> args, String option) {
		Iterator<String> it = args.iterator();
		while (it.hasNext()) {
			String arg = it.next();
			if (arg.equals(option))
				return it.next();
		}
		return null;
	}

	private static void validateArguments(List<String> args) {
		if (isInvalidArgs(args))
			throw new RuntimeException(ILLEGAL_ARGUMENT_MESSAGE);
		validateOptions(args);
		validateOptionArgs(args);
	}

	private static void validateOptions(List<String> args) {
		for (String arg : args) {
			if (isOption(arg) && !OPTIONS.contains(arg))
				throw new RuntimeException(arg + ": " + ILLEGAL_OPTIONS_MESSAGE);
		}
	}

	private static void validateOptionArgs(List<String> args) {
		for (String option : OPTIONS) {
			if (isInvalidOptionArgs(args, option))
				throw new RuntimeException(option + ": " + INVALID_OPTION_VALUE);
		}
	}

	private static boolean isInvalidOptionArgs(List<String> args, String option) {
		Iterator<String> it = args.iterator();
		while (it.hasNext()) {
			if (it.next().equals(option))
				return !it.hasNext() || isOption(it.next());
		}
		return false;
	}

	private static boolean isInvalidArgs(List<String> args) {
		return args.size() < 1 || isOption(args.get(0));
	}

	private static boolean isOption(String texto) {
		return texto.startsWith("-");
	}

	public static String getURL(List<String> args) {
		return args.get(0);
	}
}
