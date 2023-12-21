package mockObjects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MockObjTester {
	
	private DummyRandom rnd;
	private BetTracker bt;

	@BeforeEach
	void instantiateBT() {
		rnd = new DummyRandom();
	  bt = new BetTracker(0, rnd);
	}

	@Test
	void canBet_ifLost() {
		bt.addMoney(300);
		assertTrue(bt.canBet(300));
	}

	@Test
	void canBet_FalseIfBelowMin() {
		bt.addMoney(300);
		assertFalse(bt.canBet(301));
	}
	
	@Test
	void canBet_ThrowsException() {	
		assertThrows(IllegalArgumentException.class, () -> {
			bt.canBet(-1);
		});
	}
	
	@Test
	void addMoney_works() {
		int bal = bt.getCurrentBalance();
		bt.addMoney(100);
		int newbal = bal + 100;
		assertEquals(bt.getCurrentBalance(), newbal);
	}
	
	@Test
	void addMoney_ThrowsException() {
		assertThrows(IllegalArgumentException.class, () -> {
			bt.addMoney(-1);
		});
	}

	@Test
	void betOnANumber_Win() {
		double amnt = 10;
		int min = 5;
		int max = 10;
		int selectedNum = 7;
		rnd.setNum(selectedNum);
		bt.addMoney(100);
		assertEquals(bt.betOnANumber(amnt, min, max, selectedNum), 40);
	}

	@Test
	void betOnANumber_OverMin() {
		double amnt = 101;
		int min = 5;
		int max = 10;
		int selectedNum = 7;
		bt.addMoney(100);
		assertThrows(IllegalArgumentException.class, () -> {
			bt.betOnANumber(amnt, min, max, selectedNum);
		});
		
	}
	 
	@Test
	void betOnProbability_throwsIfAboveOne() {
		bt.addMoney(100);
		double amnt = 100;
		double p = 1.1;
		assertThrows(IllegalArgumentException.class, () -> {
			bt.betOnProbability(amnt, p);
		});
	}

	@Test
	void betOnProbability_rejectsAboveOne() {
		bt.addMoney(100);
		double amnt = 101;
		double p = 1.1;
		assertThrows(IllegalArgumentException.class, () -> {
			bt.betOnProbability(amnt, p);
		});
	}

	@Test
	void betOnProbability_throwsIfNeg() {
		bt.addMoney(100);
		double amnt = 100;
		double p = -.1;
		assertThrows(IllegalArgumentException.class, () -> {
			bt.betOnProbability(amnt, p);
		});
		
	}
}