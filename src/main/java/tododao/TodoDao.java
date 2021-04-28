package tododao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import todo.DbInfo;
import tododto.TodoDto;

public class TodoDao {

	private static TodoDao singleton;

	private TodoDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static TodoDao getInstance() {
		if (singleton == null) {
			singleton = new TodoDao();
		}
		return singleton;
	}

	public List<TodoDto> getTodos() {
		List<TodoDto> todoList = new ArrayList<>();

		String sql = "select id, title, DATE_FORMAT(regdate,'%Y-%m-%d') AS DATE , name, sequence, type from todo;";

		try (Connection conn = DriverManager.getConnection(DbInfo.DB_URL, DbInfo.DB_USER, DbInfo.DB_PASSWORD);
			PreparedStatement ps = conn.prepareStatement(sql)) {

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					TodoDto todo = new TodoDto();

					todo.setId(rs.getLong(1));
					todo.setTitle(rs.getString(2));
					todo.setRegDate(rs.getString(3));
					todo.setName(rs.getString(4));
					todo.setSequence(rs.getInt(5));
					todo.setType(rs.getString(6));

					todoList.add(todo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return todoList;
	}

	public int addTodo(TodoDto todo) {
		int insertCount = 0;
		String sql = "insert into todo(title,name,sequence) values (?,?,?);";

		try (Connection conn = DriverManager.getConnection(DbInfo.DB_URL, DbInfo.DB_USER, DbInfo.DB_PASSWORD);
			PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, todo.getTitle());
			ps.setString(2, todo.getName());
			ps.setInt(3, todo.getSequence());

			insertCount = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return insertCount;
	}

	public int updateTodo(TodoDto todo) {
		int updateCount = 0;

		String sql = "update todo set type=? where id=?;";

		try (Connection conn = DriverManager.getConnection(DbInfo.DB_URL, DbInfo.DB_USER, DbInfo.DB_PASSWORD);
			PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, todo.getType());
			ps.setLong(2, todo.getId());

			updateCount = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateCount;
	}

}
