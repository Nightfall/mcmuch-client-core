package minesharelib;

import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		API.INSTANCE = new API("http://127.0.0.1", 9292);
		try {
			System.out.println(User.fromId(1).toJson());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			new User().put();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
