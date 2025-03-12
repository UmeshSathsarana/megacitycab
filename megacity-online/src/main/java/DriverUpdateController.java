import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.example.model.DriverModel;
import com.example.service.DriverService;
import java.nio.file.Paths;
import java.io.File;

@WebServlet("/updateDriver")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
                 maxFileSize = 1024 * 1024 * 10,      // 10MB
                 maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class DriverUpdateController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DriverService driverService;

    public DriverUpdateController() {
        super();
        this.driverService = DriverService.getInstance();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int drvId = Integer.parseInt(request.getParameter("drvId"));
            String fullName = request.getParameter("fullName");
            String address = request.getParameter("address");
            String phoneNumber = request.getParameter("phoneNumber");
            String Email = request.getParameter("email");
            String nicNumber = request.getParameter("nicNumber");
            String licNumber = request.getParameter("licNumber");
            String password = request.getParameter("password");
            String status = request.getParameter("status");

            Part filePart = request.getPart("image");
            String imagePath = null;
            if (filePart != null && filePart.getSize() > 0) {
                imagePath = "uploads/" + filePart.getSubmittedFileName();
                filePart.write(getServletContext().getRealPath("/") + imagePath);
            }
            
            DriverModel updatedDriver = new DriverModel(drvId, fullName, address, phoneNumber, Email, nicNumber, licNumber, imagePath, password, status);
            boolean isUpdated = driverService.updateDriver(updatedDriver);

            if (isUpdated) {
                response.sendRedirect("viewDetails.jsp?drvId=" + drvId + "&success=Profile updated successfully");
            } else {
                response.sendRedirect("driverEdit.jsp?drvId=" + drvId + "&error=Failed to update profile");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("driverEdit.jsp?error=An error occurred while updating profile");
        }
    }
}
