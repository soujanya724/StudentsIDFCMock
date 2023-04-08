package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.dao.StudentDAO;
import com.entity.Student;

@WebServlet("/register")
public class RegisterSevlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String dob=req.getParameter("dob");
		String address=req.getParameter("address");
		String qualification=req.getParameter("qualification");
		String email=req.getParameter("email");
		
		
		Student student=new Student(name,dob,address,qualification,email);
		
//		System.out.println(student);

		StudentDAO dao=new StudentDAO(DBConnect.getConn());
		
		HttpSession session=req.getSession();
		
		boolean f=dao.addStudent(student);
		
		if(f)
		{
			
			session.setAttribute("succmsg", "Student Details submit Sucessfully");
			resp.sendRedirect("add_student.jsp");
			
//			System.out.println("Student Details submit Sucessfully");
			
		}
		else{
			
			session.setAttribute("errormsg", "Something wrong on server");
			resp.sendRedirect("add_student.jsp");
//		System.out.println("Something wrong on server");
		}
		
		
	}

}
