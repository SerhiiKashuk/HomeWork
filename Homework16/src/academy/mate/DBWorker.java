package academy.mate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBWorker {

	private Connection conn;
	private Statement st;
	private final static String ADD_SHAPE = "INSERT INTO shape(name, color, area, perimeter, user) VALUES(?, ?, ?, ?, ?)";
	private final static String GET_ALL_SHAPE = "SELECT * FROM shape";
	private final static String GET_LAST_RECORDS = "SELECT * FROM shape ORDER BY id DESC LIMIT ?";
	private final static String GET_LAST_ID = "SELECT * FROM shape ORDER BY id DESC LIMIT 1";
	private final static String DELETE_BY_ID= "DELETE FROM shape WHERE id = ?";

	public DBWorker() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			System.out.println("Could not load driver");
		}

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/tetris?" + "user=root&password=");
			st = conn.createStatement();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	public boolean createShape(Shape shape) {
		try {
			PreparedStatement ps = conn.prepareStatement(ADD_SHAPE);
			ps.setString(1, shape.getName());
			ps.setString(2, shape.getColor());
			ps.setString(3, String.valueOf(shape.getArea()));
			ps.setString(4, String.valueOf(shape.getPerimeter()));
			ps.setString(5, shape.getUser());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	
	public int getIdLastRecord() {
		int id = 0;
		try {
			ResultSet rs = st.executeQuery(GET_LAST_ID);
			if (rs.next()) {
				id = rs.getInt("id");
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public List<String[]> getLastRecordsById(int id) {
		List<String[]> list = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(GET_LAST_RECORDS);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String[] obj = new String[6];
				obj[0] = String.valueOf(rs.getInt("id"));
				obj[1] = rs.getString("name");
				obj[2] = rs.getString("color");
				obj[3] = rs.getString("area");
				obj[4] = rs.getString("perimeter");
				obj[5] = rs.getString("user");
				list.add(obj);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	public List<String[]> getAllRecord() {
		List<String[]> list = new ArrayList<>();
		try {
			ResultSet rs = st.executeQuery(GET_ALL_SHAPE);
			while (rs.next()) {
				String[] obj = new String[6];
				obj[0] = String.valueOf(rs.getInt("id"));
				obj[1] = rs.getString("name");
				obj[2] = rs.getString("color");
				obj[3] = rs.getString("area");
				obj[4] = rs.getString("perimeter");
				obj[5] = rs.getString("user");
				list.add(obj);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean deleteById(int id) {
		try {
			PreparedStatement ps = conn.prepareStatement(DELETE_BY_ID);
			ps.setInt(1, id);
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public void close() {
		try {
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
