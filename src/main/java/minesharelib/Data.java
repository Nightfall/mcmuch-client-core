package minesharelib;

import org.codehaus.jackson.node.ContainerNode;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public abstract class Data {
	protected static <T> List<T> getWith(String type, Class<T> clazz) throws IOException {
		return API.mapper.readValue(new URL(API.INSTANCE.requester.base + "/" + type), new TypeReference<List<T>>() {});
	}

	protected static <T> T getFrom(String type, Class<T> clazz) throws IOException {
		return API.mapper.readValue(new URL(API.INSTANCE.requester.base + "/" + type), clazz);
	}

	public String toJson() throws IOException {
		return API.mapper.writeValueAsString(this);
	}

	protected void putHelper(String type) throws IOException {
		API.INSTANCE.requester.put(type, toJson());
	}

	public abstract void put() throws IOException;
}
