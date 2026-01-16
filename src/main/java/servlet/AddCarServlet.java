package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Car;
import model.CarStatus;
import service.CarService;

import java.io.IOException;

@WebServlet(value = "/addcar")
public class AddCarServlet extends HttpServlet {
    private CarService carService = new CarService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/addcar.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carBrand = req.getParameter("brand");
        String carModel = req.getParameter("model");
        String carYear = req.getParameter("year");
        double carDailyRate = Double.parseDouble(req.getParameter("dailyRate"));
        CarStatus carStatus = CarStatus.valueOf(req.getParameter("status"));

        Car car = new Car();
        car.setBrand(carBrand);
        car.setModel(carModel);
        car.setYear(carYear);
        car.setDailyRate(carDailyRate);
        car.setStatus(carStatus);
        carService.addCar(car);
        resp.sendRedirect("/cars");
    }
}
