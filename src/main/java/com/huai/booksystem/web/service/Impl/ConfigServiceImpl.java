package com.huai.booksystem.web.service.Impl;

import com.huai.booksystem.web.dao.ConfigDao;
import com.huai.booksystem.web.entity.Config;
import com.huai.booksystem.web.service.ConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Created by laiyunjing
 * @Date 2019/11/14 21:08
 * @Version
 */
@Service("configService")
public class ConfigServiceImpl implements ConfigService {
    @Resource
    private ConfigDao configDao;
    @Override
    public Config findById(Integer id) {
        return configDao.findId(id);
    }
}
