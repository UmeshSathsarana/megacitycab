
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.model.Customer;
import com.example.model.DriverModel;
import com.example.service.CustomerService;

/**
 * Servlet implementation class CustomerLoginController
 */
@WebServlet("/jsp/customerLogin")
public class CustomerLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService customerService;
	
	
	public void init() throws ServletException {
        this.customerService = new CustomerService();
    }

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
    


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Email = request.getParameter("email");
        String Password = request.getParameter("password");

        Customer customer = customerService.loginCustomer(Email, Password);
        if (customer != null) {
        	HttpSession session = request.getSession();
        	session.setAttribute("cusId", customer.getCusID());
        	session.setAttribute("fullName", customer.getFullName());
        	
        	response.sendRedirect("customerdashbord.jsp");
        }else {
        	response.sendRedirect("login.jsp?=Invalid email or password");
        }
        }
	}


