package minesharelib;

import org.codehaus.jackson.node.ContainerNode;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public abstract class Data {
	private static <T, J extends ContainerNode> T get(String type, TypeReference<T> typeRef) throws IOException {
		return API.mapper.readValue(new URL(API.INSTANCE.requester.base + "/" + type), typeRef);
	}

	protected static <T extends Data> List<T> getWith(String type, Class<T> clazz) throws IOException {
		return get(type, new TypeReference<List<T>>() {});
	}

	protected static <T extends Data> T getFrom(String type, Class<T> clazz) throws IOException {
		return get(type, new TypeReference<T>() {});
	}

	public String toJson() throws IOException {
		return API.mapper.writeValueAsString(this);
	}

	protected void putHelper(String type) throws IOException {
		API.INSTANCE.requester.put(type, toJson());
	}

	public abstract void put() throws IOException;
}
