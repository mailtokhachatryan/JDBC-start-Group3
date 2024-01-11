package controller.filter;

import util.constants.Massage;
import util.constants.Parameter;
import util.constants.Path;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        if (req.getSession().getAttribute(Parameter.ID) == null) {
            req.setAttribute(Parameter.MESSAGE, Massage.LOGIN_FIRST);
            req.getRequestDispatcher(Path.WELCOME).forward(req, response);
        } else {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {
        System.out.println("Filter destroyed");
    }
}
