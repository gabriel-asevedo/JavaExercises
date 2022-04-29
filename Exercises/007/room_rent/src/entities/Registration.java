package entities;

public class Registration {

	private String name, email;

	public Registration() {
		super();
	}

	public Registration(String name, String email) {
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return name + "\t" + email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
