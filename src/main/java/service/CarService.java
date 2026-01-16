package service;

import db.DB;
import model.Car;
import model.CarStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarService {

    private Connection connection = DB.getInstance().getConnection();

    public void addCar(Car car) {
        String sql = "INSERT INTO Car (brand, model, year, dailyRate, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, car.getBrand());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setString(3, car.getYear());
            preparedStatement.setString(4, String.valueOf(car.getDailyRate()));
            preparedStatement.setString(5, car.getStatus().name());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCar(int id) {
        String sql = "DELETE FROM Car WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCar(Car car) {
        String sql = "UPDATE Car SET  brand= ?, model=?, year=?, dailyRate=?, status=? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, car.getBrand());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setString(3, car.getYear());
            preparedStatement.setString(4, String.valueOf(car.getDailyRate()));
            preparedStatement.setString(5, car.getStatus().name());
            preparedStatement.setInt(6, car.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Car getCarById(int id) {
        String sql = "SELECT * FROM Car WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setBrand(resultSet.getString("brand"));
                car.setModel(resultSet.getString("model"));
                car.setYear(resultSet.getString("year"));
                car.setDailyRate(resultSet.getDouble("dailyRate"));
                String status = resultSet.getString("status");
                car.setStatus(CarStatus.valueOf(status));
                return car;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM Car";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setBrand(resultSet.getString("brand"));
                car.setModel(resultSet.getString("model"));
                car.setYear(resultSet.getString("year"));
                car.setDailyRate(resultSet.getDouble("dailyRate"));
                car.setStatus(CarStatus.valueOf(resultSet.getString("status")));
                cars.add(car);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cars;


    }
}


