package com.golfzone.social.db;

public interface MariaDB {
    String DRIVER_NAME = "org.mariadb.jdbc.Driver";
    String URL = "jdbc:mariadb://localhost:3306/socialactivity";
    String USER = "root";
    String PASSWORD = "root1234";
    String USER_SELECT_ALL = "select * from user";
    String USER_FIND_BY_USER = "select * from user where user_id = ";
    String INSERT_USER = "insert into user(user_name, user_id, user_pw, user_location, user_age, user_sex, user_tier, user_score) values(?, ?, ?, ?, ?, ?, ?, ?)";
    String CLUB_FIND_BY_CLUB_NAME = "select * from club where club_name = ?";
    String CLUB_FIND_BY_CLUB_PASSWORD = "select * from club where club_name = ?, club_pw = ?";
    String INSERT_CLUB = "insert into club(club_name, club_maxcount, club_age, club_location, club_tier, club_description, club_emblempath, club_sex, club_pw) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String CLUB_SELECT_ALL = "select * from club";
    String ACTIVITY_SELECT_ALL = "select * from activity";
    String INSERT_BOARD = "insert into board(board_title, board_content, board_writer) values(?, ?, ?)";
    String INSERT_COMMENT = "insert into comment(comment_content, comment_writer) values(?, ?)";
    String INSERT_ACTIVITY = "insert into activity(activity_title, activity_description) values(?, ?)";
    String INSERT_ALBUM = "insert into album(image_name, image_path) values(?, ?)";
    String INSERT_CLUB_MEMBER = "insert into club_member(role_num, club_num, user_num, tier_name) values(?, ?, ?, ?)";
    String CLUB_MEMBER_SELECT_ALL = "select * from club_member";
    String CLUB_MEMBER_FIND_BY_CLUB_NUM = "select * from club_member where club_num = ?";
    String INSERT_ACTIVITY_MEMBER = "insert into activity_member(activity_num, club_num, user_num) values(?, ?, ?)";
    String ACTIVITY_MEMBER_SELECT_ALL = "select * from activity_member";
    String USER_FIND_BY_ACTIVITY_MEMBER = "select * from activity_member where user_num = ? and activity_num = ?";

}
