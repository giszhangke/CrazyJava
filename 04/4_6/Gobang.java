import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Gobang
{
	public static String BOARD_EGG =   "● ";
        public static String BOARD_CROSS = " ┼ ";
	private static int BOARD_SIZE = 15;
	//棋盘
	public String[][] board;

	public Gobang()
	{
		initBoard();
	}

	private void initBoard()
	{
		//初始化棋盘
		board = new String[BOARD_SIZE][BOARD_SIZE];
		for (int i = 0; i < BOARD_SIZE ; i++)
		{
			Arrays.parallelSetAll(board[i], operand -> BOARD_CROSS);
			/*
			for (int j = 0; j < BOARD_SIZE; j++)
			{
				board[i][j] = BOARD_CROSS;
			}
			*/
			
		}
	}

	public void printBoard()
	{
		for (int i = 0; i < BOARD_SIZE; i++)
		{
			for (int j = 0; j < BOARD_SIZE; j++)
			{
				System.out.print(board[i][j]);//这里是print, 打印后不会换行
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) throws Exception
	{
		Gobang gb = new Gobang();
		gb.printBoard();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		while ((inputStr = br.readLine()) != null)
		{
			String[] posStrArr = inputStr.split(",");
			int xPos = Integer.parseInt(posStrArr[0]);
			int yPos = Integer.parseInt(posStrArr[1]);
			gb.board[yPos - 1][xPos - 1] = gb.BOARD_EGG;
			gb.printBoard();
			System.out.println("请输入您下棋的坐标, 应以x,y的格式: ");
		}
	}
}
