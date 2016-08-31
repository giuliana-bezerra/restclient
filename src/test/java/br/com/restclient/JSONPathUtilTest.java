package br.com.restclient;

import static org.junit.Assert.*;

import org.junit.Test;

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
