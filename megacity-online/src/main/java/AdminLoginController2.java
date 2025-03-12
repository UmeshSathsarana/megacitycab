import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.model.Admin;
import com.example.model.DriverModel;
import com.example.service.AdminService;
import com.example.service.DriverService;

/**
 * Servlet implementation class AdminLoginController2
 */
@WebServlet("/jsp/admin/adminLogin")
public class AdminLoginController2 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminService adminService;

    public void init() throws ServletException {
        this.adminService = new AdminService();
    }

    public AdminLoginController2() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DriverModel> drivers = DriverService.getAllDrivers();
        request.setAttribute("drivers", drivers);
        request.getRequestDispatcher("viewDrivers.jsp").forward(request, response);
    }

    // Delete a Driver
    protected void deleteDriver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int drvId = Integer.parseInt(request.getParameter("drvId"));
        boolean deleted = DriverService.deleteDriver(drvId);

        if (deleted) {
            response.sendRedirect("viewDrivers.jsp?message=Driver deleted successfully");
        } else {
            response.sendRedirect("viewDrivers.jsp?error=Failed to delete driver");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Admin admin = adminService.loginAdmin(email, password);

        if (admin != null) {
            HttpSession session = request.getSession();
            session.setAttribute("email", admin);
            response.sendRedirect("admindashbord.jsp");
        } else {
            response.getWriter().write("Invalid username or password.");
        }

        String action = request.getParameter("action");

        if ("deleteDriver".equals(action)) {
            int drvId = Integer.parseInt(request.getParameter("drvId"));
            boolean deleted = DriverService.getInstance().deleteDriver(drvId);

            if (deleted) {
                response.getWriter().write("Driver deleted successfully.");
            } else {
                response.getWriter().write("Failed to delete driver.");
            }
        }
    }
}
