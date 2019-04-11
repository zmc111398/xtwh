package cn.zmc.xtwh.dao.impl;

import cn.zmc.xtwh.dao.AdminDao;
import cn.zmc.xtwh.domain.Admin;
import cn.zmc.xtwh.utils.DSUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaolmpl implements AdminDao {
    @Override
    public Admin login(Admin admin) throws SQLException {
        //获取连接
        Connection conn = DSUtils.getConnetion();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from admin where name=? and password=? limit 1");
            //设置参数
            ps.setString(1,admin.getName());
            ps.setString(2,admin.getPassword());
            //执行sql
            rs = ps.executeQuery();
            if (rs.next()){
                admin.setId(rs.getInt("id"));
                admin.setLimits(rs.getInt("limit"));
            }else {
                admin = null;
            }
        }finally {
            try {
                rs.close();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
            try {
                ps.close();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
            try {
                conn.close();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
        return admin;
    }
    @Test
    public void test1() throws Exception{
        Admin admin = new Admin(0,"admin","1234",0);
        AdminDao dao = new AdminDaolmpl();
        admin = dao.login(admin);
        System.out.println(admin);
    }
}
