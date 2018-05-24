package br.com.restclient.jersey;

/**
 * Manager responsible for making calls to the rest client .
 *
 * @author giuliana.bezerra
 *
 */
public class RestManager {
	private RestManager() {
		// DO NOTHING.
	}

	public static void manageRequest(RestRequest restRequest) {
		if (restRequest.isGetRequest())
			RestClient.executeGetCall(restRequest);
		else
			RestClient.executePostCall(restRequest);
	}

}
