import java.awt.GridLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private Game game;
	private GameStatusPanel gameStatus;
	private CardButton[] cardButtons;
 
	
	
	public GamePanel(Game g, GameStatusPanel status) {
		//להגדיר פריסה של גריד
		//איתחול המערך מתוך הקלפים בלוח
		//להוסיף לפאנל
		this.game=g;
	    this.gameStatus = status;
	    this.game.setRefreshCallback(() -> {
	        Refresh();
	        gameStatus.refresh();
	    });
	    
		Card [] cards = this.game.getBoard().returnCards();
		this.cardButtons=new CardButton[cards.length];
		for(int i=0; i<cards.length; i++) {
		    this.cardButtons[i] = new CardButton(cards[i]);

		    this.cardButtons[i].addActionListener(e -> {
		        CardButton btn = (CardButton)e.getSource();
		        game.choosingCard(btn.getCard());

		        this.Refresh();
		        //System.out.println(game.isFinished());
		        if(game.isFinished())
		        {
		        	int num = game.winner();
		        		if(num == 1)
		        	        JOptionPane.showMessageDialog(this,"Player "+ this.game.getP1().getName()+" Won!");
		        	    else if(num == 2)
		        	        JOptionPane.showMessageDialog(this,"Player "+ this.game.getP2().getName()+" Won!");
		        	    else
		        	        JOptionPane.showMessageDialog(this,"It's a tie!!");
		        }
		        gameStatus.refresh();
		    });
		    this.add(cardButtons[i]);
		}
		if(cards.length==4)
			this.setLayout(new GridLayout(2,2,10,10));
		else if(cards.length==8)
			this.setLayout(new GridLayout(2,4,10,10));
		else
			this.setLayout(new GridLayout(4,4,10,10));
	}
	
	public void Refresh() {
		for(int i=0; i<this.cardButtons.length; i++) {
			this.cardButtons[i].refresh();
		}
		
		revalidate();
	    repaint();
	}
}