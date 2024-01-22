package dao;

import java.sql.*;
import java.util.*;

import entity.Department;
import util.DBUtil;

public class DeptDAOImpl implements IDeptDAO {

	Connection conn = null;

	public DeptDAOImpl() {
		conn = DBUtil.getDBConnection();
	}

	@Override
	public int insert(Department dept) {
		// TODO Auto-generated method stub
		String insert = "insert into dept values(?,?,?)";
		int count = 0;

		try {
			PreparedStatement pstmt = conn.prepareStatement(insert);

			pstmt.setInt(1, dept.getDno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLocation());

			count = pstmt.executeUpdate();

			System.out.println(count);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public int update(Department dept) {
		String update = "update dept set dname = ? , location = ? where dno = ?";
		int count = 0;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(update);
			
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLocation());
			pstmt.setInt(3, dept.getDno());

			count = pstmt.executeUpdate();

			System.out.println("record update is " + count);

		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int deleteOne(int dno) {
		String delete = "delete from dept where dno = ?";
		int count = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(delete);
			
			ps.setInt(1, dno);
			
			count = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Department selectOne(int dno) {
		String selectOne = "select dno, dname, location from dept where dno = ?";
		ResultSet rs = null;
		Department dept = null;
		try {
			PreparedStatement ps = conn.prepareStatement(selectOne);
			
			ps.setInt(1, dno);
			
			rs = ps.executeQuery();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			dept = new Department(rs.getInt("dno"),rs.getString("dname"),rs.getString("location"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dept;
	}

	@Override
	public List<Department> selectAll() {
		List<Department> list = new ArrayList<Department>();
		String selectAll = "select dno, dname, location from dept;";
		ResultSet rs = null;
//		Department dept = null;
		try {
			PreparedStatement ps = conn.prepareStatement(selectAll);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Department(rs.getInt("dno"),rs.getString("dname"),rs.getString("location")));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
