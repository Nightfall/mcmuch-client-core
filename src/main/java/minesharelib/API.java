package minesharelib;

import org.codehaus.jackson.map.ObjectMapper;

public class API {
	public static final API INSTANCE = new API("http://mineshare.com");
	public static final ObjectMapper mapper = new ObjectMapper();


	public final Requester requester;

	public API(String url) {
		this.requester = new Requester(url);
	}
}