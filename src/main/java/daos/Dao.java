package daos;

import models.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dao implements DaoInterface<Car>{
    public Car getCarById(int id) {

        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM car WHERE id=" + id);

            if(rs.next())
            {
                extractCarFromResultSet(rs);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    private Car extractCarFromResultSet(ResultSet rs) throws SQLException {
        Car car = new Car();

        car.setId( rs.getInt("id") );
        car.setMake( rs.getString("make") );
        car.setModel( rs.getString("model") );
        car.setYear( rs.getString("year") );
        car.setColor( rs.getString("color") );
        car.setVin( rs.getString("vin") );

        return car;
    }


    public List<Car> findAll() {

        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM car");

            List<Car> carList = new ArrayList<Car>();

            while(rs.next())
            {
                Car car = extractCarFromResultSet(rs);
                carList.add(car);
            }

            return carList;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public Boolean update(Car car) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE car SET make=?, model=?, year=?, color=?, vin=? WHERE id=?");

            ps.setString(1, car.getMake());
            ps.setString(2, car.getModel());
            ps.setString(3, car.getYear());
            ps.setString(4, car.getColor());
            ps.setString(5, car.getVin());
            ps.setInt(6, car.getId());
            int i = ps.executeUpdate();

            if(i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public Boolean create(Car car) {

        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO car VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, car.getId());
            ps.setString(2, car.getMake());
            ps.setString(3, car.getModel());
            ps.setString(4, car.getYear());
            ps.setString(5, car.getColor());
            ps.setString(6, car.getVin());
            int i = ps.executeUpdate();

            if(i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public Boolean delete(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM car WHERE id=" + id);

            if(i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }


}
