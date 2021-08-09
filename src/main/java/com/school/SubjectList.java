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
 * Servlet implementation class SubjectList
 */
@WebServlet("/SubjectList")
public class SubjectList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
			SessionFactory factory = com.school.HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			List<Subject> list = session.createQuery("from com.school.Subject").list();
			session.close();
			Set<String> set = new HashSet<String>();
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<b>List of Subjects:</b><br>");
			for (Subject s : list) {
				set.add(s.getSubjectName().toString());
			}
			
			for(String s : set) {
				out.println(s + "<br>");
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
