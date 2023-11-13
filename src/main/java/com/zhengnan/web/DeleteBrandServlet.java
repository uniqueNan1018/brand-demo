package com.zhengnan.web;

import com.zhengnan.mapper.BrandMapper;
import com.zhengnan.pojo.Brand;
import com.zhengnan.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.zhengnan.util.FieldDecodeUtils.decode;

@WebServlet("/deleteBrandServlet")
public class DeleteBrandServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BrandService service = new BrandService();
        Integer id = Integer.parseInt(decode(req.getParameter("id")));
        int i = service.deleteBrand(id);
        if (i > 0) {
            resp.getWriter().write("success");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
