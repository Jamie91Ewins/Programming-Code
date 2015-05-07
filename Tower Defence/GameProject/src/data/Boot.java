//This is the main class where all the other sub-classes are brought together
package data;

import static helpers.Artist.*;
import helpers.Clock;

import org.lwjgl.opengl.Display;

public class Boot {
	
	public Boot(){

		BeginSession();
		
		//set the tiles by using an array 0=grass, 1=dirt, 2=water \\
		int[][] map = {
				{0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 2, 2, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 2, 2, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		};
		//Loads the tile with the values set above\\
		//Allows a certain tile to be loaded in a set location\\
		TileGrid grid = new TileGrid(map);
		grid.setTile(3, 4, grid.GetTile(2, 4).getType());
		//Loads  the enemy PNG on a set designated tile\\ 
		//Also sets the speed of the enemy at the end to 2\\
		Enemy e = new Enemy(QuickLoad("UFO64"), grid.GetTile(10, 10), grid, 64, 64, 3);
		Wave wave = new Wave(31, e);
		Player player = new Player(grid);
		while(!Display.isCloseRequested()) {
			//Update and draw functions hold all the data to make the enemies and towers move\\
			Clock.update();
			
			grid.Draw();
			wave.Update();
			player.Update();
			
			Display.update();
			Display.sync(60);
			
		}
		
		Display.destroy();
	}
	
	public static void main(String[] args){
		new Boot();
	}

}
