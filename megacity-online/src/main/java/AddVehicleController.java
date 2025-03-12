

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.model.VehicleModel;
import com.example.service.VehicleService;

/**
 * Servlet implementation class AddVehicleController
 */
@WebServlet("/jsp/driver/AddVehicle")
public class AddVehicleController extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Integer drvId = (session != null && session.getAttribute("driverId") != null) 
        	    ? (Integer) session.getAttribute("driverId") : null;


        if (drvId == null) {
            response.sendRedirect("dlogin.jsp");
            return;
        }

        String vehiclenumber = request.getParameter("vehiclenumber");
        String model = request.getParameter("model");
        String type = request.getParameter("type");
        String seatingcapacity = request.getParameter("seatingcapacity");
        String vtype = request.getParameter("vtype");
        String pricePerKmStr = request.getParameter("pricePerKm");

        double pricePerKm = 0.0;
        try {
            pricePerKm = Double.parseDouble(pricePerKmStr);
        } catch (NumberFormatException e) {
            response.sendRedirect("addVehicle.jsp?error=Invalid Price per KM");
            return;
        }

        VehicleModel vehicle = new VehicleModel(0, drvId, vehiclenumber, model, type, seatingcapacity, vtype, pricePerKm);
        boolean isAdded = VehicleService.registerVehicle(vehicle);

        if (isAdded) {
            response.sendRedirect("viewDetails.jsp");
        } else {
            response.sendRedirect("addVehicle.jsp?error=Failed to Add Vehicle");
        }
    }
}
