package minesharelib;

import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ContainerNode;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.List;

public abstract class Data {
	private static <T, J extends ContainerNode> T get(String type, TypeReference<T> typeRef, Class<J> nodeType) throws IOException {
		return API.mapper.readValue(API.INSTANCE.requester.get("/" + type, nodeType).asText(), typeRef);
	}

	protected static <T extends Data> List<T> getWith(String type, Class<T> clazz) throws IOException {
		return get(type, new TypeReference<List<T>>() {}, ArrayNode.class);
	}

	protected static <T extends Data> T getFrom(String type, Class<T> clazz) throws IOException {
		return get(type, new TypeReference<T>() {}, ObjectNode.class);
	}

	public String toJson() throws IOException {
		return API.mapper.writeValueAsString(this);
	}
}
