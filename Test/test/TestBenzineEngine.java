package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import vehicles.BenzineEngine;

public class TestBenzineEngine {

	BenzineEngine engine;
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testCloneData() {
		engine = new BenzineEngine(40.0);
		try {
			BenzineEngine engine2 = (BenzineEngine) engine.clone();
			assertEquals(engine,engine2);
		} catch (CloneNotSupportedException e) {
			
			System.out.println("Can't clone benzine engine");
		}
		
	}
	@Test
	public void testCloneAddress() {
		engine = new BenzineEngine(40.0);
		try {
			BenzineEngine engine2 = (BenzineEngine) engine.clone();
			assertNotSame(engine,engine2);
		} catch (CloneNotSupportedException e) {
			
			System.out.println("Can't clone benzine engine");
		}
	}
}
