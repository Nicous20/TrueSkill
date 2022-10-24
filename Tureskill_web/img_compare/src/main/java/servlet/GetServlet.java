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
import java.util.Objects;
import java.util.Random;

@WebServlet("/getServlet")
public class GetServlet extends HttpServlet {
    private ComparisonService comparisonService = new ComparisonService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Comparison comparison = (Comparison) req.getSession().getAttribute("Comparison_in");
//        System.out.println("GetS");
//        System.out.println(comparison);
        //set to database
        BufferedReader br = req.getReader();
        String params = br.readLine();
        Res res  = JSON.parseObject(params, Res.class);
        System.out.println(res);
        if(Objects.equals(res.getRes(), "null")){
            resp.sendRedirect("main.html");
        }else {
            //because this part, the code deserve $1500

            comparison.setRes(res.getRes());
            comparison.setAttr(res.getAttr());
            comparisonService.add(comparison);
            System.out.println(comparison);
        }





    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req,resp);

    }


}
