


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.model.DriverModel;
import com.example.service.DriverService;

/**
 * Servlet implementation class DriverLoginController
 */
@WebServlet("/jsp/driver/driverLogin")
public class DriverLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DriverService driversservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DriverLoginController() {
        super();
        this.driversservice = new DriverService();
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
        String email = request.getParameter("Email");
        String password = request.getParameter("password");

        DriverModel driverModel = driversservice.loginDdriver(email, password);
        
        if (driverModel != null) {
            HttpSession session = request.getSession();
            session.setAttribute("driverId", driverModel.getDrvId());
            session.setAttribute("fullName", driverModel.getFullName());

            response.sendRedirect("driverdashboard.jsp"); // Redirect to Dashboard
        } else {
            response.sendRedirect("dlogin.jsp?error=Invalid email or password");
        }
    }
	
	
	
	
	
	
}
