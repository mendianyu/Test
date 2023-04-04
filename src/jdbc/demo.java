package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class demo
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        String url="jdbc:mysql:///db1";
        String username="root";
        String password="Mendy030628";
        Connection conn=DriverManager.getConnection(url,username,password);
        //3.定义sql语句
        String sql="update account set money=1 where money=0";
        //4.获取执行sql的对象Statement
        Statement stmt=conn.createStatement();
        //5.执行sql
        int count=stmt.executeUpdate(sql);//执行完DML语句，受影响的行数
        //6.处理结果
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
