package com.school;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Servlet implementation class StudentList
 */
@WebServlet("/StudentList")
public class StudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
			SessionFactory factory = com.school.HibernateUtil.getSessionFactory();
			Session session = factory.openSession(); 
			List<Student> list = session.createQuery("from com.school.Student").list();
			session.close();
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<b>List Of Students</b><br>");
			for(Student s : list) {
				out.println(s.getStudentName().toString()+ "<br>");
			}
			
			out.println("<a href='index.html'>Click here to go to main menu</a>");
			out.println("</body></html>");
	}catch(Throwable th) {
		th.printStackTrace();
	}
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
