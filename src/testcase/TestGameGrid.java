package testcase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.GameGrid;

class TestGameGrid {

	@Test
	void test() {
		testClearAndDrop();
	}

	void testClearAndDrop() {
		GameGrid gameGrid = new GameGrid(5, 3);
		int[][] exampleData = {
				{0,0,0},	
				{0,0,0},	
				{0,0,0},	
				{1,2,0},	
				{1,2,3},	
		};
		int[][] resultData = {
				{0,0,0},	
				{0,0,0},	
				{0,0,0},	
				{0,0,0},	
				{1,2,0},	
		};
		gameGrid.data = (exampleData);
		gameGrid.clearAndDrop();
		
		for (int i = 0; i < resultData.length; i++) {
			for (int j = 0; j < resultData[0].length; j++) {
				assertEquals(gameGrid.data[i][j], resultData[i][j]);
			}
		}
	}
	
}
