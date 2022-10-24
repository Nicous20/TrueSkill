package servlet;

import Dao.Comparison;
import Dao.Res;
import Service.ComparisonService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

@WebServlet("/mainServlet")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Comparison comparison = new Comparison();
        Random r = new Random();

        //TODO: Change the attributes here
//        String[] attr = {"scale","space","green","facility"};

        int n1 = r.nextInt(500);
        int n2 = r.nextInt(500);
        int a1 = r.nextInt(4);
        comparison.setItem1(String.valueOf(n1));
        comparison.setItem2(String.valueOf(n2));
        comparison.setAttr("Attr_null");
        comparison.setRes("Res_null");



        req.getSession().setAttribute("Comparison_in",comparison);

        String jsonString = JSON.toJSONString(comparison);
        System.out.println("--------------start a comparison----------------");
        System.out.println(jsonString);
//        System.out.println("MainS");
        resp.getWriter().write(jsonString);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req,resp);

    }


}
