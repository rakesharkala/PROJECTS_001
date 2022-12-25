import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao
{
	private String dburl="jdbc:mysql://localhost:3306/userdb";
    private String dbname ="root";
    private String pass="7032248200@Aa";
    private String dbDriver ="com.mysql.cj.jdbc.Driver";
 
    public void loadDriver (String dbDriver)
    {
    	try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public Connection getConnection()
    {
    	Connection con =null;
    	try {
			con=DriverManager.getConnection(dburl,dbname,pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
    	
    }
    
    public String insert(Member member)
    {
    	loadDriver(dbDriver);
    	Connection con =getConnection();
    	String result="<h1>data enterd successfully</h1>";
    	String sql="insert into member values(?,?,?,?)";
    	
    	PreparedStatement ps;
		try
		{
			ps = con.prepareStatement(sql);
			ps.setString(1,member.getUname());
	    	ps.setString(2,member.getPass());
	        ps.setString(3,member.getEmail());
	        ps.setString(4, member.getPhone());
	        ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="<h1>data not enterd</h1>";
		}
    	
       
    	return result;
    }
}
