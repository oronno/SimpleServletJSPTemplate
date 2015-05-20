package com.oneous.javaee.web;

import com.oneous.javaee.dao.UserDao;
import com.oneous.javaee.dao.UserDaoImpl;
import com.oneous.javaee.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Abdullah Al Mamun Oronno
 *         Created on 5/12/15
 */
@WebServlet(name = "HomeServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    public static final Logger log = LoggerFactory.getLogger(HomeServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("get request at /login");

        UserDao userDao = new UserDaoImpl();
        List<User> userList = userDao.getUserList();

        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
    }
}
