package thirtyonegame;

public class ThirtyOneGameApp {
	public void gameStart() {
		ThirtyOneGame tOGame = new ThirtyOneGame();
		tOGame.gamePlay(tOGame.gameSet());
	}
}
