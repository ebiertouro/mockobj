package mockObjects;

public class DummyRandom implements RandomValueGenerator{

	public int NumGenerator(int min, int max) {
		return min;
	}
	
	public boolean PercentageTrue(double probability) {
		return false;
	}
}