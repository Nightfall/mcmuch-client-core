package minesharelib;

import org.apache.http.HttpHost;

import java.io.IOException;

class Requester {
	private final HttpHost host;
	public final String base;

	public Requester(String url) {
		this.host = new HttpHost(url, 80, "http");
		this.base = host.getSchemeName() + host.getHostName() + "/api/v1";
	}

	public void put(String request, String json) throws IOException {
		// TODO;
	}
}
