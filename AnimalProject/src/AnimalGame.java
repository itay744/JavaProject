import java.util.Scanner;
import java.util.Random;

public class AnimalGame {
	public static final char MATCH = '*';
	public static final char COVERED = '#';
	public static final String YES = "y";
	public static final String NO = "n";
}
//	public static char[][] initHiddenBoard() { // Creating the hidden numbers board
//		char[][] board = new char[5][4];
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[0].length; j++) {
//				board[i][j] = COVERED;
//			}
//		}
//		return board;
//	}
//
//	public static void printBoard(char[][] board) { // prints the chars board.
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[0].length; j++) {
//				System.out.print(board[i][j] + "     ");
//			}
//			System.out.println();
//
//		}
//	}
//
//	public static int firstMove(char[][] arr) { // function for the first player choice.
//		return move(arr, "first");
//	}
//
//	public static int secondMove(char[][] arr, int firstMove) { // function for the second player choice.
//		int secondMove = move(arr, "second");
//		while (secondMove == firstMove) { // checks if the player chose the same place in his second choice.
//			System.out.println("Sorry, wrong input. Please try again.");
//			printBoard(arr);
//			secondMove = move(arr, "second");
//		}
//		return secondMove;
//	}
//
//	public static int move(char[][] arr, String turn) { // gets the user choice
//		Scanner sc = new Scanner(System.in);
//		System.out.println("please choose " + turn + " card to flip");
//		String choice = sc.nextLine();
//		while (!legalChoice(choice)) { // if choice is not legal.
//			System.out.println("Sorry, wrong input. Please try again.");
//			printBoard(arr);
//			System.out.println("please choose " + turn + " card to flip");
//			choice = sc.nextLine(); // re- enter choice
//		}
//		int numChoise = stringToInt(choice); // Changing the string to int.
//
//		return numChoise;
//	}
//
//	public static boolean checkMatch(char[][] board, int choice1, int choice2, Board animalBoard) { // checks if match
//		if (animalBoard.isPiranhaOrShark(choice1, choice2) && checkForDenis(board, choice1, choice2, animalBoard)) {
//			return false;
//		} else if (compareChoice(choice1, choice2, animalBoard)) {
//			return true;
//		}
//		return false;
//
//	}
//
//	public static boolean compareChoice(int choice1, int choice2, Board animalBoard) { // checks if the 2 choices are the same
//		return (animalBoard.getBoard()[choice1 / 10][choice1 % 10]
//				.checkMatching(animalBoard.getBoard()[choice2 / 10][choice2 % 10]));
//	}
//
//	public static boolean checkForDenis(char[][] board, int choice1, int choice2, Board animalBoard) {// checks if one of the choices is denis
//		return (animalBoard.isDenisThere(choice1, board) || animalBoard.isDenisThere(choice2, board));
//	}
//
//	public static boolean checkIfGameOver(char[][] board, Board animalBoard) { // checks the two options if the game
//		// finished. returns true if game-over.
//		int counter = 0;
//		char firstChar = MATCH;
//		char secondChar = '@';
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[0].length; j++) {
//				if (board[i][j] == MATCH) {
//					counter++;
//				} else {
//					if (firstChar != MATCH) {
//						secondChar = animalBoard.getBoard()[i][j].getName();
//					} else {
//						firstChar = animalBoard.getBoard()[i][j].getName();
//					}
//				}
//			}
//		}
//		return (counter == 18 && firstChar != secondChar && firstChar != 0 && secondChar != 0) || counter == 20
//				|| animalBoard.noMoreMatch(board);
//
//	}
//
//	public static void flipCard(int number, char[][] board) { // putting '*' in the number place inside the chars array.
//		setBoardByFormat(number, board, MATCH);
//	}
//
//	public static void setBoardByFormat(int number, char[][] board, char input) { // putting the current char inside the
//		// board.
//		board[number / 10][number % 10] = input;
//	}
//
//	public static void turnCard(int place, char[][] board, Board animalBoard) { // copying the current number from the
//		// numbers board to the chars board.
//		char currentAnimal = getNameFromBoard(place, board, animalBoard);
//		setBoardByFormat(place, board, currentAnimal);
//	}
//
//	public static char getNameFromBoard(int place, char[][] board, Board animalBoard) { // return the char in choosen place
//		char currentChar = animalBoard.getBoard()[place / 10][place % 10].getName();
//		return currentChar;
//	}
//
//	public static void turnBack(int number, char[][] board) { // putting back '#' in the number place inside the chars
//		// array.
//		setBoardByFormat(number, board, COVERED);
//		;
//	}
//
//	private static boolean legalRow(char c) { // check if row is legal
//
//		return c >= '0' && c <= '4';
//	}
//
//	private static boolean legalCol(char c) { // check if col is legal
//		return c >= '0' && c <= '3';
//	}
//
//	public static int stringToInt(String number) { // changing string to integer.
//		int num1 = number.charAt(0) - '0';
//		int num2 = number.charAt(1) - '0';
//		return num1 * 10 + num2;
//	}
//
//	public static boolean legalChoice(String choice) { // check if the choice is legal
//		return choice.length() == 2 && legalRow(choice.charAt(0)) && legalCol(choice.charAt(1));
//	}
//
//	public static boolean checkIfWantPlay() { // after game-over, checking if the player wants to restart the game.
//		Scanner sc = new Scanner(System.in);
//		String question = sc.nextLine().toLowerCase();
//		while (question.compareTo(NO) != 0 && question.compareTo(YES) != 0) { // is legal.
//			System.out.println("Wrong answer, try again.");
//			question = sc.nextLine().toLowerCase();
//		}
//		return question.compareTo(YES) == 0;// return yes
//	}
//
//	public static boolean alredyMatch(int place, char[][] board) { // checks if the chosen input is already matched.
//		return (board[place / 10][place % 10] == MATCH);
//	}
//
//	public static void checkFirstMove(int playerPick, char[][] board) {// checks if first move is valide
//		while (alredyMatch(playerPick, board)) {
//			System.out.println("Sorry, wrong input. Please try again.");
//			printBoard(board);
//			playerPick = firstMove(board);
//		}
//	}
//
//	public static void checkSecondMove(int playerPick, char[][] board, int firstChoice) { // checks if second move is valide
//		while (alredyMatch(playerPick, board) || playerPick == firstChoice) {
//			System.out.println("Sorry, wrong input. Please try again.");
//			printBoard(board);
//			playerPick = firstMove(board);
//		}
//	}
//
//	public static void doTurn(char[][] board, Board animalBoard, boolean gameOver) { // making one turn
//		printBoard(board);
//		int firstChoice = firstMove(board);// first move
//		checkFirstMove(firstChoice, board);
//		turnCard(firstChoice, board, animalBoard);// turn to number card
//		printBoard(board);
//		int secondChoice = secondMove(board, firstChoice);// second move
//		checkSecondMove(secondChoice, board, firstChoice);
//		turnCard(secondChoice, board, animalBoard);// turn to number card
//		printBoard(board);
//		if (checkMatch(board, firstChoice, secondChoice, animalBoard)) { // if the two numbers matches.
//			flipCard(firstChoice, board);// turn to star card
//			flipCard(secondChoice, board);// turn to star card
//			System.out.println("Cards match!");
//		} else {
//			System.out.println("Cards do not match!");
//			turnBack(firstChoice, board);// turn card back
//			turnBack(secondChoice, board);// turn card back
//		}
//
//	}
//
//	public static void turnTwoLastCards(char[][] board, Board animalBoard) {// turn two last cards
//
//		int sulamit = -1;
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[0].length; j++) {
//				if (board[i][j] == COVERED) {
//					sulamit = i * 10 + j;
//					turnCard(sulamit, board, animalBoard);// turn to number cards
//				}
//			}
//		}
//	}
//
//	public static void gameIsFinished(char[][] board, Board animalBoard) {// run actions after game is finished
//
//		Scanner sc = new Scanner(System.in);
//		printBoard(board);
//		if (!allStars(board)) {// if not all cards are stars
//			System.out.println("Game is over! No more possible matches.");
//			turnTwoLastCards(board, animalBoard);// turn two last cards
//			printBoard(board);
//		} else {
//			System.out.println("Game is over! All cards are matched.");
//		}
//	}
//
//	public static boolean allStars(char[][] board) {// return true if 20 stars counted
//
//		int counter = 0;
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[0].length; j++) {
//				if (board[i][j] == MATCH) {
//					counter++;
//				}
//			}
//		}
//		return counter == 20;
//	}
//
//	public static void playGame() {// running the game
//		Scanner sc = new Scanner(System.in);
//		char[][] board = initHiddenBoard(); // Hidden numbers board
//		Board animalBoard = new Board(); // Random numbers board
//		print(animalBoard); // remove before finishing
//		boolean gameOver = false; // check if game is over
//		System.out.print("Welcome to Fatma Memory Game. ");
//		sc.nextLine();
//		while (!gameOver) { // runs until game over
//			doTurn(board, animalBoard, gameOver);
//			gameOver = checkIfGameOver(board, animalBoard);
//		}
//		gameIsFinished(board, animalBoard);
//	}
//
//	public static void print(Board board) { // to remove before finish
//		for (int i = 0; i < board.getBoard().length; i++) {
//			for (int j = 0; j < board.getBoard()[0].length; j++) {
//				System.out.print(board.getBoard()[i][j].getName() + "     ");
//			}
//			System.out.println();
//
//		}
//	}
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		boolean play = true;
//		while (play) { // runs until play is false
//			playGame();
//			System.out.println("Would you like to start a new game?");
//			play = checkIfWantPlay();
//		}
//
//	}
//
//}
