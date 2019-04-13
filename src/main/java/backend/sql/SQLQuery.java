package backend.sql;

import backend.converter.Converter;
import backend.house.model.HouseSale;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLQuery {

    private String pathToDatabase;

    public SQLQuery(String pathToDatabase){
        this.pathToDatabase = pathToDatabase;
    }

    public List<HouseSale> queryDataBase(String postcode){

        Connection c = null;

        List<HouseSale> listOfHouses = new ArrayList<>();

        try {

            c = DriverManager.getConnection("jdbc:sqlite:" + pathToDatabase);

            Statement statement = c.createStatement();
            String sql = "SELECT * FROM sales WHERE postcode LIKE '"+ postcode + "%'";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()) {
                listOfHouses.add(new HouseSale().setPostcode(rs.getString("postcode"))
                        .setPrice(rs.getInt("price")).setSaleDate(rs.getString("sale_date"))
                        .setCounty(rs.getString("county")).setDistrict(rs.getString("district"))
                        .setLocality(rs.getString("locality")).setStreet(rs.getString("street"))
                        .setTown(rs.getString("town")));
            }

            Object[][] toReturn = new Object[0][];

            Converter converter = new Converter();

            toReturn = converter.convertToObjectArray(listOfHouses);

            return listOfHouses;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();

    }

}
