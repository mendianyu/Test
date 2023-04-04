package jdbc;

import org.junit.Test;
import pojo.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class demo6_UserLogin
{
    /**
     *DML
     * @throws Exception
     */
    @Test
    public  void testResultSet() throws Exception
    {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql:///db1";
        String username = "root";
        String password = "Mendy030628";
        Connection conn = DriverManager.getConnection(url, username, password);
        //接收用户输入 用户名和密码
        String name = "zhangsan";
        String pwd = "123";
        String sql = "select *from tb_user where username='" + name + "' and password='" + pwd + "' ";
        //获取Statement对象
        Statement stmt = conn.createStatement();
        //执行sql
        ResultSet rs = stmt.executeQuery(sql);
        //判断是否成功登录
        if (rs.next())
        {
            System.out.println("登录成功");
        } else
        {
            System.out.println("登录失败");
        }
        //7.释放资源
        stmt.close();
        conn.close();
        rs.close();
    }



}
