package com.ycorn.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StorageDao {
    @Update("  update t_storage\n" +
            "        set used =used + #{count},residue=total - used \n" +
            "        where product_id=#{productId};")
    int decrease(@Param("productId") Long productId, @Param("count") Integer count);
}