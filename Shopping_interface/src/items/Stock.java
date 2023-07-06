package items;

public class Stock {
	int shirts;
	int t_shirts;
	int pants;
	int shorts;
	
	public Stock(int shirts, int t_shirts, int pants, int shorts) {
		this.shirts = shirts;
		this.t_shirts = t_shirts;
		this.pants = pants;
		this.shorts = shorts;
	}

	public int getShirts() {
		return shirts;
	}

	public void setShirts(int shirts) {
		this.shirts = shirts;
	}

	public int getT_shirts() {
		return t_shirts;
	}

	public void setT_shirts(int t_shirts) {
		this.t_shirts = t_shirts;
	}

	public int getPants() {
		return pants;
	}

	public void setPants(int pants) {
		this.pants = pants;
	}

	public int getShorts() {
		return shorts;
	}

	public void setShorts(int shorts) {
		this.shorts = shorts;
	}
	
	
	
	public void buyShirt() {
		this.shirts--;
	}
	public void buyT_shirt() {
		this.t_shirts--;
	}
	public void buyPants() {
		this.pants--;
	}
	public void buyShorts() {
		this.shorts--;
	}
	
	
}
