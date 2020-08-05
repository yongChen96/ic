package com.example.icsecurity.config.mybatisplus.superclass;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: BaseController
 * @Description: Controller父类
 * @Author: yongchen
 * @Date: 2020/8/5 14:14
 **/
public abstract class BaseController {

    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;
    String PAGE_NO = "pageNo";
    String PAGE_SIZE = "pageSize";
    String PAGE_ASCS = "ascs";
    String PAGE_DESCS = "descs";
    String SEARCH_COUNT = "searchCount";
    int DEFAULT_LIMIT = 20;
    int MAX_LIMIT = 100;

    public BaseController() {}



}
