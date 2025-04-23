package End_of_term;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;

	public class connect {
		
		public connect() {
			
		}

		public  Connection newConnection() {
			// TODO Auto-generated method stub
			Connection conn = null;
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QL_VatLieu; "
						+ "user=sa; password=utthi15102003");
				System.out.println("sdjvf");
			} catch(Exception e){
				   System.out.println(e.getMessage());
			}
			return conn;
		}
		
		public static void main(String[] args) {
			connect c = new connect();
			c.newConnection();
		}

	}


