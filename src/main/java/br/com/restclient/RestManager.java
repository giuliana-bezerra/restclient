package br.com.restclient;

/**
 * Manager responsible for making calls to the rest client .
 *
 * @author giuliana.bezerra
 *
 */
public class RestManager {

	public static void manageRequest(RestRequest restRequest) {
		if (restRequest.isGetRequest())
			RestClient.executeGetCall(restRequest);
		else
			RestClient.executePostCall(restRequest);
	}

}
