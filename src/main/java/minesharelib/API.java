package minesharelib;

import minesharelib.util.Requester;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;

public class API {
	public static API INSTANCE = new API("http://mineshare.com");
	public static final HttpClient client = HttpClients.createDefault();

	public final Requester requester;

	public API(String url) {
		this.requester = new Requester(url);
	}
}