
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
           <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
        <div class="row"> 
            <div class="add">
                <table>
                    <h1>Add User</h1>
                        <form action="Add" method="POST">
                            
                            <input type="text" name="email" id="email" placeholder="Email" required>
                            <br>
                           <input type="text" name="firstName" id="firstName" placeholder="First Name" required>
                           <br>
                           <input type="text" name="lastName" id="lastName" placeholder="Last Name" required>
                           <br>
                            <input type="text" name="password" id="password" placeholder="Password" required>
                            <br>
                            
                            <select class="options">
                                
                                <option value="admin">company admin</option>
                                <option value="reg">regular user</option>
                                <option value="sysadmin">system admin</option>
                                
                            </select>
                            <br>
                            <input type="hidden" value="add">
                            <button type="submit">Save</button>
                        </form>
                </div>
            
                <div class="main">
                    
                    <h1>Amy's User Management System</h1>

                    <table class="table">
                        <thead>
                            <tr>
                                <th>E-mail</th>
                                <th>First name</th>
                                <th>Last name</th>
                                <th>Active</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" items="${users}">
                                <tr>
                                    <td>${user.email}</td>
                                    <td>${user.firstName}</td>
                                    <td>${user.lastName}</td>
                                    <td>${user.active ? "Y" : "N"}</td>
                                    <td>
                                        <a href="">Edit</a>
                                        <a href="user?action=delete&email=${user.email.replace("+", "&#43;")}" >Delete </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
             
                <div class="edit">
                    
                    <h1>Edit User</h1>
                    
                        <form action="Edit" method="POST">
                            
                            <input type="text" name="email" id="email" required>
                            <br>
                            <input type="text" name="firstName" id="firstName" required>
                            <br>
                            <input type="text" name="lastName" id="lastName" required>
                            <br>
                            <input type="text" name="password" id="password" required>
                            <br>
                            <select class="roleName">
                                
                                <option value="admin">company admin</option>
                                <option value="user">regular user</option>
                                <option value="admin">system admin</option>
                                
                            </select>
                            <br>
                            <button type="submit" value="edit">Save</button>
                            <button type="submit">Cancel</button>
                        </form>
            
        
    </body>
</html>
