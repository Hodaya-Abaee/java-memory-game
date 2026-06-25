import java.awt.Color;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameStatusPanel extends JPanel {
	private Game game;
	private JPanel panel;
	private JLabel whichPlayerLabel;
	private JLabel player1ScoreLabel;
	private JLabel player2ScoreLabel;
	
	public GameStatusPanel(Game g) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.whichPlayerLabel=new JLabel();
		this.player1ScoreLabel=new JLabel();
		this.player2ScoreLabel=new JLabel();
		this.setBackground(new Color(230, 230, 250));
		this.add(whichPlayerLabel);
		this.add(player1ScoreLabel);
		this.add(player2ScoreLabel);
		this.game=g;
		refresh();
	}
	
	public void refresh() {
		if(this.game.getNum()==1)
			this.whichPlayerLabel.setText("It's "+game.getP1().getName()+"'s turn!");
		else
			this.whichPlayerLabel.setText("It's "+game.getP2().getName()+"'s turn!");
		this.player1ScoreLabel.setText(game.getP1().getName()+"'s score is: "+game.getP1().getScore());
		this.player2ScoreLabel.setText(game.getP2().getName()+"'s score is: "+game.getP2().getScore());
	}
}

