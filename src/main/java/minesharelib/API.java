package minesharelib;

import org.codehaus.jackson.map.ObjectMapper;

public class API {
	public static API INSTANCE = new API("http://mineshare.com", 9292);
	public static final ObjectMapper mapper = new ObjectMapper();


	public final Requester requester;

	public API(String url, int port) {
		this.requester = new Requester(url, port);
	}
}