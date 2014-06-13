package se.r2m.lab.xd.http.client;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.FactoryBean;

/**
 * Factory bean for creating {@link HttpClient} with authentication set.
 * 
 */
public class HttpClientFactoryBean implements FactoryBean<HttpClient> {

	private String username;

	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public HttpClient getObject() throws Exception {
		if (username != null && password != null) {
			CredentialsProvider credsProvider = new BasicCredentialsProvider();
			credsProvider.setCredentials(AuthScope.ANY,
					new UsernamePasswordCredentials(username, password));
			return HttpClients.custom()
					.setDefaultCredentialsProvider(credsProvider).build();
		} else {
			return HttpClients.createDefault();
		}
	}

	public Class<?> getObjectType() {
		return HttpClient.class;
	}

	public boolean isSingleton() {
		return true;
	}
}
