<%@ page import="java.util.List" %>
<%@ page import="entity.Student" %>
<%@ page import="entity.StudentList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
</head>
<body>

<%
    StudentList studentList = new StudentList();
    List<Student> students = studentList.getStudents();

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    for (Student student : students) {
%>
<div>
    <p>学号: <%= student.getStudentId() %></p>
    <p>姓名: <%= student.getName() %></p>
    <p>性别: <%= student.getGender() %></p>
    <p>出生日期: <%= dateFormat.format(student.getBirthDate()) %></p>
    <p>专业: <%= student.getMajor() %></p>
    <p>入学年份: <%= student.getAdmissionYear() %></p>
    <hr/>
</div>
<%
    }
%>

</body>
</html>
