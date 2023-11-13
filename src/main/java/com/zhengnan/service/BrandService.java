package com.zhengnan.service;

import com.zhengnan.mapper.BrandMapper;
import com.zhengnan.pojo.Brand;
import com.zhengnan.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Brand> selectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        sqlSession.close();
        return brands;
    }

    public int addOne(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int i = mapper.addOne(brand);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    public Brand selectById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(id);
        sqlSession.close();
        return brand;
    }

    public int updateBrand(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int i = mapper.updateBrand(brand);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    public int deleteBrand(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int i = mapper.deleteBrand(id);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    public List<Brand> selectByConditions(Integer status, String companyName, String brandName) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectByConditions(status, companyName, brandName);
        sqlSession.close();
        return brands;
    }

    public int deleteBrandByIds(int[] ids) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int i = mapper.deleteBrandByIds(ids);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    public List<Brand> search(Integer status, String companyName, String brandName, Integer start, Integer pageSize) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.search(status, companyName, brandName, start, pageSize);
        sqlSession.close();
        return brands;
    }

    public int brandsCount(Integer status, String companyName, String brandName) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int count = mapper.brandsCount(status, companyName, brandName);
        sqlSession.close();
        return count;
    }
}
