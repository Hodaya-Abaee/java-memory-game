import java.awt.*;

import javax.swing.*;

public class CardButton extends JButton {
	private Card card;
	
	public CardButton(Card c) {
		this.card=c;
		this.setIcon(changeProportions("pics/pic.png"));
		this.setFocusPainted(false);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setOpaque(true);
		this.setBackground(new Color(255, 209, 220));
	}
	
	public Card getCard() {
		return this.card;
	}
	
	public void refresh() {
		if(this.card.isOpened())
		{
			this.setIcon(card.getValue());
			if (this.card.isFound())
				this.setBackground(new Color(230, 230, 250));
		}
		else
			this.setIcon(changeProportions("pics/pic.png"));
	}
	
	public ImageIcon changeProportions(String img) {
		ImageIcon icon= new ImageIcon(img);
		Image image = icon.getImage();
		Image resizedImage = image.getScaledInstance(200 ,200,Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		return resizedIcon;
	}
	
}
