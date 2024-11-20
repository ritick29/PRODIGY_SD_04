package SudokuSolver;

public class SudokuSolver {

    // Method to check if it's safe to place the number at the given position
    public static boolean isSafe(int[][] board, int row, int col, int num) {
        int N = 4; // Fixed size for 4x4 Sudoku grid

        // Check if the number is already in the row or column
        for (int x = 0; x < N; x++) {
            if (board[row][x] == num || board[x][col] == num) {
                return false;
            }
        }

        // Check if the number is in the 2x2 sub-grid (for 4x4 Sudoku)
        int startRow = row - row % 2; // Subgrid starts at (row - row % 2, col - col % 2)
        int startCol = col - col % 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    // Backtracking method to solve the Sudoku puzzle
    public static boolean solveSudoku(int[][] board) {
        int N = 4; // Fixed size for 4x4 Sudoku grid

        // Try to find an empty cell (represented by 0)
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (board[row][col] == 0) { // Empty cell
                    // Try all possible numbers (1-4 for a 4x4 Sudoku)
                    for (int num = 1; num <= N; num++) {
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num; // Place the number

                            // Recursively try to solve the rest of the grid
                            if (solveSudoku(board)) {
                                return true;
                            }

                            // If no solution is found, backtrack
                            board[row][col] = 0;
                        }
                    }
                    return false; // If no number can be placed in the empty cell
                }
            }
        }
        return true; // Puzzle solved
    }

    // Function to print the Sudoku grid (for debugging purposes)
    public static void printBoard(int[][] board) {
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }
}
