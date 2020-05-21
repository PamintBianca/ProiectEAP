package repositories;

import models.User;
import utils.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public static void save(User user) throws SQLException {
        String sql = "INSERT INTO user(iduser, email, parola, nume, prenume) VALUES(?, ?,? ,?,?)";
        PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, count()+1);
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setString(3, user.getParola());
        preparedStatement.setString(4, user.getNume());
        preparedStatement.setString(5, user.getPrenume());
        preparedStatement.execute();
    }

    public static int count() throws  SQLException {
        Statement statement = DbConnection.getConnection().createStatement();
        String sql = "SELECT * FROM user";
        ResultSet resultSet = statement.executeQuery(sql);
        int count = 0;
        while (resultSet.next()) count++;
        return count;
    }

    public static List<User> findByEmailandPass(String email,String password ) throws SQLException {
        Statement statement = DbConnection.getConnection().createStatement();
        String sql = "SELECT * FROM user WHERE email = '" + email + "' and parola='"+password+"'";

        ResultSet resultSet = statement.executeQuery(sql);

        List<User> users = new ArrayList<>();

        while (resultSet.next()) {
            User user = new User(
                    resultSet.getInt("iduser"),
                    resultSet.getString("email"),
                    resultSet.getString("parola"),
                    resultSet.getString("nume"),
                    resultSet.getString("prenume")
            );
            users.add(user);
        }

        return users;
    }
}
