/*
 * Program 1
 * QR Code
 * Cs 160-1
 * 02-07-2022
 * @author Conor Murphy
 */
import java.util.Random;
public class QRCode {
	private int[][] grid;// set grid in setGrid
	public static void main(String args[]) {
		final int DEFAULT_DIMENSION = 30;
		final int DEFAULT_SEED = 160;
		int dim = DEFAULT_DIMENSION;
		int seed = DEFAULT_SEED;
		if (args.length == 2) {
			dim = Integer.parseInt(args[0]);
			seed = Integer.parseInt(args[1]);
		}
		/* If the user doesn't enter 2 numbers in the command line. Dim will be set to 30 and
		 * seed will be set to 160
		 */
		QRCode QRCode1 = new QRCode(); 
		int[] pattern = QRCode1.createPattern(dim, seed);
		QRCode1.setGrid(dim, pattern);
		QRCode1.setFinder(0,0);//top left
		QRCode1.setFinder(dim -15, 0);// top right
		QRCode1.setFinder(0,dim-15);// bottom left
		/* Alters grid to create three finders in the top left, top right, and bottom left corner 
		 * of the qr code
		 * The Finders are placed at dim - 15 in top right and bottom left
		 */
		int[][] grid1 = QRCode1.getGrid();
		QRCode1.print(grid1);// outputs grid as a series of 0s and 1s
		
		
	}
	
	public int[] createPattern(int dim, int seed) {
		Random rand = new Random(seed);
		int[] oneDimensional = new int[dim * dim];
		for(int i = 0; i< oneDimensional.length; i++) {
			oneDimensional[i] = rand.nextInt(2);
			// Only outputs 0s and 1s
		}
		return oneDimensional;//put for int[] pattern in setGrid
		/*
		 * Creates a random pattern that is the length of dim squared.
		 */
	}
	public void setGrid(int dim, int[] pattern) {
		grid = new int[dim][dim];
		int temp = 0;
		for(int i = 0; i< grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				grid[i][j] = pattern[temp];
				temp++;
				/*
				 * temp increments each time thorugh for loop
				 * Assigns grid with elements from oneDimensional 
				 * array assigned in createPattern
				*/
			}
			}
		}
	public int[][] getGrid(){
		return grid;//return grid which is a class memeber
				
	}
	public void setFinder(int xPos, int yPos) {
		for(int i = yPos; i<yPos + 15; i++) {
			for(int j =xPos; j< xPos + 15; j++) {
				grid[i][j] = 1;
				// setting grid to 1 is white
			}
			
		}
		for(int i = yPos+2; i< yPos + 13; i++) {
			for(int j = xPos+2; j<xPos+13; j++ ) {
				grid[i][j] = 0;
				//setting grid to 0 is black
			}
			
		}
		for(int i = yPos+4; i< yPos + 11; i++) {
			for(int j = xPos + 4; j< xPos + 11; j++) {
				grid[i][j] = 2;	
				//setting grid to 2 is white
			}
			
		}
		for(int i = yPos+6; i< yPos + 9; i++) {
			for(int j = xPos+6; j< xPos + 9; j++) {
				grid[i][j] = 3;
				//setting grid to 3 is black
			}
			
		}
		/*
		 * Set finder creates 4 grids placing a finder in each of the upper left, upper right, and lower left corners of the grid. 
		 * If a grid is null, it returns null.
		 * xPos is a column and yPos is a row.
		 * There are 4 total borders.
		 * The output border is two pixels in width, The next inner border is two pixels in width
		 * The next inner border is two pixels in width. The innermost box is 3x3 pixels
		 */
		
		
	}
	public void print() {
		for(int i = 0; i< grid.length; i++) {
			for(int j = 0; j< grid[i].length; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		//outputs the class member grid as a two-dimensional grid with no spaces between values in a row
	}
	public void print(int[] pattern) {
		for(int i = 0; i<Math.sqrt(pattern.length); i++) {
			//Math.sqrt takes the square of the length of pattern since pattern is the length of dim squared
			for(int j = 0; j<Math.sqrt(pattern.length);j++) {
				System.out.print(pattern[i*3 + j]);
		}
			System.out.println();
		}
		System.out.println();
		
	}
	public void print(int[][] matrix) {
		for(int i = 0; i< matrix.length; i++) {
			for(int j = 0; j< matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		//outputs the two-dimensional matrix passed as a parameter row by row with no spaces between values in a row
}
}
