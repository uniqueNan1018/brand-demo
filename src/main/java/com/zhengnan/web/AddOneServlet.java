package com.zhengnan.web;

import com.alibaba.fastjson.JSON;
import com.zhengnan.pojo.Brand;
import com.zhengnan.service.BrandService;
import com.zhengnan.util.FieldDecodeUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import static com.zhengnan.util.FieldDecodeUtils.*;

@WebServlet("/addOneServlet")
public class AddOneServlet extends HttpServlet {
    private BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("addOneServlet...");

        req.setCharacterEncoding("utf-8");
        BufferedReader br = req.getReader();
        final String jsonBrand = br.readLine();
        System.out.println(jsonBrand);
        final Brand brand = JSON.parseObject(jsonBrand, Brand.class);
        System.out.println(brand);
//        String brandName = decode(req.getParameter("brandName"));
//        String companyName = decode(req.getParameter("companyName"));
//        Integer ordered = Integer.parseInt(decode(req.getParameter("ordered")));
//        String description = decode(req.getParameter("description"));
//        Integer status = Integer.parseInt(decode(req.getParameter("status")));
//
//        Brand brand = new Brand();
//        brand.setBrandName(brandName);
//        brand.setCompanyName(companyName);
//        brand.setOrdered(ordered);
//        brand.setDescription(description);
//        brand.setStatus(status);


        int i = service.addOne(brand);
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
//
        if (i > 0) {
            System.out.println("success");
            writer.write("success");
        } else {
            writer.write("追加失敗!");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
