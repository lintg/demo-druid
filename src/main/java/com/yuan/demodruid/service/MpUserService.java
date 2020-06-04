package com.yuan.demodruid.service;

import com.yuan.demodruid.domain.entity.MpUser;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuan
 * @since 2019-05-11 
 */
public interface MpUserService extends IService<MpUser> {
	public List<MpUser> queryUserForPage(Integer current, Integer size);
}
