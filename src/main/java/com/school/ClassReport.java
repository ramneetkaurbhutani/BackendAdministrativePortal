package com.school;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Servlet implementation class ClassReport
 */
@WebServlet("/ClassReport")
public class ClassReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassReport() {
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
			List<Class> list = session.createQuery("from com.school.Class").list();
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			for(Class c : list) {
				out.println("<b>Class Report for </b>" + c.getClassName().toString() + "<b>:</b><br>");
				out.println("List of students: ");
				List<Student> students = c.getStudents();
				for (Student s : students) {
					out.println(s.getStudentName() + "&nbsp&nbsp");
				}
				out.println("<br>List of subjects: ");
				List<Subject> subjects = c.getSubjects();
				for(Subject s : subjects) {
					out.println(s.getSubjectName() + "&nbsp&nbsp");
				}
				out.println("<br>List of teachers: ");
				List<Teacher> teachers = c.getTeachers();
				Set<String> set = new HashSet<String>();
				for(Teacher t : teachers) {
					set.add(t.getTeacherName().toString());
				}
				for(String s : set) {
					out.println(s + "&nbsp&nbsp");
				}
				
				
				out.println("<hr>");
			}
			session.close();
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
