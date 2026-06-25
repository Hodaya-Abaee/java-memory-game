import java.util.Random;
import java.awt.*;
import javax.swing.*;

public class Board {
	private Card[] arr;
	
	public Board(int size) {
		this.arr=new Card[size];
		
		ImageIcon [] images= new ImageIcon[8];
		images[0]=changeProportions("pics/pic1.jpg");
		images[1]=changeProportions("pics/pic2.jpg");
		images[2]=changeProportions("pics/pic3.jpg");
		images[3]=changeProportions("pics/pic4.jpg");
		images[4]=changeProportions("pics/pic5.jpg");
		images[5]=changeProportions("pics/pic6.jpg");
		images[6]=changeProportions("pics/pic7.jpg");
		images[7]=changeProportions("pics/pic8.jpg");
		
		int pairs = size /2;
		int index=0;
		for(int i=0; i<pairs; i++) {
			this.arr[index]=new Card(images[i]);
			this.arr[index+1]=new Card(images[i]);
			index+=2;
		}
		
		shuffleCards(size);
	}
	
	public Card[] returnCards() {
		return this.arr;
	}
	
	public void shuffleCards(int size) {
		int index, x;
		Random random = new Random();
		
		for(int i=0; i<this.arr.length; i++) {
			index = random.nextInt(size);
			//x = this.arr[i].getValue();
			//this.arr[i].setValue(this.arr[index].getValue());
			//this.arr[index].setValue(x);
			
			Card temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
		}
	}
	
	public boolean isFinished() {
		for(int i=0; i<this.arr.length; i++) {
			if(!arr[i].isFound())
				return false;
		}
		return true;
	}
	
	public ImageIcon changeProportions(String img) {
		ImageIcon icon= new ImageIcon(img);
		Image image = icon.getImage();
		Image resizedImage = image.getScaledInstance(200 ,200,Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		return resizedIcon;
	}
}