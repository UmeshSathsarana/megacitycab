

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Contact;
import com.example.service.ContactService;

/**
 * Servlet implementation class contactController
 */
@WebServlet("webapp/contact")
public class contactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contactController() {
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
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		Contact contact = new Contact(0,name, email, subject, message);
		try {
			boolean  isRegistered = ContactService.regicontact(contact);
			if(isRegistered) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/login.jsp");
			}else {
				response.getWriter().write("faild sucessfull");
			}
	}catch ( IllegalArgumentException e) {
		response.getWriter().write("Error" + e.getMessage());
		// TODO: handle exception
	}  

}
}
