package com.zhuiyi.demo.studyTest.jdbc;

import java.sql.*;
import java.util.Scanner;

/** JDBC连接
 * @author by niYongJian
 * @Date 2022-07-26 20:29
 */
public class JDBCTest {
    public static void main(String[] args) throws Exception {
        //注册驱动 [加载com.mysql.jdbc.DriverJVM中]
            //升级后的mysql驱动类，Driver位置由com.mysql.jdbc.Driver 变为com.mysql.cj.jdbc.Drive
        Class.forName("com.mysql.cj.jdbc.Driver");
        //连接数据库
        String url="jdbc:mysql://localhost:3306/demo";
        String userName="root";
        String password="ok";
        Connection connection=DriverManager.getConnection(url,userName,password);
        //获取执行sql语句的对象
        Statement sql = connection.createStatement();
        String insert = "insert into TestData() value('5','5','5','5','5','5')";
        String delete = "delete from TestData where column1 = '5' ";
        System.out.println("输入查询条件：");
        Scanner scanner=new Scanner(System.in);
        String param=scanner.nextLine();
        String select = "select * from TestData where column1 = '" + param+"'";

        String selectfangzhuru = "select * from TestData where column1 = ?"; //防注入
        PreparedStatement preparedStatement=connection.prepareStatement(selectfangzhuru);
        preparedStatement.setString(1,"6");
//        long row=sql.executeLargeUpdate(insert);
//        long row=sql.executeLargeUpdate(delete);
//        System.out.println("执行成功："+ row +"记录");

        ResultSet resultSet = sql.executeQuery(select);
        ResultSet resultSetFangZhuRu = preparedStatement.executeQuery(); //防注入
        if(resultSetFangZhuRu.next()) {
            System.out.println("column1:" + resultSet.getString(1) + "\n" +
                    "column2:" + resultSet.getString(2) + "\n" +
                    "column3:" + resultSet.getString(3) + "\n" +
                    "column4:" + resultSet.getString(4) + "\n" +
                    "column5:" + resultSet.getString(5) + "\n" +
                    "column6:" + resultSet.getString(6) + "\n");
        }else {
            System.out.println("未查询到相关数据！");
        }
        resultSet.close();
        sql.close();
        connection.close();

    }
}
