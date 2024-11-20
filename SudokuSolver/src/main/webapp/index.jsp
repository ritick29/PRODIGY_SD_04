<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>4x4 Sudoku Solver</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>Enter Sudoku Puzzle (4x4 Grid)</h2>
    <form action="solve" method="post">
        <table id="sudokuGrid">
            <% for (int i = 0; i < 4; i++) { %>
                <tr>
                    <% for (int j = 0; j < 4; j++) { %>
                        <td>
                            <input type="text" name="cell_<%=i%>_<%=j%>" maxlength="1" class="grid-input" />
                        </td>
                    <% } %>
                </tr>
            <% } %>
        </table>
        <input type="submit" value="Solve Sudoku" />
    </form>
</body>
</html>
