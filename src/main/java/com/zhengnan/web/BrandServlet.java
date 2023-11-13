package com.zhengnan.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhengnan.pojo.Brand;
import com.zhengnan.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
    private BrandService service = new BrandService();

    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Brand> brands = service.selectAll();
        String s = JSON.toJSONString(brands);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(s);
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        BufferedReader br = req.getReader();
        final String jsonBrand = br.readLine();
        System.out.println(jsonBrand);
        final Brand brand = JSON.parseObject(jsonBrand, Brand.class);
        System.out.println(brand);

        int i = service.addOne(brand);
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (i > 0) {
            System.out.println("success");
            writer.write("success");
        } else {
            writer.write("追加失敗!");
        }
    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        BufferedReader br = req.getReader();
        final String jsonBrand = br.readLine();
        final Brand brand = JSON.parseObject(jsonBrand, Brand.class);
        int i = service.updateBrand(brand);
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (i > 0) {
            System.out.println("success");
            writer.write("success");
        } else {
            writer.write("更新失敗!");
        }
    }

    public void delByIds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        BufferedReader br = req.getReader();
        String idsStr = br.readLine();
        JSONObject ids = JSONObject.parseObject(idsStr);
        idsStr = ids.getString("ids");
        String[] idsStrAry = idsStr.split(",");
        int[] idsAry = new int[idsStrAry.length];
        for (int i = 0; i < idsStrAry.length; i++) {
            idsAry[i] = Integer.parseInt(idsStrAry[i]);
        }
        int i = service.deleteBrandByIds(idsAry);
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (i > 0) {
            System.out.println("success");
            writer.write("success");
        } else {
            writer.write("更新失敗!");
        }
    }

    public void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        BufferedReader br = req.getReader();
        final String jsonConditions = br.readLine();
        System.out.println(jsonConditions);
        JSONObject conditions = JSONObject.parseObject(jsonConditions);
        String statusStr = conditions.getString("status");
        String companyName = conditions.getString("companyName");
        String brandName = conditions.getString("brandName");
        String currentPageStr = conditions.getString("currentPage");
        String pageSizeStr = conditions.getString("pageSize");
        Integer status = null;
        if (statusStr != null) {
            status = Integer.parseInt(statusStr);
        }
        Integer currentPage = Integer.parseInt(currentPageStr);
        Integer pageSize = Integer.parseInt(pageSizeStr);
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";
        Integer start = (currentPage - 1) * pageSize;

        List<Brand> brands = service.search(
                status,
                companyName,
                brandName,
                start,
                pageSize
        );
        Integer count = service.brandsCount(status, companyName, brandName);
        HashMap hm = new HashMap();
        hm.put("totalCount", count);
        hm.put("brands", brands);
        String s = JSON.toJSONString(hm);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(s);
    }
}
