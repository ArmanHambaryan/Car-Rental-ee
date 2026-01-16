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

@WebServlet(value = "/changerental")
public class ChangeRentalServlet extends HttpServlet {
    private RentalService rentalService = new RentalService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("rental", rentalService.getRentalById(id));
        req.getRequestDispatcher("/WEB-INF/changerental.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Rental rental = rentalService.getRentalById(id);
        int carId = Integer.parseInt(req.getParameter("carid"));
        int customerId = Integer.parseInt(req.getParameter("customerid"));
        String startDate = req.getParameter("startdate");
        String endDate = req.getParameter("enddate");
        double totalCost = Double.parseDouble(req.getParameter("totalcost"));
        RentalStatus rentalStatus = RentalStatus.valueOf(req.getParameter("statusRental"));
        rental.setCarId(carId);
        rental.setCustomerId(customerId);
        rental.setStartDate(startDate);
        rental.setEndDate(endDate);
        rental.setTotalCost(totalCost);
        rental.setStatus(rentalStatus);
        rentalService.ChangeRental(rental);

        resp.sendRedirect("/rentals");
    }
}
