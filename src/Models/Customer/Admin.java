package Models.Customer;

public class Admin extends People {

	public Admin(String name, String address, String password, String username, int age) {
		super(name, address, password, username, age);
		this.setRole("Admin");
	}

}
