package cn.zmc.xtwh.dao;

import cn.zmc.xtwh.domain.Admin;

import java.sql.SQLException;

public interface AdminDao {
    //登录
    public Admin login(Admin admin) throws SQLException;
}
