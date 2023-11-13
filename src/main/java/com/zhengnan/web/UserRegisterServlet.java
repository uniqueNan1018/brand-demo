package com.zhengnan.web;

import com.zhengnan.pojo.Brand;
import com.zhengnan.pojo.User;
import com.zhengnan.service.BrandService;
import com.zhengnan.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import static com.zhengnan.util.FieldDecodeUtils.*;

@WebServlet("/userRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = decode(req.getParameter("username"));
        String password = decode(req.getParameter("password"));
        String gender = decode(req.getParameter("gender"));
        String addr = decode(req.getParameter("addr"));
        String checkCode = decode(req.getParameter("checkCode"));

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setGender(gender);
        user.setAddr(addr);

        /**
         * checkCode 認証
         * */
        HttpSession session = req.getSession();
        Object _checkCode = session.getAttribute("checkCode");
        System.out.println(_checkCode);
        if (!_checkCode.toString().equals(checkCode)) {
            req.setAttribute("errMsg", "認証コードが間違いました！");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        } else {
            if (!service.checkDuplicate(username)) {
                req.setAttribute("errMsg", "ユーザーネームが既に存在しています！");
            } else {
                Integer register = service.register(user);
                if (register > 0) {
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                } else {
                    req.setAttribute("errMsg", "エラーです");
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

