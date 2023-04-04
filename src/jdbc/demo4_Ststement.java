package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Test;
public class demo4_Ststement
{
    /**
     *DML
     * @throws Exception
     */
    @Test
    public  void testDML() throws Exception
    {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        String url="jdbc:mysql:///db1";
        String username="root";
        String password="Mendy030628";
        Connection conn=DriverManager.getConnection(url,username,password);
        //3.定义sql
        String sql="update account set money=3000 where id =1";
        //4.获取statement对象
        Statement stmt=conn.createStatement();
        //5.执行sql
        int count=stmt.executeUpdate(sql);
        //6.处理结果
       // System.out.println(count);
        if(count>0)
        {
            System.out.println("修改成功");
        }
        else
        {
            System.out.println("修改失败");
        }
        //7.释放资源
        stmt.close();
        conn.close();
    }
    /**
     *DDL
     * @throws Exception
     */
    @Test
    public  void testDDL() throws Exception
    {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        String url="jdbc:mysql:///db1";
        String username="root";
        String password="Mendy030628";
        Connection conn=DriverManager.getConnection(url,username,password);
        //3.定义sql
        String sql="create database  db2";
        //4.获取statement对象
        Statement stmt=conn.createStatement();
        //5.执行sql
        int count=stmt.executeUpdate(sql);
        //6.处理结果
        // System.out.println(count);
        if(count>0)
        {
            System.out.println("修改成功");
        }
        else
        {
            System.out.println("修改失败");
        }
        //7.释放资源
        stmt.close();
        conn.close();
    }
}
