package minesharelib;

import org.codehaus.jackson.node.ArrayNode;

import java.io.IOException;

public abstract class Data {
	protected static ArrayNode allWith(String type) {
		try {
			return API.INSTANCE.requester.get("/content", ArrayNode.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
