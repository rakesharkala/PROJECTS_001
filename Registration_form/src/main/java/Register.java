

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/Register")
public class Register extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname =request.getParameter("uname");
		String pass =request.getParameter("pass");	
		String email =request.getParameter("email");
		String phone =request.getParameter("phone");
		
		Member member =new Member(uname,pass,email,phone);
		
		RegisterDao rDao=new RegisterDao();
		String result =rDao.insert(member);  //OBJ CONTAIN ALL OBJ VALUES LIKE UNAME PASS EMAIL...
         
		response.getWriter().print(result);
	}

}
