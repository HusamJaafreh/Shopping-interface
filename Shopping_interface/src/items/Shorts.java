package items;

public class Shorts extends Lower_body {
	boolean above_knee;
	
	
	public Shorts(char size, String color, String gender, boolean above_knee) {
		this.size = size;
		this.color = color;
		this.gender = gender;
		this.above_knee = above_knee;
	}
	
	public boolean isAbove_knee() {
		return above_knee;
	}

	public void setAbove_knee(boolean above_knee) {
		this.above_knee = above_knee;
	}
	
}
