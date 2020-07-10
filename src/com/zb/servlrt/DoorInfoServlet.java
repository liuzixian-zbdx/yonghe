package com.zb.servlrt;

import com.zb.dao.DoorDao;
import com.zb.pojo.Door;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doorInfo")
public class DoorInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取门店id
        Integer id = Integer.parseInt(request.getParameter("id"));
        //查询门店信息
        DoorDao doorDao = new DoorDao();
        Door door = doorDao.finfById(id);
        System.out.println(door);
        request.setAttribute("door",door);
        request.getRequestDispatcher("/door_update.jsp").forward(request,response);
    }
}
