

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoubleSubmit
 */
@WebServlet("/DoubleSubmit")
public class DoubleSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoubleSubmit() {
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
		//doGet(request, response);
		boolean isValidUser = false;
		Cookie cookies[] = request.getCookies();
		String redirect = "Error.jsp";
		String hiddenFieldValue = request.getParameter("hiddenField");
		System.out.println("DoubleSubmit: doPost: hidden field value: "+hiddenFieldValue);
		for(Cookie ck:cookies){
			String cookieName = ck.getName();
			System.out.println("DoubleSubmit: doPost: cookie name: "+cookieName);
			if(cookieName.equalsIgnoreCase("CSRF")){
				System.out.println("DoubleSubmit: doPost: inside if ");
				String cookieValue = ck.getValue();
				System.out.println("DoubleSubmit: doPost: cookie value: "+cookieValue);
				if(cookieValue.equals(hiddenFieldValue)){
					isValidUser = true;
				}
			}
		}
		if(isValidUser){
			redirect = "Valid.jsp";
		}
		response.sendRedirect(redirect);
	}

}
