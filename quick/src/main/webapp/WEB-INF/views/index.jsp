<%-- 
    Document   : index
    Created on : Aug 6, 2014, 8:15:00 AM
    Author     : u329022
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="assets/uikit/2.8.0/dist/css/uikit.min.css" />
        <script src="assets/jquery/2.1.3/jquery.js"></script>
        <script src="assets/uikit/2.8.0/dist/js/uikit.min.js"></script>
    </head>
    <body>
        <h1>Hello World JSP</h1>
        
        <form method="POST" action="result.htm">
            <table>
                <tr><td>First Name: </td><td><input type="text" name="fName"/></td></tr>
                <tr><td>Last Name: </td><td><input type="text" name="lName"/></td></tr>
                <tr><td><button class="uk-button uk-button-primary" type="button" data-uk-button>Button</button></td><td><input type="reset" value="Reset"/><input type="submit" value="Submit"/></td></tr>
            </table>
        </form>
        <a href="display.htm">Display</a>
    </body>
</html>
