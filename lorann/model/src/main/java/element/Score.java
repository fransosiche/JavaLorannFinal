package element;

/**
 * <h1>Score Class</h1>
 *
 * @author group1
 * @version 1.0
 */
public class Score {
	private int score = 0;
	
	public void IncreaseScore() {
		score = score +1;
		System.out.print("Le score est de = ");
		System.out.println(score);
	}
/*
 * get the score
 */
	public int getScore() {
		return score;
	}
/*
 * set the score
 */
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
