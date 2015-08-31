package minesharelib;

import java.io.IOException;
import java.util.List;

public class Content extends Data {
	public final int user;

	public final String sha1;
	public final String name;
	public final String type;

	public static List<Content> all() throws IOException {
		return Data.getWith("content", Content.class);
	}

	public static List<Content> withUser(int id) throws IOException {
		return Data.getWith("content/by_user/" + Integer.toString(id), Content.class);
	}

	public static List<Content> withUser(User user) throws IOException {
		return withUser(user.id);
	}

	public static List<Content> withName(String name) throws IOException {
		return Data.getWith("content/" + name, Content.class);
	}

	public static List<Content> withSha1(String sha1) throws IOException {
		return withName(sha1);
	}

	protected static Content fromJson(String json) throws IOException {
		return API.mapper.readValue(json, Content.class);
	}

	public Content(int user, String sha1, String name, String type) {
		this.user = user;
		this.sha1 = sha1;
		this.name = name;
		this.type = type;
	}
}
