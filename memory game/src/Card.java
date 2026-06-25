import java.awt.*;
import javax.swing.*;

public class Card {
	private ImageIcon value;
	private boolean isOpened;
	private boolean isFound;
	
	public Card(ImageIcon v)
	{
		this.value=v;
		this.isFound=false;
		this.isOpened=false;
	}

	public ImageIcon getValue() {
		return value;
	}

	public void setValue(ImageIcon value) {
		this.value = value;
	}

	public boolean isOpened() {
		return isOpened;
	}

	public boolean isFound() {
		return isFound;
	}

	public void setFound(boolean isFound) {
		this.isFound = isFound;
	}
	
	public void openCard() {
		this.isOpened=true;
	}

	public void closeCard() {
		this.isOpened=false;
	}
	
	public boolean equals(Card other) {
		if (this.value == other.value)
			return true;
		return false;
	}
}
