package com.zhengnan.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ShopTest")
public class ShopTest extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF‐8");
        String goods = req.getParameter("goods");
        String numStr = req.getParameter("num");
        int num = Integer.parseInt(numStr);
        res.setContentType("text/html; charset=UTF‐8");
        PrintWriter out = res.getWriter();
        out.println("<html>");
        out.println("<head><title>ShopTest</title></head>");
        out.println("<body>");
        out.println("<p>商品：" +goods + "</p>");
        out.println("<p>個数：" +num + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
