package com.zhou.business.util;

import java.sql.*;

        import java.io.InputStream;
        import java.sql.*;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/2 9:37
 */
public class SybaseConnectionUtil {


    /**
     * @Title: getConnSybase
     * @Description:
     * @param
     * @return
     * @return Connection
     * @throws
     */
//    public static Connection getConnSybase() {
//        try {
//            Connection conn;
////            InputStream path =Thread.currentThread().getContextClassLoader().getResourceAsStream("analysis.properties");
////            config.clear();
////            config.load(path);
////            String url = config.getProperty("jdbc.url").toString();
////            String username = config.getProperty("jdbc.username").toString();
////            String password = config.getProperty("jdbc.password").toString();
////            String drvier = config.getProperty("jdbc.driver").toString();
//            Class.forName("com.sybase.jdbc4.jdbc.SybDriver").newInstance();
//            conn = DriverManager.getConnection("192.168.100.203","userfk","userfk_ds2019");
//            return conn;
//        } catch (Exception e) {
//            return null;
//        }
//    }


    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
//            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance(); // 通过jtds方式连接
//            String url = "jdbc:jtds:sybase://192.168.100.203:5000/warehouse_sfd";// 通过jtds方式连接，test为数据库名

            Class.forName("com.sybase.jdbc3.jdbc.SybDriver").newInstance();//通过jdbc方式连接
            String url ="jdbc:sybase:Tds:192.168.100.203:5000/warehouse_sfd";//通过jdbc方式连接,test为数据库名

            conn = DriverManager.getConnection(url, "userfk", "userfk_ds2019");
            stmt = conn.createStatement();
            String sql = "select * from order_head_ds";
            rs = stmt.executeQuery(sql);
            int i=1;
            while (rs.next()) {
                System.out.println("(" + i++ + ")" + "OrderId:" + rs.getString("OrderId"));
            }
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                rs = null;
            }
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                stmt = null;
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                conn = null;
            }
        }
    }

}
