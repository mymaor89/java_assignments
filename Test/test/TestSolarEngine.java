package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import vehicles.BenzineEngine;
import vehicles.SolarEngine;

public class TestSolarEngine {

	SolarEngine engine;
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testCloneData() {
		engine = new SolarEngine(40.0);
		try {
			SolarEngine engine2 = (SolarEngine) engine.clone();
			assertEquals(engine,engine2);
		} catch (CloneNotSupportedException e) {
			
			System.out.println("Can't clone solar engine");
		}
		
	}
	@Test
	public void testCloneAddress() {
		engine = new SolarEngine(40.0);
		try {
			SolarEngine engine2 = (SolarEngine) engine.clone();
			assertNotSame(engine,engine2);
		} catch (CloneNotSupportedException e) {
			
			System.out.println("Can't clone solar engine");
		}
	}


}
