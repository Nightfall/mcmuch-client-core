package minesharelib;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

class Requester {
	private static final HttpClient client = HttpClients.createDefault();
	private final HttpHost host;
	public final String base;

	public Requester(String url) {
		this.host = new HttpHost(url, 80, "http");
		this.base = host.getSchemeName() + host.getHostName() + "/api/v1";
	}

	public HttpResponse put(String request, String json) throws IOException {
		HttpPut put = new HttpPut(request);
		put.setEntity(new StringEntity(json));
		return client.execute(host, put);
	}
}
