package repositories;

import models.Company;
import models.User;
import utils.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompanyRepository {

    public static void save(Company company) throws SQLException {
        String sql = "INSERT INTO company(idcompany, email, parola, nume) VALUES(?, ?,? ,?)";
        PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, company.getIdcompany());
        preparedStatement.setString(2, company.getEmail());
        preparedStatement.setString(3, company.getParola());
        preparedStatement.setString(4, company.getNume());
        preparedStatement.execute();
    }

    public static List<Company> findByEmailandPass(String email, String password ) throws SQLException {
        Statement statement = DbConnection.getConnection().createStatement();
        String sql = "SELECT * FROM company WHERE email = '" + email + "' and parola='"+password+"'";

        ResultSet resultSet = statement.executeQuery(sql);

        List<Company> companies = new ArrayList<>();

        while (resultSet.next()) {
            Company c = new Company(
                    resultSet.getInt("iduser"),
                    resultSet.getString("email"),
                    resultSet.getString("parola"),
                    resultSet.getString("nume")

            );
            companies.add(c);
        }

        return companies;
    }
}
