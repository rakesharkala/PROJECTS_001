package data_accessing_object;

import data.Songs;
import utility.DB_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO {

    public List<Songs> songsOfGenre(String genreType) throws SQLException, ClassNotFoundException {

        List<Songs> songsListOfGenre = new ArrayList<>();
        Connection connection = DB_connection.getConnection();
        String sql = "Select * from songs where genreType like ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,genreType + "%");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            songsListOfGenre.add(new Songs(resultSet.getInt(1),resultSet.getString(2),
                    resultSet.getDouble(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)));
        }

        return songsListOfGenre;
    }
}
