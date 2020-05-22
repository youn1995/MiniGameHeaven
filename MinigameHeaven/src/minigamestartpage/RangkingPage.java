package minigamestartpage;

public class RangkingPage {

	int memberId = 0;

	public RangkingPage(int memberId) {
		this.memberId = memberId;
	}

	void execute() {
		while (true) {
			System.out.println("1.Top30 Ranking");
			System.out.println("2.Player Ranking");
			System.out.println("3.Return");
			// userinput
			int rangPageSel = 1;
			
			
			
			if(rangPageSel == 1) {
				
			} else if(rangPageSel == 2) {
				
			} else if(rangPageSel == 3) {
				
			} else if(rangPageSel == 4) {
				break;
			}
		}
	}

	void top30Rangking() {
		System.out.println("Top 30 in all players");
	}

	void playerRangking() {
		System.out.println("");
	}
}
