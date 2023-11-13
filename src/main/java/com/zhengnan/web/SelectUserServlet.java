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

@WebServlet("/selectUserServlet")
public class SelectUserServlet extends HttpServlet {
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = decode(req.getParameter("username"));
        String password = decode(req.getParameter("password"));
        String remember = req.getParameter("remember");

//        System.out.println(remember);

        User user = service.selectByUsernameAndPwd(username, password);
        if (user == null) {
            req.setAttribute("errMsg", "ユーザーネームまたはパスワードが間違いました！");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession();
//            boolean aNew = session.isNew();
            session.setAttribute("user", user);

            /**
             * username と　password 覚える
             * */
            if ("1".equals(remember)) {
//                String info = "username=" + username + "password" + password;
//                info = URLEncoder.encode(info, "UTF-8");
                Cookie c_username = new Cookie("username", URLEncoder.encode(username, "UTF-8"));
                Cookie c_password = new Cookie("password", URLEncoder.encode(password, "UTF-8"));
                c_username.setMaxAge(60 * 60 * 24);
                c_password.setMaxAge(60 * 60 * 24);
                resp.addCookie(c_username);
                resp.addCookie(c_password);
            }

            req.getRequestDispatcher("/selectAllServlet").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
