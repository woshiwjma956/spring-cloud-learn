package com.ycorn.service.impl;

import com.ycorn.dao.StorageDao;
import com.ycorn.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: wujianmin
 * @Date: 2020/3/26 12:01
 * @Function:
 * @Version 1.0
 */
@Service
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        storageDao.decrease(productId, count);
    }
}
