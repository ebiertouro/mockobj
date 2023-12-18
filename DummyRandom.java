package mockObjects;

public class DummyRandom implements IRandomValueGenerator{

	private int randInt;
	private boolean randbl;
	
	public DummyRandom() {
		this.randInt = 5;
		this.randbl = true;
	}
	
	public void setNum(int num) {
		this.randInt = num;
	}
	
	public void setBool(boolean bool) {
		this.randbl = bool;
	}
	
	public int NumGenerator(int min, int max) {
		return randInt;
	}
	
	public boolean PercentageTrue(double probability) {
		return randbl;
	}
}