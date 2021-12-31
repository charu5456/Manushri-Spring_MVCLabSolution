<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 TRANSITIONAL//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
      integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
      crossorigin="anonymous">
      
<title>Student Debate Event</title>
</head>
<body>

<div class="container">
    <h3>Students Form</h3>
    <hr>
    <p class="h4 mb-4">Student</p>
    <form action="/DebateEvent/save" method="POST">
        
        <input type="hidden" name="id" value="${Student.id}"/>
        <div class="form-inline">
            <input type="text" name="name" value="${Student.name}" placeholder="Name" class="form-control mb-4 col-4" />
        </div>
        <div class="form-inline">
            <input type="text" name="department" value="${Student.department}"  placeholder="Department" class="form-control mb-4 col-4" />
        </div>
        <div class="form-inline">
            <input type="text" name="country" value="${Student.country}"  placeholder="Country" class="form-control mb-4 col-4" />
        </div>
        
        <button type="submit" class="btn btn-info col-2">Save</button>
        
    </form>
   
    <a href="/DebateEvent/list">Back</a>
    
</div>
</body>
</html>