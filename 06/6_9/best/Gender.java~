interface GenderDesc
{
	void info();
}

public enum Gender implements GenderDesc
{
	MALE("男") {
		public void info() {
			System.out.println("代表男");
		}
	}, 
	FEMALE("女") {
		public void info() {
			System.out.println("代表女");
		}
	};
	private final String name;

	private Gender(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
