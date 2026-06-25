import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Scanner;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class GameFrame extends JFrame {
	private Game game;
	private GamePanel gamePanel;
	private GameStatusPanel gameStatusPanel;
	
	public GameFrame() {
		//כפתור משחק חדש
		JButton newGameButton = new JButton("New Game");
		newGameButton.addActionListener(e -> {
			getContentPane().removeAll();
		    buildGame();

		    add(newGameButton, BorderLayout.NORTH);
		    add(gameStatusPanel, BorderLayout.EAST);
		    add(gamePanel, BorderLayout.CENTER);

		    revalidate();
		    repaint();
		});
		
		this.setLayout(new BorderLayout(10,10));
		buildGame();
		this.add(gameStatusPanel, BorderLayout.EAST);
		this.add(gamePanel, BorderLayout.CENTER);
		this.add(newGameButton, BorderLayout.NORTH);
		this.setTitle("My Memory Game");
		this.setSize(1000, 1000);
		newGameButton.setBackground(new Color(230, 230, 250));
		this.getContentPane().setBackground(new Color(255, 209, 220));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void buildGame()
	{
		int size;
		String levelAnswer="";
		
		do{levelAnswer=JOptionPane.showInputDialog("Choose a level: Easy / Medium / Hard");}
		while(levelAnswer==null||(!levelAnswer.equalsIgnoreCase("Easy") 
				&& !levelAnswer.equalsIgnoreCase("Medium")
				&& !levelAnswer.equalsIgnoreCase("Hard")));
		
		if(levelAnswer.equalsIgnoreCase("Easy"))
			size=4;
		else if(levelAnswer.equalsIgnoreCase("Medium"))
			size=8;
		else
			size=16;

		String player1Name=JOptionPane.showInputDialog("Select a name for player 1");
		Player p1 = new Player(player1Name);
		String player2Name=JOptionPane.showInputDialog("Select a name for player 2");
	    Player p2 = new Player(player2Name);

	    this.game = new Game(p1,p2,size);

	    this.gameStatusPanel = new GameStatusPanel(game);

	    this.gamePanel = new GamePanel(game, gameStatusPanel);
	}
}
