package service;

import business.Util;
import dao.AddressDAO;
import entity.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressService extends Util implements AddressDAO {

    Connection connection = getConnection();

    public AddressService() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void add(Address address) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO ADDRESS (ID, COUNTRY, CITY, STREET, POST_CODE)" +
                " VALUES (?,?,?,?,?);";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, address.getId());
            preparedStatement.setString(2,address.getCountry());
            preparedStatement.setString(3,address.getCity());
            preparedStatement.setString(4,address.getStreet());
            preparedStatement.setString(5,address.getPostCode());
            preparedStatement.executeUpdate();
        }
        finally {
            if(preparedStatement != null)
                preparedStatement.close();
            connection.close();
            if(connection != null)
                connection.close();
        }
    }

    @Override
    public ArrayList<Address> getAll() throws SQLException{
        ArrayList<Address> list = new ArrayList<>();

        String sql = "SELECT * FROM ADDRESS;";

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Address address = new Address();
                address.setId(resultSet.getLong("ID"));
                address.setCountry(resultSet.getString("COUNTRY"));
                address.setCity(resultSet.getString("CITY"));
                address.setStreet(resultSet.getString("STREET"));
                address.setPostCode(resultSet.getString("POST_CODE"));
                list.add(address);
            }
        }
        finally {
            if(statement != null)
                statement.close();
            connection.close();
            if(connection != null)
                connection.close();
        }
        return list;
    }

    @Override
    public Address getById(long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM ADDRESS WHERE ID=?;";

        Address address = new Address();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery(sql);

            while (resultSet.next()){
                address.setId(resultSet.getLong("ID"));
                address.setCountry(resultSet.getString("COUNTRY"));
                address.setCity(resultSet.getString("CITY"));
                address.setStreet(resultSet.getString("STREET"));
                address.setPostCode(resultSet.getString("POST_CODE"));
            }
        }
        finally {
            if(preparedStatement != null)
                preparedStatement.close();
            connection.close();
            if(connection != null)
                connection.close();
        }
        return address;
    }

    @Override
    public void update(Address address) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE ADDRESS SET COUNTRY=?, CITY=?, STREET=?, POST_CODE=? WHERE ID=?;";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setString(4, address.getPostCode());
            preparedStatement.setLong(5, address.getId());

            preparedStatement.executeUpdate();
        }
        finally {
            if(preparedStatement != null)
                preparedStatement.close();
            connection.close();
            if(connection != null)
                connection.close();
        }
    }

    @Override
    public void remove(Address address) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM ADDRESS WHERE ID=?;";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, address.getId());

            preparedStatement.executeUpdate();
        }
        finally {
            if(preparedStatement != null)
                preparedStatement.close();
            connection.close();
            if(connection != null)
                connection.close();
        }
    }
}
