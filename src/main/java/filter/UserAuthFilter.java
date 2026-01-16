package filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;
//
//@WebFilter(urlPatterns = {"/cars", "/rentals", "/customers", "/addcar", "/addental", "/addcustomer"})
//public class UserAuthFilter {
//
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        if (servletRequest instanceof HttpServletRequest request) {
//            User user = (User) request.getSession().getAttribute("user");
//            if (user != null) {
//                filterChain.doFilter(servletRequest, servletResponse);
//            } else {
//                ((HttpServletResponse) servletResponse).sendRedirect("/home");
//            }
//        }
//    }
//}
