

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.service.DriverService;
import com.example.model.DriverModel;
/**
 * Servlet implementation class DriverController1
 */
@WebServlet("/jsp/driver/driverReg")
public class DriverController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DriverController1() {
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

		    String fullName= request.getParameter("fullName");
	        String address= request.getParameter("address");
	        String phoneNumber= request.getParameter("phoneNumber");
	        String Email= request.getParameter("Email");
	        String nicNumber= request.getParameter("nicNumber");
	        String licNumber= request.getParameter("licNumber");
	        String image= request.getParameter("image");
	        String password = request.getParameter("password");
	        String status =request.getParameter("status");
	        

	        DriverModel driver = new DriverModel(0, fullName, address, phoneNumber, Email, nicNumber, licNumber, image, password, status);
	        try {
	            boolean isRegistered = DriverService.regiDriver(driver);
	            if (isRegistered) {
	                response.getWriter().write("Registration Successful");
	            } else {
	                response.getWriter().write("Registration Failed");
	            }
	        } catch (IllegalArgumentException e) {
	            response.getWriter().write("Error: " + e.getMessage());
	        }
	    }
	}
	
