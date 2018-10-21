package filter;

import common.UriEnum;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzinoviou
 * 13/10/2018
 */
@WebFilter(filterName = "AuthenticationFilter")
public class AuthenticationFilter implements Filter {

    private ServletContext servletContext;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest requestUser = (HttpServletRequest) req;

        HttpServletResponse responseUser = (HttpServletResponse) resp;

        String uri = requestUser.getRequestURI();

        this.servletContext.log("Requested Resource::"+uri);

        HttpSession httpSession = requestUser.getSession(false);

        /*
        if(httpSession == null && !(uri.endsWith(".jsp") || uri.endsWith("LoginServlet"))){
            this.servletContext.log("Unauthorized Access request");
            responseUser.sendRedirect("login.jsp");
        }
        */

        List<UriEnum> uris = new ArrayList<>();

        for(UriEnum u : UriEnum.values())
            uris.add(u);

        if(httpSession == null && (!uri.endsWith("/login.jsp") || (uri.startsWith("LoginServlet")) )){
            this.servletContext.log("Unauthorized Access request");
            responseUser.sendRedirect("/login.jsp");
        }


        else{
            chain.doFilter(req, resp);
        }


    }

    public void init(FilterConfig config) throws ServletException {

        this.servletContext = config.getServletContext();

        this.servletContext.log("Authentication initialized");
    }

}
