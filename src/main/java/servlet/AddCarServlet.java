package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.Car;
import model.CarStatus;
import service.CarService;

import java.io.IOException;

@WebServlet(value = "/addcar")
@MultipartConfig(maxFileSize = 50 * 1024 * 1024, maxRequestSize = 100 * 1024 * 1024, fileSizeThreshold = 1024 * 1024)
public class AddCarServlet extends HttpServlet {
    private CarService carService = new CarService();
    private static final String IMAGE_UPLOAD_PATH = "/Users/armanhambaryan/IdeaProjects/JavaCore/Car-Rental-ee/upload-images/";

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

        Part pic = req.getPart("pic");
        String pictureName = System.currentTimeMillis() + "_" + pic.getSubmittedFileName();
        pic.write(IMAGE_UPLOAD_PATH + pictureName);


        Car car = new Car();
        car.setBrand(carBrand);
        car.setModel(carModel);
        car.setYear(carYear);
        car.setDailyRate(carDailyRate);
        car.setStatus(carStatus);
        car.setPictureName(pictureName);
        carService.addCar(car);
        resp.sendRedirect("/cars");
    }
}
