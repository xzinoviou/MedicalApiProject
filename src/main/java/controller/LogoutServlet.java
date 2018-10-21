package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by xzinoviou
 * 13/10/2018
 */
@WebServlet(name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        Cookie[] cookies = request.getCookies();

        if(cookies != null){
            for (Cookie cookie : cookies){
                if(cookie.getName().equals("JSESSIONID")){
                    System.out.println("JESSIONID = " + cookie.getValue());
                    break;
                }
            }
        }

        /**
         * invalidate the session if exists
         */
        HttpSession session = request.getSession(false);

        System.out.println("UUID = " + session.getAttribute("uuid"));

        if(session != null){

            session.removeAttribute("uuid");
            session.invalidate();

        }

        response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
        response.sendRedirect("/login.jsp");




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
