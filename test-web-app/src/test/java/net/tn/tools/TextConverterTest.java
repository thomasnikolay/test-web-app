package net.tn.tools;

import static org.junit.Assert.*;

import org.junit.Test;

public class TextConverterTest {

	@Test
	public void testToSomethingString() {
		TextConverter testObj = new TextConverter();
		System.out.println(testObj.toSomethingString(0x6468));
		assertTrue(true);
	}

}
