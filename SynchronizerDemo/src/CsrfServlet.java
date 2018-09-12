

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CsrfServlet
 */
@WebServlet("/CsrfServlet")
public class CsrfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CsrfServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("this was also called");
		String text = "This is the doGet method response, sent after ajax call";
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(text);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			InputStream input = getServletContext().getResourceAsStream("data.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			String line = null;
			while((line=br.readLine())!=null){
				System.out.println("CsrfServlet.java: doPost : "+line);
			}
			
		}catch(Exception e){
			System.out.println("CsrfServlet.java: exeption "+e.getMessage());
		}
		response.sendRedirect("form.jsp");
	}
	

}
