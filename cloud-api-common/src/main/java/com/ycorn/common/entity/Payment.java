package com.ycorn.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 *
 * @author JimWu
 * @create 2020-03-14 16:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {
    private Long id;

    private String serial;

}