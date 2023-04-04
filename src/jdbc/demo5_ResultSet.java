package jdbc;

import org.junit.Test;
import pojo.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class demo5_ResultSet
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
        String url="jdbc:mysql:///db1";
        String username="root";
        String password="Mendy030628";
        Connection conn=DriverManager.getConnection(url,username,password);
        //3.定义sql
        String sql="select *from account";
        //4.获取statement对象
        Statement stmt=conn.createStatement();
        //5.执行sql
        ResultSet rs=stmt.executeQuery(sql);
        //6.处理结果

        while(rs.next())
        {
            int id=rs.getInt("id");
            String name=rs.getString("name");
            int money=rs.getInt("money");
            System.out.println(id);
            System.out.println(name);
            System.out.println(money);
            System.out.println("---------------");
        }
        //7.释放资源
        stmt.close();
        conn.close();
        rs.close();
    }
    /**
     * 查询account账户表数据，封装为Account对象中，并且存储到ArrayList集合中
     * 1。定义实体类Account
     * 2。查询数据，封装到Account对象中
     * 3。将Account对象存入Arraylist集合中
     * @throws Exception
     */
    @Test
    public  void testResultSet2() throws Exception
    {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        String url="jdbc:mysql:///db1";
        String username="root";
        String password="Mendy030628";
        Connection conn=DriverManager.getConnection(url,username,password);
        //3.定义sql
        String sql="select *from account";
        //4.获取statement对象
        Statement stmt=conn.createStatement();
        //5.执行sql
        ResultSet rs=stmt.executeQuery(sql);

        List<Account> list=new ArrayList<>();
        //6.处理结果

        while(rs.next())
        {
            Account account=new Account();
            int id=rs.getInt("id");
            String name=rs.getString("name");
            int money=rs.getInt("money");

            account.setId(id);
            account.setName(name);
            account.setMoney(money);
            list.add(account);
        }
        System.out.println(list);
        //7.释放资源
        stmt.close();
        conn.close();
        rs.close();
    }

}
