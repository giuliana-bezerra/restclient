package br.com.restclient;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Utility class which provides utility methods for managing json content from a
 * path.
 *
 * @author giuliana.bezerra
 *
 */
public class JSONPathUtil {

	public static String getJSONFromPath(String jsonPath) {
		try {
			return handleJsonPath(jsonPath);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	private static String handleJsonPath(String jsonPath) throws FileNotFoundException, IOException {
		if (isPathNotEmpty(jsonPath))
			return getJSONFileContent(jsonPath);
		else
			return null;
	}

	private static boolean isPathNotEmpty(String jsonPath) {
		return jsonPath != null && !jsonPath.trim().isEmpty();
	}

	private static String getJSONFileContent(String jsonPath) throws FileNotFoundException, IOException {
		FileReader fileReader = new FileReader(jsonPath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line, json = "";
		while ((line = bufferedReader.readLine()) != null) {
			json += line;
		}
		bufferedReader.close();
		return json;
	}

}
