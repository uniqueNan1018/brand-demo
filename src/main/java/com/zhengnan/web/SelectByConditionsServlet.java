package com.zhengnan.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhengnan.pojo.Brand;
import com.zhengnan.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectByConditionsServlet")
public class SelectByConditionsServlet extends HttpServlet {
    private BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        BufferedReader br = req.getReader();
        final String jsonConditions = br.readLine();
        System.out.println(jsonConditions);
        JSONObject conditions = JSONObject.parseObject(jsonConditions);
        String statusStr = conditions.getString("status");
        String companyName = conditions.getString("companyName");
        String brandName = conditions.getString("brandName");
        Integer status = Integer.parseInt(statusStr);
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        List<Brand> brands = service.selectByConditions(status, companyName, brandName);
        String s = JSON.toJSONString(brands);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
