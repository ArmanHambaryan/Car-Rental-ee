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

@WebServlet(value = "/changecar")
public class ChangeCarServlet extends HttpServlet {

    private CarService carService =  new CarService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("car",carService.getCarById(id));
        req.getRequestDispatcher("/WEB-INF/changecar.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Car car = carService.getCarById(id);

        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        String year = req.getParameter("year");
        double dailyRate = Double.parseDouble(req.getParameter("dailyRate"));
        CarStatus status = CarStatus.valueOf(req.getParameter("status"));
        car.setBrand(brand);
        car.setModel(model);
        car.setYear(year);
        car.setDailyRate(dailyRate);
        car.setStatus(status);
        carService.updateCar(car);
        resp.sendRedirect("/cars");


    }
}
