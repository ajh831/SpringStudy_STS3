//package com.loginform.dao;
//
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.loginform.myapp.User;
//
//// @Repository
//public class UserDAOImplTest implements UserDAO {
//    @Autowired
//    DataSource ds;
//
//    final int FAIL = 0;
//    
//    @Override
//    public User selectUser(String id) {
//        User user = null;
//
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//
//        String sql = "select * from registerTB where id= ? ";
//
//        try {
//            conn = ds.getConnection();
//            pstmt = conn.prepareStatement(sql); // SQL Injection공격, 성능향상
//            pstmt.setString(1, id);
//
//            rs = pstmt.executeQuery(); //  select
//
//            if (rs.next()) {
//                user = new User();
//                user.setId(rs.getString(1));
//                user.setPwd(rs.getString(2));
//                user.setName(rs.getString(3));
//                user.setBirth(new Date(rs.getDate(4).getTime()));
//                user.setAddress(rs.getString(5));
//            }
//        } catch (SQLException e) {
//            return null;
//        } finally {
//            // close()를 호출하다가 예외가 발생할 수 있으므로, try-catch로 감싸야함.
//            // close()의 호출순서는 생성된 순서의 역순
////            try { if(rs!=null)    rs.close();    } catch (SQLException e) { e.printStackTrace();}
////            try { if(pstmt!=null) pstmt.close(); } catch (SQLException e) { e.printStackTrace();}
////            try { if(conn!=null)  conn.close();  } catch (SQLException e) { e.printStackTrace();}
//            close(rs, pstmt, conn);  //     private void close(AutoCloseable... acs) {
//        }
//
//        return user;
//    }
//    
//    // 사용자 정보를 user_info테이블에 저장하는 메서드
//    @Override
//    public int insertUser(User user) {
//        int rowCnt = FAIL;
//
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//
////        insert into user_info (id, pwd, name, birth, address, reg_date)
////        values ('asdf22', '1234', 'smith', '2022-01-01', now());
//        String sql = "insert into user_info values (?, ?, ?, ?, now()) ";
//
//        try {
//            conn = ds.getConnection();
//            pstmt = conn.prepareStatement(sql); // SQL Injection공격, 성능향상
//            pstmt.setString(1, user.getId());
//            pstmt.setString(2, user.getPwd());
//            pstmt.setString(3, user.getName());
//            pstmt.setDate(4, new java.sql.Date(user.getBirth().getTime()));
//            pstmt.setString(5, user.getAddress());
//
//            return pstmt.executeUpdate(); //  insert, delete, update;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return FAIL;
//        } finally {
//            close(pstmt, conn);  //     private void close(AutoCloseable... acs) {
//        }
//    }
//    
//    private void close(AutoCloseable... acs) {
//        for(AutoCloseable ac :acs)
//            try { if(ac!=null) ac.close(); } catch(Exception e) { e.printStackTrace(); }
//    }
//
//	@Override
//	public User updateUser(User user) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String deleteUser(User user) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getServerTime() throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
