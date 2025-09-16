package main.java.com.servlet;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/submit")
public class Employees extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("empId");
        int empId = Integer.parseInt(id);

        String name = request.getParameter("empName");

        String email = request.getParameter("empEmail");

        String age = request.getParameter("empAge");
        int empAge = Integer.parseInt(age);

        String dob = request.getParameter("empDob");
        int empDob = Integer.parseInt(age);

        String address = request.getParameter("empAddress");

        String state = request.getParameter("empState");

        String gender = request.getParameter("empGender");

        String dept = request.getParameter("empDept");

        String salary = request.getParameter("empSalary");
        int empSalary = Integer.parseInt(salary);

        String exp = request.getParameter("empExp");
        int empExp = Integer.parseInt(exp);


        System.out.println(id);
        System.out.println(name);

        System.out.println(email);

        System.out.println(age);
        System.out.println(dob);
        System.out.println(address);
        System.out.println(state);
        System.out.println(gender);
        System.out.println(dept);
        System.out.println(salary);
        System.out.println(exp);


    }

}

