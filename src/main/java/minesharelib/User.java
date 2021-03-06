package minesharelib;

import java.io.IOException;
import java.util.List;

public class User extends Data {
	public final int id;
	public final String uuid_hash;
	public final String salt;
	public final String uuid;

	public static List<User> all() throws IOException {
		return Data.getWith("users", User.class);
	}

	public static User fromId(int id) throws IOException {
		return Data.getFrom("users/" + Integer.toString(id), User.class);
	}

	protected static User fromJson(String json) throws IOException {
		return API.mapper.readValue(json, User.class);
	}

	public User() {
		id = -1;
		uuid_hash = "";
		salt = "";
		uuid = "Default";
	}

	public User(int id, String hash, String salt, String uuid) {
		this.id = id;
		this.uuid_hash = hash;
		this.salt = salt;
		this.uuid = uuid;
	}

	@Override
	public void put() throws IOException {
		putHelper("/users");
	}
}
