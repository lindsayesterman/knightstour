import java.util.Stack;
// Do you know the chess piece that looks like a horse? It's called a "Knight",
// and the "Knight's Tour" is a famous problem where you want the Knight to move
// around a chess board such that it visits every position on the board exactly 
once.

// Recall that the Knight can move in the shape of the letter "L" in any direction
// IMPORTANT: See our A2 handout for examples and more detailed instructions/hints!
public class KnightTour {
    // TODO: Implement and print a Knight's Tour solution, using
    // the chess board defined in class KnightBoard. Your solution must
    // use a Stack to keep track of different possible sequences of moves
    // for the Knight, in order to discover and return a valid tour.
    // NOTE: There can be several distinct valid tours; your job is to find
    // and print only one valid tour (the first valid one you discover).
    // Please do NOT attempt to discover all possible valid tours! To get
    // a sense of how many valid board configurations exist for different
    // board sizes, see "The Knight's Paths" table here:
    // http://www.behnel.de/knight.html
    /**
     * tour method is where you add your code for implementing
     * a Knight Tour's solution for an n*n chess board
     * 
     * @param n size of the board
     * @return KnightBoard object with a valid Knight Tour
     */
    public static KnightBoard tour(int n) {
        // Your solution must utilize the stack "candidates" below,
        // to keep track of different possible sequences of Knight moves
        Stack<KnightBoard> candidates = new Stack<KnightBoard>();
        KnightBoard kb = new KnightBoard(n); // create initial board of size n*n
        candidates.push(kb); // push the initial board onto the stack
        // pick every possible move from one point
        // put the board with each different move in the stack
        // when you pick a move, pop it off the stack
        // TODO: ...... Add your solution code here ..... //

        KnightBoard currentBoard = new KnightBoard(n);
        while (candidates.size() > 0) {
            currentBoard = candidates.pop();
            if (currentBoard.getMoveCount() == n * n) {
                return currentBoard;
            } else {
                int coordinates[][] = { { 2, 1 }, { 1, 2 }, { 2, -1 }, { -1, 2 }, { 1, -2 },
                        { -1, -2 }, { -2, 1 },
                        { -2, -1 } };
                // it keeps going but it should instead explore more possibilities
                for (int i = 0; i < 8; i++) {
                    int xTest = currentBoard.getCurrentX() + coordinates[i][0];
                    int yTest = currentBoard.getCurrentY() + coordinates[i][1];
                    KnightBoard newBoard = currentBoard.copyBoard();
                    // calls function and checks if it worked (was valid)
                    if (newBoard.move(xTest, yTest)) {
                        candidates.push(newBoard);
                    }
                }
            }
        }
        return currentBoard; // TODO: return a KnightBoard object with a valid Knight Tour
    }

    // Do NOT modify this main method. If you need to add code for
    // testing your solution, just make sure to comment it out before submission
    public static void main(String[] args) {
      int n = 3; // default board size if user didn't specify
      // pass in parameter n from command line
      if (args.length == 1) {
          n = Integer.parseInt(args[0].trim());
          if (n < 3 || n > 8) {
              System.out.println("Incorrect parameter (n must be >= 3 and <= 8)");
              System.exit(-1);
          }
      }
      long startTime = System.nanoTime();
      KnightBoard winner = KnightTour.tour(n);
      long endTime = System.nanoTime();
      double delta = (endTime - startTime) / 1e6;
      // Display the solution you discovered:
      System.out.println("\nPossible Knight Tour with max #squares visited in this ("+n+"x" +n+") board:");
      winner.printChessBoard();
      System.out.println("\n(Time to find this solution = " + delta + " milliseconds)");
    }
}