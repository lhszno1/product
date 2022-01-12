package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.P_Dto;

public class P_Dao {
	
	private String drv = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "dev02";
	private String pwd = "1234";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public P_Dao() {
		try {
			Class.forName(drv);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("드라이버 로드 실패");
		}
	}//p_dao
	
	private void close() {
		try {
			if(rs != null)rs.close();
			if(pstmt != null)pstmt.close();
			if(conn != null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}//close
	
	//1. 입력
	public int inputProduct(P_Dto product) {
		int result = 0;
		String query = "INSERT INTO p VALUES (?, ?, ?, ?, ?)";
		
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, product.getCode());
			pstmt.setString(2, product.getName());
			pstmt.setInt(3, product.getPrice());
			pstmt.setInt(4, product.getStock());
			pstmt.setString(5, product.getCategory());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}finally {
			close();
		}	
		return result;
	}
	
	//2. 전체출력
	public List<P_Dto> selectAll(){
		List<P_Dto> pList = new ArrayList<P_Dto>();
		String query = "SELECT * FROM p";
		
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				P_Dto pd = new P_Dto();
				pd.setCode(rs.getInt(1));
				pd.setName(rs.getString(2));
				pd.setPrice(rs.getInt(3));
				pd.setStock(rs.getInt(4));
				pd.setCategory(rs.getString(5));
				pList.add(pd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}finally {
			close();
		}	
		return pList;
	}
	
	//3. 구분출력
	public List<P_Dto> selectCate(String cate){
		List<P_Dto> pList = new ArrayList<P_Dto>();
		String query = "SELECT * FROM p WHERE p_category = ?";
		
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, cate);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				P_Dto pd = new P_Dto();
				
				pd.setCode(rs.getInt(1));
				pd.setName(rs.getString(2));
				pd.setPrice(rs.getInt(3));
				pd.setStock(rs.getInt(4));
				pd.setCategory(rs.getString(5));
				pList.add(pd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return pList;
	}
	
	//4. 검색
	public P_Dto selectProduct(int code) {
		P_Dto product = null;
		String query = "SELECT * FROM p WHERE p_code = ?";
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				product = new P_Dto();
				product.setCode(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setStock(rs.getInt(4));
				product.setCategory(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}finally {
			close();
		}
		return product;
	}
	
	//5.수정
	public int updateProduct(P_Dto product) {
		int result = 0;
		String query = "UPDATE p SET p_name = ?, p_price = ?, p_stock = ?, p_category = ? WHERE p_code = ?";
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, product.getName());
			pstmt.setInt(2, product.getPrice());
			pstmt.setInt(3, product.getStock());
			pstmt.setString(4, product.getCategory());
			pstmt.setInt(5, product.getCode());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	
	//6. 삭제
	public int deleteProduct(int code) {
		int result = 0;
		String query = "DELETE FROM p WHERE p_code = ?";
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, code);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}

}//class






























































