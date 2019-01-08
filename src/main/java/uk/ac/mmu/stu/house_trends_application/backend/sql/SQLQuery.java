package uk.ac.mmu.stu.house_trends_application.backend.sql;

import uk.ac.mmu.stu.house_trends_application.backend.house.model.HouseSale;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLQuery {

    private List<HouseSale> listOfHouses = new ArrayList<>();

    public void queryDataBase(String postcode){

        Connection c = null;

        try {

            c = DriverManager.getConnection("jdbc:sqlite:./database/housepricesdb.db");

            Statement statement = c.createStatement();
            String sql = "SELECT * FROM sales WHERE postcode = '"+ postcode +"'";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()) {
                System.out.println("This track is called " + rs.getString("locality"));
                listOfHouses.add(new HouseSale().setPostcode(rs.getString("postcode"))
                        .setPrice(rs.getInt("price")).setSaleDate(rs.getString("sale_date"))
                        .setCounty(rs.getString("county")).setDistrict(rs.getString("district"))
                        .setLocality(rs.getString("locality")).setStreet(rs.getString("street")));
            }

            if (!listOfHouses.isEmpty()) {

            }

            

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
