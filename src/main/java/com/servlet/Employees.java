package main.java.com.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/submit")
public class Employees extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("empId");
        int empId = Integer.parseInt(id);

        String name = request.getParameter("empName");

        String email = request.getParameter("empEmail");

        String age = request.getParameter("empAge");
        int empAge = Integer.parseInt(age);

        String address = request.getParameter("empAddress");

        String state = request.getParameter("empState");

        String gender = request.getParameter("empGender");

        String dept = request.getParameter("empDept");

        String salary = request.getParameter("empSalary");
        int empSalary = Integer.parseInt(salary);

        String exp = request.getParameter("empExp");
        int empExp = Integer.parseInt(exp);

        response.setContentType("application/json"); // Set response type to JSON
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "Amol@1234");
            PreparedStatement ps = c.prepareStatement(
                    "insert into employee (id, name, email, age,address, state, gender, dept, salary, exp) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?,?, ?)"
            );

            ps.setInt(1, empId);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setInt(4, empAge);
            ps.setString(5, address);
            ps.setString(6, state);
            ps.setString(7, gender);
            ps.setString(8, dept);
            ps.setInt(9, empSalary);
            ps.setInt(10, empExp);

            int check = ps.executeUpdate();


            if (check > 0) {
                System.out.println("data inserted...");
            } else {
                System.out.println("data no inserted");            }

            c.close();

        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }


    }

}

