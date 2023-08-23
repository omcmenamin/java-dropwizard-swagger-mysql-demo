package org.kainos.ea.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDao {

    private DatabaseConnector databaseConnector = new DatabaseConnector();

//    public getCustomerById(int id) throws SQLException {
//
//        Connection c = databaseConnector.getConnection();
//
//        String sql = "SELECT CustomerID, Name, Address, Phone FROM Customer WHERE CustomerID = ?";
//
//        PreparedStatement preparedStatement = c.prepareStatement(sql);
//
//
//
//
//
//    }
}
