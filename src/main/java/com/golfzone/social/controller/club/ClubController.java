package com.golfzone.social.controller.club;

import com.golfzone.social.club.ClubDAO;
import com.golfzone.social.club.ClubDAOImpl;
import com.golfzone.social.club.ClubVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClubController extends HttpServlet {
    // create new club controller

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String clubResultMsg = "resultMsg";
        String clubName = req.getParameter("clubName");
        String clubMaxCount = req.getParameter("maxCount");
        String clubAge = req.getParameter("age");
        String clubLocation = req.getParameter("location");
        String clubTier = req.getParameter("tier");
        String clubDescription = req.getParameter("description");
        String clubEmblemPath = req.getParameter("emblemPath");
        String clubSex = req.getParameter("sex");
        String clubPw = req.getParameter("pw");

        ClubDAO clubDAO = new ClubDAOImpl();
        ClubVO clubVO = new ClubVO();
        clubVO.setClubName(clubName);
        clubVO.setClubMaxCount(Integer.parseInt(clubMaxCount));
        clubVO.setClubAge(Integer.parseInt(clubAge));
        clubVO.setClubLocation(clubLocation);
        clubVO.setClubTier(clubTier);
        clubVO.setClubDescription(clubDescription);
        clubVO.setClubEmblemPath(clubEmblemPath);
        clubVO.setClubSex(Integer.parseInt(clubSex));
        clubVO.setClubPw(clubPw);
        if (clubDAO.findByClubName(clubVO).equals(clubVO.getClubName())){
            clubResultMsg = "이미 존재하는 클럽명입니다.";
        }
        else {
            clubDAO.insertClub(clubVO);
            clubResultMsg = "클럽 생성 완료!";
        }
        req.setAttribute("resultMsg" ,clubResultMsg);
        req.getRequestDispatcher("/club.jsp").forward(req, resp);
    }
}