package filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;

@WebFilter(urlPatterns = {"/cars", "/rentals", "/customers", "/addcar", "/addental", "/addcustomer"})
public class UserAuthFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest request1) {
            User user = (User) request1.getSession().getAttribute("user");
            if (user != null) {
                filterChain.doFilter(request, servletResponse);
            } else {
                ((HttpServletResponse) servletResponse).sendRedirect("/home");
            }
        }
    }
}
