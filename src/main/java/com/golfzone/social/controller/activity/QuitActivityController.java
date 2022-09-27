package com.golfzone.social.controller.activity;

import com.golfzone.social.activitymember.ActivityMemberDAO;
import com.golfzone.social.activitymember.ActivityMemberDAOImpl;
import com.golfzone.social.activitymember.ActivityMemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuitActivityController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String activityMemberResultMsg = "";
        // init get parameter
        String activityMemberNum = req.getParameter("activityMemberNum");
        String activityNum = req.getParameter("activityNum");
        String userNum = req.getParameter("userNum");
        String clubNum = req.getParameter("clubNum");
        ActivityMemberVO activityMemberVO = new ActivityMemberVO();
        ActivityMemberDAO activityMemberDAO = new ActivityMemberDAOImpl();

        activityMemberVO.setActivityMemberNum(Integer.parseInt(activityMemberNum));
        activityMemberVO.setActivityNum(Integer.parseInt(activityNum));
        activityMemberVO.setUserNum(Integer.parseInt(userNum));
        activityMemberVO.setClubNum(Integer.parseInt(clubNum));

        // Checking Number, input nothing
        if (activityMemberDAO.findUserByActivityNum(activityMemberVO).getActivityNum() == 0) {
            activityMemberResultMsg = "가입하지 않은 액티비티입니다.";
        } else {
            // init VO, DAO
            activityMemberDAO = new ActivityMemberDAOImpl();
            activityMemberVO = new ActivityMemberVO();
            activityMemberVO.setActivityMemberNum(Integer.parseInt(activityMemberNum));
            activityMemberVO.setActivityNum(Integer.parseInt(activityNum));
            activityMemberVO.setClubNum(Integer.parseInt(clubNum));
            activityMemberVO.setUserNum(Integer.parseInt(userNum));
            activityMemberDAO.deleteActivityMember(activityMemberVO);
            activityMemberResultMsg = "탈퇴완료...";
        }
        System.out.println(activityMemberResultMsg);

        req.setAttribute("activityMemberResultMsg", activityMemberResultMsg);
        req.getRequestDispatcher("zxcvzxcv").forward(req, resp);
    }
}