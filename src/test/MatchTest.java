package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Match;



class MatchTest {
	Match match;
	
	@Test
	void starAtMiddle() {
		match = new Match("c*tb");
		assertEquals(2, match.findFirstIn("bacatatb"));
	}
	
	@Test
	void starAtStart() {
		match = new Match("*t");
		assertEquals(0, match.findFirstIn("bobcafft"));
	}
	
	
	@Test
	void starAtEnd() {
		match = new Match("ca*");
		assertEquals(3, match.findFirstIn("bobcat"));
	}
	
	@Test
	void failedStarTest() {
		match = new Match("c*t");
		assertEquals(-1, match.findFirstIn("bobat"));
	}
	
	
	@Test
	void dotAtStart() {
		match = new Match(".t");
		assertEquals(0, match.findFirstIn("at"));
	}
	
	@Test
	void dotAtMiddle() {
		match = new Match("c.tb");
		assertEquals(2, match.findFirstIn("bacatb"));
	}
	
	@Test
	void dotAtEnd() {
		match = new Match("b.");
		assertEquals(0, match.findFirstIn("bobcat"));
	}
	
	@Test
	void failedDotTest() {
		match = new Match(".t");
		assertEquals(-1, match.findFirstIn("cacacat"));
	}
	
	@Test
	void starAndDot() {
		match = new Match("c.*t");
		assertEquals(0, match.findFirstIn("cacacat"));
	}
	
	@Test
	void testOnlyAlphabets() {
		match = new Match("cat");
		assertEquals(4, match.findFirstIn("cacacate"));
	}
	
	@Test
	void testBothWildCharacters() {
		match = new Match("c*.");
		assertEquals(0, match.findFirstIn("cat"));
	}
	
	@Test
	void testDot() {
		match = new Match("c..");
		assertEquals(1, match.findFirstIn("bcde"));
	}
	

}

