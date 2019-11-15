package com.huai.booksystem.init;

import com.huai.booksystem.web.entity.Config;
import com.huai.booksystem.web.service.ConfigService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 初始化加载数据
 * @Created by laiyunjing
 * @Date 2019/11/14 20:58
 * @Version
 */
@Component
public class Initsystem implements ServletContextListener, ApplicationContextAware {

    private static ApplicationContext applicationContext;



    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext =applicationContext;
    }

    public void loadData(ServletContext servletContext){
        ConfigService configService = (ConfigService) applicationContext.getBean("configService");
        Config config = configService.findById(1);
        servletContext.setAttribute("config",config);
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        loadData(sce.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
