import java.sql.*;
class DBTable1
{
public static void main(String args[])
{
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
Statement stmt=con.createStatement();
String sql="create table Student11(Reg_Number varchar2(15),StudentName varchar2(20),Date_of_birth Date,Gender varchar2(10),Branch varchar2(10),Programming_languages varchar2(15),Address varchar(50))";
stmt.executeUpdate(sql);
System.out.println("Table created");
}
catch(Exception e)
{
System.out.println(e);
}
}
}