import java.util.Random;

public class Board2 {
	public static final char COVERED = '#';
	public static final char MATCH = '*';
	public Animal[][] board;

	public Board2() {
		board = new Animal[5][4];
		insertAnimals(board);
		mixCards(board);
	}

	private void mixCards(Animal[][] board) {
		while (!shuffleIsLegal(board)) {
			shuffle(board);
		}
	}

	private void shuffle(Animal[][] board) { // shuffling the animals board.
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

	private boolean shuffleIsLegal(Animal[][] board) { // checks if there is places that are not legal, same animal next
		// to the other.
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (isNeighborEqual(i, j, board[i][j])) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isNeighborEqual(int row, int column, Animal currentAnimal) { // checks if there is two animal witch
		// from the same
		return checkNeighbor(row, column+1, currentAnimal)||
				checkNeighbor(row, column-1, currentAnimal)||
				checkNeighbor(row+1, column, currentAnimal)|| 
				checkNeighbor(row-1, column-1, currentAnimal);
	}
	
	private boolean checkNeighbor(int row, int column, Animal currentAnimal) {
		return ((placeIsLegal(row, column)) && (board[row][column].equals(currentAnimal)));

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

	private boolean placeIsLegal(int row, int column) { // checks if the place is legal.
		return row >= 0 && row <= 4 && column >= 0 && column <= 3 && !empty(row, column);
	}

	private int row(int place) { // returns the row.
		return place / 10;
	}

	private int column(int place) { // returns the column.
		return place % 10;
	}

	public static void insertAnimals(Animal[][] animalMatrix) { // helper array to insert the animals to the final
		// board.
		Animal[] animals = new Animal[20];

		for (int i = 0; i < 20;) {
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
		int place = 0;
		for (int i = 0; i < animalMatrix.length; i++) {
			for (int j = 0; j < animalMatrix[0].length; j++) {
				animalMatrix[i][j] = animals[place];
				place++;
			}
		}
	}

	public boolean isDenisFound(int place, char[][] arr) { // Public function - checks if there is Denis next to the
		int row = row(place);
		int col = column(place);
		return isDenisThere(row+1, col, arr) || isDenisThere(row-1, col, arr) ||
				isDenisThere(row, col+1, arr)|| isDenisThere(row, col-1, arr);
	}

	public boolean isDenisThere(int row,int col, char[][] arr) {
		return (placeIsLegal(row,col) && board[row][col].getName() == 'D'
				&& arr[row][col] != MATCH);

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

	public boolean isPiranhaOrShark(int place1, int place2) { // Public function - checks if there is match with Piranha
		// and Shark.
		return (thisAnimal(place1).getName() == 'P' &&
				thisAnimal(place2).getName() == 'S')
				|| (thisAnimal(place1).getName() == 'S' &&
				thisAnimal(place2).getName() == 'P');
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
