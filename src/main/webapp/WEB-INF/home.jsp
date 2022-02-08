<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <table>
            <tr> <td> <b>Hello ${username}.</b></td> </tr>     
            <tr> <td></td> </tr>
        <tr> <td> <a href="login?logout">Log out</a> </td> </tr>
        </table>
    </body>
</html>
