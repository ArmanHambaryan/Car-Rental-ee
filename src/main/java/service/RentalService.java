package service;

import db.DB;
import model.Rental;
import model.RentalStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RentalService {


    private Connection connection = DB.getInstance().getConnection();

    public void addRental(Rental rental) {
        String sql = "INSERT INTO Rental(carid, customerid, startdate, enddate, totalcost, statusRental) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, rental.getCarId());
            preparedStatement.setInt(2, rental.getCustomerId());
            preparedStatement.setString(3, rental.getStartDate());
            preparedStatement.setString(4, rental.getEndDate());
            preparedStatement.setDouble(5, rental.getTotalCost());
            preparedStatement.setString(6, rental.getStatus().name());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteRental(int id) {
        String sql = "DELETE FROM Rental WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ChangeRental(Rental rental) {
        String sql = "UPDATE Rental SET carid = ?, customerid = ?,  startdate = ?, enddate = ?, totalcost = ?, statusRental = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, rental.getCarId());
            preparedStatement.setInt(2, rental.getCustomerId());
            preparedStatement.setString(3, rental.getStartDate());
            preparedStatement.setString(4, rental.getEndDate());
            preparedStatement.setDouble(5, rental.getTotalCost());
            preparedStatement.setString(6, rental.getStatus().name());
            preparedStatement.setInt(7, rental.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Rental getRentalById(int id) {
        String sql = "SELECT * FROM Rental WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Rental rental = new Rental();
                rental.setId(resultSet.getInt("id"));
                rental.setCarId(resultSet.getInt("carid"));
                rental.setCustomerId(resultSet.getInt("customerid"));
                rental.setStartDate(resultSet.getString("startdate"));
                rental.setEndDate(resultSet.getString("enddate"));
                rental.setTotalCost(resultSet.getDouble("totalcost"));
                String status = resultSet.getString("statusRental");
                rental.setStatus(RentalStatus.valueOf(status));
                return rental;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Rental> getAllRentals() {
        String sql = "SELECT * FROM Rental";
        List<Rental> rentals = new ArrayList<>();
        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Rental rental = new Rental();
                rental.setId(resultSet.getInt("id"));
                rental.setCarId(resultSet.getInt("carid"));
                rental.setCustomerId(resultSet.getInt("customerid"));
                rental.setStartDate(resultSet.getString("startdate"));
                rental.setEndDate(resultSet.getString("enddate"));
                rental.setTotalCost(resultSet.getDouble("totalcost"));
                rental.setStatus(RentalStatus.valueOf(resultSet.getString("statusRental")));
                rentals.add(rental);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return rentals;
    }


}
