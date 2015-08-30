package minesharelib;

import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.List;

public class Content extends Data {
	public final int user;
	public final String sha1;

	public static List<Content> all() throws IOException {
		return API.mapper.readValue(Data.allWith("content").asText(), new TypeReference<List<Content>>() {});
	}

	protected static Content fromJson(String json) throws IOException {
		return API.mapper.readValue(json, Content.class);
	}

	public String toJson() throws IOException {
		return API.mapper.writeValueAsString(this);
	}

	public Content(int user, String sha1) {
		this.user = user;
		this.sha1 = sha1;
	}
}
