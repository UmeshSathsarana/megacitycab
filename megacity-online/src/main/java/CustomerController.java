
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.model.Customer;
import com.example.service.CustomerService;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/jsp/customerReg")
public class CustomerController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private CustomerService customerService;
	
	
	public void init() throws ServletException{
		this.customerService = new CustomerService();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getParameter("action");

	        if (action != null) {
	            if (action.equals("view")) {
	                List<Customer> customerList = customerService.getAllCustomers();
	                HttpSession session = request.getSession();
	                session.setAttribute("customerList", customerList);
	                response.sendRedirect("jsp/customerdashbord.jsp");
	            } else if (action.equals("delete")) {
	                int id = Integer.parseInt(request.getParameter("id"));
	                boolean isDeleted = customerService.deleteCustomer(id);
	                if (isDeleted) {
	                    response.sendRedirect("customerController?action=view");
	                } else {
	                    response.getWriter().write("Failed to Delete Customer");
	                }
	            }
	        }
	    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String fullName = request.getParameter("fullName");
		String NicNumber = request.getParameter("NicNumber");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("phoneNumber");
		String Email = request.getParameter("Email");
		String Password = request.getParameter("Password");
		
		
		
		Customer customer = new Customer(0, fullName, NicNumber, address, phoneNumber, Email, Password);
		try {
			boolean isRegistered = customerService.regiCustomer(customer);
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
