package model;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
//DB연결  
public class DAOBase implements DAO {
public Connection getConnection() throws SQLException{
	String jdbc_driver = "oracle.jdbc.OracleDriver";
	String db_url = "jdbc:oracle:thin:@localhost:1521:XE";
	try{
		Class.forName(jdbc_driver);
		Connection conn =
		DriverManager.getConnection(db_url,"PROJECT_TEST","hrdkorea");
		return conn;
	} catch(Exception e) {
		e.printStackTrace();
	}
		return null;
	}

public void closeDBResources(ResultSet rs, Statement stmt, Connection conn) {
	if(rs != null) {
	try {
		rs.close();
		} catch(Exception e) {
		e.printStackTrace();
	}
		}
	if(stmt != null) {
	try {
		stmt.close();
	} catch(Exception e) {
		e.printStackTrace();
		}
	}
	if(conn != null) {
	try {
		conn.close();
	} catch(Exception e) {
		e.printStackTrace();
	}
	}
	}
}

