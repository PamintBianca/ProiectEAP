package repositories;

import models.Bike;
import models.History;
import utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryRepository {

    public static void save(History history) throws SQLException {
        String sql = "INSERT INTO history (idbike, iduser, datastart,datastop) VALUES(?, ?,?, ? )";
        PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, history.getIdbike());
        preparedStatement.setInt(2, history.getIduser());
        preparedStatement.setDate(3, (Date) history.getDatastart());
        preparedStatement.setDate(4, (Date) history.getDatastop());

        preparedStatement.execute();
    }

    public static List<History> findAll() throws SQLException {
        Statement statement = DbConnection.getConnection().createStatement();
        String sql = "SELECT * FROM history ";

        ResultSet resultSet = statement.executeQuery(sql);

        List<History> histories = new ArrayList<>();

        while (resultSet.next()) {
            History h = new History(
                    resultSet.getInt("iduser"),
                    resultSet.getInt("idbike"),
                    resultSet.getDate("datastart"),
                    resultSet.getDate("datastop")


            );
            histories.add(h);
        }

        return histories;
    }
}
