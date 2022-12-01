package data_accessing_object;

import data.Songs;
import utility.DB_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAO {

    public List<Songs> songsOfArtist(String artistName) throws SQLException, ClassNotFoundException {

        List<Songs> songsListOfArtist = new ArrayList<>();
        Connection connection = DB_connection.getConnection();
        String sql = "Select * from songs where artistName like ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,artistName + "%");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            songsListOfArtist.add(new Songs(resultSet.getInt(1),resultSet.getString(2),
                    resultSet.getDouble(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)));
        }

        return songsListOfArtist;
    }
}
