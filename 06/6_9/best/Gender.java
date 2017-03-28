interface GenderDesc
{
	void info();
}

public enum Gender implements GenderDesc
{
	MALE("��") {
		public void info() {
			System.out.println("������");
		}
	}, 
	FEMALE("Ů") {
		public void info() {
			System.out.println("����Ů");
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
