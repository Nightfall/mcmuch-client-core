package minesharelib;

import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.List;

public abstract class Data {
	protected static <T extends Data> List<T> getWith(String type, Class<T> clazz) throws IOException {
		return API.mapper.readValue(API.INSTANCE.requester.get("/" + type, ArrayNode.class).asText(), new TypeReference<List<T>>() {});
	}

	public String toJson() throws IOException {
		return API.mapper.writeValueAsString(this);
	}
}
