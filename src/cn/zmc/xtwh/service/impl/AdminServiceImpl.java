package cn.zmc.xtwh.service.impl;

import cn.zmc.xtwh.dao.AdminDao;
import cn.zmc.xtwh.dao.impl.AdminDaolmpl;
import cn.zmc.xtwh.domain.Admin;
import cn.zmc.xtwh.service.AdminService;
import cn.zmc.xtwh.utils.PasswordUtils;

/**
 * Created by zmc on 20:22 2019/3/31/031
 */
public class AdminServiceImpl implements AdminService {

    private AdminDao dao = new AdminDaolmpl();
    @Override
    public AdminService login(Admin admin) throws Exception {
        //此处加密
//        String pwd = PasswordUtils.
        return null;
    }
}
