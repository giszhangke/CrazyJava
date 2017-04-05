import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

public class ShowHand {
	private static final int PLAY_NUM = 5;
	private static final String[] types = {"黑桃", "红桃", "梅花", "方块"};
	private static final String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
	private List<String> cards = new LinkedList<String>();
	private String[] players = new String[PLAY_NUM];
	private List<String>[] playersCards = new List[PLAY_NUM];

	public void initCards() {
		for (String type : types) {
			for (String value : values) {
				cards.add(type + value);
			}
		}
		Collections.shuffle(cards);	
	}

	public void initPlayers(String... players) {
		if (players == null || players.length < 2) {
			System.out.println("玩家过于2个");
			return;
		} else if (players.length > PLAY_NUM) {
		        System.out.println("玩家不能超过" + PLAY_NUM + "个");
			return;
		} else {
			for (int i = 0; i < players.length; i++) {
				if(players[i].length() > 0) {
					this.players[i] = players[i];
				}
			}
		}

		System.out.println("this.players: " + Arrays.toString(this.players));
	}

	public void initPlayersCards() {
		for (int  i = 0; i < players.length; i++) {
			if (players[i] != null && !players[i].equals("")) {
				playersCards[i] = new LinkedList<String>();
			}
		}
	}

	public void deliverCards(String firstPlayer) {
		int firstPlayerIndex = Arrays.asList(players).indexOf(firstPlayer);
		System.out.println("firstPlayerIndex: " + firstPlayerIndex);
		for (int i = 0; i < firstPlayerIndex && players[i] != null && cards.size() > 0; i++) {
			getOneCard(i);		
		}
		for (int i = firstPlayerIndex; i < players.length && players[i] != null && cards.size() > 0; i++) {
			getOneCard(i);
		}
	}

	private void getOneCard(int playerIndex) {
		playersCards[playerIndex].add(cards.get(0));
		cards.remove(0);
	}

	public void showPlayersCards() {
		for (int i = 0; i < players.length; i++) {
			if (players[i] != null && !players[i].equals("")) {
				System.out.println(players[i] + " 的手牌：" + playersCards[i]);
			}
		}
	}

	public static void main(String[] args) {
		ShowHand showHand = new ShowHand();
		showHand.initCards();
		showHand.initPlayers("孙", "唐", "沙", "猪");
		showHand.initPlayersCards();
		showHand.deliverCards("唐");
		showHand.showPlayersCards();
		showHand.deliverCards("孙");
		showHand.showPlayersCards();
	}
}
