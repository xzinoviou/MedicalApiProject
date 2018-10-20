package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by xzinoviou
 * 13/10/2018
 */
@WebFilter(filterName = "RequestLoggingFilter")
public class RequestLoggingFilter implements Filter {

    private ServletContext servletContext;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req1 = (HttpServletRequest) req;

        Enumeration<String> params = req.getParameterNames();

        while(params.hasMoreElements()){
            String name = params.nextElement();

            String value = req.getParameter(name);

            this.servletContext.log(req1.getRemoteAddr() + "::Request " +
                    "Params::{" + name + " = " + value+"}");
        }

        Cookie[] cookies = req1.getCookies();

        if(cookies != null){
            for(Cookie cookie : cookies){
                this.servletContext.log(req.getRemoteAddr() + "::Cookie:: {" + cookie.getName() +
                        " , " + cookie.getValue() + "}");
            }
        }


        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

        this.servletContext = config.getServletContext();

        this.servletContext.log("RequestLoggingFilter initialized");
    }

}
