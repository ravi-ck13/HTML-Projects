import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/servlet")
public class servlet extends HttpServlet{
	public void doPost(HttpServletRequest rq,HttpServletResponse res) throws ServletException, IOException{
		String u_name=rq.getParameter("id");
		String pwd=rq.getParameter("pwd");
		
		try {
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/vsb","root","");
			String str="select * from studentmarks where username=? and password=?;";
			PreparedStatement ps=cn.prepareStatement(str);
			ps.setString(1, u_name);   //this 1 is represent the ? (1st phaseholder)
			ps.setString(2, pwd);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){ 
				int Tamil=rs.getInt(3);
				int English=rs.getInt(4);
				int Maths=rs.getInt(5);
				int Total=rs.getInt(6);
				String Status=rs.getString(7);
				//return true;
					HttpSession htp=rq.getSession();
					htp.setAttribute("u_name",Tamil);
					HttpSession htp1=rq.getSession();
					htp.setAttribute("u_name1",English);
					HttpSession htp2=rq.getSession();
					htp.setAttribute("u_name2",Maths);
					HttpSession htp3=rq.getSession();
					htp.setAttribute("u_name3",Total);
					HttpSession htp4=rq.getSession();
					htp.setAttribute("u_name4",Status);
					RequestDispatcher rs1=rq.getRequestDispatcher("jsp.jsp");
					rs1.forward(rq, res);
				}
			else {
			RequestDispatcher rs2=rq.getRequestDispatcher("login.html");
			rs2.forward(rq, res);}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}