package minesharelib;

import minesharelib.util.Function;
import org.codehaus.jackson.JsonNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Content extends Data {
	public final int user;
	public final String sha1;

	public static List<Content> all() {
		List<Content> contents = new ArrayList<Content>();
		for (JsonNode node : Data.allWith("content")) {
			contents.add(fromJson(node));
		}
		return contents;
	}

	protected static Content fromJson(JsonNode json) {
		Builder builder = new Builder();
		Iterator<Map.Entry<String, JsonNode>> iter = json.getFields();

		while (iter.hasNext()) {
			Map.Entry<String, JsonNode> entry = iter.next();
			switch (entry.getKey()) {
				case "user": builder.setUser(entry.getValue().asInt()); break;
				case "sha1": builder.setSha1(entry.getValue().asText()); break;
			}
		}

		return builder.build();
	}

	protected Content() {
		this.user = 0;
		this.sha1 = "sha1";
	}

	protected Content(int user, String sha1) {
		this.user = user;
		this.sha1 = sha1;
	}

	public static class Builder {
		private Content internal;

		public Builder() {
			this(new Content());
		}

		private Builder(Content content) {
			this.internal = content;
		}

		private Builder set(Function<Content, Content> func) {
			this.internal = func.apply(this.internal);
			return this;
		}

		public Content build() {
			return internal;
		}

		public Builder setUser(int user) {
			return new Builder(new Content(user, internal.sha1));
		}

		public Builder setSha1(String sha1) {
			return new Builder(new Content(internal.user, sha1));
		}
	}
}
