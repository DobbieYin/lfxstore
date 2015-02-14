package com.newedo.projects.lfx.servlet;

import com.newedo.projects.lfx.biz.impl.MapStoreServiceImpl;
import com.newedo.projects.lfx.biz.itf.IMapStoreService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 服务servlet地址
 */
public class MapStoreServlet extends HttpServlet {
    private IMapStoreService mapStoreService = new MapStoreServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        resp. setCharacterEncoding("UTF-8");
        String t = req.getParameter("t");
        if(t != null && t.trim().toUpperCase().equals("GETALL")){
            resp.getWriter().write(mapStoreService.getAll());
        }else if(t != null && t.trim().toUpperCase().equals("RESET")){
            String reset = mapStoreService.reset();
            reset = reset != null ? reset : "200";
            resp.getWriter().write(reset);
        }else if(t != null && t.trim().toUpperCase().equals("ADDALL")){
            String addAll = mapStoreService.addAll(req.getParameter("d"));
            addAll = addAll != null ? addAll : "200";
            resp.getWriter().write(addAll);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
