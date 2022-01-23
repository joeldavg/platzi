package com.platzi.java.tests.player;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class PlayerTest {

	@Test
	public void losesWhenDiceNumberIsTooLow() {
		
		Dice dice = Mockito.mock(Dice.class);
		
		Mockito.when(dice.roll()).thenReturn(2);
		
		Player player = new Player(dice, 3);
		assertFalse(player.play());
		
	}
	
	@Test
	public void winsWhenDiceNumberIsBig() {
		
		Dice dice = Mockito.mock(Dice.class);
		
		Mockito.when(dice.roll()).thenReturn(4);
		
		Player player = new Player(dice, 3);
		assertTrue(player.play());
		
	}


}
