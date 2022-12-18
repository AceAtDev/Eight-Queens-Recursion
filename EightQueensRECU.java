/*
 * Finished date: 2022-12-18 (yyyy-MM-dd)
 * 
 * A fully recursive algorithm to solve eight queens' problem
 * 
 * --------------------------------------------------------------------------------------------------------------------------------
 * Keep in mind that this algorithm is not not good for performance.
 * You can accully optimize the algorithm by using for loops instead, but it was created as a chellenge.
 * --------------------------------------------------------------------------------------------------------------------------------
 * 
 * If you found a problem in the following code, please create issue on github.
 * Thank you and have a nice day!
 * :)
 */

public class EightQueensRECU {
    // The size of the chessboard
    public static final int N = 8;
  
    // The columns where the queens are placed
    public static int[] queens = new int[N];
  
    // A utility function to print the solution
    public static void printSolution() {
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (queens[i] == j) {
            System.out.print("Q  ");
          } else {
            System.out.print(".  ");
          }
        }
        System.out.println();
      }
    }
  
    // A utility function to check if a queen can be placed on board[row][col]
    public static boolean isSafe(int row, int col) {
      // Check this row on left side
      for (int i = 0; i < col; i++) {
        if (queens[row] == i) {
          return false;
        }
      }
  
      // Check upper diagonal on left side
      for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
        if (queens[i] == j) {
          return false;
        }
      }
  
      // Check lower diagonal on left side
      for (int i = row, j = col; i < N && j >= 0; i++, j--) {
        if (queens[i] == j) {
          return false;
        }
      }
  
      return true;
    }
  
    // A recursive utility function to solve the N Queen problem
    public static boolean solveNQueensUtil(int col, int start, int steps) { // Main solver
      
      
      if (col >= N) { // Found a solution (end case)
        return true;
      }
      if(start == N) { // Can not put a queen on that row; return false
        return false; 
      }
  
      
      // Consider this column and try placing this queen in all rows one by one
      if (start < N){


        if (isSafe(start, col)) {
          // Place this queen in board[i][col]
          queens[start] = col;
  
          // recur to place rest of the queens
          if (solveNQueensUtil(col + 1, 0, steps)) {
            return true;
          }
  
          // Backtrack and remove the queen that been placed
          queens[start] = -1;
          
        }

      }
      // Continue to placing trying to put a queen on that row
      return solveNQueensUtil(col, start + steps, steps);

    }

  
    // This function solves the N Queen problem using Backtracking. It mainly uses solveNQueensUtil() to solve the problem.
    public static void solveNQueens() {
      // Initialize all entries of queens[] as -1
      for (int i = 0; i < N; i++) {
        queens[i] = -1;
      }
    }
  
    public static void main(String[] args) {

      /*
       * How it works:
       * 1. initialize all entries with solveNQueens method
       * 2. Solve the N Queen problem with solveNQueensUtil function
       * 3. print the solution with printSolution method
       * 4. Done
       * 
       * Note: you will need reinitialize solveNQueens if you want to use solveNQueensUtil to find another solution.
       * ALSO, column must equal 0 in solveNQueensUtil to solve correctly!
      */



      /* Solves for one soluation  */
      solveNQueens();

      solveNQueensUtil(0, 0, 1);

      printSolution();

      
      /* Use the below if you want to find more then one soluation!  */
      /* 
      for (int i = 0; i < N; i++) {

          if(solveNQueensUtil(0, i, 1)){
            printSolution();
            solveNQueens();
            System.out.println();
          }else{
            solveNQueens();
            System.out.println("No solution for when start is " + i);
          }
        
      }
      */
  
    }
  
  }
  