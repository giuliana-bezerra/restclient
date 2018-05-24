package br.com.restclient.jersey;

import java.io.BufferedReader;
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

	private JSONPathUtil() {
		// DO NOTHING.
	}

	public static String getJSONFromPath(String jsonPath) {
		try {
			return handleJsonPath(jsonPath);
		} catch (Exception e) {
			throw new RestRuntimeException(e.getMessage());
		}
	}

	private static String handleJsonPath(String jsonPath) throws RestException {
		try {
			if (isPathNotEmpty(jsonPath))
				return getJSONFileContent(jsonPath);
			else
				return null;
		} catch (Exception e) {
			throw new RestException(e);
		}
	}

	private static boolean isPathNotEmpty(String jsonPath) {
		return jsonPath != null && !jsonPath.trim().isEmpty();
	}

	private static String getJSONFileContent(String jsonPath) throws RestException {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		try {
			fileReader = new FileReader(jsonPath);
			bufferedReader = new BufferedReader(fileReader);
			String line;
			StringBuilder json = new StringBuilder();
			while ((line = bufferedReader.readLine()) != null) {
				json.append(line);
			}
			return json.toString();
		} catch (Exception e) {
			throw new RestException(e);
		} finally {
			closeResources(fileReader, bufferedReader);
		}
	}

	private static void closeResources(FileReader fileReader, BufferedReader bufferedReader) {
		try {
			if (fileReader != null)
				fileReader.close();
			if (bufferedReader != null)
				bufferedReader.close();
		} catch (IOException e) {
			// DO NOTHING.
		}
	}

}
