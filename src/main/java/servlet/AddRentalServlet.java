package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Rental;
import model.RentalStatus;
import service.RentalService;

import java.io.IOException;

@WebServlet(value = "/addrental")
public class AddRentalServlet extends HttpServlet {
    private RentalService rentalService = new RentalService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/addrental.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int carId = Integer.parseInt(req.getParameter("carid"));
        int customerId = Integer.parseInt(req.getParameter("customerid"));
        String startDate = req.getParameter("startdate");
        String endDate = req.getParameter("enddate");
        double totalcost = Double.parseDouble(req.getParameter("totalcost"));
        RentalStatus statusRental = RentalStatus.valueOf(req.getParameter("statusRental"));
        Rental rental = new Rental();
        rental.setCarId(carId);
        rental.setCustomerId(customerId);
        rental.setStartDate(startDate);
        rental.setEndDate(endDate);
        rental.setTotalCost(totalcost);
        rental.setStatus(statusRental);
        rentalService.addRental(rental);
        resp.sendRedirect("/rentals");

    }
}
