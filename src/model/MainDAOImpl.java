package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//DB연결과  sql처리
public class MainDAOImpl extends DAOBase implements SampleDAO {
	@Override
	public ArrayList<GroupCodeVO> selectGcode() throws SQLException {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from groupcode";
		pstmt=conn.prepareStatement(sql);
		rs= pstmt.executeQuery();
		
		ArrayList<GroupCodeVO> groupcode = new ArrayList<GroupCodeVO>();
		
		while(rs.next()) {
			GroupCodeVO groupcodevo = new GroupCodeVO();
			groupcodevo.setGcode(rs.getString(1));
			groupcodevo.setGname(rs.getString(2));
			groupcode.add(groupcodevo);
		}
		closeDBResources(rs,pstmt,conn);
		return groupcode;
	}
	
	@Override
	public int create(ProductVO vo) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
//		System.out.println(vo);
		String sql = "insert into product values(?,?,?,?,?,?,?)";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,vo.getCode());
		pstmt.setString(2,vo.getPname());
		pstmt.setInt(3,vo.getCost());
		pstmt.setInt(4,vo.getPnum());
		pstmt.setInt(5,vo.getJnum());
		pstmt.setInt(6,vo.getSale());
		pstmt.setString(7,vo.getGcode());

		result = pstmt.executeUpdate();
		closeDBResources(null,pstmt,conn);
		return result;
	}

	@Override
	public ProductVO readOne(String code) throws SQLException {
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from product where 제품코드='"+code+"'";
		stmt=conn.createStatement();
		rs= stmt.executeQuery(sql);
		
		ProductVO product = new ProductVO();
		
		while(rs.next()) {
			System.out.println(rs.getString(1));
			product.setCode(rs.getString(1));
			product.setPname(rs.getString(2));
			product.setCost(rs.getInt(3));
			product.setPnum(rs.getInt(4));
			product.setJnum(rs.getInt(5));
			product.setSale(rs.getInt(6));
			product.setGcode(rs.getString(7));
			
		}
		closeDBResources(null,stmt,conn);
//		System.out.println(product);//product확인
		return product;
	}



	@Override
	public int update(ProductVO vo) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "update product SET 제품이름=?, 제품원가=?, 목표수량=?, "
				+ "재고수량=?, 출고가=?,그룹코드=? where 제품코드=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,vo.getPname());
		pstmt.setInt(2,vo.getCost());
		pstmt.setInt(3,vo.getPnum());
		pstmt.setInt(4,vo.getJnum());
		pstmt.setInt(5,vo.getSale());
		pstmt.setString(6,vo.getGcode());
		pstmt.setString(7,vo.getCode());
		result = pstmt.executeUpdate();
		closeDBResources(null,pstmt,conn);
		return result;
	}

	@Override
	public int delete(String code) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "delete product where  제품코드=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,code);
		result = pstmt.executeUpdate();
		closeDBResources(null,pstmt,conn);
		return result;
	}
	//우선생산제품
	@Override
	public List<ProductVO> ProductList(String sql) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductVO> productList= new ArrayList<ProductVO>();
		pstmt=conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			ProductVO product = new ProductVO();
			product.setCode(rs.getString(1));
			product.setPname(rs.getString(2));
			product.setCost(rs.getInt(3));
			product.setPnum(rs.getInt(4));
			product.setJnum(rs.getInt(5));
			product.setSale(rs.getInt(6));
			product.setGcode(rs.getNString(7));
//			System.out.println(product);//확인
			productList.add(product);
		}
		closeDBResources(null,pstmt,conn);
		return productList;
	}

	@Override
	public List<ProductVO> groupRemain() throws SQLException {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductVO> groupRemain= new ArrayList<ProductVO>();
		String  sql  = "select  그룹코드, sum(재고수량) from  product  group by  그룹코드";
		pstmt=conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			ProductVO product = new ProductVO();
			product.setCode(rs.getString(1));
			product.setJnum(rs.getInt(2));
			System.out.println(product);//확인
			groupRemain.add(product);
		}
		closeDBResources(null,pstmt,conn);
		return groupRemain;
	}


}
