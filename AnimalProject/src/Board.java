import java.util.Random;
import java.util.Scanner;

public class Board {
	public static final char COVERED = '#';
	public static final char MATCH = '*';

	public Animal[][] board;

	public Board() { // Building the random animal board.
		int place = 0;
		board = new Animal[5][4];
		Animal[] help = helper();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = help[place];
				place++;
			}
		}
		shuffle();
		while (unLegal()) { // shuffling until the board is legal.
			shuffle();
		}
	}

	public boolean noMoreMatch(char[][] board) { // checks if their is no more possible matches.
		Animal[] animals = leftAnimal(board);
		boolean flag = true;
		for (int i = 0; i < animals.length; i++) {
			for (int j = 1; j < animals.length; j++) {
				if (animals[i].checkMatching(animals[j])) {
					flag = false;
					return flag;
				}
			}
		}
		return flag;
	}

	private Animal[] leftAnimal(char[][] gameBoard) { // return an animal array with all the left animals.
		int count = countCovered(gameBoard);
		Animal[] animal = new Animal[count];
		int place = 0;
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[0].length; j++) {
				if (gameBoard[i][j] == COVERED) {
					animal[place] = this.board[i][j];
					place++;
				}
			}
		}
		return animal;
	}

	private int countCovered(char[][] board) { // counts covered cards.
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == COVERED) {
					count++;
				}
			}
		}
		return count;
	}

	private void shuffle() { // shuffling the animals board.
		Random random = new Random();
		for (int i = board.length - 1; i > 0; i--) {
			for (int j = board[i].length - 1; j > 0; j--) {
				int m = random.nextInt(i + 1);
				int n = random.nextInt(j + 1);
				Animal temp = board[i][j];
				board[i][j] = board[m][n];
				board[m][n] = temp;
			}
		}
	}

	private boolean unLegal() { // checks if there is places that are not legal, same animal next to the other.
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (neighbor(i, j, board[i][j])) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isDenisThere(int place, char[][] arr) { // Public function - checks if there is Denis next to the
															// current place.
		if (Legal(row(place) + 1, column(place)) && board[row(place) + 1][column(place)].getName() == 'D'
				&& arr[row(place) + 1][column(place)] != MATCH) {
			return true;
		} else if (Legal(row(place) - 1, column(place)) && board[row(place) - 1][column(place)].getName() == 'D'
				&& arr[row(place) - 1][column(place)] !=MATCH ) {
			return true;
		} else if (Legal(row(place), place % 10 + 1) && board[row(place)][column(place) + 1].getName() == 'D'
				&& arr[row(place)][column(place) + 1] != MATCH) {
			return true;
		} else if (Legal(row(place), column(place) - 1) && board[row(place)][column(place) - 1].getName() == 'D'
				&& arr[row(place)][column(place) - 1] != MATCH) {
			return true;
		}
		return false;
	}

	private boolean neighbor(int row, int column, Animal an) { // checks if there is two animal witch from the same
																// type and close to the other.
		if (Legal(row, column + 1) && !empty(row, column + 1)) {
			if (board[row][column + 1].equals(an))
				return true;
		}
		if (Legal(row, column - 1) && !empty(row, column - 1)) {
			if (board[row][column - 1].equals(an))
				return true;
		}
		if (Legal(row + 1, column) && !empty(row + 1, column)) {
			if (board[row + 1][column].equals(an))
				return true;
		}
		if (Legal(row - 1, column) && !empty(row - 1, column)) {
			if (board[row - 1][column].equals(an))
				return true;
		}
		return false;

	}

	private static Animal[] helper() { // helper array to insert the animals to the final board.
		Animal[] animals = new Animal[20];
		int i = 0;
		while (i < 20) {
			animals[i] = new Denis();
			i++;
			animals[i] = new Iguana();
			i++;
			animals[i] = new Kangaroo();
			i++;
			animals[i] = new Lion();
			i++;
			animals[i] = new Monkey();
			i++;
			animals[i] = new Piranha();
			i++;
			animals[i] = new Shark();
			i++;
			animals[i] = new Turtle();
			i++;
			animals[i] = new Viper();
			i++;
			animals[i] = new Zebra();
			i++;
		}
		return animals;
	}

	public boolean isPiranhaOrShark(int place1, int place2) { // Public function - checks if there is match with Piranha
															// and Shark.
		return (thisAnimal(place1).getName() == 'P' &&
				thisAnimal(place2).getName() == 'S')
				|| (thisAnimal(place1).getName() == 'S' &&
				thisAnimal(place2).getName() == 'P');
	}

	public Animal[][] getBoard() { // Public function - returning the board.
		return this.board;
	}

	private Animal thisAnimal(int place) { // returns the animal in a specific place.
		return board[row(place)][column(place)];
	}

	private boolean empty(int row, int column) { // checks if the specific place inside the board is empty.
		return board[row][column] == null;
	}

	private boolean Legal(int row, int column) { // checks if the place is legal.
		return row >= 0 && row <= 4 && column >= 0 && column <= 3;
	}

	private int row(int place) { // returns the row.
		return place / 10;
	}

	private int column(int place) { // returns the column.
		return place % 10;
	}

	

}
