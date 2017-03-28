class Person
{
	private final Name name;
	/* 常规写法
	public Person(Name name) {
		this.Name = name;
	}

	public Name getName() {
		return name;
	}
	*/

	// 不可以变类写法
	public Person(Name name) {
		this.name = new Name(name.getFirstName(), name.getLastName());
	}

	public Name getName() {
		return new Name(name.getFirstName(), name.getLastName());
	}
}

class Name
{
	private String firstName = "";
	private String lastName = "";

	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}	

	public String getLastName() {
		return lastName;
	}
}

class Address
{
	private final String detail;
	private final String postCode;

	public Address(String detail, String postCode) {
		this.detail = detail;
		this.postCode = postCode;
	}

	public String getDetail() {
		return detail;
	}

	public String getPostCode() {
		return postCode;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
		{
			return true;
		} else if (obj != null && obj.getClass() == Address.class) {
			Address a = (Address)obj;
			if (a.getDetail() == this.getDetail() && a.getPostCode() == this.getPostCode()) {
				return true;
			}
		}

		return false;
	}

	public int hashCode() {
		return detail.hashCode() + postCode.hashCode() * 23;
	}
}
