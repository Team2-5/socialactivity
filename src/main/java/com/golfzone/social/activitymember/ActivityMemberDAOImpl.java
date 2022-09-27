package com.golfzone.social.activitymember;

import com.golfzone.social.club.ClubVO;
import com.golfzone.social.db.MariaDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityMemberDAOImpl implements ActivityMemberDAO {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public ActivityMemberDAOImpl() {
        try {
            Class.forName(MariaDB.DRIVER_NAME);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insertActivityMember(ActivityMemberVO activityMemberVO) {
        int flag = 0;
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("insertActivityMember: conn success");
            String sql = MariaDB.INSERT_ACTIVITY_MEMBER;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, activityMemberVO.getActivityNum());
            pstmt.setInt(2, activityMemberVO.getClubNum());
            pstmt.setInt(3, activityMemberVO.getUserNum());
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        } // end finally
        return flag;
    }


    @Override
    public List<ActivityMemberVO> selectAll() {
        List<ActivityMemberVO> vos = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("ActivityMember selectAll: conn success");

            String sql = MariaDB.ACTIVITY_MEMBER_SELECT_ALL;
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ActivityMemberVO vo = new ActivityMemberVO();
                vo.setActivityNum(rs.getInt("ACTIVITY_NUM"));
                vo.setClubNum(rs.getInt("CLUB_NUM"));
                vo.setUserNum(rs.getInt("USER_NUM"));
                vos.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } // end finally
        return vos;
    }

    @Override
    public ActivityMemberVO findUserByActivityNum(ActivityMemberVO activityMemberVO) {
        ActivityMemberVO vo = new ActivityMemberVO();
        try {
            conn = DriverManager.getConnection(MariaDB.URL, MariaDB.USER, MariaDB.PASSWORD);
            System.out.println("find user activity conn success");

            String sql = MariaDB.USER_FIND_BY_ACTIVITY_MEMBER;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, activityMemberVO.getUserNum());
            pstmt.setInt(2, activityMemberVO.getActivityNum());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                vo.setActivityMemberNum(rs.getInt("activity_member_num"));
                vo.setActivityNum(rs.getInt("activity_num"));
                vo.setClubNum(rs.getInt("club_num"));
                vo.setUserNum(rs.getInt("user_num"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } // end finally
        return vo;
    }
}
