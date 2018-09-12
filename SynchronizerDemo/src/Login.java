

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		System.out.println("Login.Java: doPost method reached");
		//System.out.println("Hello.java : "+serialVersionUID);
		String name= request.getParameter("uname");
		Cookie ck = new Cookie("myCookie",name);
		double r = Math.random();
		String random = Double.toString(r);
		//InputStream input = getServletContext().getResourceAsStream("test.txt");
		try{
		File file = new File(getServletContext().getRealPath("data.txt"));
		System.out.println("Login.java : "+"at least it came to here");
		FileWriter fw = new FileWriter(file);
		fw.write("myCookie,"+name);
		fw.write(System.lineSeparator());
		fw.write("csrf_token,"+random);
		fw.flush();
		fw.close();
		}
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}
		
		
		response.addCookie(ck);
		response.sendRedirect("home.jsp");
	}

}
