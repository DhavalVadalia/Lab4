

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="post">
            <table>
                <tr> <td><label for="username">Username: </label> </td> 
                     <td><input type="text" name="username" id="username"  value="${username}" ></td>
                </tr>    
                
                <tr> <td><label for="password">Password: </label></td>
                    <td><input type="password" id="password" name="password" ></td>
                </tr> 
                
                <tr> <td><button type="submit">Log in</button></td></tr>
                       
            </table>
        </form>        
        <p>${message}</p>
    </body>
</html>
