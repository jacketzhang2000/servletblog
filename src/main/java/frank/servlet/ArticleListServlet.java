package frank.servlet;

import frank.dao.ArticleDAO;
import frank.model.Article;
import frank.model.Result;
import frank.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 张益月
 * @version 1.0
 * @date 2020/3/8 12:40
 */
@WebServlet("/articleList")
public class ArticleListServlet extends BaseServlet{
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//        req.setCharacterEncoding("UTF-8");
//        resp.setCharacterEncoding("UTF-8");
//        resp.setContentType("application/json; charset=UTF-8");
//        Result result=new Result();
//        try {
//
//            //解析请求数据=1
//            Integer id = Integer.parseInt(req.getParameter("id"));
//
//            //TODO
//            result.setSuccess(true);
//            result.setCode("200");
//            result.setMessage("操作成功");
//            result.setData(new ArrayList<>());
//
//        }catch (Exception e){
//            result.setCode("500");
//            result.setMessage("服务器出错了");
//            e.printStackTrace();
//        }
//        PrintWriter pw=resp.getWriter();
//        pw.println(JSONUtil.serialize(result));
//        pw.flush();
//        }

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Integer id = Integer.parseInt(req.getParameter("id"));
        List<Article> articles= ArticleDAO.queryByUserId(id);
        return articles;
    }
}
