package br.com.restclient.jersey;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.restclient.jersey.JSONPathUtil;

/**
 * Test class for JSONPathUtil methods.
 *
 * @author giuliana.bezerra
 *
 */
public class JSONPathUtilTest {
	@Test
	public void testGetJSONFromPathSuccess() {
		String json = JSONPathUtil
				.getJSONFromPath(JSONPathUtil.class.getClassLoader().getResource("files/json_file.txt").getPath());
		String jsonExpected = "{    \"glossary\": {        \"title\": \"example glossary\",		\"GlossDiv\": {            \"title\": \"S\",             \"ID\": \"SGML\"        }    }}";
		assertEquals(jsonExpected, json);
	}

	@Test
	public void testGetJSONFromPathFailure() {
		try {
			JSONPathUtil.getJSONFromPath("json_file.txt");
			fail("Invalid path!");
		} catch (RuntimeException e) {
			assertTrue(true);
		}
	}
}
