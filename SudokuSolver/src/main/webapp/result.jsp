<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Sudoku Result</title>
    <link rel="stylesheet" type="text/css" href="style	.css">
</head>
<body>
    <h2>Sudoku Solution</h2>

    <c:if test="${solved}">
        <table id="sudokuGrid">
            <c:forEach var="row" items="${board}">
                <tr>
                    <c:forEach var="cell" items="${row}">
                        <td>${cell}</td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <c:if test="${!solved}">
        <p>No solution exists for the provided Sudoku puzzle.</p>
    </c:if>

    <a href="index.jsp">Try Another Puzzle</a>
</body>
</html>
