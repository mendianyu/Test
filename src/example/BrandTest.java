package example;

import org.junit.Test;
import pojo.Brand;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mendianyu
 */ /*
* 品牌数据的增删改查
 */
public class BrandTest
{
    @Test
    //查询所有
    public void testSelectAll() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        String url="jdbc:mysql:///db1";
        String username="root";
        String password="Mendy030628";
        Connection conn= DriverManager.getConnection(url,username,password);
        String sql="select * from tb_brand";
        PreparedStatement pstmt=conn.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        List<Brand> brands=new ArrayList<>();
        while(rs.next())
        {
            int id=rs.getInt("id");
            String brandName=rs.getString("brand_name");
            String companyName=rs.getString("company_name");
            int ordered=rs.getInt("ordered");
            String description=rs.getString("description");
            int status=rs.getInt("status");
            Brand brand=new Brand();
            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setCompanyName(companyName);
            brand.setOrdered(ordered);
            brand.setDescription(description);
            brand.setStatus(status);
            brands.add(brand);

        }
        System.out.println(brands);
        rs.close();
        pstmt.close();
        conn.close();
    }
    @Test
    public void testAdd() throws ClassNotFoundException, SQLException
    {
        String brandName="香飘飘";
        String companyName="香飘飘";
        int ordered=1;
        String description="绕地球一圈";
        int status=1;
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        String url="jdbc:mysql:///db1";
        String username="root";
        String password="Mendy030628";
        Connection conn= DriverManager.getConnection(url,username,password);
        String sql="insert into tb_brand( brand_name, company_name, ordered, description, status) values(?,?,?,?,?)";
        PreparedStatement pstmt=conn.prepareStatement(sql);

        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);
        pstmt.close();
        conn.close();
    }

}
