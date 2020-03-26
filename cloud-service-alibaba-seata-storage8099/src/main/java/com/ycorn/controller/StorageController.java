package com.ycorn.controller;

import com.ycorn.common.entity.CommonResult;
import com.ycorn.service.StorageService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wujianmin
 * @Date: 2020/3/26 12:00
 * @Function:
 * @Version 1.0
 */
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId,
                          @RequestParam("count") Integer count){
        storageService.decrease(productId,count);
        int age = 10/0;
        return CommonResult.success();
    }
}
