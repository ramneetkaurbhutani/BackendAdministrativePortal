package com.school;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Servlet implementation class TeacherAssign
 */
@WebServlet("/TeacherAssign")
public class TeacherAssign extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherAssign() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			int count = 0;
			SessionFactory factory = com.school.HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			String classId= request.getParameter("classId");
			String subjectname = request.getParameter("subjectname");
			String teachername = request.getParameter("teachername");
			List<Teacher> list = session.createQuery("from com.school.Teacher").list();
			Teacher teacher = new Teacher();
			for(Teacher t : list) {
				if(t.getClassId() == Integer.parseInt(classId) && t.getSubjectName().toString().equals(subjectname)
						&& t.getTeacherName().toString().equals(teachername)) {
					out.println("This entry already exists<br>");
					count++;
					break;
				}
				
			}
				if(count == 0) {
					teacher.setClassId(Integer.parseInt(classId));
					teacher.setSubjectName(subjectname);
					teacher.setTeacherName(teachername);
					out.println(subjectname + " subject is assigned to " + teachername +
							" for class " + classId + "<br>");
				
			}
			
			out.println("<hr>");
			session.save(teacher);
			transaction.commit();
			session.close();
			out.println("<a href='dashboard.jsp'>Go to Dashboard</a>");
			out.println("</body></html>");
		}catch(Throwable th) {
			th.printStackTrace();
		}
	}

}
