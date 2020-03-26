package com.ycorn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

    @TableId(type = IdType.AUTO)
    private Long id;
    private Long productId;
    private Integer total;
    private Integer used;
    private Integer residue;

}