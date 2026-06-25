
public class Player {
	private String name;
	private int score;
	
	public Player(String n) {
		this.name=n;
		this.score=0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void addSCore(int s) {
		this.score += s;
	}
	
	
}
