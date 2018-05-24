package br.com.restclient.jersey;

/**
 * Entity that encapsulates attributes required for REST service requests.
 *
 * @author giuliana.bezerra
 *
 */
public class RestRequest {
	private String serverURL;
	private String user;
	private String password;
	private String jsonPath;
	private String json;

	public String getServerURL() {
		return serverURL;
	}

	public void setServerURL(String serverURL) {
		this.serverURL = serverURL;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJsonPath() {
		return jsonPath;
	}

	public void setJsonPath(String jsonPath) {
		this.jsonPath = jsonPath;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public boolean isGetRequest() {
		return (json == null || json.isEmpty());
	}

	public boolean hasAuth() {
		return (user != null && password != null);
	}
}
