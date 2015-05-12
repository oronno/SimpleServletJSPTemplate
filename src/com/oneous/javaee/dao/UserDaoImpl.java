package com.oneous.javaee.dao;

import com.oneous.javaee.domain.User;
import com.oneous.javaee.jdbc.DBConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Abdullah Al Mamun Oronno
 *         Created on 5/12/15
 */
public class UserDaoImpl implements UserDao {
    private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public List<User> getUserList() {
        log.info("getUserList");
        Connection con = DBConnection.getConnection();
        String sql = "SELECT id,name,email,password FROM User";
        List<User> userList = new ArrayList<User>();

        try {
            Statement stmt = con.createStatement();
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
