package com.yuan.demodruid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.demodruid.domain.entity.MpUser;
import com.yuan.demodruid.mapper.MpUserMapper;
import com.yuan.demodruid.service.MpUserService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuan
 * @since 2019-05-11
 */
@Service
public class MpUserServiceImpl extends ServiceImpl<MpUserMapper, MpUser> implements MpUserService {
	 @Autowired
	 private MpUserMapper userMapper;
	 
	public List<MpUser> queryUserForPage(Integer current, Integer size){
        IPage<MpUser> userPage = new Page<>(current, size);//参数一是当前页，参数二是每页个数
        userPage = userMapper.selectPage(userPage, null);
        return userPage.getRecords();
    }
}
