/*
 * Algorithm by Mohamed Elshoubky
 * ICS4U1
 * Finished date: 2022-12-18 (yyyy-MM-dd)
 * 
 * A fully recursive algorithm to solve eight queens problem
 */

public class EightQueensRECU {
    // The size of the chessboard
    public static final int N = 3;
  
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
      if(start == N) { // If out of bounds, then return false
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
  
          queens[start] = -1;
          //System.out.println("backtracked!");
          
        }



      }
      // If the queen cannot be placed in any row in this column, then return false
      //System.out.println("Reached False end!");
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
      
      solveNQueens();

      //solveNQueensUtil(0, 0, 1);

      //printSolution();

      
      
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
      
  
      /* 
      System.out.println(solveNQueensUtil(0, 1, 1));
      printSolution();
      */
  
      /* 
      for(int i = 0; i < N; i++){
        if(solveNQueensUtil(i) == true){
          printSolution();
          System.out.println("------------------------------");
        }
  
      }
      */
  
    }
  
  }
  