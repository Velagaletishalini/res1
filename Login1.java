import java.sql.*;
class Login1
{
public static void main(String args[])
{
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
Statement stmt=con.createStatement();
String sql="create table StudentC5(Username varchar2(20) NOT NULL,Password varchar2(20))";
stmt.executeUpdate(sql);
System.out.println("Table created");
con.close();
}
catch(Exception e)
{
System.out.println(e);
}
}
}