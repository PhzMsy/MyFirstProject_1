package msy.servlet;


import com.alibaba.fastjson.JSON;
import msy.bean.Champion;
import msy.bean.City;
import msy.bean.Hero;
import msy.service.ChService;
import msy.service.ChampionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Msy
 * @date 2023/2/1  15:18
 */
@WebServlet("/Champion")
public class ChampionServlet extends HttpServlet {
    /**
     * 将service实例化
     */
    private ChService chService = new ChampionServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String m = req.getParameter("m");
        if ("query".equals(m)) {
            query(req, resp);
        } else if ("insert".equals(m)) {
            insert(req, resp);
        } else if ("getHero".equals(m)) {
            getHero(req, resp);
        } else if ("queryById".equals(m)) {
            queryById(req, resp);
        } else if ("update".equals(m)) {
            update(req, resp);
        }else if ("delete".equals(m)) {
            delete(req, resp);
        }else if ("queryCity".equals(m)) {
            queryCity(req, resp);
        }
    }

    private void queryCity(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("进到queryCity里了");
        String pid = req.getParameter("pid");
        ArrayList<City> list =chService.queryCity(pid);
        String s = JSON.toJSONString(list);
        System.out.println(s);
        resp.getWriter().print(s);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        int i = chService.delete(id);
        resp.getWriter().print(i>0);

    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int star = Integer.parseInt(req.getParameter("star"));
        int pid = Integer.parseInt(req.getParameter("pid"));
        String nickname = req.getParameter("nickname");
        Hero hero = new Hero(pid, "");
        Champion champion = new Champion(id, name, star, hero, nickname);
        int i = chService.update(champion);

        resp.getWriter().print(i > 0);
    }

    private void queryById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        Champion champion = chService.queryById(id);
        String s = JSON.toJSONString(champion);
        System.out.println("根据id查询"+s);
        resp.getWriter().print(s);

    }

    private void getHero(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ArrayList<Hero> list = chService.queryHero();
        String s = JSON.toJSONString(list);
        System.out.println(s);
        resp.getWriter().print(s);
    }

    private void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        int star = Integer.parseInt(req.getParameter("star"));
        int pid = Integer.parseInt(req.getParameter("pid"));
        String nickname = req.getParameter("nickname");
        int i = chService.insert(new Champion(null, name, star, new Hero(pid, ""), nickname));
        resp.getWriter().print(i > 0);


    }

    private void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Champion> list = chService.queryAll();
        req.setAttribute("champion", list);
        System.out.println("查询中的list"+list);
        req.getRequestDispatcher("hero/list.jsp").forward(req, resp);
    }
}
