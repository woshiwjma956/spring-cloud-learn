package com.ycorm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: wujianmin
 * @Date: 2020/3/26 11:49
 * @Function:
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    private Integer money;
    private Integer used;
    private Integer residue;
}
