package repositories;

import models.Bike;
import models.Company;
import models.User;
import utils.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BikesRepository {

    public static void save(Bike bike) throws SQLException {
        String sql = "INSERT INTO bikes (idbikes, idcompany, isAvailable) VALUES(?, ?,? )";
        PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, count()+1);
        preparedStatement.setInt(2, bike.getIdcompany());
        preparedStatement.setBoolean(3, bike.isAvailable());

        preparedStatement.execute();
    }

    public static List<Bike> findAvailable() throws SQLException {
        Statement statement = DbConnection.getConnection().createStatement();
        String sql = "SELECT * FROM bikes WHERE isAvailable = 1";

        ResultSet resultSet = statement.executeQuery(sql);

        List<Bike> bikes = new ArrayList<>();

        while (resultSet.next()) {
            Bike b = new Bike(
                    resultSet.getInt("idbikes"),
                    resultSet.getInt("idcompany"),
                    resultSet.getBoolean("isAvailable")


            );
            bikes.add(b);
        }

        return bikes;
    }
    public static List<Bike> findAll() throws SQLException {
        Statement statement = DbConnection.getConnection().createStatement();
        String sql = "SELECT * FROM bikes ";

        ResultSet resultSet = statement.executeQuery(sql);

        List<Bike> bikes = new ArrayList<>();

        while (resultSet.next()) {
            Bike b = new Bike(
                    resultSet.getInt("idbikes"),
                    resultSet.getInt("idcompany"),
                    resultSet.getBoolean("isAvailable")


            );
            b.setCompanyName(CompanyRepository.findById(resultSet.getInt("idcompany")).getNume());
            bikes.add(b);
        }

        return bikes;
    }
    public static int count() throws  SQLException {
        Statement statement = DbConnection.getConnection().createStatement();
        String sql = "SELECT * FROM bikes";
        ResultSet resultSet = statement.executeQuery(sql);
        int count = 0;
        while (resultSet.next()) count++;
        return count;
    }
}
