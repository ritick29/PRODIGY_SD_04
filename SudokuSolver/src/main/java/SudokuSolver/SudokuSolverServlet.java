package SudokuSolver;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SudokuSolverServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int size = 4; // Fixed size for 4x4 grid
        int[][] board = new int[size][size];

        // Parse the input grid from the JSP form
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                String cellValue = request.getParameter("cell_" + i + "_" + j);
                board[i][j] = (cellValue != null && !cellValue.isEmpty()) ? Integer.parseInt(cellValue) : 0;
            }
        }

        // Solve the Sudoku puzzle
        boolean solved = SudokuSolver.solveSudoku(board);

        // Set attributes for the JSP to display the solved grid
        request.setAttribute("board", board);
        request.setAttribute("solved", solved);

        // Forward to result.jsp to display the solved puzzle
        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
        dispatcher.forward(request, response);
    }
}
