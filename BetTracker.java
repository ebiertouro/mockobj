package mockObjects;

public class BetTracker {
	
	BetTracker(int minBalance, DummyRandom rnd){

	}
	BetTracker(int minBalance, RandomValueGenerator rnd){

		}
	
	public int getCurrentBalance() {
		return 100;
		
	}
	
	public boolean canBet(double amnt) {
		return true;
		
	}
	
	public void addMoney(double amnt) {
		
	}
	
	public double betOnANumber(double amnt, int min, int max, int selectedNumber) {
		return 25.61;
	}
	
	public double betOnProbability(double amnt, double p) {
		return 25.61;
	}
	
	
}