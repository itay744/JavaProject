import java.util.Scanner;
import java.util.Random;

public class Assignment1 {
	public static final char MATCH = '*';
	public static final char COVERED = '#';
	public static final String YES = "y";
	public static final String NO = "n";
	

	public static char[][] initHiddenBoard() { // Creating the hidden numbers board
		char[][] board = new char[5][4];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = COVERED;
			}
		}
		return board;
	}

	public static void printBoard(char[][] board) { // prints the chars board.
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + "     ");
			}
			System.out.println();

		}
	}

	public static int firstMove(char[][] board) { // function for the first player choice.
		int choice = move(board, "first");
		choice = checkFirstMove(choice, board);
		return choice;
	}

	public static int secondMove(char[][] board, int firstChoice) { // function for the second player choice.
		int secondMove = move(board, "second");
		secondMove = checkSecondMove(secondMove, board, firstChoice);
		return secondMove;
	}

	public static int move(char[][] arr, String turn) { // gets the user choice
		Scanner sc = new Scanner(System.in);
		System.out.println("please choose " + turn + " card to flip");
		String choice = sc.nextLine();
		while (!legalChoice(choice)) { // if choice is not legal.
			System.out.println("Sorry, wrong input. Please try again.");
			printBoard(arr);
			System.out.println("please choose " + turn + " card to flip");
			choice = sc.nextLine(); // re- enter choice
		}
		int numChoise = stringToInt(choice); // Changing the string to int.

		return numChoise;
	}

	public static boolean checkMatch(char[][] board, int choice1, int choice2, Animal[][] animalBoard) { 																				// match
		if (isPiranhaOrShark(choice1, choice2, animalBoard) && 
				checkForDenis(board, choice1, choice2, animalBoard)) {
				return false;
			} else if (compareChoice(choice1, choice2, animalBoard)) {
				return true;
			}
			return false;

	}

	public static boolean compareChoice(int choice1, int choice2, Animal[][] animalBoard) { 
		return (animalBoard[row(choice1)][col(choice1)].
				checkMatching(animalBoard[row(choice2)][col(choice2)]));
	}

	public static boolean checkForDenis(char[][] board, int choice1, int choice2, Animal[][] animalBoard) {// check id denis around choices																							// denis
		return (isDenisFound(choice1,board, animalBoard) || isDenisFound(choice2,board, animalBoard));
	}

	public static boolean checkIfGameOver(char[][] board, Animal[][] animalBoard) { 
		int counter = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == MATCH) {
					counter++;
				}
			}
		}	
		return   counter == 20 || isNoMoreMatchLeft(board, animalBoard);

	}

	public static void flipCard(int number, char[][] board) { // putting '*' in the number place inside the chars array.
		setBoardByFormat(number, board, MATCH);
	}

	public static void setBoardByFormat(int number, char[][] board, char input) { // putting the current char inside the
		// board.
		board[number / 10][number % 10] = input;
	}

	public static void turnCard(int place, char[][] board, Animal[][] animalBoard) { // copying the current number from
																						// the
		// numbers board to the chars board.
		char currentAnimal = getNameFromBoard(place, animalBoard);
		setBoardByFormat(place, board, currentAnimal);
	}

	public static char getNameFromBoard(int place, Animal[][] animalBoard) { // return the char in
																								// choosen
		// place
		char currentName = animalBoard[place / 10][place % 10].getName();
		return currentName;
	}

	public static void turnBack(int number, char[][] board) { // putting back '#' in the number place inside the chars
		// array.
		setBoardByFormat(number, board, COVERED);
		;
	}

	private static boolean isLegalRow(char c) { // check if row is legal

		return c >= '0' && c <= '4';
	}

	private static boolean isLegalCol(char c) { // check if col is legal
		return c >= '0' && c <= '3';
	}

	public static int stringToInt(String input) { // changing string to integer.
		int num1 = input.charAt(0) - '0';
		int num2 = input.charAt(1) - '0';
		return num1 * 10 + num2;
	}

	public static boolean legalChoice(String choice) { // check if the choice is legal
		return choice.length() == 2 && isLegalRow(choice.charAt(0)) && isLegalCol(choice.charAt(1));
	}

	public static boolean checkIfWantPlay() { // after game-over, checking if the player wants to restart the game.
		Scanner sc = new Scanner(System.in);
		String question = sc.nextLine().toLowerCase();
		while (question.compareTo(NO) != 0 && question.compareTo(YES) != 0) { // is legal.
			System.out.println("Wrong answer, try again.");
			question = sc.nextLine().toLowerCase();
		}
		return question.compareTo(YES) == 0;// return yes
	}

	public static boolean alredyMatch(int place, char[][] board) { // checks if the chosen input is already matched.
		return (board[row(place)][col(place)] == MATCH);
	}

	public static int checkFirstMove(int playerPick, char[][] board) {// checks if first move is valide
		while (alredyMatch(playerPick, board)) {
			System.out.println("Sorry, wrong input. Please try again.");
			printBoard(board);
			playerPick = firstMove(board);
		}
		return playerPick;
	}

	public static int checkSecondMove(int playerPick, char[][] board, int firstChoice) { // checks if second move is
																							// valide
		while (alredyMatch(playerPick, board) || playerPick == firstChoice) {
			System.out.println("Sorry, wrong input. Please try again.");
			printBoard(board);
			playerPick = secondMove(board, firstChoice);
		}
		return playerPick;
	}

	public static void doTurn(char[][] board, Animal[][] animalBoard, boolean gameOver) { // making one turn
		printBoard(board);
		int firstChoice = firstMove(board);// first move
		turnCard(firstChoice, board, animalBoard);// turn to number card
		printBoard(board);
		int secondChoice = secondMove(board, firstChoice);// second move
		turnCard(secondChoice, board, animalBoard);// turn to number card
		printBoard(board);
		if (checkMatch(board, firstChoice, secondChoice, animalBoard)) { // if the two numbers matches.
			flipCard(firstChoice, board);// turn to star card
			flipCard(secondChoice, board);// turn to star card
			System.out.println("Cards match!");
		} else {
			System.out.println("Cards do not match!");
			turnBack(firstChoice, board);// turn card back
			turnBack(secondChoice, board);// turn card back
		}

	}

	public static void turnLastCards(char[][] board, Animal[][] animalBoard) {// turn two last cards

		int covered = -1;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == COVERED) {
					covered = i * 10 + j;
					turnCard(covered, board, animalBoard);// turn to number cards
				}
			}
		}
	}

	public static void gameIsFinished(char[][] board, Animal[][] animalBoard) {// run actions after game is finished

		Scanner sc = new Scanner(System.in);
		printBoard(board);
		if (!allMatch(board)) {// if not all cards are stars
			System.out.println("Game is over! No more possible matches.");
			turnLastCards(board, animalBoard);// turn two last cards
			printBoard(board);
		} else {
			System.out.println("Game is over! All cards are matched.");
		}
	}

	public static boolean allMatch(char[][] board) {// return true if 20 stars counted

		int counter = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == MATCH) {
					counter++;
				}
			}
		}
		return counter == 20;
	}

	public static void playGame() {// running the game
		Scanner sc = new Scanner(System.in);
		char[][] board = initHiddenBoard(); // Hidden numbers board
		Animal[][] animalBoard = createAnimalBoard();
		print(animalBoard);
		boolean gameOver = false; // check if game is over
		System.out.print("Welcome to Fatma Memory Game. ");
		sc.nextLine();
		while (!gameOver) { // runs until game over
			doTurn(board, animalBoard, gameOver);
			gameOver = checkIfGameOver(board, animalBoard);
		}
		gameIsFinished(board, animalBoard);
	}

	public static void print(Animal[][] animalBoard) { // to remove before finish
		for (int i = 0; i < animalBoard.length; i++) {
			for (int j = 0; j < animalBoard[0].length; j++) {
				System.out.print(animalBoard[i][j].getName() + "     ");
			}
			System.out.println();

		}
	}

	public static void mixCards(Animal[][] animalBoard) {
		shuffle(animalBoard);
		while (!isShuffleLegal(animalBoard)) {
			shuffle(animalBoard);
		}
	}

	public static void shuffle(Animal[][] board) { // shuffling the animals board.
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

	public static boolean isShuffleLegal(Animal[][] animalBoard) { // checks if there is places that are not legal, same
																	// animal next
		for (int i = 0; i < animalBoard.length; i++) {
			for (int j = 0; j < animalBoard[0].length; j++) {
				if (checkAllNeighbors(i, j, animalBoard[i][j], animalBoard)) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean checkAllNeighbors(int row, int column, Animal currentAnimal, Animal[][] animalBoard) { 
		return checkNeighbor(row, column + 1, currentAnimal, animalBoard)
				|| checkNeighbor(row, column - 1, currentAnimal, animalBoard)
				|| checkNeighbor(row + 1, column, currentAnimal, animalBoard)
				|| checkNeighbor(row - 1, column, currentAnimal, animalBoard);
	}

	public static boolean checkNeighbor(int row, int col, Animal currentAnimal, Animal[][] animalBoard) {
		return ((isPlaceLegal(row, col, animalBoard)) && (animalBoard[row][col].equals(currentAnimal)));

	}

	public static Animal thisAnimal(int place, Animal[][] animalBoard) { // returns the animal in a specific place.
		return animalBoard[row(place)][col(place)];
	}

	public static boolean empty(int row, int column, Animal[][] animalBoard) { // checks if the specific place inside
																				// the board is empty.
		return animalBoard[row][column] == null;
	}

	public static boolean isPlaceLegal(int row, int column, Animal[][] animalBoard) { // checks if the place is legal.
		return row >= 0 && row <= 4 && column >= 0 && column <= 3 && !empty(row, column, animalBoard);
	}

	public static int row(int place) { // returns the row.
		return place / 10;
	}

	public static int col(int place) { // returns the column.
		return place % 10;
	}

	public static void insertAnimals(Animal[][] animalBoard) { // helper array to insert the animals to the final
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
		for (int i = 0; i < animalBoard.length; i++) {
			for (int j = 0; j < animalBoard[0].length; j++) {
				animalBoard[i][j] = animals[place];
				place++;
			}
		}
	}

	public static boolean isDenisFound(int place, char[][] board, Animal[][] animalBoard) { // check if neighbor is denis																// the
		int row = row(place);
		int col = col(place);
		return isDenisThere(row + 1, col,board, animalBoard) || isDenisThere(row - 1, col,board, animalBoard)
				|| isDenisThere(row, col + 1,board, animalBoard) || isDenisThere(row, col - 1,board, animalBoard);
	}

	public static boolean isDenisThere(int row, int col, char[][] arr, Animal[][] animalBoard) {
		return (isPlaceLegal(row, col, animalBoard) && animalBoard[row][col].getName() == 'D'
				&& arr[row][col] != MATCH);
	}

	public static int countCovered(char[][] board) { // counts covered cards.
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

	public static boolean isPiranhaOrShark(int place1, int place2, Animal[][] animalBoard) { 
		return (thisAnimal(place1, animalBoard).isPiranha()&& thisAnimal(place2, animalBoard).isShark()
				|| thisAnimal(place2, animalBoard).isPiranha()&& thisAnimal(place1, animalBoard).isShark());
		
	}
	
	public static boolean isNoMoreMatchLeft(char[][] board, Animal[][] animalBoard) { 											// matches.
		Animal[] remainAnimals = checkRemainAnimals(board, animalBoard);
		for (int i = 0; i < remainAnimals.length; i++) {
			for (int j = i+1; j < remainAnimals.length; j++) {
				if (remainAnimals[i].checkMatching(remainAnimals[j])) {
					return false;
				}
			}
		}
		return true;
	}

	public static Animal[] checkRemainAnimals(char[][] gameBoard, Animal[][] animalBoard) {
		int count = countCovered(gameBoard);
		Animal[] animal = new Animal[count];
		int place = 0;
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[0].length; j++) {
				if (gameBoard[i][j] == COVERED) {
					animal[place] = animalBoard[i][j];
					place++;
				}
			}
		}
		return animal;
	}

	public static Animal[][] createAnimalBoard() {
		Animal[][] animalBoard = new Animal[5][4];
		insertAnimals(animalBoard);
		mixCards(animalBoard);
		return animalBoard;
	}

	public static void main(String[] args) {
		boolean play = true;
		while (play) { // runs until play is false
			playGame();
			System.out.println("Would you like to start a new game?");
			play = checkIfWantPlay();
		}

	}

}
