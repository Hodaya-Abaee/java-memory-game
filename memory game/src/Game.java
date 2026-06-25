import javax.swing.Timer;

public class Game {
	private Player p1;
	private Player p2;
	private Board board;
	
	private Card card1;
	private Card card2;
	
	private int num;
	
	private Runnable refreshCallback;
	
	public Game(Player player1, Player player2, int size) {
		this.p1=player1;
		this.p2=player2;
		this.board=new Board(size);
		
		this.card1=null;
		this.card2=null;
		
		this.num=1;
	}
	
	
	public void choosingCard(Card card) {
		if(card.isOpened()) return;
	    if(card.isFound()) return;
	    if(card2 != null) return;

	    if(this.card1 == null) {
	        this.card1 = card;
	        card1.openCard();
	    } 
	    else {
	        this.card2 = card;
	        card2.openCard();

	        if(card1.equals(card2)) {
	        	card1.setFound(true);
	        	card2.setFound(true);
	            if(num == 1)
	                p1.addSCore(10);
	            else
	                p2.addSCore(10);

	            card1 = null;
	            card2 = null;
	        } 
	        else {
	            Timer t = new Timer(1500, e -> {
	                card1.closeCard();
	                card2.closeCard();

	                card1 = null;
	                card2 = null;

	                changePlayer();
	                
	                if(refreshCallback != null)
	                {
	                    refreshCallback.run();
	                }
	            });

	            t.setRepeats(false);
	            t.start();
	        }
	    }
	}
	
	public Runnable getRefreshCallback() {
		return refreshCallback;
	}


	public void changePlayer() {
		if(num==1)
			this.num=2;
		else
			num=1;
	}
	
	public boolean isFinished() {
		if(!board.isFinished())
			return false;
		return true;	
	}
	
	//פונקציה שמחזירה את מספר השחקן שניצח
	//אם תיקו מחזירה 0
	public int winner() {
		if(p1.getScore()>p2.getScore())
			return 1;
		else if(p1.getScore()<p2.getScore())
			return 2;
		else
			return 0;
	}
	
	public void setRefreshCallback(Runnable refreshCallback) {
	    this.refreshCallback = refreshCallback;
	}


	public Player getP1() {
		return p1;
	}


	public void setP1(Player p1) {
		this.p1 = p1;
	}


	public Player getP2() {
		return p2;
	}


	public void setP2(Player p2) {
		this.p2 = p2;
	}


	public Board getBoard() {
		return board;
	}


	public void setBoard(Board board) {
		this.board = board;
	}


	public Card getCard1() {
		return card1;
	}


	public void setCard1(Card card1) {
		this.card1 = card1;
	}


	public Card getCard2() {
		return card2;
	}


	public void setCard2(Card card2) {
		this.card2 = card2;
	}


	public int getNum() {
		return this.num;
	}


	public void setNum(int num) {
		this.num = num;
	}
}
