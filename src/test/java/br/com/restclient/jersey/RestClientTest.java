package br.com.restclient.jersey;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.restclient.jersey.RestClient;
import br.com.restclient.jersey.RestRequest;

/**
 * Test class for {@link RestClient}. The server must be configured for running
 * these tests.
 *
 * @author giuliana.bezerra
 *
 */
public class RestClientTest {
	@Test
	public void testExecuteGetCallWithAuthSuccess() {
		try {
			RestRequest request = new RestRequest();
			request.setServerURL("http://192.168.33.10:5984");
			request.setUser("admin");
			request.setPassword("123");
			RestClient.executeGetCall(request);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testExecuteGetCallWithoutAuthSuccess() {
		try {
			RestRequest request = new RestRequest();
			request.setServerURL("http://localhost:8080/job/job/config.xml");
			RestClient.executeGetCall(request);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testExecuteGetCallWithAuthFailure() {
		try {
			RestRequest request = new RestRequest();
			request.setServerURL("http://192.168.33.10:5984");
			request.setUser("admin");
			RestClient.executeGetCall(request);
			fail("Invalid auth!");
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public void testExecuteGetCallWithoutAuthFailure() {
		try {
			RestRequest request = new RestRequest();
			request.setServerURL("http://localhost");
			RestClient.executeGetCall(request);
			fail("Invalid URL!");
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public void testExecutePostCallSuccess() {
		try {
			RestRequest request = new RestRequest();
			request.setServerURL("http://192.168.33.10:5984/teste");
			request.setUser("admin");
			request.setPassword("123");
			request.setJson(
					"{    \"glossary\": {        \"title\": \"example glossary\",		\"GlossDiv\": {            \"title\": \"S\",             \"ID\": \"SGML\"        }    }}");
			RestClient.executePostCall(request);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testExecutePostCallFailure() {
		try {
			RestRequest request = new RestRequest();
			request.setServerURL("http://192.168.33.10:5984/teste");
			request.setUser("admin");
			request.setPassword("123");
			request.setJson("{");
			RestClient.executePostCall(request);
			fail("Invalid JSON!");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
}
