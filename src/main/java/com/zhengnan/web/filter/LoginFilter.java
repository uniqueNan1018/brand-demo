package com.zhengnan.web.filter;

import com.zhengnan.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        String[] urls = {
                "/images/",
                "/css/",
                "login.jsp",
                "register.jsp",
                "register.html",
                "/checkCodeServlet",
                "/selectUserServlet",
                "/userRegisterServlet",
                "/ajax-demo1.html",
                "/ajaxServlet",
                "/usernameCheckServlet",
                "/vue-demo.html",
                "/element-demo"
        };
        String requestURL = String.valueOf(req.getRequestURL());
        for (String url : urls) {
            if(requestURL.contains(url)) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if (user != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            String contextPath = req.getContextPath();
            req.setAttribute("errMsg", "まだログインしていません！");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
//            resp.sendRedirect(contextPath + "/login.jsp");

        }

    }

    @Override
    public void destroy() {

    }
}
