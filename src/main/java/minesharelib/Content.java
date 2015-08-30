package minesharelib;

import org.codehaus.jackson.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Content extends Data {
	public final int user;
	public final String sha1;

	public static List<Content> all() throws IOException {
		List<Content> contents = new ArrayList<Content>();
		for (JsonNode node : Data.allWith("content")) {
			contents.add(fromJson(node));
		}
		return contents;
	}

	protected static Content fromJson(JsonNode json) throws IOException {
		return API.mapper.readValue(json.asText(), Content.class);
	}

	public Content(int user, String sha1) {
		this.user = user;
		this.sha1 = sha1;
	}
}
