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
 * Servlet implementation class ClassAssignForSubject
 */
@WebServlet("/ClassAssignForSubject")
public class ClassAssignForSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassAssignForSubject() {
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
		try{
			int count = 0;
			SessionFactory factory = com.school.HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			String classId= request.getParameter("classId");
			String subjectname = request.getParameter("subjectname");
			Subject subject = new Subject();
			List<Subject> list = session.createQuery("from com.school.Subject").list();
			for(Subject s : list ) {
				if(s.getSubjectName().toString().equals(subjectname) && s.getClassId() == Integer.parseInt(classId)) {
					out.println(subjectname + " subject has already been assigned to class " + 
					Integer.parseInt(classId) + "<br>");
					count++;
					break;
				}
			}
			
			if(count == 0) {
					subject.setSubjectName(subjectname);
					subject.setClassId(Integer.parseInt(classId));
					out.println(subjectname + " subject is assigned to class " + Integer.parseInt(classId) + "<br>");
				
			}
			
			out.println("<hr>");
			session.save(subject);
			t.commit();
			session.close();
			out.println("<a href='dashboard.jsp'>Go to Dashboard</a>");
			out.println("</body></html>");
		}catch(Throwable th) {
			th.printStackTrace();
		}
		
	}

}
