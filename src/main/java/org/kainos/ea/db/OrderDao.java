package org.kainos.ea.db;

import org.kainos.ea.cli.Order;
import org.kainos.ea.cli.OrderRequest;
import org.kainos.ea.cli.ProductRequest;
import org.kainos.ea.client.FailedToGetOrderException;
import org.kainos.ea.client.OrderDoesNotExistException;
import org.kainos.ea.client.ProductDoesNotExistException;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.sql.Connection;

import static org.kainos.ea.db.DatabaseConnector.getConnection;

public class OrderDao {

    private DatabaseConnector databaseConnector = new DatabaseConnector();

    public List<Order> getAllOrders() throws SQLException {
        Connection c = databaseConnector.getConnection();

        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT OrderID, CustomerID, OrderDate from `Order`");

        List<Order> orderList = new ArrayList<>();

        while (rs.next()) {
            Order order = new Order(
                    rs.getInt("OrderID"),
                    rs.getInt("CustomerID"),
                    rs.getDate("OrderDate")
            );

            orderList.add(order);
        }
        return orderList;

    }

    public Order getOrderById(int id) throws SQLException {
        Connection c = databaseConnector.getConnection();

        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT OrderID, CustomerID, OrderDate from `Order`");

        while (rs.next()) {
            return new Order(
                    rs.getInt("OrderID"),
                    rs.getInt("CustomerID"),
                    rs.getDate("OrderDate")
            );

        }
        return null;

    }
    public int createOrder(OrderRequest order) throws SQLException{
        Connection c = databaseConnector.getConnection();

        String sql = "INSERT INTO `Order` (CustomerID, OrderDate) VALUES (?, ?)";

        PreparedStatement st = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        st.setInt(1, order.getCustomerId());
        st.setDate(2, new java.sql.Date(order.getOrderDate().getTime()));


        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if (rs.next()){
            return rs.getInt(1);

        }
        return -1;
    }
}


