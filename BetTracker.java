package mockObjects;

public class BetTracker {
	
	int minbal;
	IRandomValueGenerator rand;
	int currentbal = 0;
	
	BetTracker(int minBalance, DummyRandom rnd){
		this.minbal = minBalance;
		this.rand = rnd;

	}
	BetTracker(int minBalance, RandomValueGenerator rnd){
		this.minbal = minBalance;
		this.rand = rnd;
		}
	
	public int getCurrentBalance() {
		return this.currentbal;
		
	}
	
	public void addMoney(double amnt) {
		if (amnt < 0) {
			throw new IllegalArgumentException();
		}
		currentbal += amnt;
		
	}
	
	public boolean canBet(double amnt) {
		if (amnt < 0) {
			throw new IllegalArgumentException();
		}
		boolean canBet = false;
		if ((currentbal - amnt) >= minbal)
			canBet = true;
		else
			canBet = false;
		return canBet;
		
	}
	
	public double betOnANumber(double amnt, int min, int max, int selectedNumber) {
		if ((currentbal - amnt) < minbal) {
			throw new IllegalArgumentException();
		}
		int startbal = currentbal;
		if (rand.NumGenerator(min, max) == selectedNumber) {
			currentbal += (((max - min) - 1) * amnt);
		}
		else
			currentbal -= amnt;
		int dif = (currentbal - startbal);
		return dif;
	}
	
	public double betOnProbability(double amnt, double p) {
		if (p >= 1) {
			throw new IllegalArgumentException();
		}
		if (p < 0) {
			throw new IllegalArgumentException();
		}
		if ((currentbal - amnt) < minbal) {
			throw new IllegalArgumentException();
		}
		int startbal = currentbal;
		if (rand.PercentageTrue(p)) {
			currentbal += (((1/p) - 1) * amnt);
		}
		else
			currentbal -= amnt;
		int dif = (currentbal - startbal);
		return dif;

	}
	
	
}