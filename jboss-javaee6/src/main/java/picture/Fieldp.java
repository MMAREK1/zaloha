package picture;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;

import kamene.GameState;

/**
 * Field represents playing field and game logic.
 */
@SuppressWarnings("serial")
public class Fieldp implements Serializable {
	/**
	 * Time of playing from saved game
	 */
	private int startTime;
	/**
	 * Playing field tiles.
	 */
	private Image[][] images;
	/**
	 * Field row count. Rows are indexed from 0 to (rowCount - 1).
	 */
	private final int rowCount;
	/**
	 * Column count. Columns are indexed from 0 to (columnCount - 1).
	 */
	private final int columnCount;
	/**
	 * Game state.
	 */
	private GameState state = GameState.PLAYING;

	/**
	 * Constructor.
	 * 
	 * @param rowCount
	 *            - row count
	 * @param columnCount
	 *            - column count
	 */
	public Fieldp(int rowCount, int columnCount) {
		this.columnCount = columnCount;
		this.rowCount = rowCount;
		images = new Image[rowCount][columnCount];
		generate();
	}


	/**
	 * generate playing field, generate random numbers which represent game -
	 * first fill arrayList with numbers from 1 to n(row*column-1) and " " than
	 * it shuffle
	 */
	private void generate() {
		
		BufferedImage image = null;
		try {
		    image = ImageIO.read(new File("resources/images2/picture.png"));
		} catch (IOException e) {
		}
		int width = image.getWidth();
		int height = image.getHeight();
		int widthOfSection=width/getColumnCount();
		int heightOfSection=height/getRowCount();
		System.out.println(widthOfSection);
		System.out.println(heightOfSection);
		List<Integer> createRandomNumber = new ArrayList<>();
		for (int i = 1; i <= getColumnCount() * getRowCount(); i++) {
			if (i != getColumnCount() * getRowCount()) {
				createRandomNumber.add(i);
			} else {
				createRandomNumber.add(0);
			}
		}
		Collections.shuffle(createRandomNumber);
		Integer[] randomNumbers = createRandomNumber.toArray(new Integer[createRandomNumber.size()]);
		int count = 0;
		for (int row = 0; row < getRowCount(); row++) {
			for (int column = 0; column < getColumnCount(); column++) {
		//		numbers[row][column] = new Image();
				count++;
			}
		}

	}

	/**
	 * action with tiles or throws exception when wrong input
	 * 
	 * @param command
	 *            read input
	 * @throws WrongInput
	 */
	public void move(String command) {
		
	}

	/**
	 * Returns true if game is solved, false otherwise.
	 * 
	 * @return true if game is solved, false otherwise
	 */
	private boolean isSolved() {
		int count = 1;
		for (int row = 0; row < getRowCount(); row++) {
			for (int column = 0; column < getColumnCount(); column++) {
				if (count != getColumnCount() * getRowCount()) {
					Image number = (Image) images[row][column];
					if (number.getValue() != count) {
						return false;
					}
					count++;
				}
			}
		}
		return true;
	}

	public Image getImage(int row, int column) {
		return images[row][column];
	}

	public int getRowCount() {
		return rowCount;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public GameState getState() {
		return state;
	}
}
