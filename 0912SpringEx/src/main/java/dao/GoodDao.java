package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.GoodsVO;

public class GoodDao {
	public GoodDao(){}
	
	
	// 전체 데이터를 읽어오는 메소드 // 머에 리스트인지 생각해봐라 저기에 머가들어갈꺼 같아 <> 클래스를 만든이유
	// 파라미터를 만들 때는 insert나 update는 특별한 경우가 아니면 VO
	//delete는 primary key
	//select는 where 절에 대입되어야 하는 데이터
	//select * from goods 전체데이터를 가져오기때문에 where절이 없으니까 파라미터를 아무것도 안쓴다.
	public List<GoodsVO> getGood(){
		//List를 리턴할 때는 객체를 생성하고 리턴하도록 작성
		List<GoodsVO> list = new ArrayList<GoodsVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.101:1521:xe", "user25",
					"user25");
			pstmt = con.prepareStatement("select * from goods");
			rs = pstmt.executeQuery();
	
			while(rs.next()) {
				GoodsVO good = new GoodsVO();
				good.setCode(rs.getInt("code"));
				good.setName(rs.getString("name"));
				good.setPrice(rs.getInt("price"));
				good.setDescription(rs.getString("description"));
				list.add(good);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				if(rs != null)rs.close();
				if(pstmt!= null)pstmt.close();
				if(con !=null)con.close();
				
			}catch(Exception e) {}
		}
		return list;
	}
}
