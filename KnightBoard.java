/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. _Lindsay_Esterman_ */

public class KnightBoard {
    // NOTE: Do NOT modify anything in this class. The only
    // method you can edit is the main method, for your own
    // testing purposes.
    private int size; // the board's width and height
    private int moveCount; // number of positions visited by the Knight so far
    private int currentX, currentY; // Knight's current (x,y) position
    public int[][] board; // the chessboard: spaces that have never been visited
                  //  are marked with -1. Visited spaces will contain positive
                  // integers, indicating the number of moves made so far
                  // by the Knight (i.e. 1 refers to the starting position)
    /** Constructor to initialize the board
    * @param n the width/height of the board */
    public KnightBoard(int n){
      this.size = n;
      board = new int[size][size];
      for (int i=0; i < board.length; i++) {
          for (int j=0; j < board.length; j++)
            board[i][j] = -1; // -1 indicates a non-visited position
      }
      // Knight starts at position (0,0), i.e. top-left corner
      currentX= 0;
      currentY= 0;
      moveCount = 1;
      board[currentY][currentX] = moveCount;  // mark the first move on the board
    }
    /** Helper method for printing the chessboard to standard output */
      public void printChessBoard() {
        for ( int i = 0; i < this.size; i++ ){
          for ( int h = 0; h < this.size; h++ )
               System.out.print("+--");
          System.out.println("+");
          for ( int j = 0; j < this.size; j++ ){
            System.out.print("|");
                if ( board[i][j] == -1 )
                    System.out.print("  ");
                else if ( board[i][j] < 10 )
                    System.out.print(" " + board[i][j]);
                else System.out.print(board[i][j]);
            }
            System.out.println("|");
         }
         for ( int h = 0; h < this.size; h++ )
             System.out.print("+--");
         System.out.println("+");
      }
      /** Helper method that creates an exact copy of the current board
      * @return the newly created board */
      public KnightBoard copyBoard(){
        KnightBoard copy = new KnightBoard(this.size);
        copy.setMoveCount(this.moveCount);
        copy.setCurrentX(this.currentX);
        copy.setCurrentY(this.currentY);
        for ( int i = 0; i < this.size; i++ )
          for ( int j = 0;  j != this.size; j++ )
            copy.board[i][j] = this.board[i][j];
        return copy;
      }
    // The board's getters and setters methods:
    public int getMoveCount(){ return moveCount; }
    public int getCurrentX(){ return currentX; }
    public int getCurrentY(){ return currentY; }
    public void setMoveCount(int count){ moveCount = count; }
    public void setCurrentX(int x) { currentX = x;}
    public void setCurrentY(int y){ currentY = y;}
    /** Place the Knight to the new position passed as a parameter.
    * NOTE: This method assumes that the caller is passing a valid position,
    * with respect to how a Knight moves on a chessboard. However, this
    * method additionally checks if the new position has not been visited before
    * and that it is within the board's valid boundaries (borders).
    * @param newX - the x coordinate of the new position
    * @param newY - the y coordinate of the new position
    * @return true, if the Knight made the move successfully.
    * return false, if the move is outside of board boundaries or
    *   if the new position has already been visited. */
      public boolean move(int newX, int newY) {
        boolean valid;
        // Check if new position is on the board and has never been visited:
        valid =  newX >= 0  &&  newX < size  &&  newY >= 0  &&  newY < size
              &&  board[newY][newX] == -1;
        // NOTE: Again, this method doesn't check if the new position
        // is valid w.r.t. how the Knight moves on a chessboard; you
        // should handle that in your KnightTour implementation!
        // Moving the Knight entails: updating current coordinates,
        // updating moveCount, and marking the new position with moveCount
        if ( valid ){
            this.currentX = newX;
            this.currentY = newY;
            this.moveCount = this.moveCount + 1;
            this.board[currentY][currentX] = this.moveCount;
         }
        return valid;
    }
   // Main method for testing the logic of some KnightBoard's methods
   // NOTE: You can modify this main method on your computer for testing
   // purposes and to better understand how KnightBoard works
   // (but do NOT modify any other method in this class!)
   public static void main(String[] args){
       KnightBoard b = new KnightBoard(4);
       System.out.println("Show the initial board with the Knight's starting position:");
       b.printChessBoard();
       System.out.println("\nIs the move 1,2 valid? " + b.move(1,2));
       b.printChessBoard();
       System.out.println("\nIs the move 0,0 valid? " + b.move(0,0));
       b.printChessBoard();
       System.out.println("\nIs the move 1,2 valid? " + b.move(1,2));
       b.printChessBoard();
       System.out.println("\nIs the move 3,1 valid? " + b.move(3,1));
       b.printChessBoard();
       System.out.println("\nCurrent Knight position: " + b.getCurrentX() + "," + 
  b.getCurrentY());
     }
    }