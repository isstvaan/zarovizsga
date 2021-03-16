package hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {
    DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country) {
        country = country.toUpperCase();

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("SELECT LOWER(`name`) AS dog_names FROM dog_types WHERE country =? ORDER BY `name`")
        ) {
            stmt.setString(1, country);
            return getDogsFromStatement(stmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot select dogs", se);
        }
    }

    private List<String> getDogsFromStatement(PreparedStatement stmt) throws SQLException {
        List<String> dogs = new ArrayList<>();

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                dogs.add(rs.getString("dog_names"));
            }
        }
        return dogs;
    }
}
