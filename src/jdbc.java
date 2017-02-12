import java.sql.*;  
  
public class jdbc {  
  
   public static void main(String[] args) {  
  
      // Declare the JDBC objects.  
      Connection con = null;  
      Statement stmt = null;  
      ResultSet rs = null;  
  
      try {  
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
         con = DriverManager.getConnection("jdbc:sqlserver://localhost:53661;databaseName=master;integratedSecurity=true;");  
         String SQL = "SELECT TOP 10 * FROM employee";  
         stmt = con.createStatement();  
         rs = stmt.executeQuery(SQL);  
         while (rs.next()) {  
            System.out.print(rs.getString(1)); 
            System.out.println("  "+rs.getString(2));
         }  
      }  
    
      catch (Exception e) {  
         e.printStackTrace();  
      }  
      finally {  
         //if (rs != null) try { rs.close(); } catch(Exception e) {}  
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
         if (con != null) try { con.close(); } catch(Exception e) {}  
      }  
   }  
}  
