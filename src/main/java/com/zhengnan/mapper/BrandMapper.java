package com.zhengnan.mapper;

import com.zhengnan.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface BrandMapper {
    List<Brand> selectAll();

    int addOne(Brand brand);

    Brand selectById(int id);

    int updateBrand(Brand brand);

    int deleteBrand(Integer id);

    int deleteBrandByIds(@Param("ids") int[] ids);

    List<Brand> selectByConditions(
            @Param("status") Integer status,
            @Param("companyName") String companyName,
            @Param("brandName") String brandName
    );

    List<Brand> search(
            @Param("status") Integer status,
            @Param("companyName") String companyName,
            @Param("brandName") String brandName,
            @Param("start") Integer start,
            @Param("pageSize") Integer pageSize
    );

    int brandsCount(
            @Param("status") Integer status,
            @Param("companyName") String companyName,
            @Param("brandName") String brandName
    );
}
