import com.example.model.BookingModel;
import com.example.service.BookingService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/jsp/BookingController")
public class BookingController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final BookingService bookingService = BookingService.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Integer drvId = (session != null) ? (Integer) session.getAttribute("drvId") : null;

        if (drvId == null) {
            response.sendRedirect("dlogin.jsp");
            return;
        }

        List<BookingModel> driverBookings = bookingService.getBookingsByDriverId(drvId);
        request.setAttribute("bookings", driverBookings);
        RequestDispatcher dispatcher = request.getRequestDispatcher("driverdashboard.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("addBooking".equals(action)) {
            addBooking(request, response);
        } else if ("updateStatus".equals(action)) {
            updateBookingStatus(request, response);
        }
    }

    private void addBooking(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("customerId") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            int customerId = (int) session.getAttribute("customerId");
            String pickupLocation = request.getParameter("pickupLocation");
            String dropLocation = request.getParameter("dropLocation");

            double pickupLat = Double.parseDouble(request.getParameter("pickupLat"));
            double pickupLng = Double.parseDouble(request.getParameter("pickupLng"));
            double dropLat = Double.parseDouble(request.getParameter("dropLat"));
            double dropLng = Double.parseDouble(request.getParameter("dropLng"));

            int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
            double distance = Double.parseDouble(request.getParameter("distance"));
            double price = Double.parseDouble(request.getParameter("price"));

            boolean success = bookingService.addBooking(
                    customerId, pickupLocation, dropLocation,
                    pickupLat, pickupLng, dropLat, dropLng,
                    vehicleId, distance, price, "Pending"
            );

            if (success) {
                response.sendRedirect("customerdashboard.jsp?message=Booking successful");
            } else {
                response.sendRedirect("customerdashboard.jsp?error=Booking failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("customerdashboard.jsp?error=An error occurred");
        }
    }

    private void updateBookingStatus(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("drvId") == null) {
            response.sendRedirect("dlogin.jsp?error=Please login first");
            return;
        }

        try {
            int bookingId = Integer.parseInt(request.getParameter("bookingId"));
            String status = request.getParameter("status");

            boolean updated = bookingService.updateBookingStatus(bookingId, status);

            if (updated) {
                response.sendRedirect("driverdashboard.jsp?message=Status updated to " + status);
            } else {
                response.sendRedirect("driverdashboard.jsp?error=Failed to update status");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("driverdashboard.jsp?error=An error occurred");
        }
    }
}
