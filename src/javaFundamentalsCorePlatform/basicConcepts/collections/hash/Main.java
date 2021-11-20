package javaFundamentalsCorePlatform.basicConcepts.collections.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * References : https://www.baeldung.com/java-hashcode TODO
 * https://www.codejava.net/java-core/collections/understanding-equals-and-hashcode-in-java
 * http://tutorials.jenkov.com/java-collections/hashcode-equals.html
 * https://stackoverflow.com/questions/27581/what-issues-should-be-considered-when-overriding-equals-and-hashcode-in-java
 * 
 * @author syncrase
 *
 */
public class Main {

	public static void main(String[] args) {

		Map<User, User> users = new HashMap<>();
		User user1 = new User(1L, "John", "john@domain.com");
		User user2 = new User(2L, "Jennifer", "jennifer@domain.com");
		User user3 = new User(3L, "Mary", "mary@domain.com");

		users.put(user1, user1);
		users.put(user2, user2);
		users.put(user3, user3);
		if (users.containsKey(user1)) {
			System.out.print("User found in the collection");
		}

	}

}

class User {

	private long id;
	private String name;
	private String email;

	public User(long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + (int) id;
		hash = 31 * hash + (name == null ? 0 : name.hashCode());
		hash = 31 * hash + (email == null ? 0 : email.hashCode());
		System.out.println("hashCode() called - Computed hash: " + hash);
		return hash;
	}
}