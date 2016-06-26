<html>
    <body>
        <form action="#" th:action="@{/book/add}" th:object="${book}" method="post">
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" th:field="*{title}" /></td>
                                    </tr>
                <tr>
                    <td>Age:</td>
                    <td><input type="text" th:field="*{author}" /></td>
                </tr>
                 <tr>
                    <td>Age:</td>
                    <td><input type="text" th:field="*{isbn}" /></td>
                </tr>
                <tr>
                    <td><button type="submit">Submit</button></td>
                </tr>
            </table>
        </form>
    </body>
</html>