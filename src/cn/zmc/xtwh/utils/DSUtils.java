package cn.zmc.xtwh.utils;

import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DSUtils {
    public static DataSource ds;

    static {
        ds = new ComboPooledDataSource();
    }

    public static DataSource getDataSource(){
        return ds;
    }

    public static Connection getConnetion(){
        Connection conn;
        try {
            conn = ds.getConnection();
        }catch (SQLException e){
            throw new RuntimeException(e);

        }
        return conn;
    }
    @Test
    public void test() throws Exception{
        System.out.println(DSUtils.getConnetion());
    }

}
