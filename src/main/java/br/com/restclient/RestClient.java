package br.com.restclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

/**
 * Generic REST cliente which hadles get and post calls to a server.
 *
 * @author giuliana.bezerra
 *
 */
public class RestClient {
	private static String APPLICATION_JSON = "application/json";
	private static String HTTP_ERROR_CODE = "HTTP error code : ";

	public static String executeGetCall(RestRequest restRequest) {
		ClientResponse response = getWebResource(restRequest).accept(APPLICATION_JSON).get(ClientResponse.class);
		validateGetResponse(response);
		return getOutputFromResponse(response);
	}

	public static String executePostCall(RestRequest restRequest) {
		ClientResponse response = getWebResource(restRequest).accept(APPLICATION_JSON).type(APPLICATION_JSON)
				.post(ClientResponse.class, restRequest.getJson());
		validatePostResponse(response);
		return getOutputFromResponse(response);
	}

	private static String getOutputFromResponse(ClientResponse response) {
		String output = response.getEntity(String.class);
		System.out.println(output);
		return output;
	}

	private static WebResource getWebResource(RestRequest restRequest) {
		Client client = Client.create();
		if (restRequest.hasAuth())
			client.addFilter(new HTTPBasicAuthFilter(restRequest.getUser(), restRequest.getPassword()));
		return client.resource(restRequest.getServerURL());
	}

	private static void validateGetResponse(ClientResponse response) {
		if (isInvalidStatusForGet(response))
			throw new RuntimeException(HTTP_ERROR_CODE + response.getStatus());
	}

	private static boolean isInvalidStatusForGet(ClientResponse response) {
		return response.getStatus() != 200 && response.getStatus() != 404;
	}

	private static void validatePostResponse(ClientResponse response) {
		if (isInvalidStatusForPost(response))
			throw new RuntimeException(HTTP_ERROR_CODE + response.getStatus());
	}

	private static boolean isInvalidStatusForPost(ClientResponse response) {
		return response.getStatus() != 201;
	}
}
