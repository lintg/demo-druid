package com.yuan.demodruid.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuan.demodruid.domain.entity.MpUser;
import com.yuan.demodruid.service.MpUserService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuan
 * @since 2019-05-11
 */
@RestController
@RequestMapping("/mp-user")
public class MpUserController {

    @Autowired
    private MpUserService mpUserService;

    /**
     * 添加一个新用户
     *
     * @author David Hong
     *
     * @return java.lang.Object
     */
    @GetMapping("/add")
    public Object post() {
        MpUser mpUser = new MpUser();
        mpUser.setUsername("yuan");
        mpUser.setAddress("广东深圳");
        mpUser.setOpenid("openid");
        mpUserService.save(mpUser);
        return "add";
    }

    /**
     * 通过id获取用户
     *
     * @author David Hong
     *
     * @param id
     * @return java.lang.Object
     */
    @GetMapping("/{id}")
    public Object get(@PathVariable Long id) {
        return mpUserService.getById(id);
    }

    /**
     * 通过id删除用户
     *
     * @author David Hong
     *
     * @param id
     * @return java.lang.Object
     */
    @GetMapping("/del/{id}")
    public Object del(@PathVariable Long id) {
        mpUserService.removeById(id);
        return "del";
    }
    
    //http://127.0.0.1:8087/demo-druid/mp-user/queryUser?current=3&size=5 
    @GetMapping("queryUser")
    public Object queryList(Integer current, Integer size) {
        return mpUserService.queryUserForPage(current, size);
    }

}
