package model;
import java.sql.SQLException;
import java.util.List;

//sql삽입삭제
public interface SampleDAO {
	List<GroupCodeVO> selectGcode() throws SQLException; //그룹코드가져오기
	int create(ProductVO vo) throws SQLException; //
	ProductVO readOne(String code) throws SQLException;
	List<ProductVO> ProductList(String sql) throws SQLException;
	List<ProductVO> groupRemain() throws SQLException;
	int update(ProductVO vo) throws SQLException;
	int delete(String code) throws SQLException;
}
