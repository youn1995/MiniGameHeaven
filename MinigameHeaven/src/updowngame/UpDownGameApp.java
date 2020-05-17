package updowngame;

public class UpDownGameApp {
	int memberId;
	
	

	public UpDownGameApp(int memberId) {
		this.memberId = memberId;
	}

	public void gameStart() {
		Updowngame game = new Updowngame();
		int[] totalResult = game.execute();
		ranking(totalResult[0],totalResult[1]);
	}
	
	public void ranking(int playtime, int scoreSum) {
		System.out.println("Your Winrate: " + (int) scoreSum/playtime*100 +"%");
		if(memberId != 0) {
			
		}
	}
}
