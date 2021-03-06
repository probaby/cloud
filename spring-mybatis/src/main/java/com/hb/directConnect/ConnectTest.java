package com.hb.directConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectTest {

  public static void main(String[] args) {
      //数据库连接
      Connection connection = null;
      //预编译的Statement，使用预编译的Statement提高数据库性能
      PreparedStatement preparedStatement = null;
      //结果集
      ResultSet resultSet = null;

      try {
          //加载数据库驱动
          Class.forName("oracle.jdbc.driver.OracleDriver");
          //通过驱动管理类获取数据库链接
          connection =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1527:HB", "scott", "orcl");
          System.out.println("连接成功");
          //定义sql语句 ?表示占位符
          String sql = "select * from students where studentsid = ?";
          //获取预处理statement
          preparedStatement = connection.prepareStatement(sql);
          //设置参数，第一个参数为sql语句中参数的序号（从1开始），第二个参数为设置的参数值
          preparedStatement.setString(1, "1");
          //向数据库发出sql执行查询，查询出结果集
          resultSet =  preparedStatement.executeQuery();
          //遍历查询结果集
          while(resultSet.next()){
              System.out.println(resultSet.getString("studentsid")+"  "+resultSet.getString("studentsname"));
          }
      } catch (Exception e) {
          e.printStackTrace();
      }finally{
          //释放资源
          if(resultSet!=null){
              try {
                  resultSet.close();
              } catch (SQLException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
              }
          }
          if(preparedStatement!=null){
              try {
                  preparedStatement.close();
              } catch (SQLException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
              }
          }
          if(connection!=null){
              try {
                  connection.close();
              } catch (SQLException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
              }
          }

      }

  }

}
