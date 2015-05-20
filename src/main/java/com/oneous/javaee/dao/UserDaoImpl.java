package com.oneous.javaee.dao;

import com.oneous.javaee.dbconnection.DBConnection;
import com.oneous.javaee.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements UserDao {
    public static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);


    @Override
    public List<User> getUserList() {
        Connection connection = DBConnection.getDatabaseConnection();
        List<User> userList = new ArrayList<User>();

        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT id,name,email,password FROM user";
            ResultSet rs = stmt.executeQuery(sql);
            log.info("after execute query");

            while (rs.next()) {
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));

                log.info("User found: {}", user.getName());
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }
}
