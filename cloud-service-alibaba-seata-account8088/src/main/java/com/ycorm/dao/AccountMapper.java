package com.ycorm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ycorm.entity.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;

/**
 * @Author: wujianmin
 * @Date: 2020/3/26 11:54
 * @Function:
 * @Version 1.0
 */

public interface AccountMapper  extends BaseMapper<Account> {

    @Update("update t_account set residue = residue- #{money},used = used + #{money}\n" +
            "   where user_id =#{userId}; ")
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
