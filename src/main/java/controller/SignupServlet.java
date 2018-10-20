package controller;

import dao.UserDao;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by xzinoviou
 * 13/10/2018
 */
@WebServlet(name = "SignupServlet")
public class SignupServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UserDao userDao;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        userDao = new UserDao();

        StringBuilder sbFormError = new StringBuilder();


        boolean isFormFilled = true;


        String firstName = request.getParameter("firstNameIn");

        String lastName = request.getParameter("lastNameIn");

        String email = request.getParameter("emailIn");

        String password = request.getParameter("passwordIn");

        String dateStr = request.getParameter("dateIn");

        String address = request.getParameter("addressIn");

        String telephone = request.getParameter("telephoneIn");

        String role = request.getParameter("roleIn");


        if((User) userDao.getEntityByParam(email)==null){


            User user = new User();

            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPassword(password);
            Date date = Date.valueOf(dateStr);
            user.setDate(date);
            user.setAddress(address);
            user.setTelephone(telephone);

            userDao.createEntity(user);

            User createdUser = (User) userDao.getEntityByParam(email);

            userDao.assignRole(createdUser,Long.valueOf(role));

            RequestDispatcher requestDispatcher = getServletContext()
                    .getRequestDispatcher("/signup.jsp");

            String signupStatus = "User was successfully added to database";

            request.setAttribute("signupStatus",signupStatus);


            requestDispatcher.include(request,response);
            requestDispatcher.forward(request,response);
        }

        else{
            RequestDispatcher requestDispatcher = getServletContext()
                    .getRequestDispatcher("/signup.jsp");

            String signupStatus = "User with such email is already registered in database";

            request.setAttribute("signupStatus",signupStatus);

            requestDispatcher.include(request,response);

            requestDispatcher.forward(request,response);
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("signup.jsp");
            requestDispatcher.forward(request,response);
        */
    }
}
