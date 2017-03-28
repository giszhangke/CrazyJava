public enum Gender
{
	MALE, FEMALE;
	public String name;
	public void setName(String name) {
		switch(this) {
			case MALE:
				if (name == "男") {
					this.name = name;
				} else {
					System.out.println("参数错误");
					return;
				}
				break;
			case FEMALE:
				if (name == "女") {
					this.name = name;
				} else {
					System.out.println("参数错误");
					return;
				}
				break;
		}		
	}

	public String getName() {
		return this.name;
	}
}

