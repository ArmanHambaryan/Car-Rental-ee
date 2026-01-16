package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Rental;
import service.RentalService;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/rentals")
public class RentalsServelt extends HttpServlet {
    private RentalService rentalService = new RentalService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Rental> rentals = rentalService.getAllRentals();
        req.setAttribute("rentals", rentals);
        req.getRequestDispatcher("/WEB-INF/rentals.jsp").forward(req, resp);

    }
}
