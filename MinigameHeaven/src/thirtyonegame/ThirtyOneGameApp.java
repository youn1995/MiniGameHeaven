package thirtyonegame;

import database.MemberService;
import database.MemberServiceImpl;

public class ThirtyOneGameApp {
	int memberId;
	
	public ThirtyOneGameApp(int memberId) {
		super();
		this.memberId = memberId;
	}
	
	public void gameStart() {
		ThirtyOneGame tOGame = new ThirtyOneGame();
		int[] totalResult = tOGame.gamePlay(tOGame.gameSet());
		ranking(totalResult[0],totalResult[1]);
	}
	
	public void ranking(int playtime, int scoreSum) {
		if(memberId != 0) {
			MemberService service = new MemberServiceImpl();
			service.updatingPlaytime(memberId, playtime, scoreSum);
		}
	}
}
