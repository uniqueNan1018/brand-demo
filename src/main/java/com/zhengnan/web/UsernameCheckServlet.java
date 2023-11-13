package com.zhengnan.web;

import com.zhengnan.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.zhengnan.util.FieldDecodeUtils.decode;

@WebServlet("/usernameCheckServlet")
public class UsernameCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = decode(req.getParameter("username"));
        UserService service = new UserService();
        if (!service.checkDuplicate(username)) {
            resp.getWriter().write("usernameError");
        } else {
            resp.getWriter().write("usernameOk");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
