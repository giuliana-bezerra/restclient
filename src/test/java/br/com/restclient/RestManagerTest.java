package br.com.restclient;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for {@link RestManager}. The server must be configured for running
 * these tests.
 *
 * @author giuliana.bezerra
 *
 */
public class RestManagerTest {
	@Test
	public void testManageRequestValidGET() {
		try {
			RestRequest request = new RestRequest();
			request.setServerURL("http://localhost:8080/job/job/config.xml");
			RestManager.manageRequest(request);
			assertTrue(true);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testManageRequestInvalidGET() {
		try {
			RestRequest request = new RestRequest();
			request.setServerURL("http://localhost");
			RestManager.manageRequest(request);
			fail("Invalid GET call!");
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public void testManageRequestValidPOST() {
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
	public void testManageRequestInvalidPOST() {
		try {
			RestRequest request = new RestRequest();
			request.setServerURL("http://192.168.33.10:5984");
			request.setUser("admin");
			request.setPassword("123");
			request.setJson(
					"{    \"glossary\": {        \"title\": \"example glossary\",		\"GlossDiv\": {            \"title\": \"S\",             \"ID\": \"SGML\"        }    }}");
			RestClient.executePostCall(request);
			fail("Invalid POST call!");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
}
