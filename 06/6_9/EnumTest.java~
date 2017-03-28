public class EnumTest
{
	public void judge(SeasonEnum season) {
		switch(season)
		{
			case SPRING:
				System.out.println(SeasonEnum.SPRING.toString());
				break;
			case SUMMARY:
				System.out.println(SeasonEnum.SUMMARY.toString());
				break;
			case FALL:
				System.out.println(SeasonEnum.FALL.toString());
				break;
			case WINTER:
				System.out.println(SeasonEnum.WINTER.toString());
				break;
				
		}
	}

	public static void main(String[] args) {
		for (SeasonEnum se : SeasonEnum.values()) {
			System.out.println(se);
		}

		EnumTest et = new EnumTest();
		et.judge(SeasonEnum.FALL);
	}
}
