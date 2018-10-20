package controller;

import dao.UserDao;
import model.RoleTypeEnum;
import model.User;
import model.UserInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

/**
 * Created by xzinoviou
 * 13/10/2018
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UserDao userDao;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String emailInput = request.getParameter("user");

        String passwordInput = request.getParameter("password");

        request.setAttribute("userID",emailInput);
        request.setAttribute("passwordID",passwordInput);




        userDao = new UserDao();

        User user = (User) userDao.getEntityByParams(emailInput,passwordInput);

        if(user != null){

            /**
             * create the session
             */

            UserInfo userInfo = new UserInfo();
            userInfo.setUser(user);
            userInfo.setRole(RoleTypeEnum.valueOf((String) userDao.getUserRole(user)));
            HttpSession session = request.getSession();

            String loginStatus = "Success!";
            request.setAttribute("loginStatus",loginStatus);



            /**
             * set user of session
             */
            session.setAttribute("userInfo",userInfo);

            /**
             * session interval const * secs
             */
            session.setMaxInactiveInterval(20*60);

            /**
             * create the cookie
             */

            String uuid = UUID.randomUUID().toString();
            Cookie userCookie = new Cookie("uuid",uuid);
            userCookie.setMaxAge(20*60);

            response.addCookie(userCookie);
            response.sendRedirect("/menu.jsp");

        }

        else{

            RequestDispatcher requestDispatcher = getServletContext()
                    .getRequestDispatcher("/login.jsp");

            String loginStatus = "Wrong credentials";

            request.setAttribute("loginStatus",loginStatus);

            requestDispatcher.include(request,response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private String getToken(String name,String password){
        String auth = name+":"+password;
        return "Basic "+ Base64.getEncoder().encode(auth.getBytes());
    }

    private boolean sanitizeData(String value){
        return false;
    }
}
