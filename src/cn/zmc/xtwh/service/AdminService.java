package cn.zmc.xtwh.service;

import cn.zmc.xtwh.domain.Admin;

/**
 * Created by zmc on 20:23 2019/3/31/031
 */
public interface AdminService {
    //登录
    public AdminService login(Admin admin) throws Exception;
}
