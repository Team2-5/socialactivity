<%@ page import="com.golfzone.social.user.UserVO" %>
<%@ page import="com.golfzone.social.user.UserDAO" %>
<%@ page import="com.golfzone.social.user.UserDAOImpl" %>
<%@ page import="com.golfzone.social.club.ClubVO" %>
<%@ page import="com.golfzone.social.club.ClubDAO" %>
<%@ page import="com.golfzone.social.club.ClubDAOImpl" %>
<%@ page import="com.golfzone.social.board.BoardVO" %>
<%@ page import="com.golfzone.social.board.BoardDAO" %>
<%@ page import="com.golfzone.social.board.BoardDAOImpl" %><%--
  Created by IntelliJ IDEA.
  User: org
  Date: 2022/10/03
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../css/main.css" />
    <link rel="stylesheet" href="../css/clubmain.css" />
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css"
    />
    <link rel="stylesheet" href="../css/navigation.css" />
    <title>검색페이지</title>
</head>
<body>
<%
    UserVO userVO = new UserVO();
    UserDAO userDAO = new UserDAOImpl();
    if (request.getAttribute("userNum") != null) {
        Integer userNum = (Integer) request.getAttribute("userNum");
        userVO = userDAO.findByUserNum(userNum);
    }
    ClubVO clubVO = new ClubVO();
    ClubDAO clubDAO = new ClubDAOImpl();
    if (request.getAttribute("clubNum") != null) {
        Integer clubNum = (Integer) request.getAttribute("clubNum");
        clubVO.setClubNum(clubNum);
        clubVO = clubDAO.findByClubNum(clubVO);
    }
%>
<section id="navBar">
    <nav id="mainNav">
        <form id="clubInfoPage" method="post" action="/searchclub">
            <input type="hidden" value="<%=userVO.getUserNum()%>" name="userNum">
        </form>
        <a onclick="document.getElementById('clubInfoPage').submit();" class="logo">Logo</a>
        <ul>
            <form id="mainPage" method="post" action="/club">
                <input type="hidden" value="<%=userVO.getUserNum()%>" name="userNum">
            </form>
            <form id="myPage" method="post" action="/mypage">
                <input type="hidden" value="<%=userVO.getUserNum()%>" name="userNum">
            </form>
            <li><a onclick="document.getElementById('mainPage').submit();" class="linkText">Home</a></li>
            <li><a onclick="document.getElementById('myPage').submit();" class="linkText">MyPage</a></li>
            <li><a href="/">Logout</a></li>
        </ul>
    </nav>
</section>
<script src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>
<script
        src="https://kit.fontawesome.com/1202a2b8dd.js"
        crossorigin="anonymous"
></script>

<script src="../js/clubmain.js"></script>
<script src="../js/navigation.js"></script>
</body>
</html>