package br.com.restclient.jersey;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.restclient.jersey.ClientMessage;
import br.com.restclient.jersey.JSONPathUtil;
import br.com.restclient.jersey.Main;

/**
 * Test class which calls the main method for testing the operation options. The
 * server must be configured for running these tests.
 *
 * @author giuliana.bezerra
 *
 */
public class MainTest {
	@Test
	public void testMainHelp() {
		try {
			Main.main(new String[] { "-h" });
			assertTrue(true);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testMainNoArguments() {
		try {
			Main.main(new String[] {});
		} catch (RuntimeException e) {
			assertEquals(ClientMessage.ILLEGAL_ARGUMENT_MESSAGE, e.getMessage());
		}
	}

	@Test
	public void testMainInvalidArguments() {
		try {
			Main.main(new String[] { "-u", "user", "-p" });
		} catch (RuntimeException e) {
			assertEquals(ClientMessage.ILLEGAL_ARGUMENT_MESSAGE, e.getMessage());
		}
	}

	@Test
	public void testMainInvalidOption() {
		try {
			Main.main(new String[] { "http://localhost:8080", "-l" });
		} catch (RuntimeException e) {
			assertEquals("-l: " + ClientMessage.ILLEGAL_OPTIONS_MESSAGE, e.getMessage());
		}
	}

	@Test
	public void testMainNoHost() {
		try {
			Main.main(new String[] { "-u", "user" });
		} catch (RuntimeException e) {
			assertEquals(ClientMessage.ILLEGAL_ARGUMENT_MESSAGE, e.getMessage());
		}
	}

	@Test
	public void testMainInvalidOptionValue() {
		try {
			Main.main(new String[] { "http://localhost:8080", "-u", "user", "-p" });
		} catch (RuntimeException e) {
			assertEquals("-p: " + ClientMessage.INVALID_OPTION_VALUE, e.getMessage());
		}
	}

	@Test
	public void testMainValidOptionValueHostArgument() {
		try {
			Main.main(new String[] { "http://localhost:8080" });
			assertTrue(true);
		} catch (RuntimeException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testMainValidOptionValueHostAuthArguments() {
		try {
			Main.main(new String[] { "http://192.168.33.10:5984", "-u", "admin", "-p", "123" });
			assertTrue(true);
		} catch (RuntimeException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testMainValidOptionValueHostAuthJsonArguments() {
		try {
			Main.main(new String[] { "http://192.168.33.10:5984/teste", "-u", "admin", "-p", "123", "-j",
					JSONPathUtil.class.getClassLoader().getResource("files/json_file.txt").getPath() });
			assertTrue(true);
		} catch (RuntimeException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testMainValidArgumentsInvalidJson() {
		try {
			Main.main(new String[] { "http://192.168.33.10:5984/teste", "-u", "admin", "-p", "123", "-j",
					JSONPathUtil.class.getClassLoader().getResource("json_file.txt").getPath() });
			fail("Invalid json file!");
		} catch (RuntimeException e) {
			assertTrue(true);
		}
	}
}
