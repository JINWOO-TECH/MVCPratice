package model;

import java.sql.Connection;
import java.sql.SQLException;

//DB연결
public interface DAO {
	Connection getConnection() throws SQLException;
}